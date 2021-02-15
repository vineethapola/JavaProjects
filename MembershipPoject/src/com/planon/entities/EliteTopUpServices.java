package com.planon.entities;

import java.util.logging.Logger;

public class EliteTopUpServices implements TopUpServices {
	private static final Logger log = Logger.getLogger(EliteTopUpServices.class.getName());

	EliteTopUpServices() {
		log.info("Power backup");
		log.info("Second car parking");
	}

}