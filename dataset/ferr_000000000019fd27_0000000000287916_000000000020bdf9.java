import java.io.*;
import java.math.BigInteger;
import java.util.*;

public final class Solution implements Runnable {

    class Pair implements Comparable<Pair> {
        public final int S;
        public final int E;
        public final int id;

        Pair(int s, int e, int id) {
            S = s;
            E = e;
            this.id = id;
        }


        @Override
        public int compareTo(Pair o) {
            if (o.S != this.S)
                return Integer.compare(this.S, o.S);
            return Integer.compare(this.E, o.E);
        }
    }

    class Edge {
        public final int C;
        public final int J;

        Edge(int c, int j) {
            C = c;
            J = j;
        }
    }

    final int MUL = 10000;

    public String solveCase() {
        int n = nextInt();
        Pair[] ps = new Pair[n + 1];
        ps[0] = new Pair(0, 0, -1);
        for (int i = 0; i < n; ++i) {
            ps[i + 1] = new Pair(nextInt(), nextInt(), i);
        }
        Arrays.sort(ps);
        Edge[][] dp = new Edge[n + 1][n + 1];
//        for (int i = 0; i < dp.length; ++i) {
//            Arrays.fill(dp[i],(byte)-1);
//        }
        Queue<Edge> q = new LinkedList<>();
        q.add(new Edge((short)0, (short)0));
        while (!q.isEmpty()) {
            Edge p = q.poll();
            int CE = ps[p.C].E, JE = ps[p.J].E;
            int next = Math.max(p.C, p.J) + 1;
            if (next == n + 1) {
                char[] cs = new char[n];
                while (p.C != 0 || p.J != 0) {
                    Edge prev = dp[p.C][p.J];
                    if (prev.C != p.C)
                        cs[ps[p.C].id] = 'C';
                    else
                        cs[ps[p.J].id] = 'J';
                    p = prev;
                }
                return new String(cs);
            }
            if (CE <= ps[next].S) {
                dp[next][p.J] = p;
                q.add(new Edge(next, p.J));
            }
            if (JE <= ps[next].S) {
                dp[p.C][next] = p;
                q.add(new Edge(p.C, next));
            }
        }
        return "IMPOSSIBLE";
    }

    public void solve() {
        int t = nextInt();
        for (int i = 0; i < t; ++i) {
            String ans = solveCase();
            pw.printf("Case #%d: %s\n", i + 1, ans);
        }
    }

    static final String filename = "A";
    static final boolean fromConsole = true;

    public void run() {
        try {
            if (!fromConsole) {
                in = new BufferedReader(new FileReader(filename + ".in"));
                pw = new PrintWriter(filename + ".out");
            } else {
                in = new BufferedReader(new InputStreamReader(System.in));
                pw = new PrintWriter(System.out);
            }
            st = new StringTokenizer("");
            long st = System.currentTimeMillis();
            solve();
            //pw.printf("\nWorking time: %d ms\n", System.currentTimeMillis() - st);
            pw.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(-1);
        }
    }

    private StringTokenizer st;
    private BufferedReader in;
    private PrintWriter pw;

    boolean hasNext() {
        try {
            while (!st.hasMoreTokens()) {
                String line = in.readLine();
                if (line == null) {
                    return false;
                }
                st = new StringTokenizer(line);
            }
            return st.hasMoreTokens();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    String next() {
        return hasNext() ? st.nextToken() : null;
    }

    int nextInt() {
        return Integer.parseInt(next());
    }

    BigInteger nextBigInteger() {
        return new BigInteger(next());
    }

    long nextLong() {
        return Long.parseLong(next());
    }

    double nextDouble() {
        return Double.parseDouble(next());
    }

    public static void main(String[] args) {
        new Thread(new Solution()).start();
    }
}