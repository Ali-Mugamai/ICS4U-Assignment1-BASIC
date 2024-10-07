import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
// some variables
    private static final int LIMIT = 100;
    private static final int MAX_GUESSES = 7;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        boolean guessedCorrectly;
        do {
            // Ask for instructions
            System.out.println("Do you want instructions (YES or NO)?");
            String instructionResponse = scanner.nextLine();

            if (instructionResponse.equalsIgnoreCase("YES")) {
                printInstructions();
            }
            int targetNumber = random.nextInt(LIMIT) + 1;
            System.out.println("OK, I am thinking of a number from 1 to " + LIMIT + ". Start guessing.");
            guessedCorrectly = false;
            for (int guessCount = 1; guessCount <= MAX_GUESSES; guessCount++) {
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
            // check if win or lose
            if (!guessedCorrectly) {
                System.out.println("SORRY, THAT WAS " + MAX_GUESSES + " GUESSES. NUMBER WAS " + targetNumber);
            } else {
                System.out.println("YOU GOT IT IN " + MAX_GUESSES + " GUESSES! LET'S PLAY AGAIN ...");
            }
            System.out.println();
        } while (true);
    }

    private static void printInstructions() {
        System.out.println("I am thinking of a whole number from 1 to " + LIMIT);
        System.out.println("Try to guess my number. After you guess, I will type one or more stars (*).");
        System.out.println("The more stars I type, the closer you are to my number.");
        System.out.println("One star (*), means far away. Seven stars (******* ) means really close!");
        System.out.println("You get " + MAX_GUESSES + " guesses.");
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

        for (int guess = 0; guess < stars; guess++) {
            System.out.print("*");
        }
        System.out.println();
    }
}
