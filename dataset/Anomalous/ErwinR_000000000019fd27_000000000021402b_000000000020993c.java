import java.util.HashSet;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int t = 1; t <= testCases; t++) {
            int n = scanner.nextInt();
            int[][] matrix = new int[n][n];
            int trace = 0, repRow = 0, repCol = 0;

            // Read matrix and calculate trace and row repetitions
            for (int i = 0; i < n; i++) {
                HashSet<Integer> rowSet = new HashSet<>();
                boolean rowHasDuplicates = false;

                for (int j = 0; j < n; j++) {
                    int value = scanner.nextInt();
                    matrix[i][j] = value;

                    if (!rowSet.add(value)) {
                        rowHasDuplicates = true;
                    }

                    if (i == j) {
                        trace += value;
                    }
                }

                if (rowHasDuplicates) {
                    repRow++;
                }
            }

            // Calculate column repetitions
            for (int j = 0; j < n; j++) {
                HashSet<Integer> colSet = new HashSet<>();
                boolean colHasDuplicates = false;

                for (int i = 0; i < n; i++) {
                    int value = matrix[i][j];

                    if (!colSet.add(value)) {
                        colHasDuplicates = true;
                    }
                }

                if (colHasDuplicates) {
                    repCol++;
                }
            }

            // Output the result for the current test case
            System.out.println("Case #" + t + ": " + trace + " " + repRow + " " + repCol);
        }

        scanner.close();
    }
}