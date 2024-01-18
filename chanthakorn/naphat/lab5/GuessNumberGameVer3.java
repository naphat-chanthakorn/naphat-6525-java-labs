package chanthakorn.naphat.lab5;

import java.util.Scanner;

public class GuessNumberGameVer3 extends GuessNumberGameVer2 {
    // Default constructor
    public GuessNumberGameVer3() {
        super();
    }

    // Constructor with minimum and maximum number parameters
    public GuessNumberGameVer3(int minNum, int maxNum) {
        super(minNum, maxNum);
    }

    // Constructor with minimum, maximum number and maximum tries parameters
    public GuessNumberGameVer3(int minNum, int maxNum, int maxTries) {
        super(minNum, maxNum, maxTries);
    }

    // Method to calculate the average of guesses
    public double guessAverage() {
        int sum = 0;
        for (int index = 0; index < numGuesses; index++) {
            sum += guesses[index];
        }
        return (double) sum / numGuesses;
    }

    // Method to find the minimum of guesses
    public int guessMin() {
        int min = guesses[0];
        for (int index = 1; index < numGuesses; index++) {
            if (guesses[index] < min) {
                min = guesses[index];
            }
        }
        return min;
    }

    // Method to find the maximum of guesses
    public int guessMax() {
        int max = guesses[0];
        for (int index = 1; index < numGuesses; index++) {
            if (guesses[index] > max) {
                max = guesses[index];
            }
        }
        return max;
    }

    // Override the playGames method from the superclass
    @Override
    public void playGames() {
        Scanner input = new Scanner(System.in);
        char choice;

        super.playGame(); // Initial game play

        do {
            System.out.println("If want to play again? type 'y' to continue or 'q' to quit:");
            System.out.println("Type 'a' to see all your guesses or 'g' to see a guess on specific play.");
            System.out.print(
                    "Type 'v' to show the average of the guesses, 'm' to show the minimum of the guesses, ");
            System.out.println("or 'x' to show the maximum of the guesses");
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
                case 'v':
                case 'V':
                    System.out.println("Average = " + guessAverage()); // Display average
                    break;
                case 'm':
                case 'M':
                    System.out.println("Min = " + guessMin()); // Display minimum
                    break;
                case 'x':
                case 'X':
                    System.out.println("Max = " + guessMax()); // Display maximum
                    break;
                default:
                    System.err.println("Invalid command");
            }

        } while (choice != 'q' && choice != 'Q');
    }
}