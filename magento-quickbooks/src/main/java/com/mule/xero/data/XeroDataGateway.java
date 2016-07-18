package com.mule.xero.data;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.google.api.client.http.ByteArrayContent;
import com.google.api.client.http.HttpContent;
import com.google.api.client.http.HttpResponse;
import com.mule.xero.controller.OAuthGetResource;
import com.mule.xero.controller.XeroXmlManager;
import com.mule.xero.dao.XeroQueryDAO;
import com.mule.xero.dao.XeroPersistenceDAO;
import com.mule.xero.pojo.XeroTokens;
import com.silverwiresapp.admin.xeroauth.api.xsd.ArrayOfContact;
import com.silverwiresapp.admin.xeroauth.api.xsd.ArrayOfInvoice;
import com.silverwiresapp.admin.xeroauth.api.xsd.ArrayOfItem;
import com.silverwiresapp.admin.xeroauth.api.xsd.ArrayOfOrganisation;
import com.silverwiresapp.admin.xeroauth.api.xsd.ArrayOfTaxRate;
import com.silverwiresapp.admin.xeroauth.api.xsd.Contact;
import com.silverwiresapp.admin.xeroauth.api.xsd.Invoice;
import com.silverwiresapp.admin.xeroauth.api.xsd.Item;
import com.silverwiresapp.admin.xeroauth.api.xsd.Organisation;
import com.silverwiresapp.admin.xeroauth.api.xsd.TaxRate;

public class XeroDataGateway {

	public static List<Invoice> getInvoices(String swUserId) throws IOException, SQLException {

		// get xeroauth data from hibernate
		XeroPersistenceDAO xeroDAO = new XeroPersistenceDAO();
		XeroTokens tokens = xeroDAO.getXeroTokensBySwUserId(swUserId);

		// call xero with auth data
		HttpResponse response = XeroDataFactory.getOauthResource("Invoice", tokens).execute();

		ArrayOfInvoice arrayOfInvoices = XeroXmlManager.xmlToInvoices(response.getContent());
		if (arrayOfInvoices != null && arrayOfInvoices.getInvoice() != null) {

			return arrayOfInvoices.getInvoice();
		} else {
			return null;
		}
	}

	/*
	 * List of organisation
	 */

	public static List<Organisation> getOraganisations(String swUserId) throws IOException, SQLException {

		// get xeroauth data from hibernate
		XeroPersistenceDAO xeroDAO = new XeroPersistenceDAO();
		XeroTokens tokens = xeroDAO.getXeroTokensBySwUserId(swUserId);

		// call xero with auth data
		HttpResponse response = XeroDataFactory.getOauthResource("Organisation", tokens).execute();

		ArrayOfOrganisation array = XeroXmlManager.organisationsToXml(response.getContent());
		if (array != null && array.getOrganisation() != null) {

			return array.getOrganisation();
		} else {
			return null;
		}
	}

	public static List<Contact> getContacts(String swUserId) throws IOException, SQLException {

		// get xeroauth data from hibernate
		XeroPersistenceDAO xeroDAO = new XeroPersistenceDAO();
		XeroTokens tokens = xeroDAO.getXeroTokensBySwUserId(swUserId);

		// call xero with auth data
		HttpResponse response = XeroDataFactory.getOauthResource("Contact", tokens).execute();

		ArrayOfContact array = XeroXmlManager.contactsToXml(response.getContent());
		if (array != null && array.getContact() != null) {
			return array.getContact();
		} else {
			return null;
		}

	}

	public static List<TaxRate> getTaxRates(String swUserId) throws IOException, SQLException {

		// get xeroauth data from hibernate
		XeroPersistenceDAO xeroDAO = new XeroPersistenceDAO();
		XeroTokens tokens = xeroDAO.getXeroTokensBySwUserId(swUserId);

		// call xero with auth data
		HttpResponse response = XeroDataFactory.getOauthResource("TaxRate", tokens).execute();

		ArrayOfTaxRate array = XeroXmlManager.taxratesToXml(response.getContent());
		if (array != null && array.getTaxRate() != null) {
			return array.getTaxRate();
		} else {
			return null;
		}

	}

	public static void postInvoice(Invoice invoice, String swUserId) throws IOException, SQLException {

		// get xeroauth data from hibernate
		XeroPersistenceDAO xeroDAO = new XeroPersistenceDAO();
		XeroTokens tokens = xeroDAO.getXeroTokensBySwUserId(swUserId);

		String arrayString = XeroXmlManager.invoiceToXml(invoice);

		// call xero with auth data
		OAuthGetResource caller = XeroDataFactory.getOauthResource("Invoice", tokens);

		System.out.println("XXX" + arrayString);

		// caller.set("xml", arrayString);
		HttpContent content = new ByteArrayContent("application/xml", arrayString.getBytes());
		HttpResponse response = caller.executePost(content);
		System.out.println(response.getContent());

	}

	public static void createContact(Contact contact, String swUserId) throws IOException, SQLException {

		// get xeroauth data from hibernate
		XeroPersistenceDAO xeroDAO = new XeroPersistenceDAO();
		XeroTokens tokens = xeroDAO.getXeroTokensBySwUserId(swUserId);

		String arrayString = XeroXmlManager.contactToXml(contact);

		// call xero with auth data
		OAuthGetResource caller = XeroDataFactory.getOauthResource("Contact", tokens);
		System.out.println("Contact created:" + contact.getName());

		// caller.set("xml", arrayString);

		HttpContent content = new ByteArrayContent("application/xml", arrayString.getBytes());

		HttpResponse response = caller.executePost(content);

		System.out.println(response.getContent());
	}

	public static void createItem(Item item, String swUserId) throws SQLException, IOException {

		// get xeroauth data from hibernate
		XeroPersistenceDAO xeroDAO = new XeroPersistenceDAO();
		XeroTokens tokens = xeroDAO.getXeroTokensBySwUserId(swUserId);

		String arrayString = XeroXmlManager.itemToXml(item);

		// call xero with auth data
		OAuthGetResource caller = XeroDataFactory.getOauthResource("Item", tokens);

		System.out.println("XXX" + arrayString);

		// caller.set("xml", arrayString);
		HttpContent content = new ByteArrayContent("application/xml", arrayString.getBytes());
		HttpResponse response = caller.executePost(content);
		System.out.println(response.getContent());

	}

}
