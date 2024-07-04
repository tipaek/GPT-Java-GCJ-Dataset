import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
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
        Expogo solver = new Expogo();
        int testCount = Integer.parseInt(in.next());
        for (int i = 1; i <= testCount; i++)
            solver.solve(i, in, out);
        out.close();
    }

    static class Expogo {
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        char[] c = {'E', 'S', 'W', 'N'};

        boolean good(long x, long y) {
            return Math.abs(x % 2) != Math.abs(y % 2);
        }

        public void solve(int testNumber, Scanner in, PrintWriter out) {
            long x = in.nextInt();
            long y = in.nextInt();

            StringBuilder ans = new StringBuilder();
            while (x != 0 || y != 0) {
                boolean found = false;
                for (int d = 0; d < 4; d++) {
                    long nx = x + dx[d];
                    long ny = y + dy[d];
                    if (nx == 0 && ny == 0) {
                        found = true;
                        ans.append(c[d]);
                        x = nx / 2;
                        y = ny / 2;
                        break;
                    }
                }
                if (!found) {
                    for (int d = 0; d < 4; d++) {
                        long nx = x + dx[d];
                        long ny = y + dy[d];
                        if (nx % 2 != 0 || ny % 2 != 0) {
                            continue;
                        }
                        if (!good(nx / 2, ny / 2)) {
                            continue;
                        }
                        found = true;
                        ans.append(c[d]);
                        x = nx / 2;
                        y = ny / 2;
                        break;
                    }
                }
                if (!found) {
                    out.println("Case #" + testNumber + ": IMPOSSIBLE");
                    return;
                }
            }
            out.println("Case #" + testNumber + ": " + ans);
        }

    }
}

