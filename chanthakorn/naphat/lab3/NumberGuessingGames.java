package chanthakorn.naphat.lab3;
import java.util.Scanner;

public class NumberGuessingGames {
    static int answer, max, min, tries, maxTries;
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        playGames();
        System.out.println("Thank you for playing our games. Bye!");
    }

    public static void playGames() {
        do {
            configure();
            genAnswer();
            playGame();
            System.out.print("Want to play again (Y or y) :");
            String playAgain = scanner.next();
            if (!playAgain.equalsIgnoreCase("y")) {
                break;
            }
        } while (true);
        scanner.close();
    }

    public static void configure() {
        System.out.print("Enter the min value:");
            min = scanner.nextInt();

        while (true) {
            System.out.print("Enter the max value:");
            max = scanner.nextInt();

            if (max >= min) {
                break;
            } else {
                System.err.println("The max value must be at least equal to the min value");
            }
        }

        while (true) {
            System.out.print("Enter the maximum number of tries:");
            maxTries = scanner.nextInt();

            if (maxTries > 0) {
                break;
            } else {
                System.err.println("The maximum number of tries must be greater than 0");
            }
        }
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
                System.out.println("The number must be between " + min + " and " + max);
                continue;
            }
            tries++;

            if (guess == answer) {
                System.out.println("Congratulations!");
                break;
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
            System.out.println("You ran out of guesses. The answer is " + answer);
        }
    }
}
