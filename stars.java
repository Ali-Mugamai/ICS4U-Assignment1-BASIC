/*
* this program runs a number guessing game
*
* @author  Ali Mugamai
* @version 1.0
* @since   2021-09-24
*/

import java.util.Scanner;
import java.util.Random;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int limit = 100;
        int numOfGuesses = 7;

        while (true) {
            System.out.println("STARS - A NUMBER GUESSING GAME");
            System.out.println("Do you want instructions (YES or NO)?");
            String UserInputInstructions = scanner.nextLine().toUpperCase();

            if ( UserInputInstructions.equals("YES")) {
                printInstructions(limit, maxGuesses);
            }

            int targetNumber = random.nextInt(limit) + 1;
            System.out.println("OK, I am thinking of a number from 1 to " + limit + ". Start guessing.");

            boolean guessedCorrectly = false;

            for (int guessCount = 1; guessCount <= maxGuesses; guessCount++) {
                System.out.print("Your guess: ");
                int guess = scanner.nextInt();
                scanner.nextLine();

                if (guess == targetNumber) {
                    guessedCorrectly = true;
                    break;
                }

                int difference = Math.abs(targetNumber - guess);
                printStars(difference);
            }

            if (!guessedCorrectly) {
                System.out.println("SORRY, THAT WAS " + maxGuesses + " GUESSES. NUMBER WAS " + targetNumber);
            } else {
                System.out.println("!!!");
                System.out.println("YOU GOT IT IN " + maxGuesses + " GUESSES! LET'S PLAY AGAIN...");
            }

            System.out.println();
        }
    }

    private static void printInstructions(int limit, int maxGuesses) {
        System.out.println("I am thinking of a whole number from 1 to " + limit);
        System.out.println("Try to guess my number. After you guess, I will type one or more stars (*).");
        System.out.println("The more stars I type, the closer you are to my number.");
        System.out.println("One star (*), means far away. Seven stars (******* ) means really close!");
        System.out.println("You get " + maxGuesses + " guesses.");
    }

    private static void printStars(int difference) {
        int stars = 0;
        if (difference > 64) stars = 1;
        else if (difference > 32) stars = 2;
        else if (difference > 16) stars = 3;
        else if (difference > 8) stars = 4;
        else if (difference > 4) stars = 5;
        else if (difference > 2) stars = 6;
        else if (difference == 1) stars = 7;

        for (int guess = 0; guess < stars; i++) {
            System.out.print("*");
        }
        System.out.println();
    }
}
