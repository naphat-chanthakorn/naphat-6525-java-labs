package chanthakorn.naphat.lab4;

import java.util.Scanner;

public class DisplayMartixOptions {

    private static int[][] matrix;
    private static int row;
    private static int col;

    public static void main(String[] args) {
        inputMatrix();
        displayMatrix();
    }

    public static void inputMatrix() {
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.print("Enter the number of rows: ");
            row = scanner.nextInt();
            System.out.print("Enter the number of columns: ");
            col = scanner.nextInt();

            if (row <= 0 || col <= 0) {
                System.out.println("Both rows and columns must be greater than 0. Please try again.");
            }
        } while (row <= 0 || col <= 0);

        matrix = new int[row][col];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print("Enter element [" + (i + 1) + "][" + (j + 1) + "]: ");
                matrix[i][j] = scanner.nextInt();
            }
        }
        scanner.close();
    }

    public static void displayMatrix() {
        System.out.println("Displaying Matrix:");

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}