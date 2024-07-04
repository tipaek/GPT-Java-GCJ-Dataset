import java.util.*;

public class Solution {
    private static final Scanner scanner = new Scanner(System.in);

    public static int calculateTrace(int n, int[][] matrix) {
        int trace = 0;
        for (int i = 0; i < n; i++) {
            trace += matrix[i][i];
        }
        return trace;
    }

    public static int countDuplicateRows(int n, int[][] matrix) {
        int duplicateRows = 0;
        for (int i = 0; i < n; i++) {
            Set<Integer> uniqueElements = new HashSet<>();
            for (int j = 0; j < n; j++) {
                uniqueElements.add(matrix[i][j]);
            }
            if (uniqueElements.size() != n) {
                duplicateRows++;
            }
        }
        return duplicateRows;
    }

    public static int countDuplicateColumns(int n, int[][] matrix) {
        int duplicateColumns = 0;
        for (int i = 0; i < n; i++) {
            Set<Integer> uniqueElements = new HashSet<>();
            for (int j = 0; j < n; j++) {
                uniqueElements.add(matrix[j][i]);
            }
            if (uniqueElements.size() != n) {
                duplicateColumns++;
            }
        }
        return duplicateColumns;
    }

    public static void solveTestCase(int testCaseNumber, int n, int[][] matrix) {
        int trace = calculateTrace(n, matrix);
        int duplicateRows = countDuplicateRows(n, matrix);
        int duplicateColumns = countDuplicateColumns(n, matrix);
        System.out.println("Case #" + (testCaseNumber + 1) + ": " + trace + " " + duplicateRows + " " + duplicateColumns);
    }

    public static void main(String[] args) {
        int testCases = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        for (int t = 0; t < testCases; t++) {
            int n = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            int[][] matrix = new int[n][n];

            for (int i = 0; i < n; i++) {
                String[] rowItems = scanner.nextLine().split(" ");
                for (int j = 0; j < rowItems.length; j++) {
                    matrix[i][j] = Integer.parseInt(rowItems[j]);
                }
            }
            solveTestCase(t, n, matrix);
        }

        scanner.close();
    }
}