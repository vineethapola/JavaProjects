package com.planon.client;

import java.util.HashSet;
import java.util.Set;
import java.util.logging.Logger;

import com.planon.entities.MemberDetails;
import com.planon.entities.MemberShip;
import com.planon.processors.MemberOperationsImpl;
import com.planon.util.MemberOperations;

/**
 * 
 * client class contains static list of members and function calls to the required methods
 *
 */

public class Client {

	private static final Logger log = Logger.getLogger(Client.class.getName());

	public static void main(String[] args) {
		Set<MemberDetails> members = new HashSet<>();
		MemberOperations operations = new MemberOperationsImpl();
		members.add(new MemberDetails(1, "Vineetha", MemberShip.BASIC, "2020-12-08"));
		members.add(new MemberDetails(2, "Sai", MemberShip.DELUXE, "2020-02-10"));
		members.add(new MemberDetails(3, "Dev", MemberShip.ELITE, "2020-01-01"));
		try {
			operations.settingServicesDetails(members);
			log.info(members.toString());
			operations.fetchMonthlyBill(members);
		} catch (Exception e) {
			log.info(e.getMessage());
		}
	}

}