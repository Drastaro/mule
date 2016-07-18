package com.mule.xero.actions;

import org.mule.api.MuleEventContext;
import org.mule.api.lifecycle.Callable;

public class XeroCreateInvoice implements Callable {

	@Override
	public Object onCall(MuleEventContext eventContext) throws Exception {
		return eventContext;

		// XeroDataControlerDAO xeroDAO = new XeroDataControlerDAO();
		//
		// String swUserId = eventContext.getMessage().getInvocationProperty(
		// "swUserId");
		// return xeroDAO.createInvoice(swUserId, "Anton", "Alexandru",
		// "alex@yahoo.com", "3", "300", "development", "from xero");

	}
}
