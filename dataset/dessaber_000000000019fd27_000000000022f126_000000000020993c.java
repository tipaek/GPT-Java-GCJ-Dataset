import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.io.*;
public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int k= 1; k <= t; ++k) {
            int n = in.nextInt();
            int[][] m = new int[n][n];
            int diag = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    m[i][j] = in.nextInt();
                    if (i == j) {
                        diag += m[i][j];
                    }
                }
            }

            int rows = 0;
            for (int i = 0; i < n; i++) {
                if (!checkRow(m, i)) {
                    rows++;
                }
            }

            int cols = 0;
            for (int i = 0; i < n; i++) {
                if (!checkCol(m, i)) {
                    cols++;
                }
            }

            //System.out.println(diag + " " + rows + " " + cols);
            System.out.println("Case #" + k + ": " + diag + " " + rows + " " + cols);
        }
    }

    private static boolean checkRow(int[][] a, int i) {
        Set<Integer> s = new HashSet<>();
        for (int j = 0; j < a.length; j++) {
            if (!s.contains(a[i][j])) {
                s.add(a[i][j]);
            } else {
                return false;
            }
        }

        return true;
    }

    private static boolean checkCol(int[][] a, int i) {
        Set<Integer> s = new HashSet<>();
        for (int j = 0; j < a.length; j++) {
            if (!s.contains(a[j][i])) {
                s.add(a[j][i]);
            } else {
                return false;
            }
        }

        return true;
    }
}