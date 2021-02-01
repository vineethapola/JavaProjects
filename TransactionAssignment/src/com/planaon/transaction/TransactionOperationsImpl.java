package com.planaon.transaction;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

public class TransactionOperationsImpl implements TransactionOperations {
	double amount;
	int noOfDaysInAPeriod;
	InterestFactory interestFactory = new InterestFactory();
	Map<String, Double> balanceMap;
	Function<? super TransactionDetails, ? extends Map<String, Double>> balanceSourceMap = td -> {
		if (balanceMap.containsKey(td.getSource())) {
			amount = td.getTransactionType().equals(TransactionType.CREDIT)
					? balanceMap.get(td.getSource()) + td.getAmount()
					: balanceMap.get(td.getSource()) - td.getAmount();
		} else {
			amount = td.getTransactionType().equals(TransactionType.CREDIT) ? td.getAmount() : -td.getAmount();
		}
		balanceMap.put(td.getSource(), amount);
		return balanceMap;
	};

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void sameSourceCreditDisplay(Set<TransactionDetails> transactions) throws Exception {
		Map<String, Double> sameSourceCreditMap = new TreeMap<>();
		Function<? super TransactionDetails, ? extends Map<String, Double>> sameSource = td -> {
			amount = sameSourceCreditMap.containsKey(td.getSource())
					? td.getAmount() + sameSourceCreditMap.get(td.getSource())
					: td.getAmount();
			sameSourceCreditMap.put(td.getSource(), amount);
			return sameSourceCreditMap;
		};
		transactions.stream().filter(td -> td.getTransactionType().equals(TransactionType.CREDIT)).map(sameSource)
				.collect(Collectors.toList());
		System.out.println("Balance for sources with type CREDIT is ");
		System.out.println(sameSourceCreditMap);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void balanceByTheEndOfAllTransactions(Set<TransactionDetails> transactions) throws Exception {
		balanceMap = new TreeMap<>();
		transactions.stream().map(balanceSourceMap).collect(Collectors.toSet());
		System.out.println("Balance for all the sources is ");
		System.out.println(balanceMap);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void balanceCalBasedOnDate(LocalDateTime localDateTime, Set<TransactionDetails> transactions)
			throws Exception {
		balanceMap = new TreeMap<>();
		transactions.stream()
				.filter(td -> td.getDatedTransactionTime().isBefore(localDateTime)
						|| td.getDatedTransactionTime().equals(localDateTime))
				.map(balanceSourceMap).collect(Collectors.toSet());
		System.out.println("Balance for sources whose transaction date is less than or equal to " + localDateTime);
		System.out.println(balanceMap);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void createBalanceMapBasedOnPeriod(Set<TransactionDetails> transactions, String period, int divisor)
			throws Exception {
		balanceMap = new TreeMap<>();
		transactions.forEach(td -> {
			int quarter = td.getDatedTransactionTime().getMonthValue() % divisor == 0
					? (td.getDatedTransactionTime().getMonthValue() / divisor)
					: (td.getDatedTransactionTime().getMonthValue() / divisor) + 1;
			String quarterKey = td.getSource() + " " + period.charAt(0) + quarter + " "
					+ td.getDatedTransactionTime().getYear() + " " + td.getAccountType();
			if (balanceMap.containsKey(quarterKey)) {
				amount = td.getTransactionType().equals(TransactionType.CREDIT)
						? balanceMap.get(quarterKey) + td.getAmount()
						: balanceMap.get(quarterKey) - td.getAmount();
			} else {
				amount = td.getTransactionType().equals(TransactionType.CREDIT) ? td.getAmount() : -td.getAmount();
			}
			balanceMap.put(quarterKey, amount);
		});
		System.out.println(balanceMap);
		getInterestRateAndCalculateBalance(balanceMap, period);
	}

	/**
	 * Getting interest rate from factory class and calculating average balance for
	 * each source per quarter
	 * 
	 * @param quarterBalanceMap map with quarter sources in a year with balance
	 */
	void getInterestRateAndCalculateBalance(Map<String, Double> balanceMap, String period) {
		balanceMap.forEach((source, balance) -> {
			String[] sourceValues = source.split(" ");
			if (period.equalsIgnoreCase(Constants.quarter)) {
				noOfDaysInAPeriod = (sourceValues[1].equals(Constants.firstQuarter) && checkYear(Integer.parseInt(sourceValues[2])))
						|| sourceValues[1].equals(Constants.secondQuarter) ? 91 : 90;
				if (sourceValues[1].equals(Constants.thirdQuarter) || sourceValues[1].equals(Constants.fourthQuarter))
					noOfDaysInAPeriod = 92;
			}
			else if(period.equalsIgnoreCase(Constants.semiAnnual))
			{
				noOfDaysInAPeriod = sourceValues[1].equals(Constants.firstSemiAnnual) && checkYear(Integer.parseInt(sourceValues[2])) ? 182 : 181;
				if(sourceValues[1].equals(Constants.secondSemiAnnual))
					noOfDaysInAPeriod = 184;
			}
			else
				noOfDaysInAPeriod = checkYear(Integer.parseInt(sourceValues[2])) ? 365:366;
			AccountInterest accountInterest = interestFactory.getAccountType(sourceValues[3]);
			accountInterest.getInterestRate();
			System.out.println(source + " " + accountInterest.calulateInterest(balance, noOfDaysInAPeriod));
		});

	}

	/**
	 * Checking if a year is leap year or not
	 * 
	 * @param year to checked
	 * @return true or false based on the type of year
	 */
	boolean checkYear(int year) {
		return (((year % 4 == 0) && (year % 100 != 0)) || (year % 400 == 0));
	}

}
