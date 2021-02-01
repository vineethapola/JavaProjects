package com.planaon.transaction;

public class Fixed extends AccountInterest {

	@Override
	public void getInterestRate() {
		interestRate = 5;
	}
}
