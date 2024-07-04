import java.util.*;
import java.io.*;
import static java.lang.Math.*;

public class Solution {
    static final long LINF = Long.MAX_VALUE / 4;
    static final long IING = Integer.MAX_VALUE / 4;
    static final boolean TEST = false;

    public static void main(String[] args) {
        FastScanner sc = new FastScanner();
        StringBuilder sb = new StringBuilder();
        int T = sc.nextInt();

        for (int t = 1; t <= T; t++) {
            int C = sc.nextInt();
            int D = sc.nextInt();
            int[] nodes = new int[C];
            int[] edgeWeights = new int[D];
            int[] nodeWeights = new int[C];
            Arrays.fill(edgeWeights, -1);
            Arrays.fill(nodeWeights, -1);
            List<Pair>[] graph = new ArrayList[C];
            for (int i = 1; i < C; i++) {
                nodes[i] = sc.nextInt();
            }
            for (int i = 0; i < C; i++) {
                graph[i] = new ArrayList<>();
            }
            for (int i = 0; i < D; i++) {
                int u = sc.nextInt() - 1;
                int v = sc.nextInt() - 1;
                graph[u].add(new Pair(v, i));
                graph[v].add(new Pair(u, i));
            }

            PriorityQueue<EW> qWeight = new PriorityQueue<>();
            PriorityQueue<EO> qOrder = new PriorityQueue<>();
            qOrder.add(new EO(0, 0, -1, -1));

            int nodesAlreadyVisited = 0;
            int previousMaxWeight = -1;
            boolean[] edgeInQueue = new boolean[D];
            HashSet<Integer> nodesTiedCurrently = new HashSet<>();

            while (!qWeight.isEmpty() || !qOrder.isEmpty()) {
                int currNode, currWeight, index, from;

                if (qOrder.size() > 0 && qOrder.peek().order == (nodesAlreadyVisited + nodesTiedCurrently.size())) {
                    EO next = qOrder.poll();
                    currNode = next.to;
                    currWeight = previousMaxWeight + 1;
                    index = next.index;
                    from = next.from;
                } else if (qOrder.size() > 0 && qOrder.peek().order == nodesAlreadyVisited) {
                    EO next = qOrder.poll();
                    currNode = next.to;
                    currWeight = previousMaxWeight;
                    index = next.index;
                    from = next.from;
                } else {
                    EW next = qWeight.poll();
                    currNode = next.to;
                    currWeight = next.weight;
                    index = next.index;
                    from = next.from;
                }

                if (index != -1) {
                    edgeWeights[index] = currWeight - nodeWeights[from];
                }
                if (nodeWeights[currNode] == -1) {
                    nodeWeights[currNode] = currWeight;
                }
                if (previousMaxWeight < currWeight) {
                    previousMaxWeight = currWeight;
                    nodesAlreadyVisited += nodesTiedCurrently.size();
                    nodesTiedCurrently.clear();
                }
                nodesTiedCurrently.add(currNode);

                for (Pair p : graph[currNode]) {
                    int v = p.to;
                    if (edgeInQueue[p.index]) continue;
                    if (nodes[v] > 0) {
                        qWeight.add(new EW(v, nodes[v], p.index, currNode));
                        edgeInQueue[p.index] = true;
                    } else {
                        qOrder.add(new EO(v, abs(nodes[v]), p.index, currNode));
                        edgeInQueue[p.index] = true;
                    }
                }
            }

            sb.append("Case #").append(t).append(": ");
            for (int i = 0; i < D; i++) {
                sb.append(edgeWeights[i]);
                if (i != D - 1) {
                    sb.append(" ");
                }
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }

    public static class Pair {
        int to;
        int index;
        public Pair(int to, int index) {
            this.to = to;
            this.index = index;
        }
    }

    public static class EW implements Comparable<EW> {
        int to;
        int weight;
        int index;
        int from;
        public EW(int to, int weight, int index, int from) {
            this.to = to;
            this.weight = weight;
            this.index = index;
            this.from = from;
        }
        @Override
        public int compareTo(EW other) {
            return Integer.compare(this.weight, other.weight);
        }
    }

    public static class EO implements Comparable<EO> {
        int to;
        int order;
        int index;
        int from;
        public EO(int to, int order, int index, int from) {
            this.to = to;
            this.order = order;
            this.index = index;
            this.from = from;
        }
        @Override
        public int compareTo(EO other) {
            return Integer.compare(this.order, other.order);
        }
    }

    public static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        public FastScanner(Reader in) {
            br = new BufferedReader(in);
        }

        public FastScanner() {
            this(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String readNextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }

        int[] readIntArray(int n) {
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = nextInt();
            }
            return a;
        }

        long[] readLongArray(int n) {
            long[] a = new long[n];
            for (int i = 0; i < n; i++) {
                a[i] = nextLong();
            }
            return a;
        }
    }
}