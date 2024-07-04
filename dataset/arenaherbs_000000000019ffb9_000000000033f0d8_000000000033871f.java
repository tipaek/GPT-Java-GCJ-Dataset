import java.util.*;
import java.io.*;
// 5/16/20
import static java.lang.Math.*;

public class Solution {
// public class CodeJamRound2A {
    static long LINF = Long.MAX_VALUE / 4;
    static long IING = Integer.MAX_VALUE / 4;
    static final boolean TEST = false;

    public static void main(String[] args) {
        FastScanner sc = new FastScanner();
        StringBuilder sb = new StringBuilder();
        int T = sc.nextInt();
        testcase:
        for (int t = 1; t <= T; t++) {
            int C = sc.nextInt();
            int D = sc.nextInt();
            int[] nodes = new int[C];
            int[] edgeWeights = new int[D];
            int[] nodeWeights = new int[C];
            Arrays.fill(edgeWeights, -1);

            Arrays.fill(nodeWeights, -1);
            int[] latency = new int[D];
            List<Pair>[] graph = new ArrayList[C];
            for (int i = 1; i < C; i++) {
                nodes[i] = sc.nextInt();
            }
            for (int i = 0; i < C; i++) {
                graph[i] = new ArrayList<Pair>();
            }
            for (int i = 0; i < D; i++) {
                int u = sc.nextInt()-1;
                int v = sc.nextInt()-1;
                graph[u].add(new Pair(v, i));
                graph[v].add(new Pair(u, i));
            }
            // try lowest order first. Order is positive.
            // try lowest weight first.
            PriorityQueue<EW> qWeight = new PriorityQueue<>();
            PriorityQueue<EO> qOrder = new PriorityQueue<>();
//            boolean[] visited = new boolean[C];
            qOrder.add(new EO(0, 0, -1, -1));



            // NOTE: SOME EDGES MAY BE HANDLED AT THE SAME TIME.  NEED *** STRICTLY *** BEFORE!!!
            int nodesAlreadyVisited = 0;
            int previousMaxWeight = -1;
            boolean[] edgeInQueue = new boolean[D];

            // a queue for edges that sorts on nodes.  Confusing....
            HashSet<Integer> nodesTiedCurrently = new HashSet<Integer>();
            while (!qWeight.isEmpty() || !qOrder.isEmpty()) {
                // add next things to queue
                int currNode, currWeight, index, from;

                // mark edge's weight.
                if (TEST && qOrder.size() > 0) {
                    System.err.println("numberAlready visited = " + nodesAlreadyVisited + ", next order = " + qOrder.peek().order);
                }
                // nodes can be tied for order....
                // only increase nodesAlreadyVisited if we strictly increase the weight.
                // process order first.
                if (qOrder.size() > 0 && (qOrder.peek().order == (nodesAlreadyVisited + nodesTiedCurrently.size()))) { // a new order
                    EO next = qOrder.poll();
                    currNode = next.to;
                    currWeight = previousMaxWeight + 1;
                    index = next.index;
                    from = next.from;
                } else if (qOrder.size() > 0 && (qOrder.peek().order == nodesAlreadyVisited)) { // an order tie
                    // new order
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

                if (TEST) {
                    System.err.println("Node: " + currNode + ", weight = " + currWeight + ", index = " + index);
                }
                // need to mark each edge with a weight.
                // But only need to add next edges if this is the first time
                // we visit this node.
                if (index != -1) { // mark edge as being visited
                    edgeWeights[index] = currWeight - nodeWeights[from];
                }
                if (nodeWeights[currNode] == -1) {
                    nodeWeights[currNode] = currWeight;
                }
                if (previousMaxWeight < currWeight) {
                    previousMaxWeight = currWeight;
                    nodesAlreadyVisited += nodesTiedCurrently.size();
                    nodesTiedCurrently.clear(); // hash set so large but nodes <= 100
                }
                nodesTiedCurrently.add(currNode);


                // need to mark next node as handled down here.
                for (Pair p : graph[currNode]) {
                    int v = p.to;
                    if (edgeInQueue[p.index]) { continue; }
                    if (nodes[v] > 0) { // weight
                        qWeight.add(new EW(v, nodes[v], p.index, currNode));
                        edgeInQueue[p.index] = true;
                    } else { // order
                        qOrder.add(new EO(v, abs(nodes[v]), p.index, currNode));
                        edgeInQueue[p.index] = true;
                    }
                }
                //
            }





            sb.append("Case #" + t + ": ");
            if (TEST)
                System.err.print("Case #" + t + ": ");
            for (int i = 0; i < D; i++) {
                sb.append(edgeWeights[i]);
                if (TEST) {
                    System.err.print(edgeWeights[i] + " ");
                }
                if (i != D-1) {
                    sb.append(" ");
                }
            }
            sb.append("\n");
            if (TEST) {
                System.err.print("\n");
            }
        }
        System.out.print(sb);
    }
    public static class Pair {
        int to;
        int index;
        public Pair (int _to, int _index) {
            to = _to;
            index = _index;
        }
    }

    public static class EW implements Comparable<EW> {
        int to;
        int weight;
        int index;
        int from;
        public EW(int _to, int _w, int _index, int _from) {
            to = _to;
            weight = _w;
            index = _index;
            from = _from;
        }
        @Override
        public int compareTo(EW other) {
            return weight - other.weight;
        }
    }
    public static class EO implements Comparable<EO> {
        int to;
        int order;
        int index;
        int from;
        public EO(int _to, int _o, int _index, int _from) {
            to = _to;
            order = _o;
            index = _index;
            from = _from;
        }
        @Override
        public int compareTo(EO other) {
            return order - other.order;
        }
    }

    static void Assert(boolean b) {
        if (!b) throw new Error("Assertion Failed");
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
            for (int idx = 0; idx < n; idx++) {
                a[idx] = nextInt();
            }
            return a;
        }

        long[] readLongArray(int n) {
            long[] a = new long[n];
            for (int idx = 0; idx < n; idx++) {
                a[idx] = nextLong();
            }
            return a;
        }
    }
}
