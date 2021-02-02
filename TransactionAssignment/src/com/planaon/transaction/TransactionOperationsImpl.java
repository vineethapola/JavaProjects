package com.planaon.transaction;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.stream.Collectors;

public class TransactionOperationsImpl implements TransactionOperations  {
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
	public void sameSourceCreditDisplay(Set<TransactionDetails> transactions) throws TransactionException {
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
	public void balanceByTheEndOfAllTransactions(Set<TransactionDetails> transactions) throws TransactionException {
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
			throws TransactionException {
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
	public void createBalanceMapBasedOnPeriod(Set<TransactionDetails> transactions, String period)
			throws TransactionException {
		balanceMap = new TreeMap<>();
		int divisor;
		if(period.equalsIgnoreCase(Constants.quarter))
		{
			divisor = Constants.quarterDivisor;
		}
		else if(period.equalsIgnoreCase(Constants.semiAnnual)) {
			divisor = Constants.semiAnnualDivisor;
		}
		else {
			divisor = Constants.annualDivisor;
		}
		transactions.forEach(td -> {
			int periodValue = td.getDatedTransactionTime().getMonthValue() % divisor == 0
					? (td.getDatedTransactionTime().getMonthValue() / divisor)
					: (td.getDatedTransactionTime().getMonthValue() / divisor) + 1;
			String quarterKey = td.getSource() + " " + period.charAt(0) + periodValue + " "
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
		getInterestRateAndCalculateBalance(balanceMap, period);
	}

	/**
	 * Getting interest rate from factory class and calculating average balance for
	 * each source per period
	 * 
	 * @param balanceMap based on period for each source
	 */
	void getInterestRateAndCalculateBalance(Map<String, Double> balanceMap, String period) {
		System.out.println("\nCalculating balance per each " + period +"\n");
		BiConsumer<? super String, ? super Double> biConsumer = (source, balance) -> {
			String[] sourceValues = source.split(" ");
			String periodValue = sourceValues[1] ;
			String year = sourceValues[2];
			String accountType = sourceValues[3];
			if (period.equalsIgnoreCase(Constants.quarter)) {
				noOfDaysInAPeriod = (periodValue.equals(Constants.firstQuarter)
						&& checkYear(Integer.parseInt(year)))
						|| periodValue.equals(Constants.secondQuarter) ? Constants.quarterOneLeapdays
								: Constants.quarterOnedays;
				if (periodValue.equals(Constants.thirdQuarter) || periodValue.equals(Constants.fourthQuarter))
					noOfDaysInAPeriod = Constants.quarterThreeAndFourdays;
			} else if (period.equalsIgnoreCase(Constants.semiAnnual)) {
				noOfDaysInAPeriod = periodValue.equals(Constants.firstSemiAnnual)
						&& checkYear(Integer.parseInt(year)) ? Constants.firstSemiAnnualLeapdays
								: Constants.firstSemiAnnualdays;
				if (periodValue.equals(Constants.secondSemiAnnual))
					noOfDaysInAPeriod = Constants.secondSemiAnnualdays;
			} else
				noOfDaysInAPeriod = checkYear(Integer.parseInt(year)) ? Constants.AnnualLeapdays
						: Constants.Annualdays;
			AccountInterest accountInterest = interestFactory.getAccountType(accountType);
			accountInterest.getInterestRate();
			System.out.println(source + " " + accountInterest.calulateInterest(balance, noOfDaysInAPeriod));
		};
		balanceMap.forEach(biConsumer);
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
