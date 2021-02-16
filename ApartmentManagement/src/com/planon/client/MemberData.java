package com.planon.client;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import com.planon.entities.Member;
import com.planon.entities.MemberShip;

/**
 * 
 *Class to get the static Member Data
 *
 */
public class MemberData {
	static final Set<Member> members = addTransactions();

	private static Set<Member>  addTransactions() {
		final Set<Member> staticMembers = new HashSet<>();
		staticMembers.add(new Member(1, "Vineetha", MemberShip.BASIC, "2020-12-08"));
		staticMembers.add(new Member(2, "Sai", MemberShip.DELUXE, "2020-02-10"));
		staticMembers.add(new Member(3, "Dev", MemberShip.ELITE, "2020-01-01"));
		return Collections.unmodifiableSet(staticMembers);
	}
}
