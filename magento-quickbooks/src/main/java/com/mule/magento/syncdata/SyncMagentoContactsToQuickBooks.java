package com.mule.magento.syncdata;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.xml.bind.JAXBException;

import org.json.JSONObject;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.intuit.ipp.exception.FMSException;
import com.mule.generated.pojo.Address;
import com.mule.generated.pojo.OrdersEntity;
import com.mule.magento.dao.MagentoPersistanceDAO;
import com.mule.magento.dao.MagentoQueryDAO;
import com.mule.magento.pojo.MagentoTokens;
import com.mule.quickbooks.dao.QuickBooksDataControlerDAO;

public class SyncMagentoContactsToQuickBooks {

	public static QuickBooksDataControlerDAO syncContactsToQB(String magentoSwUserId, String qbSwUserId)
			throws SQLException, JAXBException, FMSException {

		Gson gson = new Gson();
		List<Address> list = new ArrayList<Address>();
		MagentoPersistanceDAO dao = new MagentoPersistanceDAO();
		MagentoTokens mgTokens = dao.getMagentoTokensBySwUserId(magentoSwUserId);
		QuickBooksDataControlerDAO qbDAO = new QuickBooksDataControlerDAO();

		/*
		 * get values from customers 137-Mircea
		 */

		String customersValue = MagentoQueryDAO.getMagentoData(magentoSwUserId, "customers/");
		System.out.println("cust value:" + customersValue);
		Address adress = gson.fromJson(customersValue, Address.class);
		/*
		 * get customer address
		 */

		String customerAddress = null;

		JSONObject jObject = new JSONObject(customersValue.trim());
		Iterator<?> keys = jObject.keys();

		while (keys.hasNext()) {
			String key = (String) keys.next();
			System.out.println(key);
			customerAddress = MagentoQueryDAO.getMagentoDataWithoutTokens(mgTokens.getAccessToken(),
					mgTokens.getAccessTokenSecret(), "customers/" + key + "/addresses");

		}
		System.out.println("customer adress" + customerAddress);
		List<Address> listRecived = gson.fromJson(customerAddress, new TypeToken<List<Address>>() {
		}.getType());
		list.add(adress);
		OrdersEntity orders = new OrdersEntity();
		orders.setAddresses(list);
		orders.setAddresses(listRecived);
		qbDAO.createQuickBooksCustomer(orders, qbSwUserId);
		System.out.println("Contact created:" + qbDAO);

		return qbDAO;

	}

}
