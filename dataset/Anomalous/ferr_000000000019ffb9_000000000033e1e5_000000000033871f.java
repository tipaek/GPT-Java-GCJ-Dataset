import java.io.*;
import java.math.BigInteger;
import java.util.*;

public final class Solution implements Runnable {

    private static class CostId implements Comparable<CostId> {
        int cost;
        int id;

        CostId(int cost, int id) {
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

    private static class BeforeId implements Comparable<BeforeId> {
        int before;
        int id;

        BeforeId(int before, int id) {
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

    private static class Edge {
        int A, B;

        Edge(int a, int b) {
            this.A = a;
            this.B = b;
        }

        @Override
        public String toString() {
            return "Edge{" + "A=" + A + ", B=" + B + '}';
        }
    }

    private void solveCase() {
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

        Collections.sort(costIdList, Collections.reverseOrder());
        Collections.sort(beforeIdList, Collections.reverseOrder());

        final int INF = 100000000;
        int[][] adjMatrix = new int[C][C];
        for (int[] row : adjMatrix) {
            Arrays.fill(row, -1);
        }

        Edge[] edges = new Edge[D];
        int[] edgeCosts = new int[D];
        Arrays.fill(edgeCosts, -1);

        for (int i = 0; i < D; ++i) {
            int from = nextInt() - 1, to = nextInt() - 1;
            edges[i] = new Edge(from, to);
            adjMatrix[from][to] = adjMatrix[to][from] = INF;
        }

        boolean[] visited = new boolean[C];
        int[] costs = new int[C];
        costs[0] = 0;
        visited[0] = true;
        int currentCost = 0;

        for (int i = 1; i < C; ++i) {
            int id;
            if (!beforeIdList.isEmpty() && beforeIdList.get(beforeIdList.size() - 1).before <= i) {
                BeforeId beforeId = beforeIdList.remove(beforeIdList.size() - 1);
                currentCost = Math.max(currentCost + 1, beforeId.before);
                id = beforeId.id;
            } else if (!costIdList.isEmpty()) {
                CostId costId = costIdList.remove(costIdList.size() - 1);
                currentCost = costId.cost;
                id = costId.id;
            } else {
                throw new IllegalStateException();
            }

            for (int j = 0; j < D; ++j) {
                Edge edge = edges[j];
                if ((edge.A == id && visited[edge.B] && currentCost > costs[edge.B]) || 
                    (edge.B == id && visited[edge.A] && currentCost > costs[edge.A])) {
                    costs[id] = currentCost;
                    visited[id] = true;
                    edgeCosts[j] = currentCost - Math.min(costs[edge.A], costs[edge.B]);
                    break;
                }
            }

            if (!visited[id]) {
                throw new IllegalStateException();
            }
        }

        currentCost++;
        for (int i = 0; i < D; ++i) {
            if (edgeCosts[i] == -1) {
                edgeCosts[i] = currentCost;
            }
        }

        for (int i = 0; i < D; ++i) {
            pw.print(edgeCosts[i]);
            if (i < D - 1) {
                pw.print(' ');
            }
        }
    }

    private void solve() {
        int testCases = nextInt();
        for (int i = 0; i < testCases; ++i) {
            pw.printf("Case #%d: ", i + 1);
            solveCase();
            pw.println();
        }
    }

    private static final String FILENAME = "A";
    private static final boolean FROM_CONSOLE = true;

    public void run() {
        try {
            if (!FROM_CONSOLE) {
                in = new BufferedReader(new FileReader(FILENAME + ".in"));
                pw = new PrintWriter(FILENAME + ".out");
            } else {
                in = new BufferedReader(new InputStreamReader(System.in));
                pw = new PrintWriter(System.out);
            }
            st = new StringTokenizer("");
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

    private boolean hasNext() {
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

    private String next() {
        return hasNext() ? st.nextToken() : null;
    }

    private int nextInt() {
        return Integer.parseInt(next());
    }

    private BigInteger nextBigInteger() {
        return new BigInteger(next());
    }

    private long nextLong() {
        return Long.parseLong(next());
    }

    private double nextDouble() {
        return Double.parseDouble(next());
    }

    public static void main(String[] args) {
        new Thread(new Solution()).start();
    }
}