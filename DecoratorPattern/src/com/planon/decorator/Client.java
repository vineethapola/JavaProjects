package com.planon.decorator;

public class Client {

	public static void main(String[] args) {
		Clothes saree = new Saree();
		saree.name();
		System.out.println("\n"+saree.priceOfClothes());
		
		Clothes sweaterDecorator = new Sweater(new Saree());
		sweaterDecorator.name();
		System.out.println("\n"+sweaterDecorator.priceOfClothes());
		
		Clothes jacketDecorator = new Jacket(new Saree());
		jacketDecorator.name();
		System.out.println("\n"+jacketDecorator.priceOfClothes());
	}
}
