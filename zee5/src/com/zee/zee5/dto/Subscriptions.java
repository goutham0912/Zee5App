package com.zee.zee5.dto;

import com.zee.zee5.exception.InvalidAmountException;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

@Data
public class Subscriptions {
	private String id;
	private String dateofpurchase;
	private String type;
	private String packcountry;
	private String paymentmode;
	private String autorenewal;
	private String expirydate;
	@Setter(value = AccessLevel.NONE)
	private int amount;
	public void setAmount(int amount) throws InvalidAmountException {
		int subscription_cost = 2000;
		UserBankDetails userdetails=new UserBankDetails();
		System.out.println(this.amount);
		if(subscription_cost<userdetails.getBankbalance())
			throw new InvalidAmountException("bank balance is less than the subscription amount cost");
		if(amount<subscription_cost)
			throw new InvalidAmountException("Please enter valid amount");
		this.amount = amount;
	}
}

