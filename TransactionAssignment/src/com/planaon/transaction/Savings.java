package com.planaon.transaction;

public class Savings extends AccountInterest {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void getInterestRate() {
		interestRate = Constants.savingsInterest;
	}
}
