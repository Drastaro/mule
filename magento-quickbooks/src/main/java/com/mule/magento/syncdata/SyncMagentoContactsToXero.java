package com.mule.magento.syncdata;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;
import org.mule.api.ConnectionException;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.mule.generated.pojo.Address;
import com.mule.generated.pojo.OrdersEntity;
import com.mule.magento.dao.MagentoPersistanceDAO;
import com.mule.magento.dao.MagentoQueryDAO;
import com.mule.magento.pojo.MagentoTokens;
import com.mule.xero.dao.XeroDataControlerDAO;

public class SyncMagentoContactsToXero {

	public XeroDataControlerDAO syncContacts(String magentoSwUserId, String xeroSwUserId) throws ConnectionException,
			SQLException, IOException {

		Gson gson = new Gson();
		List<Address> list = new ArrayList<Address>();
		XeroDataControlerDAO xeroDAO = new XeroDataControlerDAO();
		MagentoPersistanceDAO dao = new MagentoPersistanceDAO();
		MagentoTokens mgTokens = dao.getMagentoTokensBySwUserId(magentoSwUserId);
		/*
		 * get values from customers
		 */
		String customersValue = MagentoQueryDAO.getMagentoData(magentoSwUserId, "customers/137");
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
					mgTokens.getAccessTokenSecret(), "customers/" + "137" + "/addresses");

		}
		System.out.println("customer adress" + customerAddress);
		List<Address> listRecived = (List<Address>) gson.fromJson(customerAddress, new TypeToken<List<Address>>() {
		}.getType());
		list.add(adress);
		OrdersEntity orders = new OrdersEntity();
		orders.setAddresses(list);
		orders.setAddresses(listRecived);
		xeroDAO.createXeroContact(orders, xeroSwUserId);

		System.out.println("orders values:" + orders.getEntityId());
		System.out.println("Contact created:" + xeroDAO);

		return xeroDAO;

	}
}
