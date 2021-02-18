package com.planon.entities;

import com.planon.client.Service;

/**
 * Class contains service name and cost for "Gym" service
 * 
 */
public class GymService implements Service {

	private String serviceName = "Gym";
	private double costOfService = 500;

	@Override
	public String getServicename() {
		return serviceName;
	}

	@Override
	public double getCost() {
		return costOfService;
	}

}
