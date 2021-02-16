package com.planon.processors;

import com.planon.entities.MemberShip;
import com.planon.util.BasicTopUpServices;
import com.planon.util.DeluxeTopUpServices;
import com.planon.util.EliteTopUpServices;
import com.planon.util.TopUpServices;

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