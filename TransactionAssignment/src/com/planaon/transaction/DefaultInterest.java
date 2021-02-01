package com.planaon.transaction;

public class DefaultInterest extends AccountInterest {

	@Override
	public void getInterestRate() {
		interestRate = 1;
	}
}
