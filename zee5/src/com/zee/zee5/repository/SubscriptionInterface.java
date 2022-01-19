package com.zee.zee5.repository;

import com.zee.zee5.dto.Subscriptions;

public interface SubscriptionInterface {
	public String addSubscription(Subscriptions s);
	public String deleteSubscription(String id);
	public Subscriptions getSubscription(String id);
	public Subscriptions[] getallSubscription();
	public Subscriptions updatesubscription(String id,Subscriptions s);
}
