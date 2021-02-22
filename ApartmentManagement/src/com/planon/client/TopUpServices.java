package com.planon.client;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Logger;

/**
 * Interface to get additional top up service details chosen by the user
 */
public class TopUpServices {
	Logger log = Logger.getLogger(TopUpServices.class.getName());
	Scanner scanner = new Scanner(System.in);

	/**
	 * Method to get the additional top up services selected by the user
	 * 
	 * @return list of selected top up services details
	 */
	public List<String> getTopUpServicesNames() {
		List<String> services = new ArrayList<>();
		log.info("Choose any/none of the above top up services\nPress enter to exit");
		while (true) {
			String serviceName = scanner.nextLine();
			if ("".equals(serviceName) || null == serviceName)
				break;
			services.add(serviceName);
		}
		return services;
	}
}