package com.planon.entities;

import com.planon.client.Service;

/**
 * Class contains service name and cost for "Two Wheeler Parking" service
 * 
 */

public class FourWheelerParkingService implements Service {

	private String serviceName = "Four Wheeler Parking";
	private double costOfService = 200;

	@Override
	public String getServicename() {
		return serviceName;
	}

	@Override
	public double getCost() {
		return costOfService;
	}

}