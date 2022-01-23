package com.zee.zee5.repository.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.zee.zee5.dto.Subscriptions;
import com.zee.zee5.dto.Subscriptions;
import com.zee.zee5.exception.NameNotFound;
import com.zee.zee5.repository.SubscriptionInterface;
import com.zee.zee5.repository.Subscription_Repo;

public class SubscriptionImpl implements SubscriptionInterface {
	ArrayList<Subscriptions> subscription=new ArrayList<Subscriptions>();
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
		boolean result=subscription.add(s);
		if(result)
		{
			return "Subscription added successfully";
		}
		else {
			return "subscription not added";
		}
	}

	@Override
	public String deleteSubscription(String id) throws NameNotFound {
		// TODO Auto-generated method stub
Optional<Subscriptions> m=getSubscription(id);
		
		if(m.isPresent())
		{
			boolean result=	subscription.remove(m.get());
			if(result)
			return "Successfully deleted";
			else
			{
			 return "Subscription Deletion Failed";
			}
		}
		else {
			 throw new NameNotFound("Name Not Found");
		}
	}

	@Override
	public Optional<Subscriptions> getSubscription(String id) throws NameNotFound {
		// TODO Auto-generated method stub
		Subscriptions m=null;
		for(Subscriptions s:subscription)
		{
			if(id.equals(s.getId()))
			{
				m=s;
				break;
			}
		}
		return Optional.of(Optional.ofNullable(m).orElseThrow(()->new NameNotFound("Subscription does not exist")));
		
	}

	@Override
	public List<Subscriptions> getallSubscription() {
		// TODO Auto-generated method stub
		return subscription;
	}

	@Override
	public Subscriptions updatesubscription(String id, Subscriptions s) throws NameNotFound {
		// TODO Auto-generated method stub
Optional<Subscriptions> m=getSubscription(id);
		
		if(m.isPresent())
		{
			boolean result=	subscription.remove(m.get());
			subscription.add(s);
			
			return s;
			
			
		}
		else {
			 throw new NameNotFound("Name Not Found");
		}
		// TODO Auto-generated method stub
	}

}
