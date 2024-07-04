import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int n = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 0; i < n; i++) {
            solveIt(in, i);
        }
    }

    private static void solveIt(Scanner in, int caseIndex) {
        int m = in.nextInt();
        final int[][] matrix = new int[m][m];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                matrix[i][j] = in.nextInt();
            }
        }
        int trace = 0;
        for (int i = 0; i < m; i++) {
            trace += matrix[i][i];
        }
        int rows = 0;
        for (int i = 0; i < m; i++) {
            final Set<Integer> row_nos = new HashSet<>();
            for (int j = 0; j < m; j++) {
                row_nos.add(matrix[i][j]);
            }
            if (row_nos.size() != m) rows++;
        }
        int cols = 0;
        for (int i = 0; i < m; i++) {
            final Set<Integer> col_nos = new HashSet<>();
            for (int j = 0; j < m; j++) {
                col_nos.add(matrix[j][i]);
            }
            if (col_nos.size() != m) cols++;
        }
        output(caseIndex, trace, rows, cols);
    }

    private static void output(int caseIdx, int trace, int rows, int columns) {
        System.out.println(String.format("Case #%d: %d %d %d", caseIdx, trace, rows, columns));
    }
}
