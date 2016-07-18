package com.mule.xero.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mule.utils.persistanceutils.DBHelper;
import com.mule.xero.pojo.XeroSettings;
import com.mule.xero.pojo.XeroTokens;

public class XeroPersistenceDAO {

	public static List<XeroTokens> getAllData() throws SQLException {
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

	public static XeroTokens getXeroTokensBySwUserId(String swUserId) throws SQLException {

		Connection con = DBHelper.createConnection();
		String query = "SELECT * FROM xero_tokens WHERE sw_user_id=?";
		PreparedStatement stmt = con.prepareStatement(query);

		stmt.setString(1, swUserId);
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
		return list.get(0);
	}

	public static XeroSettings getXeroSettingsBySwUserId(String swUserId) throws SQLException {

		Connection con = DBHelper.createConnection();
		String query = "SELECT * FROM magento_xero_settings WHERE sw_user_id=?";
		PreparedStatement stmt = con.prepareStatement(query);
		stmt.setString(1, swUserId);
		XeroSettings xero = null;

		ResultSet rs = stmt.executeQuery();
		while (rs.next()) {

			int incomeAccountId = rs.getInt("income_account_id");
			xero = new XeroSettings(swUserId, incomeAccountId);
		}
		DBHelper.closeConnection(con);
		return xero;
	}

	public static void saveXeroSettings(String swUserId, String incomeAccountId) throws SQLException {

		Connection con = DBHelper.createConnection();
		String insertString = "INSERT INTO magento_xero_settings (sw_user_id,income_account_id) values(?,?)";
		PreparedStatement stmt = con.prepareStatement(insertString);

		stmt.setString(1, swUserId);
		stmt.setString(2, incomeAccountId);
		stmt.executeUpdate();
		DBHelper.closeConnection(con);
	}

	public static void updateXeroSettings(String swUserId, String incomeAccountId) throws SQLException {

		Connection con = DBHelper.createConnection();
		String insertString = "UPDATE magento_xero_settings SET sw_user_id=?,income_account_id=? WHERE sw_user_id="
				+ swUserId;
		PreparedStatement stmt = con.prepareStatement(insertString);

		stmt.setString(1, swUserId);
		stmt.setString(2, incomeAccountId);
		stmt.executeUpdate();
		DBHelper.closeConnection(con);
	}
}
