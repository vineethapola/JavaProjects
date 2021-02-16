package com.planon.util;

import java.util.ArrayList;
import java.util.List;

import com.planon.entities.Services;

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