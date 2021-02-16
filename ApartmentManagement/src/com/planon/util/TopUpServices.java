package com.planon.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Logger;

import com.planon.client.Client;

/**
 * Interface to get additional top up service details chosen by the user
 */
public interface TopUpServices {
	Logger log = Logger.getLogger(Client.class.getName());

	/**
	 * Method to calculate the additional top up services selected by the user
	 * 
	 * @return list of selected top up services details
	 */
	default List<String> getTopUpServicesNames() {
		Scanner scanner = new Scanner(System.in);
		List<String> services = new ArrayList<>();
		log.info("Choose any/none of the above top up services\nPress enter to exit");
		while (true) {
			String serviceName = scanner.nextLine();
			if ("".equals(serviceName) || null == serviceName)
				break;
			services.add(serviceName.toUpperCase());
		}
		return services;
	}
}