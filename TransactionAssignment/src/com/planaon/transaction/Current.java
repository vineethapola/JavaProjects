package com.planaon.transaction;

public class Current extends AccountInterest {

	@Override
	public void getInterestRate() {
		interestRate = 3;
	}
}
