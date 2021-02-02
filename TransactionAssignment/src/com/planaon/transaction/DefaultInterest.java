package com.planaon.transaction;

public class DefaultInterest extends AccountInterest {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void getInterestRate() {
		interestRate = Constants.defaultInterest;
	}
}
