package com.mule.quickbooks.data;

import java.sql.SQLException;
import org.apache.poi.ss.formula.functions.T;
import com.intuit.ipp.core.Context;
import com.intuit.ipp.core.IEntity;
import com.intuit.ipp.core.ServiceType;
import com.intuit.ipp.exception.FMSException;
import com.intuit.ipp.security.OAuthAuthorizer;
import com.intuit.ipp.services.DataService;
import com.intuit.ipp.util.Config;
import com.mule.quickbooks.dao.QuickBooksPersistenceDAO;
import com.mule.quickbooks.pojo.QuickBooksTokens;
import com.mule.utils.propertiesutils.QuickBooksPropertiesUtils;

public class QuickBooksDataServiceFactory {

	/*
	 * need to make it work if the user exists to upadte it
	 */

	public static <T extends IEntity> DataService postDataService(String swUserId, T qboObject) {

		QuickBooksTokens tokens = null;
		try {
			tokens = QuickBooksPersistenceDAO.getQuickBooksTokensBySwUserId(swUserId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		OAuthAuthorizer oauth = new OAuthAuthorizer(QuickBooksPropertiesUtils.OAUTH_CONSUMER_KEY,
				QuickBooksPropertiesUtils.OAUTH_CONSUMER_SECRET, tokens.getAccessToken(), tokens.getAccessTokenSecret());

		Context context = null;
		try {
			context = new Context(oauth, ServiceType.QBO, tokens.getQboCompanyId());
		} catch (FMSException e) {
			e.printStackTrace();
		}
		Config.setProperty(Config.BASE_URL_QBO, "https://sandbox-quickbooks.api.intuit.com/v3/company");
		DataService service = new DataService(context);
		try {
			service.add(qboObject);
		} catch (FMSException e) {
			e.printStackTrace();
		}
		System.out.println("Object created:" + qboObject.getClass().getName());
		return service;
	}

	public static <T extends IEntity> DataService updateDataService(String swUserId, T qboObject) {

		QuickBooksTokens tokens = null;
		try {
			tokens = QuickBooksPersistenceDAO.getQuickBooksTokensBySwUserId(swUserId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		OAuthAuthorizer oauth = new OAuthAuthorizer(QuickBooksPropertiesUtils.OAUTH_CONSUMER_KEY,
				QuickBooksPropertiesUtils.OAUTH_CONSUMER_SECRET, tokens.getAccessToken(), tokens.getAccessTokenSecret());

		Context context = null;
		try {
			context = new Context(oauth, ServiceType.QBO, tokens.getQboCompanyId());
		} catch (FMSException e) {
			e.printStackTrace();
		}
		Config.setProperty(Config.BASE_URL_QBO, "https://sandbox-quickbooks.api.intuit.com/v3/company");
		DataService service = new DataService(context);
		try {
			service.update(qboObject);
		} catch (FMSException e) {
			e.printStackTrace();
		}
		System.out.println("Object created:" + qboObject.getClass().getName());
		return service;
	}

	public static DataService getDataService(String swUserId) throws SQLException, FMSException {

		QuickBooksTokens tokens = QuickBooksPersistenceDAO.getQuickBooksTokensBySwUserId(swUserId);
		OAuthAuthorizer oauth = new OAuthAuthorizer(QuickBooksPropertiesUtils.OAUTH_CONSUMER_KEY,
				QuickBooksPropertiesUtils.OAUTH_CONSUMER_SECRET, tokens.getAccessToken(), tokens.getAccessTokenSecret());

		Context context = new Context(oauth, ServiceType.QBO, tokens.getQboCompanyId());
		Config.setProperty(Config.BASE_URL_QBO, "https://sandbox-quickbooks.api.intuit.com/v3/company");
		DataService service = new DataService(context);

		return service;
	}
}
