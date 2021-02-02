package com.planaon.transaction;

public abstract class AccountInterest {
	
	protected double interestRate;

	/** Getting interest Rate based on the child object created
	 * 
	 **/
	public abstract void getInterestRate();

	/**calculating interest based on the account type
	 * 
	 * @param balance
	 * @param days
	 * @return balance for each source based on the period
	 */
	public double calulateInterest(double balance, int days) {
		return (balance / days) * interestRate;
	}
}
