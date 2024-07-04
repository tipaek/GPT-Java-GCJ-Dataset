import java.util.HashSet;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int testCase = 1; testCase <= testCases; testCase++) {
            int size = scanner.nextInt();
            int[][] matrix = new int[size][size];

            // Input matrix
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }

            // Calculate trace
            int trace = 0;
            for (int i = 0; i < size; i++) {
                trace += matrix[i][i];
            }

            // Calculate duplicate rows
            int duplicateRows = 0;
            for (int i = 0; i < size; i++) {
                HashSet<Integer> rowSet = new HashSet<>();
                for (int j = 0; j < size; j++) {
                    rowSet.add(matrix[i][j]);
                }
                if (rowSet.size() != size) {
                    duplicateRows++;
                }
            }

            // Calculate duplicate columns
            int duplicateCols = 0;
            for (int j = 0; j < size; j++) {
                HashSet<Integer> colSet = new HashSet<>();
                for (int i = 0; i < size; i++) {
                    colSet.add(matrix[i][j]);
                }
                if (colSet.size() != size) {
                    duplicateCols++;
                }
            }

            // Output result for the current test case
            System.out.printf("Case #%d: %d %d %d%n", testCase, trace, duplicateRows, duplicateCols);
        }

        scanner.close();
    }
}