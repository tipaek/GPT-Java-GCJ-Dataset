import java.util.Scanner;

public class MatrixAddition {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[][] matrixA = new int[2][2];
        int[][] matrixB = new int[2][2];
        int[][] resultMatrix = new int[2][2];

        System.out.println("Enter elements for matrix A:");
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                System.out.print("(" + (i + 1) + ", " + (j + 1) + "): ");
                matrixA[i][j] = scanner.nextInt();
            }
        }

        System.out.println("Enter elements for matrix B:");
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                System.out.print("(" + (i + 1) + ", " + (j + 1) + "): ");
                matrixB[i][j] = scanner.nextInt();
            }
        }

        System.out.println("Matrix A:");
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                System.out.print(matrixA[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println("Matrix B:");
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                System.out.print(matrixB[i][j] + " ");
            }
            System.out.println();
        }

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                resultMatrix[i][j] = matrixA[i][j] + matrixB[i][j];
            }
        }

        System.out.println("Matrix Addition Process:");
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                System.out.print(matrixA[i][j] + " + " + matrixB[i][j] + " = " + resultMatrix[i][j] + "   ");
            }
            System.out.println();
        }

        System.out.println("Resulting Matrix:");
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                System.out.print(resultMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}