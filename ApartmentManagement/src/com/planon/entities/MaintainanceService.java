package com.planon.entities;

import com.planon.client.Service;

/**
 * Class contains service name and cost for "Maintainance" service
 * 
 */
public class MaintainanceService implements Service {

	private String serviceName = "Maintainance";
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
