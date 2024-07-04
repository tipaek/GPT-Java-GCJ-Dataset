import java.util.*;

public class Solution {

    public static int[] computeTrace(int[][] matrix) {
        int[] result = new int[3];
        int n = matrix.length;

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
                if (!isRepeatedRow && !rowRecords.add(currentValue)) {
                    repeatedRows++;
                    isRepeatedRow = true;
                }
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

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for (int testCase = 0; testCase < t; testCase++) {
            int n = scanner.nextInt();
            int[][] matrix = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }
            int[] result = computeTrace(matrix);
            System.out.printf("#%d: %d %d %d%n", testCase + 1, result[0], result[1], result[2]);
        }
        scanner.close();
    }
}