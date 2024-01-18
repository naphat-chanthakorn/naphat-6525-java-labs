package chanthakorn.naphat.lab5;

import java.util.Scanner;

public class GuessNumberGameVer2 extends GuessNumberGameVer1 {
    protected static final int MAX_GUESSES = 20;
    protected int[] guesses;
    protected int numGuesses;

    public GuessNumberGameVer2() {
        super();
        guesses = new int[MAX_GUESSES];
        numGuesses = 0;
    }

    public GuessNumberGameVer2(int minNum, int maxNum) {
        super(minNum, maxNum);
        guesses = new int[MAX_GUESSES];
        numGuesses = 0;
    }

    public GuessNumberGameVer2(int minNum, int maxNum, int maxTries) {
        super(minNum, maxNum, maxTries);
        guesses = new int[MAX_GUESSES];
        numGuesses = 0;
    }

    @Override
    public void playGame() {
        System.out.println("Welcome to a number guessing game!");
        this.correctNum = minNum + (int) (Math.random() * ((maxNum - minNum) + 1));
        Scanner input = new Scanner(System.in);
        int guess;
        numGuesses = 0;

        do {
            System.out.print("Enter an integer between " + minNum + " and " + maxNum + ":");
            guess = input.nextInt();

            if (guess >= minNum && guess <= maxNum) {
                numGuesses++;
                guesses[numGuesses - 1] = guess;

                if (guess == correctNum) {
                    System.out.println("Congratulations!");
                    System.out.println("You have tried " + numGuesses + " times.");
                    break;
                } else if (guess > correctNum) {
                    System.out.println("Try a lower number!");
                } else {
                    System.out.println("Try a higher number!");
                }

                if (numGuesses == maxTries) {
                    System.out.println("You have tried " + numGuesses + " times. You ran out of guesses.");
                    System.out.println("The answer is " + correctNum);
                    break;
                }
            }
        } while (guess != correctNum && numGuesses < maxTries);
    }

    public void showSpecific() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter which guess in range (1-" + numGuesses + ")");
        int position = input.nextInt();

        if (position >= 1 && position <= numGuesses) {
            System.out.println("Guess number " + position + " is " + guesses[position - 1]);
        }
    }

    public void showGuesses() {
        for (int index = 0; index < numGuesses; index++) {
            System.out.print(guesses[index] + " ");
        }
        System.out.println("");
    }

    public void playGames() {
        Scanner input = new Scanner(System.in);
        char choice;

        playGame();

        do {
            System.out.println("If want to play again? type 'y' to continue or 'q' to quit:");
            System.out.println("Type 'a' to see all your guesses or 'g' to see a guess on specific play.");
            choice = input.next().charAt(0);

            switch (choice) {
                case 'y':
                case 'Y':
                    playGame();
                    break;
                case 'g':
                case 'G':
                    showSpecific();
                    break;
                case 'a':
                case 'A':
                    showGuesses();
                    break;
                case 'q':
                case 'Q':
                    break;
            }

        } while (choice != 'q' && choice != 'Q');
    }
}