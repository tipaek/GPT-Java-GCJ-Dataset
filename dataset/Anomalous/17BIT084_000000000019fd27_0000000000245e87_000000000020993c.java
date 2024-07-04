import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int n = scanner.nextInt();
            int[][] matrix = new int[n][n];
            int trace = 0, rowDuplicates = 0, colDuplicates = 0;

            // Read the matrix and calculate the trace
            for (int i = 0; i < n; i++) {
                Set<Integer> rowSet = new HashSet<>();
                boolean rowHasDuplicate = false;

                for (int j = 0; j < n; j++) {
                    int value = scanner.nextInt();
                    matrix[i][j] = value;

                    if (rowSet.contains(value)) {
                        rowHasDuplicate = true;
                    } else {
                        rowSet.add(value);
                    }

                    if (i == j) {
                        trace += value;
                    }
                }

                if (rowHasDuplicate) {
                    rowDuplicates++;
                }
            }

            // Check for column duplicates
            for (int j = 0; j < n; j++) {
                Set<Integer> colSet = new HashSet<>();
                boolean colHasDuplicate = false;

                for (int i = 0; i < n; i++) {
                    if (colSet.contains(matrix[i][j])) {
                        colHasDuplicate = true;
                    } else {
                        colSet.add(matrix[i][j]);
                    }
                }

                if (colHasDuplicate) {
                    colDuplicates++;
                }
            }

            System.out.println("Case #" + caseNumber + ": " + trace + " " + rowDuplicates + " " + colDuplicates);
        }

        scanner.close();
    }
}