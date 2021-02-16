package com.planon.util;

import java.util.logging.Logger;

public class EliteTopUpServices implements TopUpServices {
	private static final Logger log = Logger.getLogger(EliteTopUpServices.class.getName());

	/**
	 * Constructor which tells the user  to choose from
	 */
	public EliteTopUpServices() {
		log.info("Power backup");
		log.info("Second car parking");
	}

}