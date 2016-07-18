package com.mule.quickbooks.dao;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.xml.bind.JAXBException;

import com.intuit.ipp.data.CheckPayment;
import com.intuit.ipp.data.Customer;
import com.intuit.ipp.data.DiscountLineDetail;
import com.intuit.ipp.data.EmailAddress;
import com.intuit.ipp.data.EntityStatusEnum;
import com.intuit.ipp.data.Invoice;
import com.intuit.ipp.data.Item;
import com.intuit.ipp.data.ItemTypeEnum;
import com.intuit.ipp.data.Line;
import com.intuit.ipp.data.LineDetailTypeEnum;
import com.intuit.ipp.data.PhysicalAddress;
import com.intuit.ipp.data.ReferenceType;
import com.intuit.ipp.data.SalesItemLineDetail;
import com.intuit.ipp.data.TelephoneNumber;
import com.intuit.ipp.exception.FMSException;
import com.intuit.ipp.query.GenerateQuery;
import com.intuit.ipp.services.DataService;
import com.intuit.ipp.services.QueryResult;
import com.mule.generated.pojo.Address;
import com.mule.generated.pojo.OrderItem;
import com.mule.generated.pojo.OrdersEntity;
import com.mule.quickbooks.data.QuickBooksDataServiceFactory;

import static com.intuit.ipp.query.GenerateQuery.$;
import static com.intuit.ipp.query.GenerateQuery.select;

public class QuickBooksDataControlerDAO {

	public QueryResult getQuickBooksCustomer(String swUserId, String firstName, String lastName, String midName)
			throws SQLException, FMSException {

		DataService service = QuickBooksDataServiceFactory.getDataService(swUserId);
		Customer customer = GenerateQuery.createQueryEntity(Customer.class);
		String query = select($(customer)).where($(customer.getGivenName()).eq(firstName))
				.where($(customer.getFamilyName()).eq(lastName)).where($(customer.getMiddleName()).eq(midName))
				.generate();
		QueryResult queryResult = service.executeQuery(query);

		return queryResult;
	}

	public QueryResult getQuickBooksCustomerBySyncToken(String swUserId, String firstName, String lastName,
			String midName, String syncToken) throws SQLException, FMSException {

		DataService service = QuickBooksDataServiceFactory.getDataService(swUserId);
		Customer customer = GenerateQuery.createQueryEntity(Customer.class);
		String query = select($(customer)).where($(customer.getGivenName()).eq(firstName))
				.where($(customer.getFamilyName()).eq(lastName)).where($(customer.getMiddleName()).eq(midName))
				.where($(customer.getSyncToken()).eq(syncToken)).generate();
		QueryResult queryResult = service.executeQuery(query);

		return queryResult;
	}

	private Customer customerData(Customer customer, Address adress, OrdersEntity mgOrder) {

		customer.setActive(true);
		if ("billing".equalsIgnoreCase(adress.getAddressType())) {

			System.err.println("adress type" + adress.getAddressType());
			PhysicalAddress billingAdress = new PhysicalAddress();
			billingAdress.setCountry(adress.getCountryId());
			billingAdress.setCountrySubDivisionCode(adress.getRegion());
			billingAdress.setCity(adress.getCity());
			billingAdress.setLine1(adress.getStreet());
			billingAdress.setPostalCode(adress.getPostcode());
			customer.setBillAddr(billingAdress);

		} else {
			PhysicalAddress shippAdress = new PhysicalAddress();
			shippAdress.setCountry(adress.getCountryId());
			shippAdress.setCountrySubDivisionCode(adress.getRegion());
			shippAdress.setCity(adress.getCity());
			shippAdress.setLine1(adress.getStreet());
			shippAdress.setPostalCode(adress.getPostcode());
			customer.setShipAddr(shippAdress);
		}

		customer.setIntuitId(mgOrder.getIncrementId());
		customer.setTitle(adress.getPrefix());
		customer.setCompanyName(adress.getCompany());
		customer.setGivenName(adress.getFirstname());
		customer.setFamilyName(adress.getLastname());
		customer.setMiddleName(adress.getMiddlename());
		customer.setContactName(adress.getLastname());
		customer.setDisplayName(adress.getFirstname() + "-" + adress.getLastname());
		if (adress.getMiddlename() != null || adress.getLastname() != null) {
			customer.setFullyQualifiedName(adress.getFirstname() + "." + adress.getMiddlename() + "-"
					+ adress.getLastname());
		} else {
			customer.setFullyQualifiedName(adress.getFirstname() + "." + adress.getLastname());
		}
		TelephoneNumber phone = new TelephoneNumber();
		phone.setCountryCode(adress.getCountryId());
		phone.setFreeFormNumber(adress.getTelephone());
		customer.setPrimaryPhone(phone);
		EmailAddress email = new EmailAddress();
		email.setAddress(adress.getEmail());
		customer.setPrimaryEmailAddr(email);
		customer.setAcctNum(mgOrder.getCustomerId());

		return customer;
	}

