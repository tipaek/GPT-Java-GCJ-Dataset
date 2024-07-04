import java.util.Scanner;

public class Matrix3x3 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int[][] matrixA = new int[3][3];
        int[][] matrixB = new int[3][3];
        int[][] sum = new int[3][3];

        // Input for matrix A
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print("Matrix A [" + (i+1) + "][" + (j+1) + "]= ");
                matrixA[i][j] = input.nextInt();
            }
        }
        System.out.println();

        // Input for matrix B
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print("Matrix B [" + (i+1) + "][" + (j+1) + "]= ");
                matrixB[i][j] = input.nextInt();
            }
        }

        // Sum of matrix A and matrix B
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                sum[i][j] = matrixA[i][j] + matrixB[i][j];
            }
        }

        // Print matrix A
        System.out.println("\nMatrix A:");
        printMatrix(matrixA);

        // Print matrix B
        System.out.println("\nMatrix B:");
        printMatrix(matrixB);

        // Print sum of matrix A and matrix B
        System.out.println("\nMatrix A + Matrix B:");
        printMatrix(sum);
    }

    private static void printMatrix(int[][] matrix) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print("  " + matrix[i][j]);
            }
            System.out.println();
        }
    }
}