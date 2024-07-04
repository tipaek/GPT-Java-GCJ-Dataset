import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;
import java.util.HashMap;
import java.util.ArrayDeque;

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
        JoinTheRanks solver = new JoinTheRanks();
        int testCount = Integer.parseInt(in.next());
        for (int i = 1; i <= testCount; i++)
            solver.solve(i, in, out);
        out.close();
    }

    static class JoinTheRanks {
        PrintWriter out;

        int stupid(int r, int s) {
            Map<S, Integer> res = new HashMap<>();
            ArrayDeque<S> q = new ArrayDeque<>();
            S start = new S(r * s);
            for (int i = 0; i < s; i++) {
                for (int j = 0; j < r; j++) {
                    start.v[i * r + j] = j;
                }
            }
            q.add(start);
            res.put(start, 0);

            while (q.size() > 0) {
                S x = q.pollFirst();
                int xbad = x.bad();
                search:
                for (int a = 0; a < x.v.length - 1; a++) {
                    for (int b = 1; a + b <= x.v.length; b++) {
                        S y = x.move(a, b);
                        if (res.containsKey(y)) {
                            continue;
                        }
                        if (y.good()) {
                            out.println(res.get(x) + 1);
                            y.printPath();
                            return res.get(x) + 1;
                        }
                        if (y.bad() > x.bad() - 2) {
                            continue;
                        }
                        res.put(y, res.get(x) + 1);
                        q.add(y);
                        break search;
                    }
                }
            }
            return -1;
        }

        public void solve(int testNumber, Scanner in, PrintWriter out) {
            this.out = out;

            int r = in.nextInt();
            int s = in.nextInt();
            out.print("Case #" + testNumber + ": ");
            stupid(r, s);
        }

        class S {
            int[] v;
            S from;
            int froma;
            int fromb;

            public S(S s) {
                v = s.v.clone();
            }

            public S(int n) {
                v = new int[n];
            }

            S move(int a, int b) {
                S r = new S(v.length);
                for (int i = a; i < a + b; i++) {
                    r.v[i - a] = v[i];
                }
                for (int i = 0; i < a; i++) {
                    r.v[i + b] = v[i];
                }
                for (int i = a + b; i < v.length; i++) {
                    r.v[i] = v[i];
                }
                r.from = this;
                r.froma = a;
                r.fromb = b;
                return r;
            }

            public boolean equals(Object o) {
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;
                S s = (S) o;
                return Arrays.equals(v, s.v);
            }

            boolean good() {
                for (int i = 0; i < v.length - 1; i++) {
                    if (v[i] > v[i + 1]) {
                        return false;
                    }
                }
                return true;
            }

            int bad() {
                int r = 0;
//            if (v[0] != 0) {
//                r++;
//            }
                boolean[] was = new boolean[v.length];
                for (int i = 0; i < v.length - 1; i++) {
                    if (v[i] > v[i + 1]) {
                        r++;
                    } else if (v[i] < v[i + 1] - 1) {
                        r++;
                    } else if (v[i] == v[i + 1] - 1 && was[v[i]]) {
                        r++;
                    } else if (v[i] == v[i + 1] - 1) {
                        was[v[i]] = true;
                    }
                }
                return r;
            }

            void printPath() {
                if (from != null) {
                    from.printPath();
                    out.println(froma + " " + fromb);
                }
//            System.out.println(Arrays.toString(v) + " " + bad());
            }

            public int hashCode() {
                return Arrays.hashCode(v);
            }

        }

    }
}

