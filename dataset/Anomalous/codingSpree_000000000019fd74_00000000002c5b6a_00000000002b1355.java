import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int testCase = 1; testCase <= testCases; ++testCase) {
            int rows = scanner.nextInt();
            int cols = scanner.nextInt();
            int[][] matrix = new int[rows][cols];

            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }

            int result = calculateInterest(matrix, rows, cols);
            System.out.println("Case #" + testCase + ": " + result);
        }
    }

    public static int calculateInterest(int[][] matrix, int rows, int cols) {
        int totalSum = 0;
        int[][] nextMatrix = new int[rows][cols];
        boolean hasChanges = false;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] != 0) {
                    totalSum += matrix[i][j];
                    int surroundingSum = 0;
                    int count = 0;

                    // Check above
                    for (int k = i - 1; k >= 0 && matrix[k][j] == 0; k--) {}
                    if (k >= 0) {
                        surroundingSum += matrix[k][j];
                        count++;
                    }

                    // Check below
                    for (int k = i + 1; k < rows && matrix[k][j] == 0; k++) {}
                    if (k < rows) {
                        surroundingSum += matrix[k][j];
                        count++;
                    }

                    // Check left
                    for (int k = j - 1; k >= 0 && matrix[i][k] == 0; k--) {}
                    if (k >= 0) {
                        surroundingSum += matrix[i][k];
                        count++;
                    }

                    // Check right
                    for (int k = j + 1; k < cols && matrix[i][k] == 0; k++) {}
                    if (k < cols) {
                        surroundingSum += matrix[i][k];
                        count++;
                    }

                    if (matrix[i][j] * count >= surroundingSum) {
                        nextMatrix[i][j] = matrix[i][j];
                    } else {
                        hasChanges = true;
                    }
                }
            }
        }

        if (!hasChanges) {
            return totalSum;
        }
        return totalSum + calculateInterest(nextMatrix, rows, cols);
    }
}