import java.io.*;
import java.math.BigInteger;
import java.util.*;

public final class Solution implements Runnable {

    class CostId implements Comparable<CostId> {
        int cost;
        int id;

        public CostId(int cost, int id) {
            this.cost = cost;
            this.id = id;
        }

        @Override
        public int compareTo(CostId o) {
            return Integer.compare(cost, o.cost);
        }

        @Override
        public String toString() {
            return "CostId{" +
                    "cost=" + cost +
                    ", id=" + id +
                    '}';
        }
    }

    class BeforeId implements Comparable<BeforeId> {
        int before;
        int id;

        public BeforeId(int before, int id) {
            this.before = before;
            this.id = id;
        }

        @Override
        public int compareTo(BeforeId o) {
            return Integer.compare(before, o.before);
        }

        @Override
        public String toString() {
            return "BeforeId{" +
                    "before=" + before +
                    ", id=" + id +
                    '}';
        }
    }

    class Edge {
        int A, B;

        public Edge(int a, int b) {
            A = a;
            B = b;
        }

        @Override
        public String toString() {
            return "Edge{" +
                    "A=" + A +
                    ", B=" + B +
                    '}';
        }
    }

    public void solveCase() {
        int C = nextInt(), D = nextInt();
        int[] X = new int[C];
        List<CostId> costId = new ArrayList<>();
        List<BeforeId> beforeId = new ArrayList<>();
        for (int i = 1; i < C; ++i) {
            X[i] = nextInt();
            if (X[i] > 0) {
                costId.add(new CostId(X[i], i));
            } else {
                beforeId.add(new BeforeId(-X[i], i));
            }
        }
        Collections.sort(costId);
        Collections.sort(beforeId);
        Collections.reverse(beforeId);
        Collections.reverse(costId);

        int INF = 100000000;
        int[][] adj = new int[C][C];
        for (int i = 0; i < adj.length; ++i) {
            Arrays.fill(adj[i], -1);
        }
        Edge[] edges = new Edge[D];
        int[] edgeCost = new int[D];
        Arrays.fill(edgeCost, -1);

        for (int i = 0; i < D; ++i) {
            int from = nextInt() - 1, to = nextInt() - 1;
            edges[i] = new Edge(from, to);
            adj[from][to] = adj[to][from] = INF;
        }
        boolean[] ok = new boolean[C];
        int[] costs = new int[C];
        costs[0] = 0;
        ok[0] = true;
        int cost = 0;
        for (int i = 1; i < C; ++i) {
            int id;
            if (beforeId.size() > 0 && beforeId.get(beforeId.size() - 1).before <= i) {
                if (beforeId.get(beforeId.size() - 1).before == i) {
                    cost = Math.max(cost + 1, beforeId.get(beforeId.size() - 1).before);
                } else {
                    cost = Math.max(cost, beforeId.get(beforeId.size() - 1).before);
                }
                id = beforeId.get(beforeId.size() - 1).id;
                beforeId.remove(beforeId.size() - 1);
            } else if (costId.size() > 0) {
                id = costId.get(costId.size() - 1).id;
                cost = costId.get(costId.size() - 1).cost;
                costId.remove(costId.size() - 1);
            } else {
                throw new IllegalStateException();
            }

            for (int j = 0; j < D; ++j) {
                Edge e = edges[j];
                if (e.A == id && ok[e.B] && cost > costs[e.B]) {
                    costs[id] = cost;
                    ok[id] = true;
                    edgeCost[j] = cost - costs[e.B];
                    break;
                }
                if (e.B == id && ok[e.A] && cost > costs[e.A]) {
                    costs[id] = cost;
                    ok[id] = true;
                    edgeCost[j] = cost - costs[e.A];
                    break;
                }

            }
            if (!ok[id])
                throw new IllegalStateException();
        }
        cost += 1;
        for (int i = 0; i < D; ++i) {
            if (edgeCost[i] == -1)
                edgeCost[i] = cost;
        }
        for (int i = 0; i < D; ++i) {
            pw.print(edgeCost[i] + " ");
        }
    }

    public void solve() {
        int t = nextInt();
        for (int i = 0; i < t; ++i) {
            pw.printf("Case #%d: \n", i + 1);
            solveCase();
            pw.println();
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