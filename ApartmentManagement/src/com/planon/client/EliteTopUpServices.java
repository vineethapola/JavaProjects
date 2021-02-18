package com.planon.client;

import java.util.logging.Logger;

public class EliteTopUpServices implements TopUpServices {
	private static final Logger log = Logger.getLogger(EliteTopUpServices.class.getName());

	/**
	 * Default Constructor from which member with membership type "ELITE" can choose
	 * additional services
	 */
	public EliteTopUpServices() {
		log.info("Power backup");
		log.info("Second car parking");
	}

}