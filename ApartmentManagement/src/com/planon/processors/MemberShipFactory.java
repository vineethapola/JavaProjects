
package com.planon.processors;

import java.util.logging.Logger;

import com.planon.client.BasicMemberShip;
import com.planon.client.DeluxeMemberShip;
import com.planon.client.EliteMemberShip;
import com.planon.client.MemberShipServices;
import com.planon.entities.MemberShip;

/**
 * Class to get the MemberShipServices object
 *
 */
public class MemberShipFactory {
	static Logger log = Logger.getLogger(MemberShipFactory.class.getName());
	/**
	 * Method to get the type of MemberShipService object
	 * 
	 * @param memberShipType
	 * @return MemberShipServices object
	 */
	public MemberShipServices getMemberShipDetails(MemberShip memberShip) {
		switch (memberShip) {
		case BASIC:
			return new BasicMemberShip();
		case DELUXE:
			return new DeluxeMemberShip();
		case ELITE:
			return new EliteMemberShip();
		default:
			log.info("Membership not found");
			break;
		}
		return null;
	}
}