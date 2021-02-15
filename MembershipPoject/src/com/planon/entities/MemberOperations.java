package com.planon.entities;

import java.util.Set;

/**
 * Interface containing operations performed on members objects
 *
 */
public interface MemberOperations {

	/**
	 * Method to set the services details for all the members
	 * @param members
	 */
	void settingServicesDetails(Set<MemberDetails> members);

	/**
	 * Method to get the monthly bill of the user based on the membership start date 
	 * @param members
	 */
	void fetchMonthlyBill(Set<MemberDetails> members);

}