package com.planon.client;

import java.util.List;

import com.planon.processors.ServiceFactory;

/**
 * Interface to get membership details based on the type of membership chosen by
 * the user
 *
 */
public interface MemberShipServices {

	/**
	 * Method to get the services names
	 * 
	 * @return list of services names
	 */
	List<String> getServicesNames();

	/**
	 * Method to get the cost of services
	 * 
	 * @return cost of services
	 */
	default double getCost(List<String> servicesNames) {
		ServiceFactory serviceFactory = new ServiceFactory();
		double cost = 0;
		for (String serviceName : servicesNames) {
			Service service = serviceFactory.getServiceDetails(serviceName);
			cost = cost + service.getCost();
		}
		return cost;
	}

}