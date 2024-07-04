import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();  // Number of test cases
        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt();
            int[][] myArray = new int[n][n];

            // Read the matrix
            for (int row = 0; row < n; row++) {
                for (int col = 0; col < n; col++) {
                    myArray[row][col] = in.nextInt();
                }
            }

            int[][] rowCounts = new int[n][n];
            int[][] colCounts = new int[n][n];

            // Count occurrences in rows
            for (int row = 0; row < n; row++) {
                for (int col = 0; col < n; col++) {
                    int value = myArray[row][col];
                    rowCounts[row][value - 1]++;
                }
            }

            // Count occurrences in columns
            for (int col = 0; col < n; col++) {
                for (int row = 0; row < n; row++) {
                    int value = myArray[row][col];
                    colCounts[value - 1][col]++;
                }
            }

            // Calculate number of rows with duplicates
            int duplicateRows = 0;
            for (int row = 0; row < n; row++) {
                boolean hasDuplicate = false;
                for (int col = 0; col < n; col++) {
                    if (rowCounts[row][col] > 1) {
                        hasDuplicate = true;
                        break;
                    }
                }
                if (hasDuplicate) {
                    duplicateRows++;
                }
            }

            // Calculate number of columns with duplicates
            int duplicateCols = 0;
            for (int col = 0; col < n; col++) {
                boolean hasDuplicate = false;
                for (int row = 0; row < n; row++) {
                    if (colCounts[row][col] > 1) {
                        hasDuplicate = true;
                        break;
                    }
                }
                if (hasDuplicate) {
                    duplicateCols++;
                }
            }

            // Calculate the sum of the main diagonal
            int diagonalSum = 0;
            for (int idx = 0; idx < n; idx++) {
                diagonalSum += myArray[idx][idx];
            }

            // Print the result for the current test case
            System.out.println("Case #" + i + ": " + diagonalSum + " " + duplicateRows + " " + duplicateCols);
        }
    }
}