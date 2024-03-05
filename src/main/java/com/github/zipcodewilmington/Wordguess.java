package com.github.zipcodewilmington;
import java.util.Scanner;
import java.util.Random;

/**
 * @author dannycao1997
 * @version 1.0.0
 * @date 3/4/24
 */

// WordGuess Game V1 :-) FINISHED


public class Wordguess {
        public static void main(String[] args) {
                String[] words = {"tesla", "honda", "dodge", "lexus"}; // Secret Words for game
                Random random = new Random();
                String secretWord = words[random.nextInt(words.length)];
                char[] guessedWord = new char[secretWord.length()];
                int triesLeft = 5; // Number of guesses

                for (int i = 0; i < secretWord.length(); i++) {
                        guessedWord[i] = '_';
                }

                Scanner scanner = new Scanner(System.in);

                while (triesLeft > 0) {
                        System.out.println("Current Guesses: " + new String(guessedWord));
                        System.out.println("You have " + triesLeft + " tries left.");

                        System.out.print("Enter a single character: ");
                        char guess = scanner.next().charAt(0);

                        boolean correctGuess = false;
                        for (int i = 0; i < secretWord.length(); i++) {
                                if (secretWord.charAt(i) == guess) {
                                        guessedWord[i] = guess;
                                        correctGuess = true;
                                }
                        }
                        if (!correctGuess) {
                                triesLeft--;
                                System.out.println(":-( :-( :-( :-( :-(");
                        } else if (new String(guessedWord).equals(secretWord)) {
                                System.out.println("CONGRATS! :-) You guessed the word: " + secretWord);
                                break;

                        }
                }
                if (triesLeft == 0) {
                        System.out.println("YOU LOST! :-( No more guesses!");
                }
                scanner.close();
        }
}