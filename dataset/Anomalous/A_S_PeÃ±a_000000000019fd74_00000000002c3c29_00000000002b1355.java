import java.util.Scanner;

public class Solution {

    static Scanner scanner = new Scanner(System.in);

    static int calculateSumAndEliminate(int[][] arr, int rows, int cols) {
        int totalSum = 0;
        boolean eliminationOccurred = true;
        int[][] tempSum = new int[rows][cols];
        int[][] tempCount = new int[rows][cols];

        while (eliminationOccurred) {
            eliminationOccurred = false;

            // Reset temporary arrays and calculate initial sum
            for (int r = 0; r < rows; r++) {
                for (int c = 0; c < cols; c++) {
                    totalSum += arr[r][c];
                    tempSum[r][c] = tempCount[r][c] = 0;
                }
            }

            // Compute sums and counts for rows
            for (int r = 0; r < rows; r++) {
                int comp = 0;
                for (int c = 0; c < cols; c++) {
                    if (arr[r][c] > 0) {
                        tempSum[r][c] += comp;
                        tempCount[r][c] += Math.min(comp, 1);
                        comp = arr[r][c];
                    }
                }
                comp = 0;
                for (int c = cols - 1; c >= 0; c--) {
                    if (arr[r][c] > 0) {
                        tempSum[r][c] += comp;
                        tempCount[r][c] += Math.min(comp, 1);
                        comp = arr[r][c];
                    }
                }
            }

            // Compute sums and counts for columns
            for (int c = 0; c < cols; c++) {
                int comp = 0;
                for (int r = 0; r < rows; r++) {
                    if (arr[r][c] > 0) {
                        tempSum[r][c] += comp;
                        tempCount[r][c] += Math.min(comp, 1);
                        comp = arr[r][c];
                    }
                }
                comp = 0;
                for (int r = rows - 1; r >= 0; r--) {
                    if (arr[r][c] > 0) {
                        tempSum[r][c] += comp;
                        tempCount[r][c] += Math.min(comp, 1);
                        comp = arr[r][c];
                    }
                }
            }

            // Eliminate elements based on the computed sums and counts
            for (int r = 0; r < rows; r++) {
                for (int c = 0; c < cols; c++) {
                    if (tempCount[r][c] > 0 && (double) tempSum[r][c] / tempCount[r][c] > arr[r][c]) {
                        arr[r][c] = 0;
                        eliminationOccurred = true;
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
            int[][] arr = new int[rows][cols];

            // Read input array
            for (int r = 0; r < rows; r++) {
                for (int c = 0; c < cols; c++) {
                    arr[r][c] = scanner.nextInt();
                }
            }

            // Calculate result for the current test case
            int result = calculateSumAndEliminate(arr, rows, cols);
            System.out.printf("Case #%d: %d\n", t, result);
        }

        scanner.close();
    }
}