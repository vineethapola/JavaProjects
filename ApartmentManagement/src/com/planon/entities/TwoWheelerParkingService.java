package com.planon.entities;

import com.planon.client.Service;

/**
 * Class contains service name and cost for "Two Wheeler Parking" service
 * 
 */

public class TwoWheelerParkingService implements Service {

	private double costOfService = 100;
	private String serviceName = "Two Wheeler Parking";

	@Override
	public String getServicename() {
		return serviceName;
	}

	@Override
	public double getCost() {
		return costOfService;
	}

}