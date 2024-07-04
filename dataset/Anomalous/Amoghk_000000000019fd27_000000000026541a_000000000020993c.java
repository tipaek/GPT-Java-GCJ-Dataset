import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int t = 0; t < testCases; t++) {
            int n = scanner.nextInt();
            int[][] matrix = new int[n][n];

            // Reading the matrix
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }

            // Calculating the sum of the diagonal
            int sumDiagonal = 0;
            for (int i = 0; i < n; i++) {
                sumDiagonal += matrix[i][i];
            }

            int duplicateRows = 0;
            int duplicateCols = 0;

            // Checking for duplicate values in rows and columns
            for (int i = 0; i < n; i++) {
                Set<Integer> rowSet = new HashSet<>();
                Set<Integer> colSet = new HashSet<>();

                for (int j = 0; j < n; j++) {
                    // Check for duplicates in the row
                    if (!rowSet.add(matrix[i][j])) {
                        duplicateRows++;
                        break;
                    }

                    // Check for duplicates in the column
                    if (!colSet.add(matrix[j][i])) {
                        duplicateCols++;
                        break;
                    }
                }
            }

            // Printing the results
            System.out.println(sumDiagonal + " " + duplicateRows + " " + duplicateCols);
        }
    }
}