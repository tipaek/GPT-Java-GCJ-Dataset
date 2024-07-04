import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int caseCount = scanner.nextInt();

        for (int caseIndex = 1; caseIndex <= caseCount; caseIndex++) {
            int n = scanner.nextInt();
            int[][] matrix = new int[n][n];

            int trace = 0;
            int rowDuplicateCount = 0;
            int colDuplicateCount = 0;

            // Read matrix and calculate trace
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = scanner.nextInt();
                    if (i == j) {
                        trace += matrix[i][j];
                    }
                }
            }

            // Check for duplicate values in rows
            for (int i = 0; i < n; i++) {
                Set<Integer> rowSet = new HashSet<>();
                boolean rowHasDuplicates = false;
                for (int j = 0; j < n; j++) {
                    if (!rowSet.add(matrix[i][j])) {
                        rowHasDuplicates = true;
                    }
                }
                if (rowHasDuplicates) {
                    rowDuplicateCount++;
                }
            }

            // Check for duplicate values in columns
            for (int j = 0; j < n; j++) {
                Set<Integer> colSet = new HashSet<>();
                boolean colHasDuplicates = false;
                for (int i = 0; i < n; i++) {
                    if (!colSet.add(matrix[i][j])) {
                        colHasDuplicates = true;
                    }
                }
                if (colHasDuplicates) {
                    colDuplicateCount++;
                }
            }

            System.out.printf("Case #%d: %d %d %d\n", caseIndex, trace, rowDuplicateCount, colDuplicateCount);
        }
    }
}