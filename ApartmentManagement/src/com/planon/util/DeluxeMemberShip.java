package com.planon.util;

import java.util.List;

import com.planon.entities.Services;

/**
 * This class sets the services names and cost details for membership "DELUXE"
 *
 */
public class DeluxeMemberShip extends BasicMemberShip {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<String> getServicesNames() {
		List<String> servicesNames;
		servicesNames = super.getServicesNames();
		servicesNames.add(Services.TWO_WHEELER_PARKING.getServicename());
		servicesNames.add(Services.FOUR_WHEELER_PARKING.getServicename());
		return servicesNames;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public int getCost() {
		int cost;
		cost = super.getCost() + Services.TWO_WHEELER_PARKING.getCost() + Services.FOUR_WHEELER_PARKING.getCost();
		return cost;
	}

}