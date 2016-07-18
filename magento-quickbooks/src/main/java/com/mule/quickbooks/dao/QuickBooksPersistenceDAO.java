package com.mule.quickbooks.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mule.quickbooks.pojo.QuickBooksSettings;
import com.mule.quickbooks.pojo.QuickBooksTokens;
import com.mule.utils.persistanceutils.DBHelper;

public class QuickBooksPersistenceDAO {

	public static List<QuickBooksTokens> getAllFromQuickBooksTokens() throws SQLException {
		Connection con = DBHelper.createConnection();
		String query = "SELECT * FROM quickbooks_tokens";
		PreparedStatement stmt = con.prepareStatement(query);
		List<QuickBooksTokens> list = new ArrayList<>();

		ResultSet rs = stmt.executeQuery();
		while (rs.next()) {
			QuickBooksTokens quickTokens = new QuickBooksTokens();
			quickTokens.setSwUserId(rs.getString("sw_user_id"));
			quickTokens.setRequestToken(rs.getString("consumer_key"));
			quickTokens.setRequestTokenSecret(rs.getString("consumer_secret"));
			quickTokens.setAuthUrl(rs.getString("auth_url"));
			quickTokens.setAccessToken(rs.getString("access_token"));
			quickTokens.setAccessTokenSecret(rs.getString("access_token_secret"));
			quickTokens.setQboCompanyId(rs.getString("company_id"));

			list.add(quickTokens);
		}
		DBHelper.closeConnection(con);
		return list;
	}

	public static QuickBooksTokens getQuickBooksTokensBySwUserId(String swUserId) throws SQLException {

		Connection con = DBHelper.createConnection();
		String query = "SELECT * FROM quickbooks_tokens WHERE sw_user_id=?";
		PreparedStatement stmt = con.prepareStatement(query);

		stmt.setString(1, swUserId);
		List<QuickBooksTokens> list = new ArrayList<>();

		ResultSet rs = stmt.executeQuery();
		while (rs.next()) {
			QuickBooksTokens quickTokens = new QuickBooksTokens();
			quickTokens.setSwUserId(rs.getString("sw_user_id"));
			quickTokens.setRequestToken(rs.getString("consumer_key"));
			quickTokens.setRequestTokenSecret(rs.getString("consumer_secret"));
			quickTokens.setAuthUrl(rs.getString("auth_url"));
			quickTokens.setAccessToken(rs.getString("access_token"));
			quickTokens.setAccessTokenSecret(rs.getString("access_token_secret"));
			quickTokens.setQboCompanyId(rs.getString("company_id"));

			list.add(quickTokens);
		}
		DBHelper.closeConnection(con);
		return list.get(0);
	}

	public static QuickBooksSettings getQuickBooksSettingsBySwUserId(String swUserId) throws SQLException {

		Connection con = DBHelper.createConnection();
		String query = "SELECT * FROM magento_quickbooks_settings WHERE sw_user_id=?";
		PreparedStatement stmt = con.prepareStatement(query);
		QuickBooksSettings settings = null;

		stmt.setString(1, swUserId);

		ResultSet rs = stmt.executeQuery();
		while (rs.next()) {

			int incomeAccountId = rs.getInt("income_account_id");
			settings = new QuickBooksSettings(swUserId, incomeAccountId);
		}
		DBHelper.closeConnection(con);
		return settings;
	}

	public static void saveQuickBooksSettings(String swUserId, String incomeAccountId) throws SQLException {

		Connection con = DBHelper.createConnection();
		String insertString = "INSERT INTO magento_quickbooks_settings (sw_user_id,income_account_id) values(?,?)";
		PreparedStatement stmt = con.prepareStatement(insertString);

		stmt.setString(1, swUserId);
		stmt.setString(2, incomeAccountId);
		stmt.executeUpdate();
		DBHelper.closeConnection(con);
	}

	public static void updateQuickBooksSettings(String swUserId, String incomeAccountId) throws SQLException {

		Connection con = DBHelper.createConnection();
		String insertString = "UPDATE INTO magento_quickBooks_settings (sw_user_id,income_account_id) values(?,?) WHERE sw_user_id="
				+ swUserId;
		PreparedStatement stmt = con.prepareStatement(insertString);

		stmt.setString(1, swUserId);
		stmt.setString(2, incomeAccountId);
		stmt.executeUpdate();
		DBHelper.closeConnection(con);
	}
}
