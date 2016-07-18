package com.mule.magento.actions;

import java.sql.SQLException;

import javax.xml.bind.JAXBException;

import com.intuit.ipp.exception.FMSException;
import com.mule.magento.syncdata.SyncMagentoContactsToQuickBooks;

public class TestQBSyncContacts {

	public static void main(String[] args) {

		try {
			SyncMagentoContactsToQuickBooks.syncContactsToQB("10", "20");
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (JAXBException e) {
			e.printStackTrace();
		} catch (FMSException e) {
			e.printStackTrace();
		}

	}

}
