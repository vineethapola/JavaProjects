package com.planon.entities;

public class GymService implements Service {

	private double costOfService = 500;
	private String serviceName = "Gym";

	@Override
	public String getServicename() {
		return serviceName;
	}

	@Override
	public double getCost() {
		return costOfService;
	}

}