	public Customer createQuickBooksCustomer(OrdersEntity mgOrder, String swUserId) throws SQLException, JAXBException,
			FMSException {

		Customer customer = new Customer();
		customer.setActive(true);

		for (Address adress : mgOrder.getAddresses()) {

			customerData(customer, adress, mgOrder);
		}
		QueryResult queryResult = getQuickBooksCustomer(swUserId, customer.getGivenName(), customer.getFamilyName(),
				customer.getMiddleName());

		if (queryResult.getEntities().size() == 0) {

			QuickBooksDataServiceFactory.postDataService(swUserId, customer);
			return customer;

		} else {
			System.out.println("Customer already exists!");
			updateCustomer(mgOrder, swUserId);
		}
		return customer;
	}

	public Customer updateCustomer(OrdersEntity mgOrder, String swUserId) throws SQLException, FMSException {

		Customer customer = null;

		for (Address adress : mgOrder.getAddresses()) {
			QueryResult queryResult = getQuickBooksCustomer(swUserId, adress.getFirstname(), adress.getLastname(),
					adress.getMiddlename());
			customer = (Customer) queryResult.getEntities().get(0);
			customerData(customer, adress, mgOrder);

			QuickBooksDataServiceFactory.updateDataService(swUserId, customer);
		}
		return customer;
	}

	public QueryResult getQuickBooksInvoiceById(String swUserId, String invoiceId) throws SQLException, FMSException {

		DataService service = QuickBooksDataServiceFactory.getDataService(swUserId);
		Invoice invoice = GenerateQuery.createQueryEntity(Invoice.class);
		String query = select($(invoice)).where($(invoice.getDocNumber()).eq(invoiceId)).generate();
		QueryResult queryResult = service.executeQuery(query);
		System.out.println("from query: " + ((Invoice) queryResult.getEntities().get(0)).getDocNumber());

		return queryResult;

	}

	private Invoice invoiceData(Invoice invoice, Item item, OrdersEntity mgOrder, Line line, String swUserId)
			throws SQLException, FMSException, ParseException {

		List<Line> linesList = new ArrayList<>();

		for (OrderItem items : mgOrder.getOrderItems()) {
			if (items.getParentItemId() == null) {

				line = new Line();
				line.setId(items.getItemId());
				line.setDetailType(LineDetailTypeEnum.SALES_ITEM_LINE_DETAIL);
				line.setDescription(items.getName());
				DiscountLineDetail discount = new DiscountLineDetail();
				BigDecimal mgDiscout = new BigDecimal(items.getDiscountAmount());
				discount.setDiscountPercent(mgDiscout);
				line.setDiscountLineDetail(discount);

				SalesItemLineDetail salesItemLineDetail = new SalesItemLineDetail();
				ReferenceType referenceType = new ReferenceType();

				QueryResult queryResult = getQuickBooksItemByName(swUserId, item.getName());
				if (queryResult.getEntities().size() != 0) {

					String id = ((Item) queryResult.getEntities().get(0)).getId();
					String name = ((Item) queryResult.getEntities().get(0)).getName();

					referenceType.setName(name);
					referenceType.setValue(id);
					System.err.println("Referenced from the QB existing item!");
				}

				BigDecimal qty = new BigDecimal(items.getQtyOrdered());
				salesItemLineDetail.setQty(qty);
				BigDecimal price = new BigDecimal(items.getBasePrice());
				salesItemLineDetail.setUnitPrice(price);
				salesItemLineDetail.setItemRef(referenceType);
				line.setSalesItemLineDetail(salesItemLineDetail);
				line.setAmount(price.multiply(qty));
				linesList.add(line);
			}
			invoice.setDocNumber(mgOrder.getEntityId());
			invoice.setLine(linesList);
			SimpleDateFormat formatter = new SimpleDateFormat("YYYY-MM-DD HH:mm:ss");
			String magentoDate = mgOrder.getCreatedAt();
			Date date = formatter.parse(magentoDate);
			invoice.setDueDate(date);
			String orderStatus = mgOrder.getStatus();

			switch (orderStatus) {

			case "new":
			case "pending":
			case "processing":
			case "holded":
			case "Payment Review":
				invoice.setStatus(EntityStatusEnum.PENDING);
				break;
			case "complete":
				invoice.setStatus(EntityStatusEnum.SYNCHRONIZED);
				break;
			case "closed":
				invoice.setStatus(EntityStatusEnum.IN_TRANSIT);
				break;
			case "canceled":
				invoice.setStatus(EntityStatusEnum.VOIDED);
				break;
			}
		}
		return invoice;
	}

