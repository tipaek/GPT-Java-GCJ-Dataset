import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

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
        SecurityUpdate solver = new SecurityUpdate();
        int testCount = Integer.parseInt(in.next());
        for (int i = 1; i <= testCount; i++)
            solver.solve(i, in, out);
        out.close();
    }

    static class SecurityUpdate {
        public void solve(int testNumber, Scanner in, PrintWriter out) {
            int c = in.nextInt();
            int d = in.nextInt();
            int[] x = new int[c];
            for (int i = 1; i < c; i++) {
                x[i] = in.nextInt();
            }
            int[][] a = new int[c][c];
            int[] u = new int[d];
            int[] v = new int[d];
            for (int i = 0; i < d; i++) {
                u[i] = in.nextInt() - 1;
                v[i] = in.nextInt() - 1;
                a[u[i]][v[i]] = a[v[i]][u[i]] = -1;
            }

            int[] dist = new int[c];
            Arrays.fill(dist, -1);
            dist[0] = 0;
            int done = 1;
            int last = 0;
            while (done < c) {
                int thisstep = 0;
                for (int i = 0; i < c; i++) {
                    if (dist[i] == -1 && (-x[i] == done || x[i] == last + 1)) {
                        for (int j = 0; j < c; j++) {
                            if (dist[j] != -1 && dist[j] <= last && a[i][j] == -1) {
                                a[i][j] = a[j][i] = last + 1 - dist[j];
                            }
                        }
                        dist[i] = last + 1;
                        thisstep++;
                    }
                }
                done += thisstep;
                last++;
            }
            for (int i = 0; i < d; i++) {
                if (a[u[i]][v[i]] == -1) {
                    a[u[i]][v[i]] = a[v[i]][u[i]] = 1000000;
                }
            }

            out.print("Case #" + testNumber + ":");
            for (int i = 0; i < d; i++) {
                out.print(" " + a[u[i]][v[i]]);
            }
            out.println();
        }

    }
}

