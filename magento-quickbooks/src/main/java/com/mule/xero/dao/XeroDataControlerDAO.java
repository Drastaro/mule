package com.mule.xero.dao;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import javax.xml.bind.JAXBException;

import com.mule.generated.pojo.Address;
import com.mule.generated.pojo.OrderItem;
import com.mule.generated.pojo.OrdersEntity;
import com.mule.xero.data.XeroDataGateway;
import com.silverwiresapp.admin.xeroauth.api.xsd.AddressType;
import com.silverwiresapp.admin.xeroauth.api.xsd.ArrayOfAddress;
import com.silverwiresapp.admin.xeroauth.api.xsd.ArrayOfContact;
import com.silverwiresapp.admin.xeroauth.api.xsd.ArrayOfInvoice;
import com.silverwiresapp.admin.xeroauth.api.xsd.ArrayOfItem;
import com.silverwiresapp.admin.xeroauth.api.xsd.ArrayOfLineItem;
import com.silverwiresapp.admin.xeroauth.api.xsd.ArrayOfPhone;
import com.silverwiresapp.admin.xeroauth.api.xsd.Contact;
import com.silverwiresapp.admin.xeroauth.api.xsd.EntityValidationStatus;
import com.silverwiresapp.admin.xeroauth.api.xsd.Invoice;
import com.silverwiresapp.admin.xeroauth.api.xsd.InvoiceStatus;
import com.silverwiresapp.admin.xeroauth.api.xsd.InvoiceType;
import com.silverwiresapp.admin.xeroauth.api.xsd.Item;
import com.silverwiresapp.admin.xeroauth.api.xsd.ItemPriceDetails;
import com.silverwiresapp.admin.xeroauth.api.xsd.LineItem;
import com.silverwiresapp.admin.xeroauth.api.xsd.Phone;

public class XeroDataControlerDAO {

	public Invoice createXeroInvoice(OrdersEntity mgOrder, String swUserId) throws IOException, SQLException,
			ParseException, JAXBException {

		Invoice invoice = null;
		ArrayOfInvoice arrayOfInvoice = new ArrayOfInvoice();
		List<Invoice> invoices = arrayOfInvoice.getInvoice();
		invoice = new Invoice();
		Contact contact = createXeroContact(mgOrder, swUserId);
		invoice.setContact(contact);
		ArrayOfLineItem arrayOfLineItem = new ArrayOfLineItem();
		LineItem lineItem = null;

		/*
		 * check if magento items already syncornized with xero
		 */

		createXeroItem(mgOrder, swUserId);

		for (OrderItem items : mgOrder.getOrderItems()) {

			if (items.getParentItemId() == null) {

				lineItem = new LineItem();
				lineItem.setAccountCode("200");
				lineItem.setDescription(items.getName());
				BigDecimal qty = new BigDecimal(items.getQtyOrdered());
				lineItem.setQuantity(qty);
				BigDecimal amnt = new BigDecimal(items.getBaseOriginalPrice());
				lineItem.setUnitAmount(amnt);
				lineItem.setLineAmount(qty.multiply(amnt));
				BigDecimal tax = new BigDecimal(items.getTaxAmount());
				lineItem.setTaxAmount(tax);
				lineItem.setItemCode(items.getSku());

				arrayOfLineItem.getLineItem().add(lineItem);
			}
		}
		invoice.setLineItems(arrayOfLineItem);

		SimpleDateFormat formatter = new SimpleDateFormat("YYYY-MM-DD HH:mm:ss");
		String magentoDate = mgOrder.getCreatedAt();
		Calendar due = Calendar.getInstance();
		due.setTime(formatter.parse(magentoDate));
		invoice.setDate(due);
		due.set(due.get(Calendar.YEAR), due.get(Calendar.MONTH) + 1, 20);
		invoice.getLineAmountTypes().add("Inclusive");
		invoice.setDueDate(due);
		invoice.setInvoiceNumber(mgOrder.getIncrementId());
		invoice.setType(InvoiceType.ACCREC);
		invoice.setReference(mgOrder.getStoreName());
		String orderStatus = mgOrder.getStatus();

		switch (orderStatus) {

		case "new":
			invoice.setStatus(InvoiceStatus.SUBMITTED);
			break;
		case "pending":
		case "processing":
			invoice.setStatus(InvoiceStatus.AUTHORISED);
			break;
		case "complete":
			invoice.setStatus(InvoiceStatus.PAID);
			break;
		case "closed":
			invoice.setStatus(InvoiceStatus.DELETED);
			break;
		case "canceled":
			invoice.setStatus(InvoiceStatus.VOIDED);
			break;
		case "holded":
		case "Payment Review":
			invoice.setStatus(InvoiceStatus.DRAFT);
			break;
		}

		for (LineItem item : invoice.getLineItems().getLineItem()) {

			BigDecimal totalTax = new BigDecimal(0);
			totalTax = totalTax.add(item.getTaxAmount());
			invoice.setTotalTax(totalTax);

		}
		if (XeroPersistenceDAO.getXeroSettingsBySwUserId(swUserId) == null) {
			XeroPersistenceDAO.saveXeroSettings(swUserId, lineItem.getAccountCode());
		} else {
			XeroPersistenceDAO.updateXeroSettings(swUserId, lineItem.getAccountCode());
		}

		invoices.add(invoice);

		XeroDataGateway.postInvoice(invoice, swUserId);
		// XeroDataControlerDAO.postScribeInvoice(invoice, swUserId, action);

		return invoice;
	}

