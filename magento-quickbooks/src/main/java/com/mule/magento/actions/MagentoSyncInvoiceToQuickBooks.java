package com.mule.magento.actions;

import java.sql.SQLException;
import java.text.ParseException;

import javax.xml.bind.JAXBException;

import com.intuit.ipp.exception.FMSException;
import com.mule.magento.syncdata.SyncMagentoInvoiceToQuickBooks;

public class MagentoSyncInvoiceToQuickBooks {

	public static void main(String[] args) {

		SyncMagentoInvoiceToQuickBooks syncInvoice = new SyncMagentoInvoiceToQuickBooks();
		try {
			syncInvoice.syncInvoiceToQB("10", "20");
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (JAXBException e) {
			e.printStackTrace();
		} catch (FMSException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}

	}

}
