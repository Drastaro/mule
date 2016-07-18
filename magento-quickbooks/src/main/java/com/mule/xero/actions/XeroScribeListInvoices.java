package com.mule.xero.actions;

import org.mule.api.MuleEventContext;
import org.mule.api.lifecycle.Callable;

import com.mule.xero.dao.XeroQueryDAO;

public class XeroScribeListInvoices implements Callable {

	@Override
	public Object onCall(MuleEventContext eventContext) throws Exception {

		String swUserId = eventContext.getMessage().getInvocationProperty("swUserId");
		XeroQueryDAO.getXeroData(swUserId, "invoices");
		return null;
	}

}
