package chanthakorn.naphat.lab5;

import java.util.Scanner;

public class GuessNumberGameVer2 extends GuessNumberGameVer1 {
    protected static final int MAX_GUESSES = 20;
    // Array to store the guesses made by the player
    protected int[] guesses;
    // Variable to keep track of the number of guesses made
    protected int numGuesses;

    // Default constructor
    public GuessNumberGameVer2() {
        super(); // Call the constructor of the superclass
        guesses = new int[MAX_GUESSES];
        numGuesses = 0;
    }

    // Constructor with minimum and maximum number parameters
    public GuessNumberGameVer2(int minNum, int maxNum) {
        super(minNum, maxNum); // Call the constructor of the superclass with parameters
        guesses = new int[MAX_GUESSES];
        numGuesses = 0;
    }

    // Constructor with minimum, maximum number, and maximum tries parameters
    public GuessNumberGameVer2(int minNum, int maxNum, int maxTries) {
        super(minNum, maxNum, maxTries);
        guesses = new int[MAX_GUESSES];
        numGuesses = 0;
    }

    // Override the playGame method from the superclass
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

    // Method to show a specific guess made by the player
    public void showSpecific() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter which guess in range (1-" + numGuesses + ")");
        int position = input.nextInt();

        if (position >= 1 && position <= numGuesses) {
            System.out.println("Guess number " + position + " is " + guesses[position - 1]);
        }
    }

    // Method to show all guesses made by the player
    public void showGuesses() {
        for (int index = 0; index < numGuesses; index++) {
            System.out.print(guesses[index] + " ");
        }
        System.out.println("");
    }

    // Method to play the game multiple times based on user choice
    public void playGames() {
        Scanner input = new Scanner(System.in);
        char choice;

        playGame(); // Initial game play

        do {
            System.out.println("If want to play again? type 'y' to continue or 'q' to quit:");
            System.out.println("Type 'a' to see all your guesses or 'g' to see a guess on specific play.");
            choice = input.next().charAt(0);

            switch (choice) {
                case 'y':
                case 'Y':
                    playGame(); // Play the game again
                    break;
                case 'g':
                case 'G':
                    showSpecific(); // Show a specific guess
                    break;
                case 'a':
                case 'A':
                    showGuesses(); // Show all guesses
                    break;
                case 'q':
                case 'Q':
                    break;
            }

        } while (choice != 'q' && choice != 'Q');
    }
}