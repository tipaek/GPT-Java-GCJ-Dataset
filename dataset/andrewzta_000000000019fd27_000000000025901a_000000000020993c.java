import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 */
public class Solution {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        Scanner in = new Scanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        Vestigium solver = new Vestigium();
        int testCount = Integer.parseInt(in.next());
        for (int i = 1; i <= testCount; i++)
            solver.solve(i, in, out);
        out.close();
    }

    static class Vestigium {
        public void solve(int testNumber, Scanner in, PrintWriter out) {
            int n = in.nextInt();
            int[][] a = new int[n][n];
            int s = 0;
            Set<Integer>[] r = new HashSet[n];
            Set<Integer>[] c = new HashSet[n];
            for (int i = 0; i < n; i++) {
                r[i] = new HashSet<>();
                c[i] = new HashSet<>();
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    a[i][j] = in.nextInt();
                    if (i == j) {
                        s += a[i][j];
                    }
                    r[i].add(a[i][j]);
                    c[j].add(a[i][j]);
                }
            }

            int br = 0, bc = 0;
            for (int i = 0; i < n; i++) {
                if (r[i].size() != n) {
                    br++;
                }
                if (c[i].size() != n) {
                    bc++;
                }
            }
            out.println("Case #" + testNumber + ": " + s + " " + br + " " + bc);
        }

    }
}

