package com.planon.client;

import java.util.List;
import com.planon.entities.ClubService;
import com.planon.entities.GymService;
import com.planon.entities.SwimmingPoolService;

/**
 * This class sets the services names and cost details for membership "ELITE"
 *
 */

public class EliteMemberShip extends DeluxeMemberShip {
	GymService gymServiceObj = new GymService();
	SwimmingPoolService swimmingPoolServiceObj = new SwimmingPoolService();
	ClubService clubServiceObj = new ClubService();

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<String> getServicesNames() {
		List<String> servicesNames = super.getServicesNames();
		servicesNames.add(gymServiceObj.getServicename());
		servicesNames.add(swimmingPoolServiceObj.getServicename());
		servicesNames.add(clubServiceObj.getServicename());
		return servicesNames;
	}

}