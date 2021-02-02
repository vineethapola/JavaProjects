package com.planaon.transaction;

public class Current extends AccountInterest {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void getInterestRate() {
		interestRate = Constants.currentInterest;
	}
}
