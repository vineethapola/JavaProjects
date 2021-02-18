package com.planon.processors;

import java.util.logging.Logger;

import com.planon.entities.GymService;
import com.planon.entities.MaintainanceService;
import com.planon.entities.SecurityService;
import com.planon.entities.Service;

public class ServiceFactory {

	static Logger log = Logger.getLogger(ServiceFactory.class.getName());

	public Service getServiceDetails(String serviceName) {
		switch (serviceName.toLowerCase()) {
		case "maintainance":
			return new MaintainanceService();
		case "security":
			return new SecurityService();
		case "gym":
			return new GymService();
		default:
			log.info("Service name not found");
			break;
		}
		return null;
	}
}
