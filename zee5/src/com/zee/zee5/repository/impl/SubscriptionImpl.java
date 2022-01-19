package com.zee.zee5.repository.impl;

import com.zee.zee5.dto.Subscriptions;
import com.zee.zee5.repository.SubscriptionInterface;
import com.zee.zee5.repository.Subscription_Repo;

public class SubscriptionImpl implements SubscriptionInterface {
	Subscriptions[] subscription=new Subscriptions[10];
	private static int count=-1;
	private static SubscriptionInterface repo;
	private SubscriptionImpl() {
		
	}
	public static SubscriptionInterface getInstance()
	{
		if(repo==null)
		{
			repo=new SubscriptionImpl();
			return repo;
		}
		return repo;
	}
	@Override
	public String addSubscription(Subscriptions s) {
		// TODO Auto-generated method stub
		if(count==subscription.length-1)
		{
			Subscriptions[] temp=new Subscriptions[subscription.length*2];	
			System.arraycopy(subscription, 0, temp, 0, subscription.length);
			subscription=temp;
			subscription[++count]=s;
			return "Success";
			}
		subscription[++count]=s;
		return "Success";
	}

	@Override
	public String deleteSubscription(String id) {
		// TODO Auto-generated method stub
		int c=0;
		for(Subscriptions s:subscription)
		{
			if(id.equals(s.getId()))
			{
				for(int i=c;i<subscription.length-2;i++)
				{
					subscription[i]=subscription[i+1];
					
				}
				subscription[subscription.length-1]=null;
				
				return "Successfully deleted1";
			}
			c+=1;
		}
		return "ID not found";
	}

	@Override
	public Subscriptions getSubscription(String id) {
		// TODO Auto-generated method stub
		for(Subscriptions s:subscription)
		{
			if(s!=null && id.equals(s.getId()))
			{
				return s;
			}
		}
		return null;
		
	}

	@Override
	public Subscriptions[] getallSubscription() {
		// TODO Auto-generated method stub
		return subscription;
	}

	@Override
	public Subscriptions updatesubscription(String id, Subscriptions s) {
		// TODO Auto-generated method stub
		int c=0;
		for(Subscriptions s1:subscription)
		{
			if(s1!=null && id.equals(s1.getId()))
			{
				subscription[c]=s;
				return subscription[c];
			}
			c+=1;
		
	}
		return null;
	}

}
