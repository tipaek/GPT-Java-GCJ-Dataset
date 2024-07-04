import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); 
        int testCases = scanner.nextInt();

        for (int k = 0; k < testCases; k++) {
            int matrixSize = scanner.nextInt();
            int[][] matrix = new int[matrixSize][matrixSize];

            for (int i = 0; i < matrixSize; i++) {
                for (int j = 0; j < matrixSize; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }

            System.out.println();
            System.out.print("case #" + (k + 1) + ": ");
            printTrace(matrix, matrixSize);
            countInvalidRows(matrix, matrixSize);
            countInvalidCols(matrix, matrixSize);
        }
    }

    static void printTrace(int[][] matrix, int size) {
        int traceSum = 0;
        for (int i = 0; i < size; i++) {
            traceSum += matrix[i][i];
        }
        System.out.print(traceSum + " ");
    }

    static void countInvalidRows(int[][] matrix, int size) {
        int invalidRowCount = 0;
        for (int i = 0; i < size; i++) {
            boolean[] seen = new boolean[size];
            for (int j = 0; j < size; j++) {
                if (seen[matrix[i][j] - 1]) {
                    invalidRowCount++;
                    break;
                } else {
                    seen[matrix[i][j] - 1] = true;
                }
            }
        }
        System.out.print(invalidRowCount + " ");
    }

    static void countInvalidCols(int[][] matrix, int size) {
        int invalidColCount = 0;
        for (int i = 0; i < size; i++) {
            boolean[] seen = new boolean[size];
            for (int j = 0; j < size; j++) {
                if (seen[matrix[j][i] - 1]) {
                    invalidColCount++;
                    break;
                } else {
                    seen[matrix[j][i] - 1] = true;
                }
            }
        }
        System.out.print(invalidColCount + " ");
    }
}