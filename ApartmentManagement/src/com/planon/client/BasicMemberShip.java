package com.planon.client;

import java.util.ArrayList;
import java.util.List;
import com.planon.entities.MaintainanceService;
import com.planon.entities.SecurityService;

/**
 * This class sets the services names and cost details for membership "BASIC"
 *
 */

public class BasicMemberShip implements MemberShipServices {
	SecurityService securityServiceObj = new SecurityService();
	MaintainanceService maintainanceServiceObj = new MaintainanceService();

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<String> getServicesNames() {
		List<String> servicesNames;
		servicesNames = new ArrayList<>();
		servicesNames.add(securityServiceObj.getServicename());
		servicesNames.add(maintainanceServiceObj.getServicename());
		return servicesNames;
	}

}