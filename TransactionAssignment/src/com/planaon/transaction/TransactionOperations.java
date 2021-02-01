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
	void sameSourceCreditDisplay(Set<TransactionDetails> transactions) throws Exception;

	/**
	 * Calculating balance by the end of all transactions
	 * 	 
	 * @param Total number of transactions
	 **/
	void balanceByTheEndOfAllTransactions(Set<TransactionDetails> transactions) throws Exception;

	/**
	 * Calculating balance based on the input date provided by the user
	 * 
	 * @param localDateTime provided by the user and total number of transactions
	 **/
	void balanceCalBasedOnDate(LocalDateTime localDateTime, Set<TransactionDetails> transactions) throws Exception;

	/**
	 * Creating a map for calculating quarter balance for each source
	 * 
	 * @param total number of transactions
	 */
	void createBalanceMapBasedOnPeriod(Set<TransactionDetails> transactions, String period, int divisor) throws Exception;

}
