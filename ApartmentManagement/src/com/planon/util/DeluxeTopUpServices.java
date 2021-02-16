package com.planon.util;

import java.util.logging.Logger;

import com.planon.client.Client;

public class DeluxeTopUpServices extends EliteTopUpServices {
	private static final Logger log = Logger.getLogger(Client.class.getName());

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