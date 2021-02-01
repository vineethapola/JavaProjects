package com.planaon.transaction;

import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;

public class Constants {

	static final Set<TransactionDetails> transactions = addTransactions();
	static final String quarter = "QUARTER";
	static final int quarterDivisor = 3;
	static final String semiAnnual = "SEMI-ANNUAL";
	static final int semiAnnualDivisor = 6;
	static final String firstQuarter = "Q1";
	static final String secondQuarter = "Q2";
	static final String thirdQuarter = "Q3";
	static final String fourthQuarter = "Q4";
	static final String firstSemiAnnual = "S1";
	static final String secondSemiAnnual = "S2";
	static final String annual = "ANNUAL";
	static final int annualDivisor = 12;
	static final int quarterOnedays = 90;
	static final int quarterOneLeapdays = 91;
	static final int quarterThreeAndFourdays = 92;
	static final int firstSemiAnnualdays = 181;
	static final int firstSemiAnnualLeapdays = 182;
	static final int secondSemiAnnualdays = 184;
	static final int Annualdays = 365;
	static final int AnnualLeapdays = 366;

	private static Set<TransactionDetails> addTransactions() {
		final Set<TransactionDetails> inputTransactions = new LinkedHashSet<>();
		inputTransactions.add(new TransactionDetails(1, TransactionType.valueOf("CREDIT"), 10000, "A", "B", "Current",
				"01/12/2019 22:30:45"));
		inputTransactions.add(new TransactionDetails(1, TransactionType.valueOf("DEBIT"), 10000, "B", "A", "Savings",
				"01/12/2019 22:30:45"));
		inputTransactions.add(
				new TransactionDetails(2, TransactionType.DEBIT, 20000, "B", "A", "Savings", "04/12/2019 04:10:59"));
		inputTransactions.add(
				new TransactionDetails(2, TransactionType.CREDIT, 20000, "A", "B", "Current", "04/12/2019 04:10:59"));
		inputTransactions.add(
				new TransactionDetails(3, TransactionType.CREDIT, 15000, "A", "C", "Current", "04/01/2020 22:30:12"));
		inputTransactions
				.add(new TransactionDetails(3, TransactionType.DEBIT, 15000, "C", "A", "Fixed", "04/01/2020 22:30:12"));
		inputTransactions.add(
				new TransactionDetails(4, TransactionType.CREDIT, 100000, "D", "B", "Fixed", "03/12/2019 16:10:44"));
		inputTransactions.add(
				new TransactionDetails(4, TransactionType.DEBIT, 100000, "B", "D", "Savings", "03/12/2019 16:10:44"));
		inputTransactions.add(
				new TransactionDetails(4, TransactionType.DEBIT, 100000, "B", "D", "Savings", "03/12/2019 16:10:44"));
		return Collections.unmodifiableSet(inputTransactions);
	}

}
