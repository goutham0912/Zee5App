package com.zee.zee5.repository;

import com.zee.zee5.dto.Subscriptions;

public class Subscription_Repo {
	Subscriptions[] subscription=new Subscriptions[10];
	private static int count=-1;
	private static Subscription_Repo repo;
	private Subscription_Repo() {
		
	}
	public static Subscription_Repo getInstance()
	{
		if(repo==null)
		{
			repo=new Subscription_Repo();
			return repo;
		}
		return repo;
	}
	public String addSubscription(Subscriptions s)
	{
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
	public String deleteSubscription(String id)
	{
		int c=0;
		for(Subscriptions s:subscription)
		{
			if(id.equals(s.getId()))
			{
				for(int i=c;i<subscription.length-2;i++)
				{
					subscription[i]=subscription[i+1];
					
				}
				
				return "Successfully deleted";
			}
			c+=1;
		}
		return "ID not found";
	}
	public Subscriptions getSubscription(String id)
	{
		for(Subscriptions s:subscription)
		{
			if(s!=null && id.equals(s.getId()))
			{
				return s;
			}
		}
		return null;
		
	}
	public Subscriptions[] getallSubscription() {
		return subscription;
	}
	public Subscriptions updatesubscription(String id,Subscriptions s)
	{

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
