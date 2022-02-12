package com.codingdojo.zookeperpart2;

public class Bat extends Mammal{
	
	public Bat(){
		super.energyLevel = 300;
	}
	
	public void fly() {
		System.out.println("The giant bat has taken flight.");
		super.energyLevel -= 50;
	}
	
	public void eatHumans() {
		System.out.println("The giant bat has eaten a human.");
		super.energyLevel += 25;
	}
	
	public void attackTown() {
		System.out.println("The giant bat has attacked a town.");
		super.energyLevel -= 100;
	}
}
