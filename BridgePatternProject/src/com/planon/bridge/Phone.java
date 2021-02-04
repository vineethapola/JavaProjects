package com.planon.bridge;

public abstract class Phone {

	protected Charger charger;

	protected Phone(Charger charger) {
		this.charger = charger;
	}

	/**
	 * Using bridge pattern, performing operations on Phone
	 */

	/**
	 * Creating new phone entry
	 * 
	 * {@inheritDoc}
	 * 
	 * @param phoneDetails
	 */
	protected abstract void newPhone(PhoneDetails phoneDetails);

	/**
	 * 
	 * {@inheritDoc} Displaying all the phone details
	 */
	protected abstract void displayAllPhones();

	/**
	 * Getting price for a phone based on the name
	 * 
	 * {@inheritDoc}
	 * 
	 * @param name
	 */
	protected abstract void getPriceOfAPhone(String name);

	/**
	 * Deleting a phone based on the phone name
	 * 
	 * {@inheritDoc}
	 * 
	 * @param name
	 */
	protected abstract void deletePhone(String name);

	/**
	 * Calculating discounted price based on the object created
	 * 
	 * @param discount
	 * @param phonesList
	 */
	protected abstract void discountedPrice();

}
