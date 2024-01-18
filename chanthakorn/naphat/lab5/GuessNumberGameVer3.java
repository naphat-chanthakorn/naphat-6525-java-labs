package chanthakorn.naphat.lab5;

import java.util.Scanner;

public class GuessNumberGameVer3 extends GuessNumberGameVer2 {
    public GuessNumberGameVer3() {
        super();
    }

    public GuessNumberGameVer3(int minNum, int maxNum) {
        super(minNum, maxNum);
    }

    public GuessNumberGameVer3(int minNum, int maxNum, int maxTries) {
        super(minNum, maxNum, maxTries);
    }

    public double guessAverage() {
        int sum = 0;
        for (int index = 0; index < numGuesses; index++) {
            sum += guesses[index];
        }
        return (double) sum / numGuesses;
    }

    public int guessMin() {
        int min = guesses[0];
        for (int index = 1; index < numGuesses; index++) {
            if (guesses[index] < min) {
                min = guesses[index];
            }
        }
        return min;
    }

    public int guessMax() {
        int max = guesses[0];
        for (int index = 1; index < numGuesses; index++) {
            if (guesses[index] > max) {
                max = guesses[index];
            }
        }
        return max;
    }

    @Override
    public void playGames() {
        Scanner input = new Scanner(System.in);
        char choice;

        super.playGame();

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
                case 'v':
                case 'V':
                    System.out.println("Average = " + guessAverage());
                    break;
                case 'm':
                case 'M':
                    System.out.println("Min = " + guessMin());
                    break;
                case 'x':
                case 'X':
                    System.out.println("Max = " + guessMax());
                    break;
                default:
                    System.err.println("Invalid command");
            }

        } while (choice != 'q' && choice != 'Q');
    }
}