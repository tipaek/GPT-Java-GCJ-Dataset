import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Vestigium {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfCases = scanner.nextInt();

        for (int caseIndex = 1; caseIndex <= numberOfCases; caseIndex++) {
            int n = scanner.nextInt();
            int[][] matrix = new int[n][n];
            int trace = 0, rowRepeats = 0, columnRepeats = 0;

            // Read matrix and compute trace
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = scanner.nextInt();
                    if (i == j) {
                        trace += matrix[i][j];
                    }
                }
            }

            // Check for repeated values in rows
            for (int i = 0; i < n; i++) {
                Set<Integer> rowSet = new HashSet<>();
                for (int j = 0; j < n; j++) {
                    if (!rowSet.add(matrix[i][j])) {
                        rowRepeats++;
                        break;
                    }
                }
            }

            // Check for repeated values in columns
            for (int j = 0; j < n; j++) {
                Set<Integer> columnSet = new HashSet<>();
                for (int i = 0; i < n; i++) {
                    if (!columnSet.add(matrix[i][j])) {
                        columnRepeats++;
                        break;
                    }
                }
            }

            System.out.printf("Case #%d: %d %d %d\n", caseIndex, trace, rowRepeats, columnRepeats);
        }

        scanner.close();
    }
}