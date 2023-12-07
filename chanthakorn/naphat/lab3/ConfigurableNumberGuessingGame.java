package chanthakorn.naphat.lab3;
import java.util.Scanner;

public class ConfigurableNumberGuessingGame {
    static int answer, max, min, tries, maxTries;
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        configure();
        genAnswer();
        playGame();
    }

    public static void configure() {
        System.out.print("Enter the min value:");
        min = scanner.nextInt();
        System.out.print("Enter the max value:");
        max = scanner.nextInt();
        System.out.print("Enter the maximum number of tries:");
        maxTries = scanner.nextInt();
    }

    public static void genAnswer() {
        answer = min + (int) (Math.random() * ((max - min) + 1));
    }

    public static void playGame() {
        System.out.println("Welcome to a number guessing game!");
        int tries = 0;

        while (tries < maxTries) {
            System.out.print("Enter an integer between " + min + " and " + max + ":");
            int guess = scanner.nextInt();
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
            System.out.println("You have tried 1 time");
        }

        if (tries == maxTries) {
            System.out.println("You ran out of guesses. The answer is " + answer);
        }
        scanner.close();
    }
}
