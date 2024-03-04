package com.github.zipcodewilmington;
//Danny Cao
import java.util.Scanner;
import java.util.Random;


/**
 * @author xt0fer
 * @version 1.0.0
 * @date 5/27/21 11:02
 */



//Version 1.0 WORDGUESS , PRACTICE
public class Wordguess {
        private String words[] = {"honda", "toyota", "nissan", "lexus"};
        private char[] secretWord;
        private char[] guesses;
        private int maxGuesses = 10;
        private int numGuesses;
        Scanner scanner;

        public Wordguess() {
                this.maxGuesses = 10;
                this.scanner = new Scanner(System.in);
        }

        public void runGame() {
                System.out.println("Let's Play Wordguess V1.0");
                do {
                        initializeGameState();
                        playRound();
                        System.out.println("Game Over!!!");
                } while (askToPlayAgain());
        }

        private void initializeGameState() {
                Random random = new Random();
                int randomIndex = random.nextInt(words.length);
                secretWord = words[randomIndex].toCharArray();
                guesses = new char[secretWord.length];
                numGuesses = 0;

                for (int i = 0; i < secretWord.length; i++) {
                        guesses[i] = '_';
                }
        }

        private void playRound() {
                boolean wordGuessed = false;
                while (!wordGuessed && numGuesses < maxGuesses) {
                        printCurrentState();
                        char guess = getNextGuess();
                        process(guess);
                        wordGuessed = isWordGuessed();
                        numGuesses++;
                }

                if (wordGuessed) {
                        playerWon();
                } else {
                        playerLost();
                }
        }

        private void printCurrentState() {
                System.out.print("Current Guesses: ");
                printArray(guesses);
                System.out.println("You have " + (maxGuesses - numGuesses) + " tries left.");
        }

        private char getNextGuess() {
                System.out.print("Enter a single character: ");
                return scanner.next().charAt(0);
        }

        private void process(char guess) {
                for (int i = 0; i < secretWord.length; i++) {
                        if (secretWord[i] == guess) {
                                guesses[i] = guess;
                        }
                }
        }

        private boolean isWordGuessed() {
                for (char letter : guesses) {
                        if (letter == '_') {
                                return false;
                        }
                }
                return true;
        }

        private void playerWon() {
                System.out.println("**** ****");
                printArray(secretWord);
                System.out.println("Congratulations, You Won!!!");
        }

        private void playerLost() {
                System.out.println(":-( :-( :-( :-(");
                printArray(secretWord);
                System.out.println("You Lost! You ran out of guesses.");
        }

        private boolean askToPlayAgain() {
                System.out.print("Would you like to play again? (yes/no) ");
                return scanner.next().equalsIgnoreCase("yes");
        }

        private void printArray(char[] array) {
                for (char character : array) {
                        System.out.print(character + " ");
                }
                System.out.println();
        }

        public static void main(String[] args) {
                Wordguess game = new Wordguess();
                game.runGame();
        }
}













