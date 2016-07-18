package com.mule.magento.syncdata;

import java.sql.SQLException;

import javax.xml.bind.JAXBException;

import com.google.gson.Gson;
import com.intuit.ipp.data.Invoice;
import com.intuit.ipp.data.Item;
import com.intuit.ipp.exception.FMSException;
import com.mule.generated.pojo.OrdersEntity;
import com.mule.magento.dao.MagentoQueryDAO;
import com.mule.quickbooks.dao.QuickBooksDataControlerDAO;

public class SyncMagentoItemsToQuickBooks {

	public Item syncItemsToQB(String magentoSwUserId, String qbSwUserId) throws SQLException, JAXBException,
			FMSException {

		/*
		 * 196 = mircea's last order
		 */
		// Date date = new Date();
		QuickBooksDataControlerDAO qbDAO = new QuickBooksDataControlerDAO();
		// date = MagentoPersistanceDAOImpl.getLastSyncDate(xeroSwUserId,
		// "magento_invoices");
		// if (date == null) {

		String values = null;
		try {
			values = MagentoQueryDAO.getMagentoLimitData(magentoSwUserId, "orders/196");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Gson gson = new Gson();
		OrdersEntity orders = gson.fromJson(values, OrdersEntity.class);
		Item item = qbDAO.createQuickBooksItems(orders, qbSwUserId);
		// date = new Date();
		// SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		// String newDate = sdf.format(date);

		// MagentoPersistanceDAOImpl.insertLastSyncDate(xeroSwUserId,
		// "magento_invoices", newDate);
		return item;

		// } else {
		// String values = MagentoQueryDAO.getMagentoData(magentoSwUserId,
		// "orders"
		// + "?filter[0][attribute]=created_at&filter[0][from][0]=" + date);
		// Gson gson = new Gson();
		// OrdersEntity orders = gson.fromJson(values, OrdersEntity.class);
		// Invoice invoice = xeroDAO.createScribeInvoice(orders, xeroSwUserId);
		// date = new Date();
		// SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		// String newDate = sdf.format(date);
		// MagentoPersistanceDAOImpl.updateLastSyncDate(xeroSwUserId,
		// "magento_invoices", newDate);
		// return invoice;
		// }
	}

}
