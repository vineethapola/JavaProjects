package com.planon.entities;

public class TopUpServiceFactory {
	/**
	 * Method to get the type of TopUpService object
	 * 
	 * @param memberShipType
	 * @return TopUpServices object
	 */
	public TopUpServices getTopUpServicesDetails(String memberShipType) {
		if (MemberShip.BASIC.equals(MemberShip.valueOf(memberShipType)))
			return new BasicTopUpServices();
		else if (MemberShip.DELUXE.equals(MemberShip.valueOf(memberShipType)))
			return new DeluxeTopUpServices();
		else
			return new EliteTopUpServices();
	}

}