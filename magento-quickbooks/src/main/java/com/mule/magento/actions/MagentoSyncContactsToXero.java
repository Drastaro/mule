package com.mule.magento.actions;

import org.mule.api.MuleEventContext;
import org.mule.api.lifecycle.Callable;

import com.mule.magento.syncdata.SyncMagentoContactsToXero;

public class MagentoSyncContactsToXero implements Callable {

	@Override
	public Object onCall(MuleEventContext eventContext) throws Exception {

		String magentoSwUserId = eventContext.getMessage()
				.getInvocationProperty("magentoSwUserId");

		SyncMagentoContactsToXero sync = new SyncMagentoContactsToXero();
		sync.syncContacts(magentoSwUserId, "20");
		System.out.println("contacts created to xero:" + sync);
		return null;

	}

}
