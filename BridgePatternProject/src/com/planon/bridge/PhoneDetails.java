package com.planon.bridge;

public class PhoneDetails {

	private String name;
	private double price;
	private String colour;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getColour() {
		return colour;
	}

	public void setColour(String colour) {
		this.colour = colour;
	}

	public PhoneDetails(String name, double price, String colour) {
		super();
		this.name = name;
		this.price = price;
		this.colour = colour;
	}
	

}
