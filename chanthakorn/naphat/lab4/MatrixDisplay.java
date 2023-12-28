package chanthakorn.naphat.lab4;

import java.util.Scanner;

public class MatrixDisplay {

    private static int[][] matrix;
    private static int rowDimension;
    private static int columnDimension;

    public static void main(String[] args) {
        inputMatrix();
        displayMatrix();
    }

    public static void inputMatrix() {
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.print("Enter the number of rows: ");
            rowDimension = scanner.nextInt();
            System.out.print("Enter the number of columns: ");
            columnDimension = scanner.nextInt();

            if (rowDimension <= 0 || columnDimension <= 0) {
                System.err.println("Both rows and columns must be greater than 0. Please try again.");
            }
        } while (rowDimension <= 0 || columnDimension <= 0);

        matrix = new int[rowDimension][columnDimension];

        for (int i = 0; i < rowDimension; i++) {
            for (int j = 0; j < columnDimension; j++) {
                System.out.print("Enter element [" + (i + 1) + "][" + (j + 1) + "]: ");
                matrix[i][j] = scanner.nextInt();
            }
        }
        scanner.close();
    }

    public static void displayMatrix() {
        System.out.println("Displaying Matrix:");

        for (int i = 0; i < rowDimension; i++) {
            for (int j = 0; j < columnDimension; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}