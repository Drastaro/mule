package com.mule.magento.actions;

import org.mule.api.MuleEventContext;
import org.mule.api.lifecycle.Callable;

import com.mule.magento.syncdata.SyncMagentoContactsToQuickBooks;

public class MagentoSyncContactsToQuickBooks implements Callable {

	@Override
	public Object onCall(MuleEventContext eventContext) throws Exception {

		String magentoSwUserId = eventContext.getMessage().getInvocationProperty("swUserId");
		return SyncMagentoContactsToQuickBooks.syncContactsToQB(magentoSwUserId, "20");
	}

}
