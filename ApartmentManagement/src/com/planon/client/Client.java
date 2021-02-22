package com.planon.client;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.logging.Logger;

import com.planon.entities.ApartmentMember;
import com.planon.processors.MemberOperationsImpl;

/**
 * 
 * Class is used to register new users and for setting the services details and
 * fetching the monthly bill
 *
 */

public class Client {

	private static final Logger log = Logger.getLogger(Client.class.getName());
	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		try {
			MemberOperations operations = new MemberOperationsImpl();
			Map<Integer, ApartmentMember> membersData = new HashMap<>();
			while (true) {
				log.info(
						"1. User registration\n2. Adding the top up services\n3. Fetching the monthly bill\nPress 0 to exit");
				int userInput = scanner.nextInt();
				if (userInput == 0)
					break;
				switch (userInput) {
				case 1:
					membersData = operations.userRegistration();
					operations.settingServicesDetails(membersData);
					break;
				case 2:
					operations.settingTopUpServicesDetails(membersData);
					break;
				case 3:
					operations.fetchMonthlyBill(membersData);
					;
					break;
				default:
					log.info("No service is available for the input you have entered");
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}