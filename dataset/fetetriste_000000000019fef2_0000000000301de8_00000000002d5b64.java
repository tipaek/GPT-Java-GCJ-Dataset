import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.Map;
import java.io.BufferedReader;
import java.util.Collections;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 */
public class Solution {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        FastScanner in = new FastScanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        C_JoinTheRanks solver = new C_JoinTheRanks();
        solver.solve(1, in, out);
        out.close();
    }

    static class C_JoinTheRanks {
        public void solve(int testNumber, FastScanner in, PrintWriter out) {
            int numTests = in.nextInt();
            for (int test = 1; test <= numTests; test++) {
                int r = in.nextInt();
                int s = in.nextInt();
                out.printf("Case #%d: ", test);
                solve(out, r, s);
            }
        }

        private void solve(PrintWriter out, int r, int s) {
            int[] st = new int[r * s];
            int[] fn = new int[r * s];
            for (int i = 0; i < st.length; i++) {
                st[i] = i % r;
                fn[i] = i / s;
            }
            State start = new State(st);
            State finish = new State(fn);
            List<State> q = new ArrayList<>();
            Map<State, Integer> d = new HashMap<>();
            Map<State, int[]> pMove = new HashMap<>();
            q.add(start);
            d.put(start, 0);
            for (int it = 0; it < q.size(); it++) {
                State cur = q.get(it);
                if (cur.equals(finish)) {
                    break;
                }
                int curD = d.get(cur);
                for (int x = 1; x < r * s; x++) {
                    for (int y = 1; x + y <= r * s; y++) {
                        State next = cur.move(x, y);
                        if (!d.containsKey(next)) {
                            q.add(next);
                            d.put(next, curD + 1);
                            pMove.put(next, new int[]{x, y});
                        }
                    }
                }
            }

            State cur = finish;
            List<String> path = new ArrayList<>();
            while (!cur.equals(start)) {
                int[] move = pMove.get(cur);
                path.add(move[0] + " " + move[1]);
                cur = cur.move(move[1], move[0]);
            }

            Collections.reverse(path);
            out.println(path.size());
            for (String str : path) {
                out.println(str);
            }
        }

        class State {
            int[] a;

            State(int[] a) {
                this.a = a;
            }

            State move(int x, int y) {
                int[] na = a.clone();
                System.arraycopy(a, x, na, 0, y);
                System.arraycopy(a, 0, na, y, x);
                return new State(na);
            }

            public int hashCode() {
                return Arrays.hashCode(a);
            }

            public boolean equals(Object obj) {
                State o = (State) obj;
                return Arrays.equals(a, o.a);
            }

        }

    }

    static class FastScanner {
        private BufferedReader in;
        private StringTokenizer st;

        public FastScanner(InputStream stream) {
            in = new BufferedReader(new InputStreamReader(stream));
        }

        public String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(in.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return st.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

    }
}

