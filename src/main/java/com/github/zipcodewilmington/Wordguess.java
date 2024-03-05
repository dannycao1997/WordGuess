package com.github.zipcodewilmington;
import java.util.Scanner;
import java.util.Random;


/**
 * @author dannycao1997
 * @version 1.0.0
 * @date 3/4/24
 */

// Word Guess Game V1


public class Wordguess {
        public static void main(String[] args) {
                String[] words = {"tesla", "honda", "dodge", "lexus"};
                Random random = new Random();
                String secretWord = words[random.nextInt(words.length)];
                char[] guessedWord = new char[secretWord.length()];
                int triesLeft = 5;
        }








