import java.util.ArrayList;
import java.util.Random;

public class PuzzleJava {
    
    // Generates an array of 10 random numbers 1 - 20
    public ArrayList<Integer> getTenRolls() {
        Random rand = new Random();
        ArrayList<Integer> randInts = new ArrayList<Integer>();

        for(int x = 1; x <= 10; x++)
            randInts.add(rand.nextInt(20)+1);

        return randInts;
    }

    // Return a random letter of the alphabet
    public char getRandomLetter(){
        Random rand = new Random();
        char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();

        return alphabet[rand.nextInt(26)];
    }

    // Return a random 8 character string
    public String generatePassword() {
        String password = "";

        for (int x = 0; x < 8; x++)
            password += getRandomLetter();

        return password;
    }

    // Return an array of 8 character strings of a provided length
    public ArrayList<String> getNewPasswordSet(int length) {
        ArrayList<String> passwords = new ArrayList<String>();
        
        for (int x = 0; x < length; x++)
            passwords.add(generatePassword());

        return passwords;
    }

    // Shuffle the values in an array of integers
    public int[] shuffleArray(int[] intArray) {
        Random rand = new Random();

        for(int x = 0; x < intArray.length; x++) {
            int randInt = rand.nextInt(intArray.length);
            int temp = intArray[x];
            intArray[x] = intArray[randInt];
            intArray[randInt] = temp;
        }

        return intArray;
    }
}
