import java.util.HashSet;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int testCase = 1; testCase <= testCases; testCase++) {
            int n = scanner.nextInt();
            int[][] matrix = new int[n][n];
            int trace = 0;
            int duplicateRows = 0;
            int duplicateColumns = 0;

            // Read the matrix and calculate the trace
            for (int i = 0; i < n; i++) {
                HashSet<Integer> rowSet = new HashSet<>();
                boolean hasDuplicateInRow = false;

                for (int j = 0; j < n; j++) {
                    int value = scanner.nextInt();
                    matrix[i][j] = value;

                    if (i == j) {
                        trace += value;
                    }

                    if (!rowSet.add(value)) {
                        hasDuplicateInRow = true;
                    }
                }

                if (hasDuplicateInRow) {
                    duplicateRows++;
                }
            }

            // Check for duplicate values in columns
            for (int j = 0; j < n; j++) {
                HashSet<Integer> colSet = new HashSet<>();
                boolean hasDuplicateInCol = false;

                for (int i = 0; i < n; i++) {
                    if (!colSet.add(matrix[i][j])) {
                        hasDuplicateInCol = true;
                        break;
                    }
                }

                if (hasDuplicateInCol) {
                    duplicateColumns++;
                }
            }

            System.out.printf("Case #%d: %d %d %d%n", testCase, trace, duplicateRows, duplicateColumns);
        }

        scanner.close();
    }
}