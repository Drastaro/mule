package com.mule.xero.dao;

import java.sql.SQLException;
import com.github.scribejava.core.builder.ServiceBuilder;
import com.github.scribejava.core.model.OAuthRequest;
import com.github.scribejava.core.model.Response;
import com.github.scribejava.core.model.Token;
import com.github.scribejava.core.model.Verb;
import com.github.scribejava.core.oauth.OAuthService;
import com.mule.scribe.XeroScribeApi;
import com.mule.utils.propertiesutils.XeroPropertiesUtils;
import com.mule.xero.pojo.XeroTokens;

public class XeroQueryDAO {

	public static String getXeroData(String swUserId, String action) throws SQLException {

		OAuthService service = new ServiceBuilder().provider(XeroScribeApi.class)
				.apiKey(XeroPropertiesUtils.OAUTH_CONSUMER_KEY).apiSecret(XeroPropertiesUtils.OAUTH_CONSUMER_SECRET)
				.build();

		XeroTokens xeroTokens = XeroPersistenceDAO.getXeroTokensBySwUserId(swUserId);
		Token accesToken = new Token(xeroTokens.getAccessToken(), xeroTokens.getAccessTokenSecret());
		System.out.println(xeroTokens.getAccessToken() + "\n" + xeroTokens.getAccessTokenSecret());

		OAuthRequest request = new OAuthRequest(Verb.GET, XeroPropertiesUtils.XERO_URL + action, service);
		service.signRequest(accesToken, request);
		Response response = request.send();
		System.out.println("Got it! Lets see what we found...");
		System.out.println();
		System.out.println(response.getBody());

		return response.getBody().toString();
	}

	public static String createXeroData(String array, String swUserId, String action) throws SQLException {

		OAuthService service = new ServiceBuilder().provider(XeroScribeApi.class)
				.apiKey(XeroPropertiesUtils.OAUTH_CONSUMER_KEY).apiSecret(XeroPropertiesUtils.OAUTH_CONSUMER_SECRET)
				.callback(XeroPropertiesUtils.OAUTH_CALLBACK_URL).build();

		System.out.println("xero service built");
		XeroTokens xeroTokens = XeroPersistenceDAO.getXeroTokensBySwUserId("20");
		Token accesToken = new Token(xeroTokens.getAccessToken(), xeroTokens.getAccessTokenSecret());
		OAuthRequest request = new OAuthRequest(Verb.POST, XeroPropertiesUtils.XERO_URL + "contacts", service);
		service.signRequest(accesToken, request);
		request.addPayload(array);
		Response response = request.send();
		System.out.println("Got it! Lets see what we found...");
		System.out.println();
		System.out.println(response.getBody());

		return response.getBody().toString();
	}
}
