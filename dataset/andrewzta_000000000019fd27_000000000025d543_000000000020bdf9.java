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
        ParentingPartneringReturns solver = new ParentingPartneringReturns();
        int testCount = Integer.parseInt(in.next());
        for (int i = 1; i <= testCount; i++)
            solver.solve(i, in, out);
        out.close();
    }

    static class ParentingPartneringReturns {
        public void solve(int testNumber, Scanner in, PrintWriter out) {
            int n = in.nextInt();
            S[] s = new S[n];
            for (int i = 0; i < n; i++) {
                s[i] = new S(i, in.nextInt(), in.nextInt());
            }
            Arrays.sort(s);
            char[] w = {'C', 'J'};
            int[] lst = new int[2];
            StringBuilder ans = new StringBuilder();
            for (int i = 0; i < n; i++) {
                boolean ok = false;
                for (int j = 0; j < 2; j++) {
                    if (lst[j] <= s[i].f) {
                        lst[j] = s[i].t;
                        s[i].c = w[j];
                        ok = true;
                        break;
                    }
                }
                if (!ok) {
                    ans = new StringBuilder("IMPOSSIBLE");
                    break;
                }
            }
            if (ans.length() == 0) {
                Arrays.sort(s, new Comparator<S>() {

                    public int compare(S o1, S o2) {
                        return o1.ind - o2.ind;
                    }
                });
                for (S x : s) {
                    ans.append(x.c);
                }
            }

            out.println("Case #" + testNumber + ": " + ans);
        }

        class S implements Comparable<S> {
            int ind;
            int f;
            int t;
            char c;

            public S(int ind, int f, int t) {
                this.ind = ind;
                this.f = f;
                this.t = t;
            }

            public int compareTo(S o) {
                return Integer.compare(f, o.f);
            }

        }

    }
}

