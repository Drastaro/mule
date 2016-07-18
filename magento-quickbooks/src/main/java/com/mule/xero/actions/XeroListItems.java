package com.mule.xero.actions;

import java.io.StringReader;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.mule.api.MuleEventContext;
import org.mule.api.lifecycle.Callable;

import com.mule.xero.dao.XeroQueryDAO;
import com.silverwiresapp.admin.xeroauth.api.xsd.Item;

public class XeroListItems implements Callable {

	@Override
	public Object onCall(MuleEventContext eventContext) throws Exception {

		String swUserId = eventContext.getMessage().getInvocationProperty("swUserId");
		return getXeroItems(swUserId);

	}

	public static List<Item> getXeroItems(String swUserId) throws SQLException, JAXBException {

		String item = XeroQueryDAO.getXeroData(swUserId, "items");
		StringReader sr = new StringReader(item);
		JAXBContext jaxbContext = JAXBContext.newInstance(Item.class);
		Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
		Item items = (Item) unmarshaller.unmarshal(sr);

		List<Item> xeroItems = new ArrayList<>();
		xeroItems.add(items);

		return xeroItems;

	}
}
