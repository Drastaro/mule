package com.mule.utils.persistanceutils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import com.mule.utils.propertiesutils.AppPropertiesUtil;

public class DBHelper {

	public static Connection createConnection() {
		
		
		Properties prop = new Properties();
		prop.put("user", AppPropertiesUtil.DB_USERNAME);
		prop.put("password", AppPropertiesUtil.DB_PASS);

		try {
			 Class.forName(AppPropertiesUtil.JDBC_DRIVER_NAME);
			Connection conn = DriverManager.getConnection(
					AppPropertiesUtil.DB_URL, prop);
			System.out.println("Connection to DB created");
			return conn;
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static void closeConnection(Connection con) {
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
