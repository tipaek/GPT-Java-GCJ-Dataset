import java.util.*;
import java.io.*;

// 1
public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt();
            int[][] arr = new int[n][n];
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    int x = in.nextInt();
                    arr[j][j] = x;
                }
            }
            int res[] = solve(arr, n);
            System.out.println("Case #" + i + ": " + res[0] + " " + res[1] + " " + res[2]);
        }
    }

    private static int[] solve(int[][] mat, int n) {
        int[] res = new int[3];
        for (int i = 0; i < n; i++) {
            res[0] += mat[i][i];
        }

        for (int i = 0; i < n; i++) {
            Set<Integer> set = new HashSet<Integer>();
            for (int j = 0; j < n; j++) {
                set.add(mat[i][j]);
            }
            if (set.size() != n) {
                res[1]++;
            }
        }

        for (int i = 0; i < n; i++) {
            Set<Integer> set = new HashSet<Integer>();
            for (int j = 0; j < n; j++) {
                set.add(mat[j][i]);
            }
            if (set.size() != n) {
                res[2]++;
            }
        }
        return res;
    }
}