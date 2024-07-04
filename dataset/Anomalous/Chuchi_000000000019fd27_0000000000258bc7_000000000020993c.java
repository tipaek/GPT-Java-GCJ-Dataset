import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();  // Number of test cases

        for (int l = 1; l <= t; l++) {
            int n = in.nextInt();
            int[][] matrix = new int[n][n];
            int diagonalSum = 0;
            int rowDuplicates = 0;
            int columnDuplicates = 0;

            // Read the matrix
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = in.nextInt();
                }
            }

            // Calculate the sum of the diagonal
            for (int i = 0; i < n; i++) {
                diagonalSum += matrix[i][i];
            }

            // Check for duplicate values in each row
            for (int i = 0; i < n; i++) {
                Set<Integer> uniqueValues = new HashSet<>();
                for (int j = 0; j < n; j++) {
                    uniqueValues.add(matrix[i][j]);
                }
                if (uniqueValues.size() != n) {
                    rowDuplicates++;
                }
            }

            // Check for duplicate values in each column
            for (int j = 0; j < n; j++) {
                Set<Integer> uniqueValues = new HashSet<>();
                for (int i = 0; i < n; i++) {
                    uniqueValues.add(matrix[i][j]);
                }
                if (uniqueValues.size() != n) {
                    columnDuplicates++;
                }
            }

            // Print the result for the current test case
            System.out.println("Case #" + l + ": " + diagonalSum + " " + rowDuplicates + " " + columnDuplicates);
        }

        in.close();
    }
}