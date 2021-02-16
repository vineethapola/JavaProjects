package com.planon.util;

import java.util.Set;

import com.planon.entities.Member;

/**
 * Interface containing operations performed on MemberDetails objects
 *
 */
public interface MemberOperations {

	/**
	 * Method to set the services details for all the members
	 * 
	 * @param members
	 */
	void settingServicesDetails(Set<Member> members);

	/**
	 * Method to get the monthly bill of the user based on the membership start date
	 * 
	 * @param members
	 */
	void fetchMonthlyBill(Set<Member> members);

}