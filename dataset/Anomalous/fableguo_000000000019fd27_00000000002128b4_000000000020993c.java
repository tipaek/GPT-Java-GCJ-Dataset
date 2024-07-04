import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int testCase = 1; testCase <= testCases; testCase++) {
            int n = scanner.nextInt();
            int[][] matrix = new int[n][n];

            // Reading the matrix
            for (int row = 0; row < n; row++) {
                for (int col = 0; col < n; col++) {
                    matrix[row][col] = scanner.nextInt();
                }
            }

            int diagonalSum = 0;
            int duplicateRows = 0;
            int duplicateCols = 0;

            // Calculating the sum of the main diagonal
            for (int i = 0; i < n; i++) {
                diagonalSum += matrix[i][i];
            }

            // Checking for duplicate elements in rows
            for (int row = 0; row < n; row++) {
                Set<Integer> uniqueElements = new HashSet<>();
                for (int col = 0; col < n; col++) {
                    if (!uniqueElements.add(matrix[row][col])) {
                        duplicateRows++;
                        break;
                    }
                }
            }

            // Checking for duplicate elements in columns
            for (int col = 0; col < n; col++) {
                Set<Integer> uniqueElements = new HashSet<>();
                for (int row = 0; row < n; row++) {
                    if (!uniqueElements.add(matrix[row][col])) {
                        duplicateCols++;
                        break;
                    }
                }
            }

            System.out.println("Case #" + testCase + ": " + diagonalSum + " " + duplicateRows + " " + duplicateCols);
        }
    }
}