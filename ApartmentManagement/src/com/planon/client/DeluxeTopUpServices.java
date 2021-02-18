package com.planon.client;

import java.util.logging.Logger;

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