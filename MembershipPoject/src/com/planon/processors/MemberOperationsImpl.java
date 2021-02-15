package com.planon.processors;

import java.util.List;
import java.util.Set;
import java.util.logging.Logger;

import com.planon.entities.MemberDetails;
import com.planon.entities.MemberOperations;
import com.planon.entities.MemberShipFactory;
import com.planon.entities.MemberShipServices;
import com.planon.entities.Services;
import com.planon.entities.TopUpServiceFactory;
import com.planon.entities.TopUpServices;

/**
 * Class containing all the implementations of MemberOperations Interface and the methods specific to this class
 *
 */
public class MemberOperationsImpl implements MemberOperations {
	MemberShipFactory memberShipfactory = new MemberShipFactory();
	TopUpServiceFactory topUpServiceFactory = new TopUpServiceFactory();
	private static final Logger log = Logger.getLogger(MemberOperationsImpl.class.getName());

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void settingServicesDetails(Set<MemberDetails> members) {
		members.forEach(member -> {
			MemberShipServices memberShipType = memberShipfactory
					.getMemberShipDetails(member.getMemberShip().toString());
			member.setCost(memberShipType.getCost());
			member.setServicesnames(memberShipType.getServicesNames());
			TopUpServices topUpServices = topUpServiceFactory.getTopUpServicesDetails(member.getMemberShip().toString());
			List<String> selectedTopUpServices = topUpServices.getTopUpServicesNames();
			if (! selectedTopUpServices.isEmpty())
				appendingCostandServicesDetails(member, selectedTopUpServices);
		});
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void fetchMonthlyBill(Set<MemberDetails> members) {
		members.forEach(member -> {
			int dayOfMonth = member.getMemberShipStartDate().getDayOfMonth();
			float totalDays = member.getMemberShipStartDate().getMonth().maxLength();
			float usedDays = (totalDays - dayOfMonth) + 1;
			float billAmount = Math.round((member.getCost() / totalDays) * usedDays);
			log.info(Float.toString(billAmount));
		});
	}

	private void appendingCostandServicesDetails(MemberDetails member, List<String> selectedTopUpServices) {
		List<String> appendServices = member.getServicesnames();
		int cost = member.getCost() ;
		for(String service: selectedTopUpServices) {
			Services serviceName = Services.valueOf(service.toUpperCase().replaceAll("\\s", "_"));	
			appendServices.add(serviceName.getServicename());
			cost = cost + serviceName.getCost();
		}
		member.setServicesnames(appendServices);
		member.setCost(cost);
	}
}
