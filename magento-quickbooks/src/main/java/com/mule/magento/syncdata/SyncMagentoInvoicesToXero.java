package com.mule.magento.syncdata;

import java.io.IOException;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.xml.bind.JAXBException;

import org.mule.api.ConnectionException;

import com.google.gson.Gson;
import com.mule.generated.pojo.OrdersEntity;
import com.mule.magento.dao.MagentoPersistanceDAO;
import com.mule.magento.dao.MagentoQueryDAO;
import com.mule.xero.dao.XeroDataControlerDAO;
import com.silverwiresapp.admin.xeroauth.api.xsd.Invoice;

public class SyncMagentoInvoicesToXero {

	public Invoice syncInvoice(String magentoSwUserId, String xeroSwUserId) throws SQLException, ConnectionException,
			IOException, ParseException, JAXBException {

		/*
		 * 196 = mircea's last order
		 */
		Invoice invoice = null;
		Date date = new Date();
		XeroDataControlerDAO xeroDAO = new XeroDataControlerDAO();
		date = MagentoPersistanceDAO.getLastSyncDate(xeroSwUserId, "magento", "xero");
		if (date == null) {

			String values = MagentoQueryDAO.getMagentoLimitData(magentoSwUserId, "orders/78");
			Gson gson = new Gson();
			OrdersEntity orders = gson.fromJson(values, OrdersEntity.class);
			invoice = xeroDAO.createXeroInvoice(orders, xeroSwUserId);
			date = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String newDate = sdf.format(date);

			MagentoPersistanceDAO.insertLastSyncDate(xeroSwUserId, "magento", "xero", newDate, "invoice");
			return invoice;

		} else {
			String values = MagentoQueryDAO.getMagentoData(magentoSwUserId, "orders"
					+ "?filter[0][attribute]=created_at&filter[0][from][0]=" + date);
			if (values.toString().equals("[]")) {
				System.err.println("Everything is up to date!");
			} else {

				Gson gson = new Gson();
				OrdersEntity orders = gson.fromJson(values, OrdersEntity.class);
				invoice = xeroDAO.createXeroInvoice(orders, xeroSwUserId);
				date = new Date();
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				String newDate = sdf.format(date);
				MagentoPersistanceDAO.updateLastSyncDate(xeroSwUserId, "magento", "xero", newDate, "invoice");
				return invoice;
			}
		}
		return invoice;
	}
}
