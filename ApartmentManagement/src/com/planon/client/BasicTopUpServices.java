package com.planon.client;

import java.util.logging.Logger;


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