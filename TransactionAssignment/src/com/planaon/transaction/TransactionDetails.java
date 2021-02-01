package com.planaon.transaction;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

enum TransactionType {
	CREDIT, DEBIT;
	static DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
}

public final class TransactionDetails {

	private int transactionId;
	private TransactionType transactionType;
	private double amount;
	private String source;
	private String destination;
	private String accountType;
	private LocalDateTime datedTransactionTime;

	public int getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}

	public TransactionType getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(TransactionType transactionType) {
		this.transactionType = transactionType;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public LocalDateTime getDatedTransactionTime() {
		return datedTransactionTime;
	}

	public void setDatedTransactionTime(LocalDateTime localDate) {
		this.datedTransactionTime = localDate;
	}

	public TransactionDetails(int transactionId, TransactionType transactionType, double amount, String source,
			String destination, String accountType, String transactionTime) {
		this.transactionId = transactionId;
		this.transactionType = transactionType;
		this.amount = amount;
		this.source = source;
		this.destination = destination;
		this.accountType = accountType;
		this.datedTransactionTime = LocalDateTime.parse(transactionTime, TransactionType.dateTimeFormatter);
	}

}
