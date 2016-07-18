package com.mule.magento.actions;

import org.mule.api.MuleEventContext;
import org.mule.api.lifecycle.Callable;

import com.mule.magento.syncdata.SyncMagentoInvoicesToXero;

public class MagentoSyncInvoicesToXero implements Callable {

	@Override
	public Object onCall(MuleEventContext eventContext) throws Exception {

		String magentoSwUserId = eventContext.getMessage()
				.getInvocationProperty("magentoSwUserId");

		SyncMagentoInvoicesToXero sync = new SyncMagentoInvoicesToXero();
		return sync.syncInvoice(magentoSwUserId, "20");

	}

}
