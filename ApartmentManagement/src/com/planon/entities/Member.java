package com.planon.entities;

import java.time.LocalDate;
import java.util.List;

/**
 * MemberDetails is an entity with all the getter, setter methods, parameterized
 * constructor to create a object of MemberDetails, overridden toString,
 * hashcode, equals method
 */
public class Member {

	private int memberId;
	private String memberName;
	private MemberShip memberShip;
	private LocalDate memberShipStartDate;
	private int cost;
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

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	public List<String> getServicesnames() {
		return servicesnames;
	}

	public void setServicesnames(List<String> list) {
		this.servicesnames = list;
	}

	public Member(int memberId, String memberName, MemberShip MemberShip, String memberShipStartDate) {
		this.memberId = memberId;
		this.memberName = memberName;
		this.memberShip = MemberShip;
		this.memberShipStartDate = LocalDate.parse(memberShipStartDate);

	}

	@Override
	public String toString() {
		return "MemberDetails [memberName=" + memberName + ", MemberShip=" + memberShip + ", memberShipStartDate="
				+ memberShipStartDate + ", cost=" + cost + ", servicesnames=" + servicesnames + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((memberShip == null) ? 0 : memberShip.hashCode());
		result = prime * result + memberId;
		result = prime * result + ((memberName == null) ? 0 : memberName.hashCode());
		result = prime * result + ((memberShipStartDate == null) ? 0 : memberShipStartDate.hashCode());
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
		Member other = (Member) obj;
		if (memberShip != other.memberShip)
			return false;
		if (memberId != other.memberId)
			return false;
		if (memberName == null) {
			if (other.memberName != null)
				return false;
		} else if (!memberName.equals(other.memberName))
			return false;
		if (memberShipStartDate == null) {
			if (other.memberShipStartDate != null)
				return false;
		} else if (!memberShipStartDate.equals(other.memberShipStartDate))
			return false;
		return true;
	}
}