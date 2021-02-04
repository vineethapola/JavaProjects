package com.planon.bridge;

import java.util.ArrayList;
import java.util.List;

public class FeaturePhone extends Phone{

	private String name;
	private List<PhoneDetails> phonesList = new ArrayList<>();
	private int discount = 2500;
	
	protected FeaturePhone(String name, Charger charger) {
		super(charger);	
		this.name = name;
		phonesList.add(new PhoneDetails("Nokia",1000,"Light blue"));
		phonesList.add(new PhoneDetails("Reliance",3500,"Red"));
		phonesList.add(new PhoneDetails("Jio Phone",3000,"Green"));
		phonesList.add(new PhoneDetails("Micromax",2500,"White"));
	}

	@Override
	protected void newPhone(PhoneDetails phoneDetails) {
			charger.newPhone(phoneDetails, phonesList);
	}

	@Override
	protected void displayAllPhones() {
		System.out.println("--------------------------------------------");
		System.out.println(name);
		charger.displayPhones(phonesList);
		System.out.println("--------------------------------------------");
	}

	@Override
	protected void getPriceOfAPhone(String name) {
		charger.getPriceOfAPhone(name, phonesList);
	}

	@Override
	protected void deletePhone(String name) {
		charger.deletePhone(name, phonesList);
	}

	@Override
	protected void discountedPrice() {
		charger.discountedPrice(discount, phonesList);
	}

}
