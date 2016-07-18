package com.mule.quickbooks.dao;

import java.sql.SQLException;

import com.github.scribejava.core.builder.ServiceBuilder;
import com.github.scribejava.core.model.OAuthRequest;
import com.github.scribejava.core.model.Response;
import com.github.scribejava.core.model.Token;
import com.github.scribejava.core.model.Verb;
import com.github.scribejava.core.oauth.OAuthService;
import com.mule.quickbooks.pojo.QuickBooksTokens;
import com.mule.scribe.QuickBooksScribeApi;
import com.mule.scribe.XeroScribeApi;
import com.mule.utils.propertiesutils.QuickBooksPropertiesUtils;
import com.mule.utils.propertiesutils.XeroPropertiesUtils;
import com.mule.xero.dao.XeroPersistenceDAO;
import com.mule.xero.pojo.XeroTokens;

public class QuickBooksQueryDAO {
	public static String getQuicksBooksData(String swUserId, String action) throws SQLException {

		OAuthService service = new ServiceBuilder().provider(QuickBooksScribeApi.class)
				.apiKey(QuickBooksPropertiesUtils.OAUTH_CONSUMER_KEY)
				.apiSecret(QuickBooksPropertiesUtils.OAUTH_CONSUMER_SECRET).build();

		System.out.println("quickBooks service built");
		QuickBooksTokens quickTokens = QuickBooksPersistenceDAO.getQuickBooksTokensBySwUserId(swUserId);
		Token accesToken = new Token(quickTokens.getAccessToken(), quickTokens.getAccessTokenSecret());
		OAuthRequest request = new OAuthRequest(Verb.GET, QuickBooksPropertiesUtils.QBO_URL
				+ quickTokens.getQboCompanyId() + "/" + action, service);
		service.signRequest(accesToken, request);
		Response response = request.send();
		System.out.println("Got it! Lets see what we found...");
		System.out.println();
		System.out.println(response.getBody());

		return response.getBody().toString();
	}

	public static String createQuickBoocksData(String fromatedString, String swUserId) throws SQLException {

		OAuthService service = new ServiceBuilder().provider(QuickBooksScribeApi.class)
				.apiKey(QuickBooksPropertiesUtils.OAUTH_CONSUMER_KEY)
				.apiSecret(QuickBooksPropertiesUtils.OAUTH_CONSUMER_SECRET).build();

		System.out.println("quickBooks service built");
		QuickBooksTokens quickTokens = QuickBooksPersistenceDAO.getQuickBooksTokensBySwUserId(swUserId);
		String companyID = quickTokens.getQboCompanyId();
		Token accesToken = new Token(quickTokens.getAccessToken(), quickTokens.getAccessTokenSecret());
		OAuthRequest request = new OAuthRequest(Verb.POST, QuickBooksPropertiesUtils.QBO_URL + companyID + "/customer",
				service);
		request.addHeader("Content-Type", "application/json");
		System.out.println(fromatedString);
		request.addPayload(fromatedString);
		service.signRequest(accesToken, request);
		Response response = request.send();
		System.out.println("Got it! Lets see what we found...");
		System.out.println();
		System.out.println(response.getBody());

		return response.getBody().toString();
	}

}
