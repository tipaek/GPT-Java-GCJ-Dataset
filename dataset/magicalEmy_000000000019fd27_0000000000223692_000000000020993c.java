import java.util.*;
import java.io.*;
public class Solution {
    static int[] vestiguim(int[][] matrix) {
        int n = matrix.length;
        int trace = 0;
        int row = 0, col = 0;


        int val;
        Set<Integer> existed = new HashSet<>();
        for (int i = 0; i < n; i ++) {
            for (int j = 0; j < n; j ++) {
                val = matrix[i][j];
                if (i == j) trace += val;
                existed.add(val);
            }
            if (existed.size() != n) row ++;
            existed.clear();
        }

        for (int j = 0; j < n; j ++) {
            for (int i = 0; i < n; i ++) {
                val = matrix[i][j];
                existed.add(val);
            }
            if (existed.size() != n) col ++;
            existed.clear();
        }

        int[] ans = new int[3];
        ans[0] = trace;
        ans[1] = row;
        ans[2] = col;

        return ans;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int test_case = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int t = 0; t < test_case; t ++) {
            int n = in.nextInt();
            int[][] matrix = new int[n][n];
            for (int i = 0; i < n; i ++) {
                for (int j = 0; j < n; j ++) {
                    matrix[i][j] = in.nextInt();
                }
            }
            int[] ans = vestiguim(matrix);
            System.out.println("Case #" + t + ": " + ans[0] + " " + ans[1] + " " + ans[2]);
        }
    }
}