	public Contact createXeroContact(OrdersEntity mgOrder, String swUserId) throws IOException, SQLException {

		ArrayOfContact arrayOfContact = new ArrayOfContact();
		ArrayOfAddress arrayOfAdress = new ArrayOfAddress();
		ArrayOfPhone arrayOfPhone = new ArrayOfPhone();
		Contact contact = new Contact();

		for (Address adress : mgOrder.getAddresses()) {
			System.err.println("adress type" + adress.getAddressType());
			if (mgOrder.getIncrementId() == null) {
				contact.setName(adress.getFirstname() + "." + adress.getLastname());

			} else if (adress.getCompany() == null) {
				contact.setName(adress.getFirstname() + "." + adress.getLastname());

			} else {
				contact.setName(adress.getCompany().toString());
			}

			System.out.println("FirstName:" + adress.getFirstname());
			contact.setFirstName(adress.getFirstname());
			contact.setLastName(adress.getLastname());
			contact.setEmailAddress(adress.getEmail());
			contact.setContactNumber(mgOrder.getEntityId());
			/*
			 * SET conntacts adress
			 */
			com.silverwiresapp.admin.xeroauth.api.xsd.Address newAdress = new com.silverwiresapp.admin.xeroauth.api.xsd.Address();
			if ("billing".equalsIgnoreCase(adress.getAddressType())) {
				newAdress.setAddressType(AddressType.POBOX);

			} else {
				newAdress.setAddressType(AddressType.STREET);
			}

			newAdress.setCountry(adress.getCountryId());
			newAdress.setCity(adress.getCity());

			newAdress.setRegion(adress.getRegion());
			newAdress.setPostalCode(adress.getPostcode());
			newAdress.setAddressLine1(adress.getStreet());
			/*
			 * SET conntact phones
			 */
			Phone phone = new Phone();
			phone.setPhoneNumber(adress.getTelephone());
			contact.setDefaultCurrency(mgOrder.getBaseCurrencyCode());

			arrayOfContact.getContact().add(contact);
			arrayOfPhone.getPhone().add(phone);
			arrayOfAdress.getAddress().add(newAdress);
			contact.setAddresses(arrayOfAdress);
			contact.setPhones(arrayOfPhone);

		}
		XeroDataGateway.createContact(contact, swUserId);
		// XeroDataControlerDAO.createScribeContact(contact, swUserId,
		// "contacts");
		return contact;
	}

	public Item createXeroItem(OrdersEntity mgOrder, String swUserId) throws SQLException, IOException {

		ArrayOfItem arrayOfItem = new ArrayOfItem();
		Item xeroItem = null;
		for (OrderItem items : mgOrder.getOrderItems()) {
			if (items.getParentItemId() == null) {
				xeroItem = new Item();
				xeroItem.setDescription(items.getName());
				xeroItem.setName(items.getName());
				xeroItem.setCode(items.getSku());
				ItemPriceDetails priceDetails = new ItemPriceDetails();
				BigDecimal price = new BigDecimal(items.getPrice());
				priceDetails.setUnitPrice(price);
				priceDetails.setTaxType("INPUT");
				xeroItem.setSalesDetails(priceDetails);
				xeroItem.setStatus(EntityValidationStatus.OK);
				arrayOfItem.getItem().add(xeroItem);
				XeroDataGateway.createItem(xeroItem, swUserId);
			}
		}
		return xeroItem;
	}
}
