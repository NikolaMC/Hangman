package hangmanPackage;

import java.util.Random;

public class SecretWord {
	
	private static String wordToGuess[] = {"java", "hello", "dog", "purple", "horse"};

	public static String getWordToGuess() { // Returns the secret word from the wordToGuess[] array
		Random rand = new Random();
		int randomNumber = rand.nextInt(wordToGuess.length);
		
		return wordToGuess[randomNumber];
	}
	
}
