
package com.planon.processors;

import com.planon.entities.MemberShip;
import com.planon.util.BasicMemberShip;
import com.planon.util.DeluxeMemberShip;
import com.planon.util.EliteMemberShip;
import com.planon.util.MemberShipServices;

/**
 * Method to get the type of MemberShipService object
 * 
 * @param memberShipType
 * @return MemberShipServices object
 */
public class MemberShipFactory {
	public MemberShipServices getMemberShipDetails(String memberShipType) {
		if (MemberShip.BASIC.equals(MemberShip.valueOf(memberShipType)))
			return new BasicMemberShip();
		else if (MemberShip.DELUXE.equals(MemberShip.valueOf(memberShipType)))
			return new DeluxeMemberShip();
		else
			return new EliteMemberShip();
	}
}