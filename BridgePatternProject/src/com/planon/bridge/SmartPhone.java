package com.planon.bridge;

import java.util.ArrayList;
import java.util.List;

public class SmartPhone extends Phone {

	private String name;
	private List<PhoneDetails> phonesList = new ArrayList<>();
	private double discount = 1000;
	
	protected SmartPhone(String name, Charger charger) {
		super(charger);
		this.name = name;
		phonesList.add(new PhoneDetails("OnePlus 7", 40000, "Crimson red"));
		phonesList.add(new PhoneDetails("Redmi 4", 12000, "Black"));
		phonesList.add(new PhoneDetails("Motorola G", 8000, "Blue"));
		phonesList.add(new PhoneDetails("Apple 8", 75000, "White"));
		phonesList.add(new PhoneDetails("Samsung Galaxy", 30000, "Cyan"));
	}

	@Override
	protected void newPhone(PhoneDetails phoneDetails) {
		charger.newPhone(phoneDetails,phonesList);
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
		charger.getPriceOfAPhone(name,phonesList);
	}

	@Override
	protected void deletePhone(String name) {
		charger.deletePhone(name,phonesList);
		
	}

	@Override
	protected void discountedPrice() {
		charger.discountedPrice(discount, phonesList);
	}

}
