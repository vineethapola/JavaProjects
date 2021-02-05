package com.planon.decorator;

public class Saree implements Clothes {

	@Override
	public void name() {
		System.out.print("Chanderi Saree");
	}

	@Override
	public int priceOfClothes() {
		return 1000;
	}

}
