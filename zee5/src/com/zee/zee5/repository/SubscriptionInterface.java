package com.zee.zee5.repository;

import java.util.List;
import java.util.Optional;

import com.zee.zee5.dto.Subscriptions;
import com.zee.zee5.exception.NameNotFound;

public interface SubscriptionInterface {
	public String addSubscription(Subscriptions s);
	public String deleteSubscription(String id) throws NameNotFound;
	public Optional<Subscriptions> getSubscription(String id) throws NameNotFound;
	public List<Subscriptions> getallSubscription();
	public Subscriptions updatesubscription(String id,Subscriptions s) throws NameNotFound;
}
