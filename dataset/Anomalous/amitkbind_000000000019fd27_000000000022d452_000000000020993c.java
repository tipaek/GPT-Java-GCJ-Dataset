import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        int testCaseNumber = 1;

        while (testCases > 0) {
            testCases--;
            int n = scanner.nextInt();
            int[][] matrix = new int[n][n];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }

            int trace = 0, rowCount = 0, colCount = 0;
            boolean[] rowFlags = new boolean[n];
            boolean[] colFlags = new boolean[n];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    int number = Math.abs(matrix[i][j]);
                    if (i == j) {
                        trace += number;
                    }
                    int index = number - 1;
                    if (!rowFlags[i]) {
                        if (matrix[i][index] < 0) {
                            rowFlags[i] = true;
                            rowCount++;
                        } else {
                            matrix[i][index] = -matrix[i][index];
                        }
                    }
                }
            }

            resetMatrix(matrix, n);

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    int number = Math.abs(matrix[i][j]);
                    int index = number - 1;
                    if (!colFlags[j]) {
                        if (matrix[index][j] < 0) {
                            colFlags[j] = true;
                            colCount++;
                        } else {
                            matrix[index][j] = -matrix[index][j];
                        }
                    }
                }
            }

            System.out.println("#" + testCaseNumber + " " + trace + " " + rowCount + " " + colCount);
            testCaseNumber++;
        }
    }

    private static void resetMatrix(int[][] matrix, int size) {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (matrix[i][j] < 0) {
                    matrix[i][j] = -matrix[i][j];
                }
            }
        }
    }

    private static void printMatrix(int[][] matrix, int size) {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}