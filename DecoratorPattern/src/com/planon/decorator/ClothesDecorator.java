package com.planon.decorator;

public class ClothesDecorator implements Clothes {

	Clothes clothes;
	ClothesDecorator(Clothes clothes){
		this.clothes = clothes;
	}
		
	@Override
	public void name() {
		clothes.name();
	}

	@Override
	public int priceOfClothes() {
		return clothes.priceOfClothes();
	}

}
