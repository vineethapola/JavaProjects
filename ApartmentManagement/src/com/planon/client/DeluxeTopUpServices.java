package com.planon.client;

import java.util.logging.Logger;

/**
 * Class to display the different top up services that are available for a user
 * to choose from, for membership type "DELUXE"
 *
 */

public class DeluxeTopUpServices extends EliteTopUpServices {
	private static final Logger log = Logger.getLogger(DeluxeTopUpServices.class.getName());

	/**
	 * Default Constructor from which member with membership type "DELUXE" can
	 * choose additional services
	 */
	public DeluxeTopUpServices() {
		super();
		log.info("Gym");
		log.info("Swimming Pool");
		log.info("Club");
	}
}