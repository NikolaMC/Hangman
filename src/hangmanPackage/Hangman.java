package hangmanPackage;

import java.util.Scanner;

public class Hangman {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner charGuess = new Scanner(System.in);
		Scanner wordGuess = new Scanner(System.in);
		
		boolean wordIsGuessed = false;
		int attemptsLeft = 7;
		int guesses = 0;
		String wordToGuess = SecretWord.getWordToGuess(); // The word that the player is trying to guess
		char wordToGuessChar[] = wordToGuess.toCharArray(); // Convert the word to a char array
		char playerGuess[] = new char[wordToGuess.length()]; // Char array for managing user guesses

		for(int i = 0; i < playerGuess.length; i++){ // Assign _ for every letter in the word
		    playerGuess[i] =  '_';
		}
		
		println("Welcome to hangman!\n");
		
		while (!wordIsGuessed && attemptsLeft > 0) {
			println("");
			DrawHangman.draw(guesses); // Draw the hangman
			println("");
			
			print(playerGuess); // Print a number of _ equal to the number of letters in the word
			println("\nEnter a character. \nIf you would like to guess the whole word, enter 1. \nTo see how many attempts you have left, enter 2.");
			char charInput = charGuess.nextLine().toLowerCase().charAt(0);
			
			if (charInput == 49) { // If player enters 1 (49 in ASCII), allow them to guess the word
				println("Enter a word: ");
				String stringInput = wordGuess.nextLine().toLowerCase();
				
				if (stringInput.equals(wordToGuess)) { // If the player correctly guesses the word, end the game, if not, go back to start of the loop
					wordIsGuessed = true;
                    println("You guessed the word! It was: " + wordToGuess);
				} else {
					attemptsLeft--;
					guesses++;
					continue;
				}
			} else if(charInput == 50) { // If player enters 2 (50 in ASCII), show them the number of attempts left and number of guesses and go back to the start of the loop without affecting guesses/attempts
				System.out.println("\nNumber of guesses: " + guesses + "\nAttempts left: " + attemptsLeft + "\n");
				continue;
			}
			
			attemptsLeft--;
			guesses++;
			
			for (int i = 0; i < wordToGuess.length(); i++) { // If user enters a correct letter, reveal that letter in the word
				if (wordToGuessChar[i] == charInput) {
					playerGuess[i] = charInput;
				}
			}
			
			if(guessedWord(playerGuess)) { // If all letters are correctly guessed, end the game
                wordIsGuessed = true;
                println("You guessed the word! It was: " + wordToGuess);
            }
			
			if (attemptsLeft == 0) { // If player runs out of attempts, end the game
				println("");
				DrawHangman.draw(guesses);
				println("");
				println("You ran out of attempts! The word was: " + wordToGuess);
			}
		}

		charGuess.close();
		wordGuess.close();
		
	}
	
	public static void print(char array[]) { // Method for printing a number of _ equal to the number of letters in the word
        for(int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        } 
        println("");
    }
	
	public static boolean guessedWord(char[] array) { // Method for checking if the player guessed all letters correctly
        boolean guessed = true;
        
        for(int i = 0; i < array.length; i++){
            if(array[i] == '_') {
                guessed = false;
            }
        }
        
        return guessed;
    }
	
	public static void println(String input) {
		System.out.println(input);
	}

}
