package com.planaon.transaction;

import java.time.LocalDateTime;
import java.util.logging.Logger;

public class Client{

	static Logger logger = Logger.getLogger(Client.class.getName());

	public static void main(String[] args) {

		TransactionOperations transactionObj = new TransactionOperationsImpl();
		try {
			transactionObj.sameSourceCreditDisplay(Constants.transactions);
			transactionObj.balanceByTheEndOfAllTransactions(Constants.transactions);
			transactionObj.balanceCalBasedOnDate(
					LocalDateTime.parse("01/01/2020 22:30:12", TransactionType.dateTimeFormatter),
					Constants.transactions);
			transactionObj.createBalanceMapBasedOnPeriod(Constants.transactions, Constants.quarter,
					Constants.quarterDivisor);
			transactionObj.createBalanceMapBasedOnPeriod(Constants.transactions, Constants.semiAnnual,
					Constants.semiAnnualDivisor);
			transactionObj.createBalanceMapBasedOnPeriod(Constants.transactions, Constants.annual,
					Constants.annualDivisor);
		} catch (TransactionException e) {
			logger.info(e.getMessage());
		} 
	}
}
