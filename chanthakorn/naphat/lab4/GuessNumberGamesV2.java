package chanthakorn.naphat.lab4;
import java.util.ArrayList;
import java.util.Scanner;

public class GuessNumberGamesV2 {
    static int answer, max, min, tries, maxTries;
    static Scanner scanner = new Scanner(System.in);
    static ArrayList<Integer> guesses = new ArrayList<>();

    public static void main(String[] args) {
        playGames();
        System.out.println("Thank you for playing our games. Bye!");
    }

    public static void playGames() {
        // Allow the player to play the game multiple times
        do {
            // Start the game by configure settings, generate anwser and play the game
            configure();
            playGame();
            postGameReview();

            // Ask the player if they want to play again
            System.out.print("Want to play again (Y or y): ");
            String playAgain = scanner.next();

            // Check if playAgain variable is Y or y to play again
            if (!playAgain.equalsIgnoreCase("y")) {
                break;
            }
        } while (true);

        scanner.close(); // Close the scanner
    }

    public static void configure() {
        // Configure settings by user input with the min value, max value and the maximum number of tries
        System.out.print("Enter the min value:");
        min = scanner.nextInt();

        // Validate the max value must be at least equal to min value
        while (true) {
            System.out.print("Enter the max value:");
            max = scanner.nextInt();

            if (max >= min) {
                break;
            } else {
                System.err.println("The max value must be at least equal to the min value");
            }
        }

        // Validate the maximum number of tries must be at least equal to min value
        while (true) {
            System.out.print("Enter the maximum number of tries:");
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

    public static void genAnswer() {
        // Generate a random answer
        answer = min + (int) (Math.random() * ((max - min) + 1));
    }

    public static void playGame() {
        // Start the game!
        System.out.println("Welcome to a number guessing game!");
        tries = 0;

        // The player make guess untill reaching the maximum of tries
        while (tries < maxTries) {
            System.out.print("Enter an integer between " + min + " and " + max + ":");
            int guess = scanner.nextInt();

            if (guess < min || guess > max) {
                System.out.println("Your guess should be in [" + min + "," + max + "]:");
            }

            guesses.add(guess); // Add the guess to the ArrayList

            tries++; // Increase the number of tries

            // Check if the guess is correct or not and then provide the result
            if (guess == answer) {
                System.out.println("Congratulations!");
                return;
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
            System.out.println("You have tried 1 time.");
        }

        // Display the player is ran out of guesses and reveal the answer
        if (tries == maxTries) {
            System.out.println("You ran out of guesses. The answer is " + answer);
        }
    }

    public static void postGameReview() {
        // Create boolean to control the review loop
        boolean continueReview = true;
        
        // Review a game before ended
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

    public static void allGuesses() {
        // Display all guesses
        System.out.println("All guesses:");
        
        for (int i = 0; i < guesses.size(); i++) {
            System.out.print(guesses.get(i) + " ");
        }
        System.out.println(""); // Move to the next line after printing guesses
    }

    public static void specificGuess() {
        // Display a specific guess
        System.out.print("Enter the number of the guess you want to see (1-" + guesses.size() + "): ");
        int guessNumber = scanner.nextInt();

        if (guessNumber >= 1 && guessNumber <= guesses.size()) {
            System.out.println("Guess " + guessNumber + ": " + guesses.get(guessNumber - 1));
        } else {
            System.out.println("Invalid guess number. Please enter a number between 1-" + guesses.size());
        }
    }
}
