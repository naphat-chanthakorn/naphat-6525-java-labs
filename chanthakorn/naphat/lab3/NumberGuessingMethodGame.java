package chanthakorn.naphat.lab3;

import java.util.Scanner;

public class NumberGuessingMethodGame {
    static int answer;
    final static int max = 20;
    final static int min = 1;

    public static void main(String[] args) {
        genAnswer();
        playGame();
    }

    public static void genAnswer() {
        answer = min + (int) (Math.random() * ((max - min) + 1));
    }

    public static void playGame() {
        System.out.println("Welcome to a number guessing game!");
        int tries = 0;
        int maxTries = 5;

        Scanner scanner = new Scanner(System.in);

        while (tries < maxTries) {
            System.out.print("Enter an integer between 1 and 20:");
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
