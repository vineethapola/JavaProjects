package com.planon.entities;

import java.time.LocalDate;
import java.util.List;

/**
 * MemberDetails is an entity with all the getter, setter methods, parameterized
 * constructor to create a object of Member, overridden hashcode, equals method
 */
public class ApartmentMember {

	private int memberId;
	private String memberName;
	private MemberShip memberShip;
	private LocalDate memberShipStartDate;
	private double cost;
	private List<String> servicesnames;

	public int getMemberId() {
		return memberId;
	}

	public String getMemberName() {
		return memberName;
	}

	public MemberShip getMemberShip() {
		return memberShip;
	}

	public LocalDate getMemberShipStartDate() {
		return memberShipStartDate;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public List<String> getServicesnames() {
		return servicesnames;
	}

	public void setServicesnames(List<String> list) {
		this.servicesnames = list;
	}

	public ApartmentMember(int memberId, String memberName, MemberShip memberShip, String memberShipStartDate) {
		this.memberId = memberId;
		this.memberName = memberName;
		this.memberShip = memberShip;
		this.memberShipStartDate = LocalDate.parse(memberShipStartDate);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + memberId;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ApartmentMember other = (ApartmentMember) obj;
		if (memberId != other.memberId)
			return false;
		return true;
	}

}