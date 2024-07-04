import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt();

            int[][] matrix = new int[n][n];
            for (int r = 0; r < n; r++) {
                for (int c = 0; c < n; c++) {
                    matrix[r][c] = in.nextInt();
                }
            }

            int[] result = trace(matrix, n);

            System.out.println("Case #" + i + ": " + result[0] + " " + result[1] + " " + result[2]);
        }
    }

    private static int[] trace(int[][] matrix, int length) {
        int trace = 0;

        List<Set<Integer>> rows = new ArrayList<>();
        List<Set<Integer>> columns = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            Set<Integer> rS = new HashSet<>();
            rows.add(rS);

            Set<Integer> cS = new HashSet<>();
            columns.add(cS);
        }

        for (int r = 0; r < length; r++) {
            for (int c = 0; c < length; c++) {
                if (r == c) {
                    trace += matrix[r][c];
                }

                rows.get(r).add(matrix[r][c]);
                columns.get(c).add((matrix[r][c]));
            }
        }

        int rR = 0;
        for (int idx = 0; idx < length; idx++) {
            if (rows.get(idx).size() < length) {
                rR++;
            }
        }

        int rC = 0;
        for (int idx = 0; idx < length; idx++) {
            if (columns.get(idx).size() < length) {
                rC++;
            }
        }

        int[] result = {trace, rR, rC};

        return result;
    }
}