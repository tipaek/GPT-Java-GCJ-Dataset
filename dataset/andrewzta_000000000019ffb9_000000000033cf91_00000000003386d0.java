import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Comparator;

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
        WormholeInOne solver = new WormholeInOne();
        int testCount = Integer.parseInt(in.next());
        for (int i = 1; i <= testCount; i++)
            solver.solve(i, in, out);
        out.close();
    }

    static class WormholeInOne {
        final boolean debug = false;

        public void solve(int testNumber, Scanner in, PrintWriter out) {
            int n = in.nextInt();
            P[] p = new P[n];
            for (int i = 0; i < n; i++) {
                p[i] = new P(in);
            }

            int ans = 1;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (i == j) continue;
                    final long dx = p[j].x - p[i].x;
                    final long dy = p[j].y - p[i].y;
                    P[] q = p.clone();
                    Arrays.sort(q, new Comparator<P>() {

                        public int compare(P o1, P o2) {
                            long vp1 = dx * o1.y - dy * o1.x;
                            long vp2 = dx * o2.y - dy * o2.x;
                            return Long.compare(vp1, vp2);
                        }
                    });
                    int c1 = 0;
                    int c2 = 0;
                    int cin = 0;
                    int cnt = 0;
                    long prev = 0;
                    if (debug) out.print("  ");
                    for (int k = 0; k < n; k++) {
                        long vp = dx * q[k].y - dy * q[k].x;
                        if (debug) out.print(vp + " ");
                        if (k == 0 || vp == prev) {
                            cnt++;
                        } else {
                            if (cnt == 1) {
                                c1++;
                            } else {
                                c2 += 2;
                                cin += cnt - 2;
                            }
                            cnt = 1;
                        }
                        prev = vp;
                    }
                    if (debug) out.println();
                    if (cnt == 1) {
                        c1++;
                    } else {
                        c2 += 2;
                        cin += cnt - 2;
                    }

                    int res = c2 + cin;
                    if (cin % 2 == 1 && c1 > 1) {
                        c1 = 1;
                    }
                    res += Math.min(c1, 2);
                    if (debug)
                        out.println(i + " " + j + " " + dx + " " + dy + " " + c1 + " " + c2 + " " + cin + " " + res);
                    if (res > ans) {
                        ans = res;
                    }
                }
            }
            out.println("Case #" + testNumber + ": " + ans);
        }

        class P {
            long x;
            long y;

            public P(Scanner in) {
                x = in.nextLong();
                y = in.nextLong();
            }

        }

    }
}

