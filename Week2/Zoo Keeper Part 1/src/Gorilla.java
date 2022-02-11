
public class Gorilla extends Mammal {
	
	public void throwSomething() {
		System.out.println("The gorilla has thrown something.");
		super.energyLevel -= 5;
	}
	
	public void eatBananas() {
		System.out.println("The gorilla enjoyed the banana.");
		super.energyLevel += 10;
	}
	
	public void climb() {
		System.out.println("The gorilla has climbed a tree.");
		super.energyLevel -= 10;
	}
}
