package com.planon.polymorphism;

@FunctionalInterface
interface Garment {

	String colour = "red";

	default void price() {
		System.out.println("Price");
	}

	default void display() {
		System.out.println("Garment");
	}

	void fabricType();
}

class Saree implements Garment {

	String colour = "blue";

	@Override
	public void display() {
		System.out.println(colour + " " + "Saree");
	}

	@Override
	public void fabricType() {
		System.out.println(colour + " " + "In Fabric type");
	}
}

class Silksaree extends Saree {

	@Override
	public void display() {
		System.out.println(colour + " Silksaree");
	}
}

public class UpCastingExample {

	public static void main(String[] args) {
		Garment g = new Saree();
		g.display();
		g.price();
		g.fabricType();
		Saree s = new Silksaree();
		System.out.println(s.colour);
		System.out.println(((Garment) s).colour);
		((Garment) s).display();

	}
}
