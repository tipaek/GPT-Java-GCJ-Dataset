import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = scanner.nextInt();
        int[][] results = new int[t][3];

        for (int caseIndex = 0; caseIndex < t; caseIndex++) {
            int n = scanner.nextInt();
            int[][] matrix = new int[n][n];

            // Read the matrix
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }

            // Calculate the sum of the diagonal
            int diagonalSum = 0;
            for (int i = 0; i < n; i++) {
                diagonalSum += matrix[i][i];
            }
            results[caseIndex][0] = diagonalSum;

            // Check for duplicate values in rows and columns
            int duplicateRows = 0;
            int duplicateCols = 0;

            for (int i = 0; i < n; i++) {
                Set<Integer> rowSet = new HashSet<>();
                Set<Integer> colSet = new HashSet<>();

                for (int j = 0; j < n; j++) {
                    // Check row for duplicates
                    if (!rowSet.add(matrix[i][j])) {
                        duplicateRows++;
                        break;
                    }

                    // Check column for duplicates
                    if (!colSet.add(matrix[j][i])) {
                        duplicateCols++;
                        break;
                    }
                }
            }

            results[caseIndex][1] = duplicateRows;
            results[caseIndex][2] = duplicateCols;
        }

        // Print the results
        for (int caseIndex = 0; caseIndex < t; caseIndex++) {
            System.out.println("Case #" + (caseIndex + 1) + ": " + results[caseIndex][0] + " " + results[caseIndex][1] + " " + results[caseIndex][2]);
        }
    }
}