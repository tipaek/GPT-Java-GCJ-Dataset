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
public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        Scanner in = new Scanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        Solution solver = new Solution();
        solver.solve(1, in, out);
        out.close();
    }

    static class Solution {
        public void solve(int testNumber, Scanner in, PrintWriter out) {

            int numOfTestCase = in.nextInt();
            for (int i = 1; i <= numOfTestCase; i++) {
                int n = in.nextInt();
                int[][] m = new int[n][n];
                for (int j = 0; j < n; j++) {
                    for (int k = 0; k < n; k++) {
                        m[j][k] = in.nextInt();
                    }
                }
                int t = 0;
                int r = 0;
                int c = 0;

                // trace
                for (int j = 0; j < n; j++) {
                    t += m[j][j];
                }

                // yoko
                for (int j = 0; j < n; j++) {
                    boolean f = false;
                    for (int k = 0; k < n; k++) {
                        for (int l = k + 1; l < n; l++) {
                            if (m[j][k] == m[j][l]) {
                                f = true;
                                break;
                            }
                        }
                    }
                    if (f) {
                        r++;
                    }
                }

                // tate
                for (int j = 0; j < n; j++) {
                    boolean f = false;
                    for (int k = 0; k < n; k++) {
                        for (int l = k + 1; l < n; l++) {
                            if (m[k][j] == m[l][j]) {
                                f = true;
                                break;
                            }
                        }
                    }
                    if (f) {
                        c++;
                    }
                }

                out.printf("Case #%d: %d %d %d\n", i, t, r, c);
            }

        }

    }
}

