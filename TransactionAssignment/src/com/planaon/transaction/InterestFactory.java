package com.planaon.transaction;

public class InterestFactory {

	public AccountInterest getAccountType(String accountType) {
		if (accountType == null)
			return null;
		if (accountType.equalsIgnoreCase("CURRENT"))
			return new Current();
		else if (accountType.equalsIgnoreCase("SAVINGS"))
			return new Savings();
		else if (accountType.equalsIgnoreCase("FIXED"))
			return new Fixed();
		return new DefaultInterest();
	}
}
