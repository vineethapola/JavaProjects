package com.planon.client;

import java.util.List;
import com.planon.entities.FourWheelerParkingService;
import com.planon.entities.TwoWheelerParkingService;

/**
 * This class sets the services names and cost details for membership "DELUXE"
 *
 */

public class DeluxeMemberShip extends BasicMemberShip {
	TwoWheelerParkingService twoWheelerParkingServiceObj = new TwoWheelerParkingService();
	FourWheelerParkingService fourWheelerParkingServiceObj = new FourWheelerParkingService();

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<String> getServicesNames() {
		List<String> servicesNames = super.getServicesNames();
		servicesNames.add(twoWheelerParkingServiceObj.getServicename());
		servicesNames.add(fourWheelerParkingServiceObj.getServicename());
		return servicesNames;
	}

}