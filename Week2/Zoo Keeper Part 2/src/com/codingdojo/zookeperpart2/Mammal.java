package com.codingdojo.zookeperpart2;

public class Mammal {
	protected int energyLevel = 100;

	public int displayEnergy() {
		System.out.println("Energy: " + this.energyLevel);
		return energyLevel;
	}
}