import java.util.*;
import java.io.*;
public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int t = 1; t <= T; ++t) {
            int n = in.nextInt();
            int[][] matrix = new int[n][n];
            int sum = 0, rr = 0, cc = 0;
            for (int r = 0; r < n; r++) {
                for (int c = 0; c < n; c++) {
                    matrix[r][c] = in.nextInt();
                }
            }
            for (int i = 0; i < n; i++) {
                sum += matrix[i][i];
            }
            for (int r = 0; r < n; r++) {
                Set<Integer> s = new HashSet<>();
                for (int c = 0; c < n; c++) {
                    s.add(matrix[r][c]);
                }
                if (s.size() != n) rr++;
            }
            for (int c = 0; c < n; c++) {
                Set<Integer> s = new HashSet<>();
                for (int r = 0; r < n; r++) {
                    s.add(matrix[r][c]);
                }
                if (s.size() != n) cc++;
            }

            System.out.println("Case #" + t + ": " + sum + " " + rr + " " + cc);
        }
    }
}