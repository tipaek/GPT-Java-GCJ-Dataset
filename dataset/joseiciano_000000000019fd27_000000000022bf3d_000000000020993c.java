import java.util.*;
import java.io.*;

public class Solution{
    static Scanner in;
    static int t, n, diag, cols, rows;
    static int[][] m;
    static HashSet<Integer> seenrow;
    static HashSet<Integer> seencol;

    public static void main(String[] args) throws Exception {
        in = new Scanner(System.in);
        // in = new Scanner(new File("vestigium.txt"));

        t = in.nextInt();
        for (int tt = 1; tt <= t; tt++) {
            n = in.nextInt();
            m = new int[n][n];

            diag = rows = cols = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    m[i][j] = in.nextInt();

                    if (i == j)
                        diag += m[i][j];
                }
            }

            for (int i = 0; i < n; i++) {
                seenrow = new HashSet<>();
                seencol = new HashSet<>();
                boolean rowf = false, colf = false;
                for (int j = 0; j < n; j++) {
                    if (!rowf && seenrow.contains(m[i][j])) {
                        rowf = true;
                        rows++;
                    }
                    if (!colf && seencol.contains(m[j][i])) {
                        colf = true;
                        cols++;
                    }
                    seenrow.add(m[i][j]);
                    seencol.add(m[j][i]);
                }
            }
            System.out.printf("Case #%d: %d %d %d\n", tt, diag, rows, cols);
        }
    }
}