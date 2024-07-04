import java.util.*;
import java.io.*;
public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.

        for (int tt = 1; tt <= t; ++tt) {
            int n = in.nextInt();

            int[][] a = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    a[i][j] = in.nextInt();
                }
            }
            
            int rows = 0;
            for (int i = 0; i < n; i++) {
                HashSet<Integer> set = new HashSet<>();
                for (int j = 0; j < n; j++) {
                    if (set.contains(a[i][j])) {
                        rows++;
                        break;
                    }
                    set.add(a[i][j]);
                }
            }

            int cols = 0;
            for (int j = 0; j < n; j++) {
                HashSet<Integer> set = new HashSet<>();
                for (int i = 0; i < n; i++) {
                    if (set.contains(a[i][j])) {
                        cols++;
                        break;
                    }
                    set.add(a[i][j]);
                }
            }

            int trace = 0;
            for (int i = 0; i < n; i++) {
                trace += a[i][i];
            }

            System.out.println("Case #" + tt + ": " + trace + " " + rows + " " + cols);
        }

        in.close();
    }
}