package com.planon.entities;

import com.planon.client.Service;

/**
 * Class contains service name and cost for "Swimming Pool" service
 *
 */

public class SwimmingPoolService implements Service {

	private String serviceName = "Swimming Pool";
	private double costOfService = 1000;

	@Override
	public String getServicename() {
		return serviceName;
	}

	@Override
	public double getCost() {
		return costOfService;
	}

}