	public Invoice createQuickBooksInvoice(OrdersEntity mgOrder, String swUserId) throws SQLException, JAXBException,
			FMSException, ParseException {

		Invoice invoice = new Invoice();
		Line line = null;

		Customer customer = createQuickBooksCustomer(mgOrder, swUserId);
		Item item = createQuickBooksItems(mgOrder, swUserId);
		invoiceData(invoice, item, mgOrder, line, swUserId);

		QueryResult invoiceQuery = getQuickBooksInvoiceById(swUserId, invoice.getDocNumber());
		if (invoiceQuery.getEntities().size() == 0) {

			if (customer != null) {

				QueryResult queryResult = getQuickBooksCustomer(swUserId, customer.getGivenName(),
						customer.getFamilyName(), customer.getMiddleName());
				String id = ((Customer) queryResult.getEntities().get(0)).getId();

				ReferenceType customerReferenceType = new ReferenceType();
				customerReferenceType.setName(customer.getFullyQualifiedName());
				customerReferenceType.setValue(id);
				invoice.setCustomerRef(customerReferenceType);
				QuickBooksDataServiceFactory.postDataService(swUserId, invoice);

				/*
				 * set quickbooks incomeAccountId to DB
				 */
				// if
				// (QuickBooksPersistenceDAO.getQuickBooksSettingsBySwUserId(swUserId)
				// != null) {
				//
				// QuickBooksPersistenceDAO.saveQuickBooksSettings(swUserId,
				// invoice.get);
				// } else {
				// QuickBooksPersistenceDAO.updateQuickBooksSettings(swUserId,
				// incomeAccountId);
				// }
				return invoice;

			} else {
				QueryResult queryResult = null;
				for (Address adress : mgOrder.getAddresses()) {

					queryResult = getQuickBooksCustomer(swUserId, adress.getFirstname(), adress.getLastname(),
							adress.getMiddlename());

				}
				ReferenceType customerReferenceType = new ReferenceType();
				customerReferenceType.setName(((Customer) queryResult.getEntities().get(0)).getFullyQualifiedName());
				customerReferenceType.setValue(((Customer) queryResult.getEntities().get(0)).getId());
				invoice.setCustomerRef(customerReferenceType);
				QuickBooksDataServiceFactory.postDataService(swUserId, invoice);
				return invoice;
			}
		} else {
			System.out.println("Invoice already exists!");
			updateQuickBooksInvoice(item, line, mgOrder, swUserId);
			return invoice;
		}
	}

	public Invoice updateQuickBooksInvoice(Item item, Line line, OrdersEntity mgOrder, String swUserId)
			throws SQLException, FMSException, ParseException {

		QueryResult queryResult = getQuickBooksInvoiceById(swUserId, mgOrder.getEntityId());
		Invoice invoice = (Invoice) queryResult.getEntities().get(0);
		invoice = invoiceData(invoice, item, mgOrder, line, swUserId);
		QuickBooksDataServiceFactory.updateDataService(swUserId, invoice);
		System.out.println("Invoice updated");
		return invoice;
	}

	public QueryResult getQuickBooksItemByName(String swUserId, String itemName) throws SQLException, FMSException {

		DataService service = QuickBooksDataServiceFactory.getDataService(swUserId);
		Item item = GenerateQuery.createQueryEntity(Item.class);
		String query = select($(item)).where($(item.getName()).eq(itemName)).generate();
		QueryResult queryResult = service.executeQuery(query);

		return queryResult;
	}

	/*
	 * Need to finish this part: like at the customers. create and update.
	 */

	private Item itemData(Item item, OrderItem items, OrdersEntity mgOrder) {

		item.setActive(true);
		item.setType(ItemTypeEnum.INVENTORY);
		item.setName(items.getName());
		BigDecimal price = new BigDecimal(items.getBasePrice());
		item.setUnitPrice(price);
		ReferenceType incAccountRef = new ReferenceType();
		incAccountRef.setName("Sales of Product Income");
		incAccountRef.setValue("79");
		item.setIncomeAccountRef(incAccountRef);
		item.setDescription(items.getName());
		ReferenceType expenseAccRef = new ReferenceType();
		expenseAccRef.setName("Cost of Goods Sold");
		expenseAccRef.setValue("80");
		item.setExpenseAccountRef(expenseAccRef);

		return item;
	}

	public Item createQuickBooksItems(OrdersEntity mgOrder, String swUserId) throws SQLException, FMSException {

		Item item = new Item();

		for (OrderItem items : mgOrder.getOrderItems()) {
			if (items.getParentItemId() == null) {

				item = itemData(item, items, mgOrder);

				QueryResult queryResult = getQuickBooksItemByName(swUserId, item.getName());
				if (queryResult.getEntities().size() == 0) {
					QuickBooksDataServiceFactory.postDataService(swUserId, item);
				} else {
					updateQuickBooksItems(mgOrder, swUserId);
					System.out.println("Item already exists!");
				}
			}
		}
		return item;
	}

	public Item updateQuickBooksItems(OrdersEntity mgOrder, String swUserId) throws SQLException, FMSException {

		Item item = null;

		for (OrderItem items : mgOrder.getOrderItems()) {
			if (items.getParentItemId() == null) {

				QueryResult queryResult = getQuickBooksItemByName(swUserId, items.getName());
				item = (Item) queryResult.getEntities().get(0);
				item = itemData(item, items, mgOrder);
				QuickBooksDataServiceFactory.updateDataService(swUserId, item);
			}
		}
		return item;
	}
}
