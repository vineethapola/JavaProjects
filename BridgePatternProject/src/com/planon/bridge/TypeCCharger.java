package com.planon.bridge;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class TypeCCharger implements Charger {
	
	double discountedPrice;

	@Override
	public void newPhone(PhoneDetails phoneDetail, List<PhoneDetails> phonesList) {
		phonesList.add(phoneDetail);
	}

	@Override
	public void displayPhones(List<PhoneDetails> phonesList) {
		phonesList.forEach(
				phone -> System.out.println(phone.getName() + " " + phone.getPrice() + " " + phone.getColour()));
	}

	@Override
	public void getPriceOfAPhone(String name, List<PhoneDetails> phonesList) {
		Set<PhoneDetails> phones = phonesList.stream().filter(phoneName -> phoneName.getName().equalsIgnoreCase(name))
				.collect(Collectors.toSet());
		phones.forEach(p -> System.out.println("Price of " + name + " is " + p.getPrice()));
	}

	@Override
	public void deletePhone(String name, List<PhoneDetails> phonesList) {
		phonesList.removeIf(p -> p.getName().equalsIgnoreCase(name));
	}

	@Override
	public void  discountedPrice(double discount,List<PhoneDetails> phonesList) {
		phonesList.forEach(p ->{
			discountedPrice =  (p.getPrice()-discount) > 0 ?  (p.getPrice()-discount) : p.getPrice();
			System.out.println("Discounted Price of " + p.getName() + " is " +   discountedPrice);
		});
	}
}
