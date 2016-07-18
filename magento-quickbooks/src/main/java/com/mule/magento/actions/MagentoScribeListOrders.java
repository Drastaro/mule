package com.mule.magento.actions;

import org.mule.api.MuleEventContext;
import org.mule.api.lifecycle.Callable;

import com.mule.magento.dao.MagentoQueryDAO;

public class MagentoScribeListOrders implements Callable {

	@Override
	public Object onCall(MuleEventContext eventContext) throws Exception {
		String swUserId = eventContext.getMessage().getInvocationProperty("swUserId");
		System.out.println("id" + swUserId);
		MagentoQueryDAO.getMagentoLimitData(swUserId, "orders");
		return null;
	}

}
