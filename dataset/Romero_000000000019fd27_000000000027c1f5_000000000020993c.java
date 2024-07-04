import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int cases = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= cases; ++i) {
            int n = in.nextInt();
            int[][] matrix = new int[n][n];
            long trace = 0L;
            for (int r = 0; r < n; r++) {
                for (int c = 0; c < n; c++) {
                    matrix[r][c] = in.nextInt();
                    if (r == c) {
                        trace += matrix[r][c];
                    }
                }
            }
            int incorrectRows = 0;
            for (int x = 0; x < n; x++) {
                Set<Integer> values = new HashSet<>();
                for (int y = 0; y < n; y++) {
                    if (values.contains(matrix[x][y])) {
                        incorrectRows++;
                        break;
                    }
                    values.add(matrix[x][y]);
                }
            }

            int incorrectCols = 0;
            for (int x = 0; x < n; x++) {
                Set<Integer> values = new HashSet<>();
                for (int y = 0; y < n; y++) {
                    if (values.contains(matrix[y][x])) {
                        incorrectCols++;
                        break;
                    }
                    values.add(matrix[y][x]);
                }
            }

            System.out.println(String.format("Case #%d: %d %d %d", i, trace, incorrectRows, incorrectCols));
        }
    }
}
