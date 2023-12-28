package chanthakorn.naphat.lab4;

import java.util.Scanner;
import java.util.Random;

public class test {

    private static int[][] matrix;
    private static int rowDimension, columnDimension;
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;

        displayMenu();
        System.out.print("Enter choice (1-5): ");
        choice = scanner.nextInt();

        switch (choice) {
            case 1:
                userInputMatrix();
                break;
            case 2:
                randomMatrix();
                break;
            case 3:
                allZerosMatrix();
                break;
            case 4:
                allOnesMatrix();
                break;
            case 5:
                diagonalMatrix();
                break;
            default:
                break;
        }

        displayMatrix();

        scanner.close();
    }

    public static void displayMenu() {
        System.out.println("Select matrix initialization method:");
        System.out.println("1. User Input");
        System.out.println("2. Random Numbers");
        System.out.println("3. All Zeros");
        System.out.println("4. All Ones");
        System.out.println("5. Diagonal");
    }

    public static void userInputMatrix() {
        System.out.print("Enter the number of rows: ");
        rowDimension = scanner.nextInt();
        System.out.print("Enter the number of columns: ");
        columnDimension = scanner.nextInt();

        if (rowDimension <= 0 || columnDimension <= 0) {
            System.out.println("Both rows and columns must be greater than 0. Please try again.");
            return;
        }

        matrix = new int[rowDimension][columnDimension];

        for (int i = 0; i < rowDimension; i++) {
            for (int j = 0; j < columnDimension; j++) {
                System.err.print("Enter element [" + (i + 1) + "][" + (j + 1) + "]: ");
                matrix[i][j] = scanner.nextInt();
            }
        }
    }

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

        for (int i = 0; i < rowDimension; i++) {
            for (int j = 0; j < columnDimension; j++) {
                matrix[i][j] = random.nextInt(10); 
            }
        }
    }

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

        for (int i = 0; i < rowDimension; i++) {
            for (int j = 0; j < columnDimension; j++) {
                matrix[i][j] = 1;
            }
        }
    }

    public static void diagonalMatrix() {
        System.out.print("Enter the number of rows and columns for diagonal matrix: ");
        int size = scanner.nextInt();

        if (size <= 0) {
            System.err.println("Both rows and columns must be greater than 0. Please try again.");
            return;
        }

        matrix = new int[size][size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                matrix[i][j] = (i == j) ? 1 : 0;
                System.out.println(matrix[i][j] + " ");
            }
            System.out.println();
        }
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
