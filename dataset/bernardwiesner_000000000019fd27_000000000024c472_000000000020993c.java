import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt(); //size of square
            int sum = 0;
            for (int j = 0; j < n; j++) {
                sum += j+1;
            }
            int[][] m = new int[n][n];
            int calcSum = 0;
            int r = 0;
            int c = 0;
            int p = -1;
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) { //column
                    m[j][k] = in.nextInt();
                }
            }
            int cur = -1;
            boolean skip = false;
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    int prev = m[j][k];
                    for (int v = k+1; v < n; v++) {
                        cur = m[j][v];
                        if (cur == prev) {
                            r++;
                            skip = true;
                            break;
                        }
                    }
                    if (skip) {
                        skip = false;
                        break;
                    }
                }
            }

            cur = -1;
            skip = false;
            for (int k = 0; k < n; k++) {
                for (int j = 0; j < n; j++) {
                    int prev = m[j][k];
                    for (int v = j+1; v < n; v++) {
                        cur = m[v][k];
                        if (cur == prev) {
                            c++;
                            skip = true;
                            break;
                        }
                    }
                    if (skip) {
                        skip = false;
                        break;
                    }
                }
            }
            int trace = 0;
            for (int j = 0; j < n; j++) {
                trace += m[j][n - (n-j)];

            }
            System.out.println("Case #" + i + ": " + trace + " " + r + " " + c);
            r = 0;
            c = 0;
        }
    }
}

