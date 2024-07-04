import java.util.Scanner;

public class Matrix3x3 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int[][] matrixA = new int[3][3];
        int[][] matrixB = new int[3][3];
        int[][] sumMatrix = new int[3][3];

        // Input for Matrix A
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print("Matrix A [" + (i+1) + "][" + (j+1) + "]: ");
                matrixA[i][j] = input.nextInt();
            }
        }
        System.out.println();

        // Input for Matrix B
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print("Matrix B [" + (i+1) + "][" + (j+1) + "]: ");
                matrixB[i][j] = input.nextInt();
            }
        }

        // Calculate sum of Matrix A and Matrix B
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                sumMatrix[i][j] = matrixA[i][j] + matrixB[i][j];
            }
        }

        // Print Matrix A
        System.out.println("\nMatrix A:");
        printMatrix(matrixA);

        // Print Matrix B
        System.out.println("\nMatrix B:");
        printMatrix(matrixB);

        // Print Sum of Matrix A and Matrix B
        System.out.println("\nMatrix A + Matrix B:");
        printMatrix(sumMatrix);
    }

    // Helper method to print a matrix
    private static void printMatrix(int[][] matrix) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}