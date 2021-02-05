package com.planon.decorator;

public class Sweater extends ClothesDecorator {

	Sweater(Clothes clothes) {
		super(clothes);
	}
	
	@Override
	public void name() {
		super.name();
		System.out.print(" with Sweater");
	}

	@Override
	public int priceOfClothes() {
		return super.priceOfClothes()+ 2000;
	}

}
