package com.planon.entities;

import java.util.logging.Logger;

public class DeluxeTopUpServices extends EliteTopUpServices {
	private static final  Logger log = Logger.getLogger(Client.class.getName());

	public DeluxeTopUpServices() {
		super();
		log.info("Gym");
		log.info("Swimming Pool");
		log.info("Club");
	}
}