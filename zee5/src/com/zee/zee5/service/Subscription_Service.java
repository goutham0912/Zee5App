package com.zee.zee5.service;

import com.zee.zee5.dto.Subscriptions;
import com.zee.zee5.repository.Subscription_Repo;

public class Subscription_Service {
	private Subscription_Repo repo=Subscription_Repo.getInstance();
	private static Subscription_Service s_service;
	private Subscription_Service()
	{
		
	}
	public static Subscription_Service getInstance()
	{
		if(s_service==null)
			s_service=new Subscription_Service();
		return s_service;
	}
	public String addSubscription(Subscriptions s)
	{
		return this.repo.addSubscription(s);
	}
	public String deleteSubscription(String id)
	{
		return this.repo.deleteSubscription(id);
	}
	public Subscriptions getSubscription(String id)
	{
		return this.repo.getSubscription(id);
	}
	public Subscriptions[] getallSubscription()
	{
		
		return this.repo.getallSubscription();	}
	public Subscriptions updatesubscription(String id,Subscriptions s)
	{
		return this.repo.updatesubscription(id,s);
	}

}
