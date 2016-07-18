package com.mule.quickbooks.test;

import java.sql.SQLException;

import com.mule.quickbooks.dao.QuickBooksQueryDAO;

public class QuickBooksListOrders {

	public static void main(String[] args) {
		try {
			QuickBooksQueryDAO.getQuicksBooksData("20", "query?query=SELECT%20*%20FROM%20Account");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
