package com.planaon.transaction;

public class Fixed extends AccountInterest {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void getInterestRate() {
		interestRate = Constants.fixedInterest;
	}
}
