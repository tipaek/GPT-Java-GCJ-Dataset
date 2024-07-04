

import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            int N = in.nextInt();

            int K = 0, R = 0, C = 0;
            boolean[][] br = new boolean[N][N];
            boolean[][] bc = new boolean[N][N];

            int[][] m = new int[N][N];
            for (int j = 0; j < N; j++) {
                boolean rowSeen = false;
                for (int k = 0; k < N; k++) {
                    m[j][k] = in.nextInt();

                    if (j == k) {
                        K += m[j][k];
                    }

                    if (!rowSeen) {
                        if (br[j][m[j][k] - 1]) {
                            rowSeen = true;
                            R++;
                        } else {
                            br[j][m[j][k] - 1] = true;
                        }
                    }
                }
            }

            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    if (bc[m[k][j] - 1][j]) {
                        C++;
                        break;
                    } else {
                        bc[m[k][j] - 1][j] = true;
                    }
                }
            }

            System.out.println("Case #" + i + ": " + K + " " + R + " " + C);
        }
    }
}