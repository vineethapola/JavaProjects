package com.planon.entities;

/**
 * Enum with list of service constants and also return the name and cost of the service
 *
 */
public enum Services {
	GYM("Gym", 500), SWIMMING_POOL("Swimming Pool", 1000), CLUB("Club", 1000), POWER_BACKUP("Power backup", 200),
	TWO_WHEELER_PARKING("Two wheeler Parking", 100), FOUR_WHEELER_PARKING("Four Wheeler Parking", 200),
	SECOND_CAR_PARKING("Second Car Parking", 400), MAINTAINENCE("Maintainence", 1000), SECURITY("Security", 1000);

	private int costOfService;
	private String serviceName;

	Services(String serviceName, int costOfService) {
		this.serviceName = serviceName;
		this.costOfService = costOfService;
	}

	public String getServicename() {
		return serviceName;
	}

	public int getCost() {
		return costOfService;
	}

}