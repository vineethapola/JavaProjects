package com.planon.client;

import java.util.logging.Logger;

import com.planon.processors.MemberOperationsImpl;
import com.planon.util.MemberOperations;

/**
 * 
 * client class contains static list of members and function calls to the
 * required methods
 *
 */

public class Client {

	private static final Logger log = Logger.getLogger(Client.class.getName());

	public static void main(String[] args) {
		MemberOperations operations = new MemberOperationsImpl();
		try {
			operations.settingServicesDetails(MemberData.members);
			log.info(MemberData.members.toString());
			operations.fetchMonthlyBill(MemberData.members);
		} catch (Exception e) {
			log.info(e.getMessage());
		}
	}

}