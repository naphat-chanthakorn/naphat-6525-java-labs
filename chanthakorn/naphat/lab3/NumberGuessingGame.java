package chanthakorn.naphat.lab3;

import java.util.Scanner;

public class NumberGuessingGame {
    public static void main(String[] args) {
        // Start the game!
        System.out.println("Welcome to a number guessing game!");

        // Set the range for the random number, generate the answer and set the guess and the maximum of tries
        int max = 20;  
        int min = 1;
        int answer = min + (int) (Math.random() * ((max - min) + 1));
        int tries = 0;
        int maxTries = 5;

        // Create Scanner for user input
        Scanner scanner = new Scanner(System.in);

        // The player make guess untill reaching the maximum of tries
        while (tries < maxTries) {
            System.out.print("Enter an integer between 1 and 20:");
            int guess = scanner.nextInt();
            tries++;

            // Check if the guess is correct or not and then provide the result
            if (guess == answer) {
                System.out.println("Congratulations!");
                break;
            } else if (guess > answer) {
                System.out.println("Try a lower number!");
            } else {
                System.out.println("Try a higher number!");
            }
        }
        // Display the number of the player tried
        if (tries > 1) {
            System.out.println("You have tried " + tries + " times.");
        } else {
            System.out.println("You have tried 1 time");
        }

        // Display the player is ran out of guesses and reveal the answer
        if (tries == maxTries) {
            System.out.println("You ran out of guesses. The answer is " + answer);
        }
        // Close the scanner
        scanner.close();
    }
}