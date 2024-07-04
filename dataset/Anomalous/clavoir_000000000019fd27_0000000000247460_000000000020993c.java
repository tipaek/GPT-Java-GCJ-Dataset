import java.util.*;

public class Solution {

    public static int[] computeTrace(int[][] matrix) {
        int[] result = new int[3];
        int n = matrix.length;

        // Initialize repeated column checker
        Map<Integer, Set<Integer>> colChecker = new HashMap<>();
        boolean[] isRepeatedCols = new boolean[n];
        for (int i = 0; i < n; i++) {
            colChecker.put(i, new HashSet<>());
        }

        int trace = 0, repeatedRows = 0, repeatedCols = 0;

        for (int i = 0; i < n; i++) {
            Set<Integer> rowRecords = new HashSet<>();
            boolean isRepeatedRow = false;

            for (int j = 0; j < n; j++) {
                int currentValue = matrix[i][j];

                if (i == j) {
                    trace += currentValue;
                }

                // Check row
                if (!isRepeatedRow && !rowRecords.add(currentValue)) {
                    repeatedRows++;
                    isRepeatedRow = true;
                }

                // Check column
                if (!isRepeatedCols[j] && !colChecker.get(j).add(currentValue)) {
                    repeatedCols++;
                    isRepeatedCols[j] = true;
                }
            }
        }

        result[0] = trace;
        result[1] = repeatedRows;
        result[2] = repeatedCols;
        return result;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int t = scanner.nextInt();
        for (int testCase = 1; testCase <= t; testCase++) {
            int n = scanner.nextInt();
            int[][] matrix = new int[n][n];
            scanner.nextLine(); // Consume the newline

            for (int i = 0; i < n; i++) {
                String[] arrRowItems = scanner.nextLine().split(" ");
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = Integer.parseInt(arrRowItems[j]);
                }
            }

            int[] result = computeTrace(matrix);
            System.out.printf("Case #%d: %d %d %d%n", testCase, result[0], result[1], result[2]);
        }

        scanner.close();
    }
}