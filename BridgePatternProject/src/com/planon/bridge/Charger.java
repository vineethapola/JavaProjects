package com.planon.bridge;

import java.util.List;

public interface Charger {

	/**
	 * Adding new Phone details {@inheritDoc}}
	 * 
	 * @param phoneDetails
	 * @param phonesList
	 */
	void newPhone(PhoneDetails phoneDetails, List<PhoneDetails> phonesList);

	/**
	 * Displaying all the phones {@inheritDoc}
	 * 
	 * @param phonesList
	 */
	void displayPhones(List<PhoneDetails> phonesList);

	/**
	 * Getting price of the phone based on the name of the phone {@inheritDoc}
	 * 
	 * @param name
	 * @param phonesList
	 */
	void getPriceOfAPhone(String name, List<PhoneDetails> phonesList);

	/**
	 * Deleting a phone based on the name {@inheritDoc}
	 * 
	 * @param name
	 * @param phonesList
	 */
	void deletePhone(String name, List<PhoneDetails> phonesList);

	/**
	 * Calculating discounted price based on the object created
	 * 
	 * @param discount
	 * @param phonesList
	 */
	void discountedPrice(double discount, List<PhoneDetails> phonesList);

}
