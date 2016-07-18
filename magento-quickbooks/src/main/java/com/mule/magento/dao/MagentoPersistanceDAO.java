package com.mule.magento.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import com.mule.magento.pojo.MagentoAuthData;
import com.mule.magento.pojo.MagentoTokens;
import com.mule.utils.persistanceutils.DBHelper;

public class MagentoPersistanceDAO {

	public MagentoAuthData getMagentoAuthDataBySwUserId(String swUserId) throws SQLException {
		MagentoAuthData result = null;

		Connection con = DBHelper.createConnection();
		String query = "SELECT * FROM magento_data WHERE sw_user_id=?";
		PreparedStatement stmt = con.prepareStatement(query);

		stmt.setString(1, swUserId);

		ResultSet rs = stmt.executeQuery();
		if (rs.next()) {
			int id = rs.getInt("id");
			String swUserIdentifier = rs.getString("sw_user_id");
			String magentoUsername = rs.getString("username");
			String magentoPass = rs.getString("pass");
			String magentoURL = rs.getString("url");
			result = new MagentoAuthData(id, swUserIdentifier, magentoUsername, magentoPass, magentoURL);

		}
		DBHelper.closeConnection(con);
		return result;
	}

	public MagentoTokens getMagentoTokensBySwUserId(String swUserId) throws SQLException {

		MagentoTokens result = null;

		Connection con = DBHelper.createConnection();
		String query = "SELECT * FROM magento_tokens WHERE SW_USER_ID=?";
		PreparedStatement stmt = con.prepareStatement(query);
		stmt.setString(1, swUserId);

		ResultSet rs = stmt.executeQuery();
		if (rs.next()) {

			String accesToken = rs.getString("ACCESS_TOKEN");
			String accesTokenSecret = rs.getString("ACCESS_TOKEN_SECRET");
			System.out.println(accesToken + accesTokenSecret);
			result = new MagentoTokens(accesToken, accesTokenSecret);
		}
		DBHelper.closeConnection(con);
		return result;
	}

	public static void insertLastSyncDate(String swUserId, String syncronizedFrom, String syncronizedTo, String date,
			String syncItem) throws SQLException {

		Connection con = DBHelper.createConnection();
		String insertString = "INSERT INTO items_sync (sw_user_id,syncronized_from,syncronized_to,last_sync_date,sync_item) values(?,?,?,?,?)";
		PreparedStatement stmt = con.prepareStatement(insertString);

		stmt.setString(1, swUserId);
		stmt.setString(2, syncronizedFrom);
		stmt.setString(3, syncronizedTo);
		stmt.setString(4, date);
		stmt.setString(5, syncItem);

		stmt.executeUpdate();
		DBHelper.closeConnection(con);
	}

	public static void updateLastSyncDate(String swUserId, String syncronizedFrom, String syncronizedTo, String date,
			String syncItem) throws SQLException {

		Connection con = DBHelper.createConnection();
		String insertString = "UPDATE INTO items_sync (sw_user_id,syncronized_from,syncronized_to,last_sync_date,sync_item) values(?,?,?,?,?) WHERE sw_user_id="
				+ swUserId;
		PreparedStatement stmt = con.prepareStatement(insertString);

		stmt.setString(1, swUserId);
		stmt.setString(2, syncronizedFrom);
		stmt.setString(3, syncronizedTo);
		stmt.setString(4, date);
		stmt.setString(5, syncItem);

		stmt.executeUpdate();
		DBHelper.closeConnection(con);
	}

	public static Date getLastSyncDate(String swUserId, String syncronizedFrom, String syncronizedTo)
			throws SQLException {

		Date date = null;
		Connection con = DBHelper.createConnection();
		String query = "SELECT * FROM items_sync WHERE sw_user_id=? AND syncronized_from=? AND syncronized_to=?";
		PreparedStatement stmt = con.prepareStatement(query);

		stmt.setString(1, swUserId);
		stmt.setString(2, syncronizedFrom);
		stmt.setString(3, syncronizedTo);

		ResultSet rs = stmt.executeQuery();
		if (rs.next()) {
			date = rs.getDate("last_sync_date");
		}
		DBHelper.closeConnection(con);
		return date;
	}
}
