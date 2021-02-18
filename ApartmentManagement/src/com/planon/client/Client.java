package com.planon.client;

import java.util.Map;
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

	public static void main(String[] args) {
		try {
			MemberOperations operations = new MemberOperationsImpl();
			Map<Integer, ApartmentMember> membersData = operations.userRegistration();
			operations.settingServicesDetails(membersData);
			operations.settingTopUpServicesDetails(membersData);
			operations.fetchMonthlyBill(membersData);
		} catch (Exception e) {
			log.info(e.getMessage());
		}
	}

}