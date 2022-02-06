import java.util.ArrayList;
public class TestPuzzleJava {
    
	public static void main(String[] args) {
		PuzzleJava generator = new PuzzleJava();
		ArrayList<Integer> randomRolls = generator.getTenRolls();
		System.out.println(randomRolls);
		
    	System.out.println("\nRandom Letter: " + generator.getRandomLetter());

        System.out.println("\nRandom Password: " + generator.generatePassword());

        System.out.println("\nRandom Password Set:");
        System.out.println(generator.getNewPasswordSet(5));

        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        System.out.print("\nShuffled Array: ");
        int[] randArray = generator.shuffleArray(numbers);
        for (int x = 0; x < randArray.length; x++)
            System.out.print(randArray[x] + ", ");
	}
}