package com.zee.zee5.service;

import java.util.List;
import java.util.Optional;

import com.zee.zee5.dto.Subscriptions;
import com.zee.zee5.exception.NameNotFound;

public interface Subscription_Service1 {
	public String addSubscription(Subscriptions s);
	public String deleteSubscription(String id) throws NameNotFound;
	public Optional<Subscriptions> getSubscription(String id) throws NameNotFound;
	public List<Subscriptions> getallSubscription();
	public Subscriptions updatesubscription(String id,Subscriptions s) throws NameNotFound;
}
