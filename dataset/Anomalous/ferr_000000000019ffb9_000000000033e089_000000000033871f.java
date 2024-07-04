import java.io.*;
import java.math.BigInteger;
import java.util.*;

public final class Solution implements Runnable {

    // Class representing cost and id, implements Comparable for sorting
    class CostId implements Comparable<CostId> {
        int cost;
        int id;

        public CostId(int cost, int id) {
            this.cost = cost;
            this.id = id;
        }

        @Override
        public int compareTo(CostId other) {
            return Integer.compare(this.cost, other.cost);
        }

        @Override
        public String toString() {
            return "CostId{" + "cost=" + cost + ", id=" + id + '}';
        }
    }

    // Class representing before and id, implements Comparable for sorting
    class BeforeId implements Comparable<BeforeId> {
        int before;
        int id;

        public BeforeId(int before, int id) {
            this.before = before;
            this.id = id;
        }

        @Override
        public int compareTo(BeforeId other) {
            return Integer.compare(this.before, other.before);
        }

        @Override
        public String toString() {
            return "BeforeId{" + "before=" + before + ", id=" + id + '}';
        }
    }

    // Class representing an edge between two nodes
    class Edge {
        int A, B;

        public Edge(int a, int b) {
            this.A = a;
            this.B = b;
        }

        @Override
        public String toString() {
            return "Edge{" + "A=" + A + ", B=" + B + '}';
        }
    }

    public void solveCase() {
        int C = nextInt(), D = nextInt();
        int[] X = new int[C];
        List<CostId> costIdList = new ArrayList<>();
        List<BeforeId> beforeIdList = new ArrayList<>();

        for (int i = 1; i < C; ++i) {
            X[i] = nextInt();
            if (X[i] > 0) {
                costIdList.add(new CostId(X[i], i));
            } else {
                beforeIdList.add(new BeforeId(-X[i], i));
            }
        }

        Collections.sort(costIdList);
        Collections.sort(beforeIdList);
        Collections.reverse(beforeIdList);
        Collections.reverse(costIdList);

        final int INF = 100000000;
        int[][] adj = new int[C][C];
        for (int[] row : adj) {
            Arrays.fill(row, -1);
        }

        Edge[] edges = new Edge[D];
        int[] edgeCosts = new int[D];
        Arrays.fill(edgeCosts, -1);

        for (int i = 0; i < D; ++i) {
            int from = nextInt() - 1, to = nextInt() - 1;
            edges[i] = new Edge(from, to);
            adj[from][to] = adj[to][from] = INF;
        }

        boolean[] ok = new boolean[C];
        int[] costs = new int[C];
        costs[0] = 0;
        ok[0] = true;
        int currentCost = 0;

        for (int i = 1; i < C; ++i) {
            int id;
            if (!beforeIdList.isEmpty() && beforeIdList.get(beforeIdList.size() - 1).before <= i) {
                if (beforeIdList.get(beforeIdList.size() - 1).before == i) {
                    currentCost = Math.max(currentCost + 1, beforeIdList.get(beforeIdList.size() - 1).before);
                } else {
                    currentCost = Math.max(currentCost, beforeIdList.get(beforeIdList.size() - 1).before);
                }
                id = beforeIdList.remove(beforeIdList.size() - 1).id;
            } else if (!costIdList.isEmpty()) {
                id = costIdList.remove(costIdList.size() - 1).id;
                currentCost = costIdList.get(costIdList.size() - 1).cost;
            } else {
                throw new IllegalStateException();
            }

            for (int j = 0; j < D; ++j) {
                Edge e = edges[j];
                if (e.A == id && ok[e.B] && currentCost > costs[e.B]) {
                    costs[id] = currentCost;
                    ok[id] = true;
                    edgeCosts[j] = currentCost - costs[e.B];
                    break;
                }
                if (e.B == id && ok[e.A] && currentCost > costs[e.A]) {
                    costs[id] = currentCost;
                    ok[id] = true;
                    edgeCosts[j] = currentCost - costs[e.A];
                    break;
                }
            }

            if (!ok[id]) {
                throw new IllegalStateException();
            }
        }

        currentCost += 1;
        for (int i = 0; i < D; ++i) {
            if (edgeCosts[i] == -1) {
                edgeCosts[i] = currentCost;
            }
        }

        for (int edgeCost : edgeCosts) {
            pw.print(edgeCost + " ");
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
            long startTime = System.currentTimeMillis();
            solve();
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