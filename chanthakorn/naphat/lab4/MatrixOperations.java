package chanthakorn.naphat.lab4;

import java.util.Scanner;
import java.util.Random;

public class MatrixOperations {
    static int[][] matrix; // Array to store the matrix elements
    static int rowDimension, columnDimension; // Variable to store the number of rows and columns in the matrix
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choiceOperation;

        creationMenu(); // Display the matrix creation menu

        do {
            operationsMenu(); // Display the matrix operations menu
            System.out.print("Enter choice: ");
            choiceOperation = scanner.nextInt();

            switch (choiceOperation) {
                case 1:
                    transposeMatrix(); // Call the method to transpose the matrix
                    break;
                case 2:
                    rowColumnSum(); // Call the method to calculate row and column sums
                    break;
                case 3:
                    findMaxMin(); // Call the method to find the maximum and minimum values in the matrix
                    break;
                case 4:
                    displayDiagonal(); // Call the method to display the main diagonal of the matrix
                    break;
                case 5:
                    break;
            }

        } while (choiceOperation != 5);

        scanner.close(); // close the scanner
    }

    // Method to display the matrix creation menu
    public static void creationMenu() {
        System.out.println("Select matrix initialization method:");
        System.out.println("1. User Input");
        System.out.println("2. Random Numbers");
        System.out.println("3. All Zeros");
        System.out.println("4. All Ones");
        System.out.println("5. Diagonal");

        int choiceCreation;

        System.out.print("Enter choice (1-5): ");
        choiceCreation = scanner.nextInt();

        // Switch statement to handle different matrix creation options
        switch (choiceCreation) {
            case 1:
                userInputMatrix(); // Call the method to input matrix elements from the user
                displayMatrix(); // Call the method to display the matrix
                break;
            case 2:
                randomMatrix(); // Call the method to generate a matrix with random values
                displayMatrix();
                break;
            case 3:
                allZerosMatrix(); // Call the method to create a matrix with all zeros
                displayMatrix();
                break;
            case 4:
                allOnesMatrix(); // Call the method to create a matrix with all ones
                displayMatrix();
                break;
            case 5:
                diagonalMatrix(); // Call method to create a diagonal matrix
                break;
            default:
                break;
        }
    }

    // Method to display the matrix operations menu
    public static void operationsMenu() {
        System.out.println("Choose an operation:");
        System.out.println("1. Transpose Matrix");
        System.out.println("2. Row and Column Sum");
        System.out.println("3. Find Max/Min Value");
        System.out.println("4. Diagonal Display");
        System.out.println("5. Exit");
    }

    // Method to input matrix elements from the user
    public static void userInputMatrix() {
        System.out.print("Enter the number of rows: ");
        rowDimension = scanner.nextInt();
        System.out.print("Enter the number of columns: ");
        columnDimension = scanner.nextInt();

        // Check if both rows and columns are greater than 0
        if (rowDimension <= 0 || columnDimension <= 0) {
            System.out.println("Both rows and columns must be greater than 0. Please try again.");
            return;
        }

        matrix = new int[rowDimension][columnDimension];

        // Loop to input values into the matrix
        for (int i = 0; i < rowDimension; i++) {
            for (int j = 0; j < columnDimension; j++) {
                System.err.print("Enter element [" + (i + 1) + "][" + (j + 1) + "]: ");
                matrix[i][j] = scanner.nextInt();
            }
        }
    }

    // Method to generate a matrix with random values
    public static void randomMatrix() {
        System.out.print("Enter the number of rows: ");
        rowDimension = scanner.nextInt();
        System.out.print("Enter the number of columns: ");
        columnDimension = scanner.nextInt();

        if (rowDimension <= 0 || columnDimension <= 0) {
            System.err.println("Both rows and columns must be greater than 0. Please try again.");
            return;
        }

        matrix = new int[rowDimension][columnDimension];
        Random random = new Random();

        // Loop to generate random values for the matrix
        for (int i = 0; i < rowDimension; i++) {
            for (int j = 0; j < columnDimension; j++) {
                matrix[i][j] = random.nextInt(10);
            }
        }
    }

    // Method to create a matrix with all zeros
    public static void allZerosMatrix() {
        System.out.print("Enter the number of rows: ");
        rowDimension = scanner.nextInt();
        System.out.print("Enter the number of columns: ");
        columnDimension = scanner.nextInt();

        if (rowDimension <= 0 || columnDimension <= 0) {
            System.err.println("Both rows and columns must be greater than 0. Please try again.");
            return;
        }

        matrix = new int[rowDimension][columnDimension];
    }

    // Method to create a matrix with all ones
    public static void allOnesMatrix() {
        System.out.print("Enter the number of rows: ");
        rowDimension = scanner.nextInt();
        System.out.print("Enter the number of columns: ");
        columnDimension = scanner.nextInt();

        if (rowDimension <= 0 || columnDimension <= 0) {
            System.err.println("Both rows and columns must be greater than 0. Please try again.");
            return;
        }

        matrix = new int[rowDimension][columnDimension];

        // Loop to set all values of the matrix to 1
        for (int i = 0; i < rowDimension; i++) {
            for (int j = 0; j < columnDimension; j++) {
                matrix[i][j] = 1;
            }
        }
    }

    // Method to create a diagonal matrix
    public static void diagonalMatrix() {
        System.out.print("Enter the number of rows and columns for diagona matrix: ");
        int size = scanner.nextInt();

        if (size <= 0) {
            System.err.println("Both rows and columns must be greater than 0. Please try again.");
            return;
        }

        matrix = new int[size][size];

        System.out.println("Displaying Matrix:");

        // Loop to set diagonal values to 1 and others to 0
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                matrix[i][j] = (i == j) ? 1 : 0;
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    // Method to display the matrix
    public static void displayMatrix() {
        System.out.println("Displaying Matrix:");

        // Loop to iterate through each element of the matrix and print it
        for (int i = 0; i < rowDimension; i++) {
            for (int j = 0; j < columnDimension; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println(); // Move to the next line after printing each row
        }
    }

    // Method to transpose the matrix
    public static void transposeMatrix() {
        System.out.println("Displaying Matrix:");
        for (int i = 0; i < columnDimension; i++) {
            for (int j = 0; j < rowDimension; j++) {
                System.out.print(matrix[j][i] + " ");
            }
            System.out.println();
        }
    }

    // Method to calculate row and column sums
    public static void rowColumnSum() {
        System.out.println("Row Sums:");
        // Calculate and display row sums
        for (int i = 0; i < columnDimension; i++) {
            int rowSum = 0;
            // Iterate through the values of the current column to calculate the row sum
            for (int j = 0; j < rowDimension; j++) {
                rowSum += matrix[j][i];
            }
            System.out.println("Row " + (i + 1) + ": " + rowSum);
        }

        System.out.println("Column Sums:");
        // Calculate and display column sums
        for (int j = 0; j < rowDimension; j++) {
            int columnSum = 0;
            // Iterate through the values of the current row to calculate the column sum
            for (int i = 0; i < columnDimension; i++) {
                columnSum += matrix[j][i];
            }
            System.out.println("Column " + (j + 1) + ": " + columnSum);
        }
    }

    // Method to find the maximum and minimum values in the matrix
    public static void findMaxMin() {
        // Initialize variables to store the maximum and minimum values
        int maxElement = matrix[0][0];
        int minElement = matrix[0][0];

        // Iterate through each row of the matrix
        for (int i = 0; i < rowDimension; i++) {
            // Iterate through each column of the matrix
            for (int j = 0; j < columnDimension; j++) {
                // Check if the current value is less than the current minimum value
                if (matrix[i][j] < minElement) {
                    minElement = matrix[i][j];
                }
                // Check if the current value is greater than the current maximum value
                if (matrix[i][j] > maxElement) {
                    maxElement = matrix[i][j];
                }
            }
        }

        System.out.println("Maximum Value: " + maxElement);
        System.out.println("Minimum Value: " + minElement);
    }

    // Method to display the main diagonal elements
    public static void displayDiagonal() {
        System.out.println("Main Diagonal:");
        // Iterate through the values of the main diagonal
        for (int i = 0; i < Math.min(rowDimension, columnDimension); i++) {
            System.out.print(matrix[i][i] + " ");
        }
        System.out.println();
    }
}