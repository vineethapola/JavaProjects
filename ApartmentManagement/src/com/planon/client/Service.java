package com.planon.client;


/**
 * Interface to get name and cost of service based on the object created
 *
 */
public interface Service {

	/**
	 * method to get the service name
	 * 
	 * @return servicename
	 */
	public String getServicename();
	
	/**
	 * method to get the cost
	 * 
	 * @return cost
	 */
	public double getCost();
}
