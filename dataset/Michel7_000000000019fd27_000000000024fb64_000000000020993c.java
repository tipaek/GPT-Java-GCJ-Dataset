import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int k = 1; k <= t; k++) {
            int n = in.nextInt();
            int[][] matrix = new int[n][n];

            int invalidRows = 0;
            for (int i = 0; i < n; i++) {
                Set<Integer> rows = new HashSet<>();
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = in.nextInt();
                    rows.add(matrix[i][j]);
                }
                if (rows.size() != n) {
                    invalidRows++;
                }
            }

            int invalidColumns = 0;
            for (int j = 0; j < n; j++) {
                Set<Integer> columns = new HashSet<>();
                for (int i = 0; i < n; i++) {
                    columns.add(matrix[i][j]);
                }
                if (columns.size() != n) {
                    invalidColumns++;
                }
            }

            int trace = 0;
            for (int i = 0; i < n; i++) {
                trace += matrix[i][i];
            }
            System.out.println("Case #" + k + ": " + trace + " " + invalidRows + " " + invalidColumns);
        }
    }
}