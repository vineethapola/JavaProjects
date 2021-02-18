package com.planon.entities;


public class SecurityService implements Service{

	private double costOfService = 1000;
	private String serviceName = "Security";
	
	@Override
	public String getServicename() {
		return serviceName;
	}
	@Override
	public double getCost() {
		return costOfService;
	}
	
}
