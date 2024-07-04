import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt();
            int[][] matrix = new int[n][n];
            for (int row = 0; row < n; row++) {
                for (int col = 0; col < n; col++) {
                    matrix[row][col] = in.nextInt();
                }
            }

            int[] result = computeVestigium(matrix);

            System.out.printf("Case #%d: %d %d %d%n", i, result[0], result[1], result[2]);
        }
    }

    // output [trace, repeatRows, repeatCols]
    private static int[] computeVestigium(int[][] matrix) {
        int trace = 0, repeatRows = 0, repeatCols = 0;
        Map<Integer, Set<Integer>> colMap = new HashMap<>();
        boolean[] foundRepeatCols = new boolean[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            Set<Integer> rowSet = new HashSet<>();
            boolean foundRepeatRow = false;
            for (int j = 0; j < matrix[0].length; j++) {
                if (i == j) {
                    trace += matrix[i][j];
                }
                if (!foundRepeatRow) {
                    if (!rowSet.add(matrix[i][j])) {
                        repeatRows++;
                        foundRepeatRow = true;
                    }
                }
                if (!foundRepeatCols[j]) {
                    if (!colMap.computeIfAbsent(j, k -> new HashSet<>()).add(matrix[i][j])) {
                        repeatCols++;
                        foundRepeatCols[j] = true;
                    }
                }
            }
        }

        return new int[] {trace, repeatRows, repeatCols};
    }


}
