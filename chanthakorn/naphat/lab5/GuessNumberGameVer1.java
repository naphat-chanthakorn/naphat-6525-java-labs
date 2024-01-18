package chanthakorn.naphat.lab5;

import java.util.Scanner;

public class GuessNumberGameVer1 {
    protected int minNum, maxNum, correctNum, maxTries;
    protected static int numOfGames = 0;
    Scanner input;

    public GuessNumberGameVer1() {
        this.minNum = 1;
        this.maxNum = 10;
        this.correctNum = minNum + (int) (Math.random() * ((maxNum - minNum) + 1));
        this.maxTries = 3;
        numOfGames++;
    }

    public GuessNumberGameVer1(int minNum, int maxNum) {
        this.minNum = minNum;
        this.maxNum = maxNum;
        this.correctNum = minNum + (int) (Math.random() * ((maxNum - minNum) + 1));
        this.maxTries = 3;
        numOfGames++;
    }

    public GuessNumberGameVer1(int minNum, int maxNum, int maxTries) {
        this.minNum = minNum;
        this.maxNum = maxNum;
        this.correctNum = minNum + (int) (Math.random() * ((maxNum - minNum) + 1));
        this.maxTries = maxTries;
        numOfGames++;
    }

    @Override
    public String toString() {
        return "GuessNumberGame with min number as " + minNum + " max number as " + maxNum + " max number of tries as "
                + maxTries;
    }

    public void playGame() {
        System.out.println("Welcome to a number guessing game!");
        this.correctNum = minNum + (int) (Math.random() * ((maxNum - minNum) + 1));
        Scanner input = new Scanner(System.in);
        int guess;
        int tries = 0;

        do {
            System.out.print("Enter an integer between " + minNum + " and " + maxNum + ":");
            guess = input.nextInt();
            tries++;

            if (guess == correctNum) {
                System.out.println("Congratulations!");
                System.out.println("You have tried " + tries + " times.");
                break;
            } else if (guess > correctNum) {
                System.out.println("Try a lower number!");
            } else {
                System.out.println("Try a higher number!");
            }
            if (tries == maxTries) {
                System.out.println("You have tried " + tries + " times. You ran out of guesses.");
                System.out.println("The answer is " + correctNum);
            }
        } while (guess != correctNum && tries < maxTries);
    }

    public int getMinNum() {
        return minNum;
    }

    public void setMinNum(int minNum) {
        this.minNum = minNum;
    }

    public int getMaxNum() {
        return maxNum;
    }

    public void setMaxNum(int maxNum) {
        this.maxNum = maxNum;
    }

    public int getMaxTries() {
        return maxTries;
    }

    public void setMaxTries(int maxTries) {
        this.maxTries = maxTries;
    }

    public static int getNumOfGames() {
        return numOfGames;
    }
}