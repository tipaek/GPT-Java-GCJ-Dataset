import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt();
            int[][] m = new int[n][n];
            for (int j = 0; j < n; ++j) {
                for (int k = 0; k < n; ++k) {
                    m[j][k] = in.nextInt();
                }
            }
            String result = solve(m);
            System.out.println(result);
        }
    }

    private static String solve(int[][] m) {
        Set<Integer> set = new HashSet<>();
        int sum = 0;
        int dr = 0;
        int dc = 0;
        for (int i = 0; i < m.length; ++i) {
            for (int j = 0; j < m.length; ++j) {
                if (i == j) {
                    sum += m[i][j];
                }
                set.add(m[i][j]);
            }
            if (set.size() < m.length)
                ++dr;
            set.clear();
        }
        for (int i = 0; i < m.length; ++i) {
            for (int j = 0; j < m.length; ++j) {
                set.add(m[j][i]);
            }
            if (set.size() < m.length)
                ++dc;
            set.clear();
        }
        return sum + " " + dr + " " + dc;
    }
}
