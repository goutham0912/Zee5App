package com.zee.zee5.service;

import com.zee.zee5.dto.Subscriptions;

public interface Subscription_Service1 {
	public String addSubscription(Subscriptions s);
	public String deleteSubscription(String id);
	public Subscriptions getSubscription(String id);
	public Subscriptions[] getallSubscription();
	public Subscriptions updatesubscription(String id,Subscriptions s);
}
