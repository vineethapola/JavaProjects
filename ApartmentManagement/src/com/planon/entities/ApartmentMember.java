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

	/**
	 * Setter method to set the cost for a member based on the membership and
	 * additional services chosen
	 * 
	 * @param cost
	 */
	public void setCost(double cost) {
		this.cost = cost;
	}

	public List<String> getServicesnames() {
		return servicesnames;
	}

	/**
	 * Setter method to set the services names for a member based on the membership
	 * and additional services chosen
	 * 
	 * @param list
	 */
	public void setServicesnames(List<String> list) {
		this.servicesnames = list;
	}

	/**
	 * Constructor to set the below values for a apartment member on registration
	 * 
	 * @param memberId
	 * @param memberName
	 * @param memberShip
	 * @param memberShipStartDate
	 */
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