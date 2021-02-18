package com.planon.client;

import java.util.Map;

import com.planon.entities.ApartmentMember;

/**
 * Interface containing operations performed on Member objects
 *
 */
public interface MemberOperations {

	/**
	 * Method to register users for BASIC or DEFAULT or ELITE membership
	 * 
	 * @return set of registered users
	 */
	Map<Integer, ApartmentMember> userRegistration();

	/**
	 * Method to set the services details for all the members
	 * 
	 * @param membersData
	 */
	void settingServicesDetails(Map<Integer, ApartmentMember> membersData);

	/**
	 * Method to set the top up services for a member
	 * 
	 * @param memberId
	 * @param membersData
	 */
	void settingTopUpServicesDetails(Map<Integer, ApartmentMember> membersData);

	/**
	 * Method to get the monthly bill of the user based on the membership start date
	 * 
	 * @param membersData
	 */
	void fetchMonthlyBill(Map<Integer, ApartmentMember> membersData);

}