package com.planon.bridge;

public class Client {

	public static void main(String[] args) {
		Phone typeCSmartPhone = new SmartPhone("Smart Phones Information", new TypeCCharger());
		typeCSmartPhone.newPhone(new PhoneDetails("Vivo",22000,"Silver"));
		typeCSmartPhone.displayAllPhones();
		typeCSmartPhone.getPriceOfAPhone("Samsung Galaxy");
		typeCSmartPhone.deletePhone("Samsung Galaxy");
		typeCSmartPhone.displayAllPhones();
		typeCSmartPhone.discountedPrice();
		
		
		Phone typeCFeaturePhone = new FeaturePhone("Feature Phones Information", new TypeCCharger());
		typeCFeaturePhone.displayAllPhones();
		typeCFeaturePhone.discountedPrice();
	}
}

