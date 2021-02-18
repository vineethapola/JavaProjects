package com.planon.client;

import java.util.logging.Logger;

/**
 * 
 * Class to display the different top up services that are available for a user
 * to choose from, for membership type "BASIC"
 *
 */
public class BasicTopUpServices extends DeluxeTopUpServices {
	private static final Logger log = Logger.getLogger(BasicTopUpServices.class.getName());

	/**
	 * Default Constructor from which member with membership type "BASIC" can choose
	 * additional services
	 */
	public BasicTopUpServices() {
		super();
		log.info("Two wheeler Parking");
		log.info("Four wheeler parking");
	}

}