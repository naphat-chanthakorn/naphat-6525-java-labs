package chanthakorn.naphat.lab4;

import java.util.ArrayList;
import java.util.Scanner;

public class GuessNumberGameV3 {
    // Static variables for game settings and statistics
    static int answer, max, min, tries, maxTries, totalGames, totalWins, totalGuesses, highScore;
    static boolean winStatus;
    static Scanner scanner = new Scanner(System.in);
    static ArrayList<Integer> guesses = new ArrayList<>();

    // The main method where the program execution starts
    public static void main(String[] args) {
        playGames();
        displayStatistics();
        System.out.println("Thank you for playing our games. Bye!"); // Goodbye message
        scanner.close(); // Closes the Scanner to prevent resource leak
    }

    // The main game loop
    public static void playGames() {
        configure(); // Configure once at the beginning

        // Loops through games until the user chooses not to play again
        do {
            playGame();
            postGameReview();
            displayGameLog(winStatus);
        } while (playAgain());
    }

    // Configures game settings at the start or for each new game
    public static void configure() {
        // Sets the minimum value for the random number
        System.out.print("Enter the min value: ");
        min = scanner.nextInt();

        // Validate the max value must be at least equal to min value
        while (true) {
            System.out.print("Enter the max value: ");
            max = scanner.nextInt();

            if (max >= min) {
                break;
            } else {
                System.err.println("The max value must be at least equal to the min value");
            }
        }

        // Validate the maximum number of tries is greater than 0
        while (true) {
            System.out.print("Enter the maximum number of tries: ");
            maxTries = scanner.nextInt();

            if (maxTries > 0) {
                break;
            } else {
                System.err.println("The maximum number of tries must be greater than 0");
            }
        }

        guesses.clear(); // Clear previous guesses when configuring for a new game
        genAnswer(); // Generate a new answer for each new game
    }

    // Generates a random answer within the specified range
    public static void genAnswer() {
        answer = min + (int) (Math.random() * ((max - min) + 1));
    }

    // Manages the gameplay for a single game
    public static void playGame() {
        System.out.println("Welcome to a number guessing game!");
        tries = 0; // Resets the number of tries for each new game
        winStatus = false;

        // Loops until the maximum number of tries is reached or the correct answer is
        // guessed
        while (tries < maxTries) {
            System.out.print("Enter an integer between " + min + " and " + max + ": ");
            int guess = scanner.nextInt();

            // Validates that the guess is within the specified range
            if (guess < min || guess > max) {
                System.out.println("Your guess should be in [" + min + "," + max + "]");
            }

            guesses.add(guess); // Adds the guess to the history
            tries++; // Increments the number of tries

            // Checks if the guess is correct and provides feedback
            if (guess == answer) {
                System.out.println("Congratulations!");
                winStatus = true; // Updates win status for a win
                updateStatistics(true); // Updates game statistics for a win
                return;
            } else if (guess > answer) {
                System.out.println("Try a lower number!");
            } else {
                System.out.println("Try a higher number!");
            }
        }

        // Display the message number(s) of the player tried
        if (tries > 1) {
            System.out.println("You have tried " + tries + " times.");
        } else {
            System.out.println("You have tried 1 time.");
        }

        // Display the player is ran out of guesses and reveal the answer
        if (tries == maxTries) {
            System.out.println("You ran out of guesses. The answer is " + answer);
            updateStatistics(false); // Updates game statistics for a loss
        }
    }

    // Allows the user to review the game by showing all guesses or a specific guess
    public static void postGameReview() {
        // Create boolean to control the review loop
        boolean continueReview = true;

        while (continueReview) {
            System.out.print("Enter 'a' to list all guesses, 'g' for a specific guess, or any other key to quit: ");
            char option = scanner.next().charAt(0);

            // Switch statement to handle different options
            switch (option) {
                case 'a':
                    allGuesses();
                    break;
                case 'g':
                    specificGuess();
                    break;
                default:
                    continueReview = false;
                    break;
            }
        }
    }

    // Lists all guesses made in the current game
    public static void allGuesses() {
        System.out.println("All guesses:");

        for (int i = 0; i < guesses.size(); i++) {
            System.out.print(guesses.get(i) + " ");
        }
        System.out.println(""); // Move to the next line after printing guesses
    }

    // Shows a specific guess based on user input
    public static void specificGuess() {
        System.out.print("Enter the number of the guess you want to see (1-" + guesses.size() + "): ");
        int guessNumber = scanner.nextInt();

        // Validates the input and shows the corresponding guess
        if (guessNumber >= 1 && guessNumber <= guesses.size()) {
            System.out.println("Guess " + guessNumber + ": " + guesses.get(guessNumber - 1));
        } else {
            System.out.println("Invalid guess number. Please enter a number between 1-" + guesses.size());
        }
    }

    // Asks the user if they want to play again and resets the game state
    // accordingly
    public static boolean playAgain() {
        System.out.print("Want to play again (Y or y): ");
        String playAgain = scanner.next();
        if (playAgain.equalsIgnoreCase("y")) {
            guesses.clear(); // Reset guesses for a new game
            genAnswer(); // Generate a new answer for a new game
            return true;
        } else {
            return false;
        }
    }

    // Displays a summary of the current game's statistics
    public static void displayGameLog(boolean winStatus) {
        System.out.println(
                "Game Log: Answer: " + answer + ", Guesses: " + tries + ", Win: " + (winStatus ? "Win" : "Loss"));
    }

    // Updates overall game statistics based on the outcome of the current game
    public static void updateStatistics(boolean winStatus) {
        totalGames++;
        totalGuesses += tries;
        if (winStatus) {
            totalWins++;
            if (highScore == 0 || tries < highScore) {
                highScore = tries;
            }
        }
    }

    // Displays overall game statistics at the end
    public static void displayStatistics() {
        System.out.println("--- Game Statistics ---");
        System.out.println("Total games played: " + totalGames);
        System.out.println("Total wins: " + totalWins);
        System.out.println("Win Ratio: " + ((double) totalWins / totalGames) * 100 + "%");
        System.out.println("Average guess per game: " + (double) totalGuesses / totalGames);
        System.out.println("High Score (Least Guesses): " + (highScore == 0 ? "N/A" : highScore));
    }
}