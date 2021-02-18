package com.planon.processors;

import java.util.logging.Logger;

import com.planon.client.Service;
import com.planon.entities.ClubService;
import com.planon.entities.FourWheelerParkingService;
import com.planon.entities.GymService;
import com.planon.entities.MaintainanceService;
import com.planon.entities.PowerBackUpService;
import com.planon.entities.SecondCarParkingService;
import com.planon.entities.SecurityService;
import com.planon.entities.SwimmingPoolService;
import com.planon.entities.TwoWheelerParkingService;

/**
 * Class to get the Service object
 *
 */
public class ServiceFactory {

	static Logger log = Logger.getLogger(ServiceFactory.class.getName());

	/**
	 * Method to get the type of Service object
	 * 
	 * @param serviceName
	 * @return Services object
	 */

	public Service getServiceDetails(String serviceName) {
		switch (serviceName.toLowerCase()) {
		case "maintainance":
			return new MaintainanceService();

		case "security":
			return new SecurityService();

		case "two wheeler parking":
			return new TwoWheelerParkingService();

		case "four wheeler parking":
			return new FourWheelerParkingService();

		case "swimming pool":
			return new SwimmingPoolService();

		case "gym":
			return new GymService();

		case "club":
			return new ClubService();

		case "power backup":
			return new PowerBackUpService();

		case "second car parking":
			return new SecondCarParkingService();

		default:
			log.info("Service name not found");
			break;
		}
		return null;
	}
}