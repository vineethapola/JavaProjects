package com.planon.util;

import java.util.List;

import com.planon.entities.Services;

/**
 * This class sets the services names and cost details for membership "ELITE"
 *
 */

public class EliteMemberShip extends DeluxeMemberShip {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<String> getServicesNames() {
		List<String> servicesNames;
		servicesNames = super.getServicesNames();
		servicesNames.add(Services.GYM.getServicename());
		servicesNames.add(Services.SWIMMING_POOL.getServicename());
		servicesNames.add(Services.CLUB.getServicename());
		return servicesNames;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int getCost() {
		int cost;
		cost = super.getCost() + Services.GYM.getCost() + Services.SWIMMING_POOL.getCost() + Services.CLUB.getCost();
		return cost;
	}
}