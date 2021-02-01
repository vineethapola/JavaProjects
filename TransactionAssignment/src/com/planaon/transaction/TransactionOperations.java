package com.planaon.transaction;

import java.time.LocalDateTime;
import java.util.Set;

public interface TransactionOperations {

	/**
	 * Calculating balance for sources with type 'CREDIT'
	 * 
	 * @param Total number of transactions
	 * @throws Exception
	 **/
	void sameSourceCreditDisplay(Set<TransactionDetails> transactions) throws TransactionException;

	/**
	 * Calculating balance by the end of all transactions
	 * 
	 * @param Total number of transactions
	 **/
	void balanceByTheEndOfAllTransactions(Set<TransactionDetails> transactions) throws TransactionException;

	/**
	 * Calculating balance based on the input date provided by the user
	 * 
	 * @param localDateTime provided by the user and total number of transactions
	 **/
	void balanceCalBasedOnDate(LocalDateTime localDateTime, Set<TransactionDetails> transactions) throws TransactionException;

	/**
	 * Creating a map for calculating balance for each source based on period
	 * 
	 * @param total number of transactions
	 */
	void createBalanceMapBasedOnPeriod(Set<TransactionDetails> transactions, String period, int divisor)
			throws TransactionException;

}
