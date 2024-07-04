import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfCases = scanner.nextInt();

        for (int caseNumber = 1; caseNumber <= numberOfCases; caseNumber++) {
            int n = scanner.nextInt();
            int trace = 0, rowRepeats = 0, columnRepeats = 0;
            int[][] matrix = new int[n][n];

            // Read the matrix and calculate trace and row repetitions
            for (int row = 0; row < n; row++) {
                Set<Integer> rowSet = new HashSet<>();
                boolean rowHasRepetition = false;
                for (int col = 0; col < n; col++) {
                    int value = scanner.nextInt();
                    matrix[row][col] = value;
                    if (row == col) {
                        trace += value;
                    }
                    if (!rowHasRepetition && !rowSet.add(value)) {
                        rowRepeats++;
                        rowHasRepetition = true;
                    }
                }
            }

            // Calculate column repetitions
            for (int col = 0; col < n; col++) {
                Set<Integer> colSet = new HashSet<>();
                for (int row = 0; row < n; row++) {
                    if (!colSet.add(matrix[row][col])) {
                        columnRepeats++;
                        break;
                    }
                }
            }

            System.out.format("Case #%d: %d %d %d\n", caseNumber, trace, rowRepeats, columnRepeats);
        }
    }
}