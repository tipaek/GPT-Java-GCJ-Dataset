import java.util.Scanner;

public class Solution {

    static Scanner scanner = new Scanner(System.in);

    static int calculateSum(int[][] matrix, int rows, int cols) {
        int totalSum = 0;
        boolean elementsEliminated = true;
        int[][] tempSum = new int[rows][cols];
        int[][] tempCount = new int[rows][cols];

        while (elementsEliminated) {
            elementsEliminated = false;

            // Initialize arrays and compute the total sum
            for (int r = 0; r < rows; r++) {
                for (int c = 0; c < cols; c++) {
                    totalSum += matrix[r][c];
                    tempSum[r][c] = 0;
                    tempCount[r][c] = 0;
                }
            }

            // Process rows from left to right and right to left
            for (int r = 0; r < rows; r++) {
                int maxElement = 0;
                for (int c = 0; c < cols; c++) {
                    if (matrix[r][c] > 0) {
                        tempSum[r][c] += maxElement;
                        tempCount[r][c] += Math.min(maxElement, 1);
                        maxElement = matrix[r][c];
                    }
                }

                maxElement = 0;
                for (int c = cols - 1; c >= 0; c--) {
                    if (matrix[r][c] > 0) {
                        tempSum[r][c] += maxElement;
                        tempCount[r][c] += Math.min(maxElement, 1);
                        maxElement = matrix[r][c];
                    }
                }
            }

            // Process columns from top to bottom and bottom to top
            for (int c = 0; c < cols; c++) {
                int maxElement = 0;
                for (int r = 0; r < rows; r++) {
                    if (matrix[r][c] > 0) {
                        tempSum[r][c] += maxElement;
                        tempCount[r][c] += Math.min(maxElement, 1);
                        maxElement = matrix[r][c];
                    }
                }

                maxElement = 0;
                for (int r = rows - 1; r >= 0; r--) {
                    if (matrix[r][c] > 0) {
                        tempSum[r][c] += maxElement;
                        tempCount[r][c] += Math.min(maxElement, 1);
                        maxElement = matrix[r][c];
                    }
                }
            }

            // Eliminate elements based on the computed values
            for (int r = 0; r < rows; r++) {
                for (int c = 0; c < cols; c++) {
                    if (tempCount[r][c] > 0 && (double) tempSum[r][c] / tempCount[r][c] > matrix[r][c]) {
                        matrix[r][c] = 0;
                        elementsEliminated = true;
                    }
                }
            }
        }

        return totalSum;
    }

    public static void main(String[] args) {
        int testCases = scanner.nextInt();

        for (int t = 1; t <= testCases; t++) {
            int rows = scanner.nextInt();
            int cols = scanner.nextInt();
            int[][] matrix = new int[rows][cols];

            for (int r = 0; r < rows; r++) {
                for (int c = 0; c < cols; c++) {
                    matrix[r][c] = scanner.nextInt();
                }
            }

            int result = calculateSum(matrix, rows, cols);
            System.out.printf("Case #%d: %d\n", t, result);
        }

        scanner.close();
    }
}