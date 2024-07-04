import java.util.*;

public class Vestigium {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int caseNum = 1; caseNum <= testCases; caseNum++) {
            int n = scanner.nextInt();
            int trace = 0, rowRepeats = 0, colRepeats = 0;

            int[][] matrix = new int[n][n];

            // Read matrix and calculate trace and row repeats
            for (int i = 0; i < n; i++) {
                Set<Integer> rowSet = new HashSet<>();
                boolean rowHasRepeat = false;

                for (int j = 0; j < n; j++) {
                    matrix[i][j] = scanner.nextInt();

                    if (i == j) {
                        trace += matrix[i][j];
                    }

                    if (!rowHasRepeat && !rowSet.add(matrix[i][j])) {
                        rowRepeats++;
                        rowHasRepeat = true;
                    }
                }
            }

            // Calculate column repeats
            for (int j = 0; j < n; j++) {
                Set<Integer> colSet = new HashSet<>();
                for (int i = 0; i < n; i++) {
                    if (!colSet.add(matrix[i][j])) {
                        colRepeats++;
                        break;
                    }
                }
            }

            System.out.printf("Case #%d: %d %d %d%n", caseNum, trace, rowRepeats, colRepeats);
        }
    }
}