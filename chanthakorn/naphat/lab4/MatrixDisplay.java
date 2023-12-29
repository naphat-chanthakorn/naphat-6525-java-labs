package chanthakorn.naphat.lab4;

import java.util.Scanner;

public class MatrixDisplay {
    static int[][] matrix; // Array to store the matrix elements
    static int rowDimension, columnDimension; // Variable to store the number of rows and columns in the matrix

    public static void main(String[] args) {
        inputMatrix(); // Call the method to input matrix elements
        displayMatrix(); // Call the method to display the matrix
    }

    // Method to input matrix values
    public static void inputMatrix() {
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.print("Enter the number of rows: ");
            rowDimension = scanner.nextInt();
            System.out.print("Enter the number of columns: ");
            columnDimension = scanner.nextInt();

            // Check if both rows and columns are greater than 0
            if (rowDimension <= 0 || columnDimension <= 0) {
                System.err.println("Both rows and columns must be greater than 0. Please try again.");
            }
        } while (rowDimension <= 0 || columnDimension <= 0);

        // Initialize the matrix with the specified dimensions
        matrix = new int[rowDimension][columnDimension];

        // Loop to input values into the matrix
        for (int i = 0; i < rowDimension; i++) {
            for (int j = 0; j < columnDimension; j++) {
                System.out.print("Enter element [" + (i + 1) + "][" + (j + 1) + "]: ");
                matrix[i][j] = scanner.nextInt();
            }
        }
        scanner.close(); // Close the scanner
    }

    // Method to display the matrix
    public static void displayMatrix() {
        System.out.println("Displaying Matrix:");

        // Loop to iterate through each value of the matrix and print it
        for (int i = 0; i < rowDimension; i++) {
            for (int j = 0; j < columnDimension; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println(); // Move to the next line after printing each row
        }
    }
}