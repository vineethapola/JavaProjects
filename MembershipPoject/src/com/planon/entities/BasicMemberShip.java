package com.planon.entities;

import java.util.ArrayList;
import java.util.List;

/**
 * This class sets the services names and cost details for membership "BASIC"
 *
 */

public class BasicMemberShip implements MemberShipServices {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<String> getServicesNames() {
		List<String> servicesNames;
		servicesNames = new ArrayList<>();
		servicesNames.add(Services.MAINTAINENCE.getServicename());
		servicesNames.add(Services.SECURITY.getServicename());
		return servicesNames;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int getCost() {
		int cost;
		cost = Services.MAINTAINENCE.getCost() + Services.SECURITY.getCost();
		return cost;
	}
}