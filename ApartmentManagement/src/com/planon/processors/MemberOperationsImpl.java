package com.planon.processors;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.logging.Logger;

import com.planon.client.MemberOperations;
import com.planon.client.MemberShipServices;
import com.planon.client.TopUpServices;
import com.planon.entities.ApartmentMember;
import com.planon.entities.MemberShip;
import com.planon.entities.Service;

/**
 * Class containing all the implementations of MemberOperations Interface and
 * the methods specific to this class
 *
 */
public class MemberOperationsImpl implements MemberOperations {
	MemberShipFactory memberShipfactory = new MemberShipFactory();
	TopUpServiceFactory topUpServiceFactory = new TopUpServiceFactory();
	ServiceFactory serviceFactory = new ServiceFactory();
	private static final Logger log = Logger.getLogger(MemberOperationsImpl.class.getName());
	Scanner scanner = new Scanner(System.in);

	@Override
	public Map<Integer, ApartmentMember> userRegistration() {
		final Map<Integer, ApartmentMember> membersData = new HashMap<>();
		MemberShip memberShip = null;
		log.info("Register a new user\nPress 0 to exit");
		while (true) {
			log.info("Enter member id");
			int memberId = scanner.nextInt();
			if (memberId == 0)
				break;
			while(true)
			{
				if(!membersData.containsKey(memberId))
					break;
				log.info("The member id you have entered already exists, please enter a different member id");
				memberId = scanner.nextInt();
			}
			log.info("Enter member name");
			String name = scanner.next();
			log.info("Choose any of the below membership\n1. BASIC \n2. DELUXE \n3. ELITE");
			int membershipId = scanner.nextInt();
			switch (membershipId) {
			case 1:
				memberShip = MemberShip.BASIC;
				break;
			case 2:
				memberShip = MemberShip.DELUXE;
				break;
			case 3:
				memberShip = MemberShip.ELITE;
				break;
			default:
				log.info("No membership found adding basic membership by default");
				memberShip = MemberShip.BASIC;
				break;
			}
			log.info("Enter start date of the membership");
			String date = scanner.next();
			membersData.put(memberId, new ApartmentMember(memberId, name, memberShip, date));
		}
		return Collections.unmodifiableMap(membersData);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void settingServicesDetails(Map<Integer, ApartmentMember> membersData) {
		membersData.forEach((id, member) -> {
			MemberShipServices memberShipType = memberShipfactory.getMemberShipDetails(member.getMemberShip());
			member.setServicesnames(memberShipType.getServicesNames());
			member.setCost(memberShipType.getCost(memberShipType.getServicesNames()));
		});
	}

	/**
	 * {@inheritDoc}
	 * 
	 */
	@Override
	public void settingTopUpServicesDetails(Map<Integer, ApartmentMember> membersData) {
		log.info("Enter a member id to add top up services");
		int memberId = scanner.nextInt();
		/**
		 * Checking if the given member id is valid or not
		 */
		if (membersData.containsKey(memberId)) {
			ApartmentMember member = membersData.get(memberId);
			TopUpServices topUpServices = topUpServiceFactory.getTopUpServicesDetails(member.getMemberShip());
			List<String> selectedTopUpServices = topUpServices.getTopUpServicesNames();
			/**
			 * Checking if the user has selected additional top up services, if yes adding
			 * the new services and the cost to the existing services and cost
			 */
			if (!selectedTopUpServices.isEmpty()) {
				double cost = member.getCost();
				List<String> memberServices = member.getServicesnames();
				for (String serviceName : selectedTopUpServices) {
					Service service = serviceFactory.getServiceDetails(serviceName);
					memberServices.add(service.getServicename());
					cost = cost + service.getCost();
				}
				member.setServicesnames(memberServices);
				member.setCost(cost);
			}
		}
	}

	@Override
	public void fetchMonthlyBill(Map<Integer, ApartmentMember> membersData) {
		log.info("Enter a month for calculating bill");
		String monthName = scanner.next();
		/**
		 * Checking if the given member id is valid or not
		 */
		membersData.forEach((id, member) -> {
			LocalDate membershipStartDate = member.getMemberShipStartDate();
			/**
			 * Condition to check whether membership started in the given month, if yes
			 * calculate bill for effective used days, else return full month bill
			 */
			if(membershipStartDate.getMonth().toString().equalsIgnoreCase(monthName)) {
				int dayOfMonth = membershipStartDate.getDayOfMonth();
				int totalDays = membershipStartDate.getMonth().maxLength();
				int usedDays = (totalDays - dayOfMonth) + 1;
				BigDecimal billAmount = BigDecimal.valueOf((member.getCost() / totalDays) * usedDays);
				log.info("Bill amount for " + monthName + " is " + billAmount.toString());
			} else {
				log.info("Bill amount for " + monthName + " is " + Double.toString(member.getCost()));
			}
		});
	}
}