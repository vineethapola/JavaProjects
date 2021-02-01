package com.planaon.transaction;

public abstract class AccountInterest {

	protected double interestRate;
	
	public abstract void getInterestRate();
	
	public double calulateInterest(double balance,int days)
	{
		return (balance/days)*interestRate;
	}
}
