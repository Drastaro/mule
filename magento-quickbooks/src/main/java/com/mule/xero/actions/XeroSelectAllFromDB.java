package com.mule.xero.actions;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.mule.api.MuleEventContext;
import org.mule.api.lifecycle.Callable;

import com.mule.utils.persistanceutils.DBHelper;
import com.mule.xero.pojo.XeroTokens;

public class XeroSelectAllFromDB implements Callable {

	XeroTokens result = null;

	@Override
	public Object onCall(MuleEventContext eventContext) throws Exception {

		return this.getTokens();
	}

	public List<XeroTokens> getTokens() throws SQLException {

		Connection con = DBHelper.createConnection();
		String query = "SELECT * FROM xero_tokens";
		PreparedStatement stmt = con.prepareStatement(query);
		List<XeroTokens> list = new ArrayList<>();

		ResultSet rs = stmt.executeQuery();
		while (rs.next()) {
			XeroTokens xero = new XeroTokens();
			xero.setSwUserId(rs.getString("sw_user_id"));
			xero.setConusmerKey(rs.getString("consumer_key"));
			xero.setConsumerSecret(rs.getString("consumer_secret"));
			xero.setAuthUrl(rs.getString("auth_url"));
			xero.setAccessToken(rs.getString("access_token"));
			xero.setAccessTokenSecret(rs.getString("access_token_secret"));

			list.add(xero);

		}
		DBHelper.closeConnection(con);
		return list;
	}

}
