package com.planon.decorator;

public class Jacket extends ClothesDecorator {

	Jacket(Clothes clothes) {
		super(clothes);
	}

	@Override
	public void name() {
		super.name();
		System.out.print(" with Jacket");
	}

	@Override
	public int priceOfClothes() {
		return super.priceOfClothes()+ 3000;
	}
	
}
