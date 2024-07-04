import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt();
            int[][] a = new int[n][n];
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    a[j][k] = in.nextInt();
                }
            }

            System.out.println("Case #" + i + ": " + getTrace(a) + " " + getDuplicateRows(a) + " " + getDuplicateColumns(a));
        }
    }

    private static int getTrace(int[][] a) {
        int k = 0;
        for (int i = 0; i < a.length; i++) {
            k += a[i][i];
        }

        return k;
    }

    private static int getDuplicateRows(int[][] a){
        int r = 0;
        for (int i = 0; i < a.length; i++) {
            HashSet<Integer> set = new HashSet<>();
            for (int j = 0; j < a.length; j++) {
                if (!set.add(a[i][j])) {
                    ++r;
                    break;
                }
            }
        }

        return r;
    }

    private static int getDuplicateColumns(int[][] a){
        int c = 0;
        for (int i = 0; i < a.length; i++) {
            HashSet<Integer> set = new HashSet<>();
            for (int j = 0; j < a.length; j++) {
                if (!set.add(a[j][i])) {
                    ++c;
                    break;
                }
            }
        }

        return c;
    }
}