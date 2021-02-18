package com.planon.entities;

import com.planon.client.Service;

/**
 * Class contains service name and cost for "Club" service
 *
 */

public class ClubService implements Service {

	private String serviceName = "Club";
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