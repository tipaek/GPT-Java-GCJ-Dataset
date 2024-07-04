import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author silviase
 */
public class Solution {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        Scanner in = new Scanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        Vestigium solver = new Vestigium();
        solver.solve(1, in, out);
        out.close();
    }

    static class Vestigium {
        public void solve(int testNumber, Scanner in, PrintWriter out) {

            int numOfTestCase = in.nextInt();
            for (int i = 1; i <= numOfTestCase; i++) {
                ;
                int n = in.nextInt();
                int[][] matrix = new int[n][n];
                int t, r, c;

                for (int j = 0; j < n; j++) {
                    for (int k = 0; k < n; k++) {
                        matrix[j][k] = in.nextInt();
                    }
                }

                // trace
                t = 0;
                for (int j = 0; j < n; j++) {
                    t += matrix[j][j];
                }

                // row
                r = 0;
                for (int j = 0; j < n; j++) {
                    boolean f = false;
                    for (int k = 0; k < n; k++) {
                        if (j > 0) {
                            f = f || matrix[k][j] == matrix[k][j - 1];
                        }
                        if (j < n - 1) {
                            f = f || matrix[k][j] == matrix[k][j + 1];
                        }
                    }
                    if (f) r++;
                }

                // col
                c = 0;
                for (int j = 0; j < n; j++) {
                    boolean f = false;
                    for (int k = 0; k < n; k++) {
                        if (j < n - 1) {
                            f = f || matrix[j][k] == matrix[j + 1][k];
                        }
                        if (j > 0) {
                            f = f || matrix[j][k] == matrix[j - 1][k];
                        }
                    }
                    if (f) c++;
                }

                out.printf("Case #%d: %d %d %d\n", i, t, r, c);
            }

        }

    }
}

