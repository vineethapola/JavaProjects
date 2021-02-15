package com.planon.entities;

import java.util.List;

/**
 * Interface to get membership details based on the type of membership chosen by the user
 *
 */
public interface MemberShipServices {

	/**
	 * Method to get the services names
	 * @return list of services names
	 */
	List<String> getServicesNames();

	/**
	 * Method to get the cost of services
	 * @return cost of services
	 */
	int getCost();
}