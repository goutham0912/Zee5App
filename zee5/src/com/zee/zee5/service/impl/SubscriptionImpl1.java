package com.zee.zee5.service.impl;

import com.zee.zee5.dto.Subscriptions;
import com.zee.zee5.repository.SubscriptionInterface;
import com.zee.zee5.repository.impl.SubscriptionImpl;
import com.zee.zee5.service.Subscription_Service1;

public class SubscriptionImpl1 implements Subscription_Service1 {
	SubscriptionInterface service1=SubscriptionImpl.getInstance();
	private static Subscription_Service1 service;
	private SubscriptionImpl1()
	{
		
	}
	public static Subscription_Service1 getInstance()
	{
		if(service==null)
		{
			service=new SubscriptionImpl1();
			return service;
		}
		return service;
	}
	@Override
	public String addSubscription(Subscriptions s) {
		// TODO Auto-generated method stub
		return service1.addSubscription(s);
	}

	@Override
	public String deleteSubscription(String id) {
		// TODO Auto-generated method stub
		return service1.deleteSubscription(id);
	}

	@Override
	public Subscriptions getSubscription(String id) {
		// TODO Auto-generated method stub
		return service1.getSubscription(id);
	}

	@Override
	public Subscriptions[] getallSubscription() {
		// TODO Auto-generated method stub
		return service1.getallSubscription();
	}

	@Override
	public Subscriptions updatesubscription(String id, Subscriptions s) {
		// TODO Auto-generated method stub
		return service1.updatesubscription(id, s);
	}

}
