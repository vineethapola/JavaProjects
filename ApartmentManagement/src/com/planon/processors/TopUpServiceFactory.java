package com.planon.processors;

import java.util.logging.Logger;

import com.planon.client.BasicTopUpServices;
import com.planon.client.DeluxeTopUpServices;
import com.planon.client.EliteTopUpServices;
import com.planon.client.TopUpServices;
import com.planon.entities.MemberShip;

public class TopUpServiceFactory {
	static Logger log = Logger.getLogger(MemberShip.class.getName());
	/**
	 * Method to get the type of TopUpService object
	 * 
	 * @param memberShip
	 * @return TopUpServices object
	 */
	public TopUpServices getTopUpServicesDetails(MemberShip memberShip) {
		
		switch (memberShip) {
		case BASIC:
			return new BasicTopUpServices();
		case DELUXE:
			return new DeluxeTopUpServices();
		case ELITE:
			return new EliteTopUpServices();
		default:
			log.info("Topup service not found");
			break;
		}
		return null;
	}

}