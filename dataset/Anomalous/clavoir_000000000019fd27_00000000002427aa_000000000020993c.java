package qualification;

import java.util.*;

public class Vestigium {

    public static int[] computeTrace(int[][] matrix) {
        int[] result = new int[3];
        int n = matrix.length;

        int trace = 0, repeatedRows = 0, repeatedCols = 0;
        boolean[] colChecked = new boolean[n];

        for (int i = 0; i < n; i++) {
            Set<Integer> rowSet = new HashSet<>();
            boolean rowHasDuplicate = false;

            for (int j = 0; j < n; j++) {
                int value = matrix[i][j];
                
                if (i == j) {
                    trace += value;
                }
                
                if (!rowHasDuplicate && !rowSet.add(value)) {
                    repeatedRows++;
                    rowHasDuplicate = true;
                }

                if (!colChecked[j]) {
                    Set<Integer> colSet = new HashSet<>();
                    for (int k = 0; k < n; k++) {
                        if (!colSet.add(matrix[k][j])) {
                            repeatedCols++;
                            colChecked[j] = true;
                            break;
                        }
                    }
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

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }

            int[] result = computeTrace(matrix);
            System.out.printf("Case #%d: %d %d %d%n", testCase, result[0], result[1], result[2]);
        }

        scanner.close();
    }
}