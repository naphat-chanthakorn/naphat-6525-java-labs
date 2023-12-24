package chanthakorn.naphat.lab4;
import java.util.ArrayList;
import java.util.Scanner;

public class test {
    static int answer, max, min, tries, maxTries, totalGames, totalWins, totalGuesses, highScore;
    static Scanner scanner = new Scanner(System.in);
    static ArrayList<Integer> guesses = new ArrayList<>();

    public static void main(String[] args) {
        playGames();
        displayStatistics();
        System.out.println("Thank you for playing our games. Bye!");
        scanner.close();
    }

    public static void playGames() {
        do {
            configure();
            playGame();
            postGameReview();
        } while (playAgain());
    }

    public static void configure() {
        System.out.print("Enter the min value: ");
        min = scanner.nextInt();

        while (true) {
            System.out.print("Enter the max value: ");
            max = scanner.nextInt();

            if (max >= min) {
                break;
            } else {
                System.err.println("The max value must be at least equal to the min value");
            }
        }

        while (true) {
            System.out.print("Enter the maximum number of tries: ");
            maxTries = scanner.nextInt();

            if (maxTries > 0) {
                break;
            } else {
                System.err.println("The maximum number of tries must be greater than 0");
            }
        }

        guesses.clear();
        genAnswer();
    }

    public static void genAnswer() {
        answer = min + (int) (Math.random() * ((max - min) + 1));
    }

    public static void playGame() {
        System.out.println("Welcome to a number guessing game!");
        tries = 0;

        while (tries < maxTries) {
            System.out.print("Enter an integer between " + min + " and " + max + ": ");
            int guess = scanner.nextInt();

            if (guess < min || guess > max) {
                System.out.println("Your guess should be in [" + min + "," + max + "]");
            }

            guesses.add(guess);
            tries++;

            if (guess == answer) {
                System.out.println("Congratulations! You guessed the correct number.");
                displayGameLog(true);
                updateStatistics(true);
                return;
            } else if (guess > answer) {
                System.out.println("Try a lower number!");
            } else {
                System.out.println("Try a higher number!");
            }
        }

        if (tries > 1) {
            System.out.println("You have tried " + tries + " times.");
        } else {
            System.out.println("You have tried 1 time.");
        }

        if (tries == maxTries) {
            System.out.println("You ran out of guesses. The answer was " + answer);
            displayGameLog(false);
            updateStatistics(false);
        }
    }

    public static void postGameReview() {
        boolean continueReview = true;

        while (continueReview) {
            System.out.print("Enter 'a' to list all guesses, 'g' for a specific guess, or any other key to quit: ");
            char option = scanner.next().charAt(0);

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
        System.out.println("All guesses:");

        for (int i = 0; i < guesses.size(); i++) {
            System.out.print(guesses.get(i) + " ");
        }
        System.out.println("");
    }

    public static void specificGuess() {
        System.out.print("Enter the number of the guess you want to see (1-" + guesses.size() + "): ");
        int guessNumber = scanner.nextInt();

        if (guessNumber >= 1 && guessNumber <= guesses.size()) {
            System.out.println("Guess " + guessNumber + ": " + guesses.get(guessNumber - 1));
        } else {
            System.out.println("Invalid guess number. Please enter a number between 1-" + guesses.size());
        }
    }

    public static boolean playAgain() {
        System.out.print("Want to play again (Y or y): ");
        String playAgain = scanner.next();
        if (playAgain.equalsIgnoreCase("y")) {
            genAnswer(); // Generate a new answer for a new game
            return true;
        }
        return false;
    }

    public static void updateStatistics(boolean win) {
        totalGames++;
        totalGuesses += tries;
        if (win) {
            totalWins++;
            if (highScore == 0 || tries < highScore) {
                highScore = tries;
            }
        }
    }

    public static void displayStatistics() {
        System.out.println("\n--- Game Statistics ---");
        System.out.println("Total Games: " + totalGames);
        System.out.println("Total Wins: " + totalWins);
        System.out.println("Win Ratio: " + ((double) totalWins / totalGames) * 100 + "%");

        if (totalGames > 0) {
            System.out.println("Average Guesses per Game: " + (double) totalGuesses / totalGames);
            System.out.println("High Score: " + (highScore == 0 ? "N/A" : highScore));
        } else {
            System.out.println("Average Guesses per Game: N/A");
            System.out.println("High Score: N/A");
        }
    }

    public static void displayGameLog(boolean win) {
        System.out.println("\n--- Game Log ---");
        System.out.println("Answer: " + answer);
        System.out.println("Number of Guesses: " + tries);
        System.out.println("Win/Loss: " + (win ? "Win" : "Loss"));
    }
}