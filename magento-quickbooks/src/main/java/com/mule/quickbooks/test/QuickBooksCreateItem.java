package com.mule.quickbooks.test;

import java.sql.SQLException;

import javax.xml.bind.JAXBException;

import com.intuit.ipp.exception.FMSException;
import com.mule.magento.syncdata.SyncMagentoItemsToQuickBooks;
import com.mule.quickbooks.dao.QuickBooksDataControlerDAO;

public class QuickBooksCreateItem {

	public static void main(String[] args) {

		SyncMagentoItemsToQuickBooks sync = new SyncMagentoItemsToQuickBooks();
		try {
			sync.syncItemsToQB("10", "20");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
