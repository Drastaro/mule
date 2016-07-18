package com.mule.xero.data;

import com.google.api.client.auth.oauth.OAuthHmacSigner;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.mule.utils.propertiesutils.XeroPropertiesUtils;
import com.mule.xero.controller.OAuthGetResource;
import com.mule.xero.pojo.XeroTokens;

public class XeroDataFactory {

	public static OAuthGetResource getOauthResource(String resourceName, XeroTokens tokens) {
		OAuthGetResource getResource = new OAuthGetResource(XeroPropertiesUtils.XERO_URL + resourceName);
		getResource.signer = createSigner(tokens.getAccessTokenSecret());
		getResource.consumerKey = XeroPropertiesUtils.OAUTH_CONSUMER_KEY;
		getResource.token = tokens.getAccessToken();
		getResource.transport = new NetHttpTransport();

		return getResource;
	}

	private static OAuthHmacSigner createSigner(String accessTokenSecret) {
		OAuthHmacSigner signer = new OAuthHmacSigner();
		signer.clientSharedSecret = XeroPropertiesUtils.OAUTH_CONSUMER_SECRET;
		signer.tokenSharedSecret = accessTokenSecret;
		return signer;
	}

}
