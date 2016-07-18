package com.mule.magento.syncdata;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.xml.bind.JAXBException;
import com.google.gson.Gson;
import com.intuit.ipp.data.Invoice;
import com.intuit.ipp.exception.FMSException;
import com.mule.generated.pojo.OrdersEntity;
import com.mule.magento.dao.MagentoPersistanceDAO;
import com.mule.magento.dao.MagentoQueryDAO;
import com.mule.quickbooks.dao.QuickBooksDataControlerDAO;

public class SyncMagentoInvoiceToQuickBooks {

	public Invoice syncInvoiceToQB(String magentoSwUserId, String qbSwUserId) throws SQLException, JAXBException,
			FMSException, ParseException {

		/*
		 * 196 = mircea's last order
		 */
		Invoice invoice = null;
		Date date = new Date();
		QuickBooksDataControlerDAO qbDAO = new QuickBooksDataControlerDAO();
		date = MagentoPersistanceDAO.getLastSyncDate(qbSwUserId, "magento", "quickbooks");
		if (date == null) {

			String values = null;
			try {
				values = MagentoQueryDAO.getMagentoLimitData(magentoSwUserId, "orders/196");
			} catch (SQLException e) {
				e.printStackTrace();
			}
			Gson gson = new Gson();
			OrdersEntity orders = gson.fromJson(values, OrdersEntity.class);
			invoice = qbDAO.createQuickBooksInvoice(orders, qbSwUserId);

			date = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String newDate = sdf.format(date);

			MagentoPersistanceDAO.insertLastSyncDate(qbSwUserId, "magento", "quickbooks", newDate, "invoice");
			return invoice;

		} else {
			String values = MagentoQueryDAO.getMagentoData(magentoSwUserId, "orders"
					+ "?filter[0][attribute]=created_at&filter[0][from][0]=" + date);
			if (values.toString().equals("[]")) {
				System.err.println("Everything is up to date!");
			} else {

				Gson gson = new Gson();
				OrdersEntity orders = gson.fromJson(values, OrdersEntity.class);
				invoice = qbDAO.createQuickBooksInvoice(orders, qbSwUserId);
				date = new Date();
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				String newDate = sdf.format(date);
				MagentoPersistanceDAO.updateLastSyncDate(qbSwUserId, "magento", "quickbooks", newDate, "invoice");

				return invoice;
			}

		}
		return invoice;
	}
}
