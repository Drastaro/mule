package com.mule.magento.dao;

import java.sql.SQLException;

import com.github.scribejava.core.builder.ServiceBuilder;
import com.github.scribejava.core.model.OAuthRequest;
import com.github.scribejava.core.model.Response;
import com.github.scribejava.core.model.Token;
import com.github.scribejava.core.model.Verb;
import com.github.scribejava.core.oauth.OAuthService;
import com.mule.generated.pojo.OrdersEntity;
import com.mule.magento.pojo.MagentoTokens;
import com.mule.scribe.MagentoScribeApi;
import com.mule.utils.propertiesutils.MagentoPropertiesUtils;
import com.mule.utils.propertiesutils.XeroPropertiesUtils;
import com.mule.xero.dao.XeroPersistenceDAO;
import com.mule.xero.pojo.XeroTokens;
import com.silverwiresapp.admin.xeroauth.api.xsd.Contact;

public class MagentoQueryDAO {

	public static String getMagentoLimitData(String swUserId, String action) throws SQLException {

		OAuthService service = new ServiceBuilder().provider(MagentoScribeApi.class)
				.apiKey(MagentoPropertiesUtils.MAGENTO_API_KEY).apiSecret(MagentoPropertiesUtils.MAGENTO_API_SECRET)
				.callback(MagentoPropertiesUtils.OAUTH_CALLBACK_URL).build();
		System.out.println("service built");
		MagentoPersistanceDAO dao = new MagentoPersistanceDAO();
		MagentoTokens mgTokens = dao.getMagentoTokensBySwUserId(swUserId);
		Token accesToken = new Token(mgTokens.getAccessToken(), mgTokens.getAccessTokenSecret());

		System.out.println("tokens from db:" + accesToken);
		OAuthRequest request = new OAuthRequest(Verb.GET, MagentoPropertiesUtils.MAGENTO_REST_URL + "/" + action
				+ "?limit=100", service);
		service.signRequest(accesToken, request);
		Response response = request.send();
		System.out.println("Got it! Lets see what we found...");
		System.out.println();
		System.out.println(response.getBody());
		return response.getBody().toString();

	}

	public static String getMagentoData(String swUserId, String action) throws SQLException {

		OAuthService service = new ServiceBuilder().provider(MagentoScribeApi.class)
				.apiKey(MagentoPropertiesUtils.MAGENTO_API_KEY).apiSecret(MagentoPropertiesUtils.MAGENTO_API_SECRET)
				.callback(MagentoPropertiesUtils.OAUTH_CALLBACK_URL).build();
		System.out.println("service built");
		MagentoPersistanceDAO dao = new MagentoPersistanceDAO();
		MagentoTokens mgTokens = dao.getMagentoTokensBySwUserId(swUserId);
		Token accesToken = new Token(mgTokens.getAccessToken(), mgTokens.getAccessTokenSecret());

		OAuthRequest request = new OAuthRequest(Verb.GET, MagentoPropertiesUtils.MAGENTO_REST_URL + "/" + action,
				service);
		service.signRequest(accesToken, request);
		Response response = request.send();
		System.out.println("Got it! Lets see what we found...");
		System.out.println();
		System.out.println(response.getBody());
		return response.getBody().toString();

	}

	public static String getMagentoDataWithoutTokens(String token, String accesTokenSecret, String action) {

		OAuthService service = new ServiceBuilder().provider(MagentoScribeApi.class)
				.apiKey(MagentoPropertiesUtils.MAGENTO_API_KEY).apiSecret(MagentoPropertiesUtils.MAGENTO_API_SECRET)
				.callback(MagentoPropertiesUtils.OAUTH_CALLBACK_URL).build();
		System.out.println("service built");

		Token accesToken = new Token(token, accesTokenSecret);
		OAuthRequest request = new OAuthRequest(Verb.GET, MagentoPropertiesUtils.MAGENTO_REST_URL + "/" + action
				+ "?limit=100", service);
		service.signRequest(accesToken, request);
		Response response = request.send();
		System.out.println("Got it! Lets see what we found...");
		System.out.println();
		System.out.println(response.getBody());

		return response.getBody().toString();
	}
}