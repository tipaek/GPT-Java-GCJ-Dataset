import java.util.Scanner;

public class Solution {
    
    static Scanner scanner = new Scanner(System.in);

    static int processArray(int[][] arr, int rows, int cols) {
        int totalSum = 0;
        boolean elementsEliminated;

        int[][] tempSum = new int[rows][cols];
        int[][] tempCount = new int[rows][cols];

        do {
            elementsEliminated = false;

            // Reset temp arrays and calculate total sum
            for (int r = 0; r < rows; ++r) {
                for (int c = 0; c < cols; ++c) {
                    totalSum += arr[r][c];
                    tempSum[r][c] = 0;
                    tempCount[r][c] = 0;
                }
            }

            // Calculate sums and counts for rows
            for (int r = 0; r < rows; ++r) {
                int runningSum = 0;

                for (int c = 0; c < cols; ++c) {
                    if (arr[r][c] > 0) {
                        tempSum[r][c] += runningSum;
                        tempCount[r][c] += Math.min(runningSum, 1);
                        runningSum = arr[r][c];
                    }
                }

                runningSum = 0;
                for (int c = cols - 1; c >= 0; --c) {
                    if (arr[r][c] > 0) {
                        tempSum[r][c] += runningSum;
                        tempCount[r][c] += Math.min(runningSum, 1);
                        runningSum = arr[r][c];
                    }
                }
            }

            // Calculate sums and counts for columns
            for (int c = 0; c < cols; ++c) {
                int runningSum = 0;

                for (int r = 0; r < rows; ++r) {
                    if (arr[r][c] > 0) {
                        tempSum[r][c] += runningSum;
                        tempCount[r][c] += Math.min(runningSum, 1);
                        runningSum = arr[r][c];
                    }
                }

                runningSum = 0;
                for (int r = rows - 1; r >= 0; --r) {
                    if (arr[r][c] > 0) {
                        tempSum[r][c] += runningSum;
                        tempCount[r][c] += Math.min(runningSum, 1);
                        runningSum = arr[r][c];
                    }
                }
            }

            // Eliminate elements based on the average comparison
            for (int r = 0; r < rows; ++r) {
                for (int c = 0; c < cols; ++c) {
                    if (tempCount[r][c] > 0 && ((double) tempSum[r][c] / tempCount[r][c]) > arr[r][c]) {
                        arr[r][c] = 0;
                        elementsEliminated = true;
                    }
                }
            }

        } while (elementsEliminated);

        return totalSum;
    }

    public static void main(String[] args) {
        int testCases = scanner.nextInt();

        for (int t = 1; t <= testCases; ++t) {
            int rows = scanner.nextInt();
            int cols = scanner.nextInt();

            int[][] arr = new int[rows][cols];
            for (int r = 0; r < rows; ++r) {
                for (int c = 0; c < cols; ++c) {
                    arr[r][c] = scanner.nextInt();
                }
            }

            int result = processArray(arr, rows, cols);
            System.out.printf("Case #%d: %d\n", t, result);
        }

        scanner.close();
    }
}