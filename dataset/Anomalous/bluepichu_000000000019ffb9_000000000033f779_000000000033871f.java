import java.util.*;
import java.io.*;

public class Solution {
    public static final boolean DEBUG = false;

    public static void main(String[] args) throws Exception {
        PrintWriter pw = new PrintWriter(System.out);
        FastScan sc = new FastScan();

        int cases = sc.nextInt();

        for (int t = 1; t <= cases; t++) {
            int c = sc.nextInt();
            int d = sc.nextInt();

            Node[] nodes = new Node[c];
            PriorityQueue<Node> nodesA = new PriorityQueue<>();
            PriorityQueue<Node> nodesB = new PriorityQueue<>();

            for (int i = 0; i < c; i++) {
                nodes[i] = new Node(i + 1, i == 0 ? 0 : sc.nextInt());

                if (nodes[i].infotype == 0) {
                    nodesA.add(nodes[i]);
                    nodes[i].d = nodes[i].info;
                } else {
                    nodesB.add(nodes[i]);
                }
            }

            Edge[] edges = new Edge[d];

            for (int i = 0; i < d; i++) {
                int a = sc.nextInt() - 1;
                int b = sc.nextInt() - 1;
                edges[i] = new Edge(nodes[a], nodes[b]);
            }

            nodes[0].d = 0;
            int k = 0;
            int dist = 0;

            while (!nodesB.isEmpty()) {
                if (!nodesB.isEmpty() && nodesB.peek().info == k) {
                    dist++;
                    nodesB.poll().d = dist;
                } else if (!nodesB.isEmpty() && nodesB.peek().info < k) {
                    nodesB.poll().d = dist;
                }
                k++;
            }

            for (Edge e : edges) {
                e.w = Math.abs(e.a.d - e.b.d);
                if (e.w == 0) {
                    e.w = 1;
                }
            }

            for (Node n : nodes) {
                debug(n.i, n.d);
            }

            pw.printf("Case #%d:", t);
            for (Edge e : edges) {
                pw.printf(" %d", e.w);
            }
            pw.println();

            if (DEBUG) {
                pw.flush();
            }
        }

        pw.close();
        sc.close();
    }

    static class Node implements Comparable<Node> {
        Set<Edge> edges;
        int d;
        int i;
        int infotype;
        int info;

        public Node(int mi, int minfo) {
            edges = new HashSet<>();
            d = -1;
            i = mi;
            infotype = minfo < 0 ? 1 : 0;
            info = Math.abs(minfo);
        }

        public int compareTo(Node o) {
            return Integer.compare(info, o.info);
        }
    }

    static class Edge {
        int w;
        Node a;
        Node b;

        public Edge(Node ma, Node mb) {
            a = ma;
            b = mb;
            a.edges.add(this);
            b.edges.add(this);
            w = -1;
        }

        public Node other(Node x) {
            return x == a ? b : a;
        }
    }

    public static void debug(Object obj, String end) {
        if (DEBUG) {
            if (obj instanceof boolean[]) {
                System.out.print(Arrays.toString((boolean[]) obj));
            } else if (obj instanceof byte[]) {
                System.out.print(Arrays.toString((byte[]) obj));
            } else if (obj instanceof short[]) {
                System.out.print(Arrays.toString((short[]) obj));
            } else if (obj instanceof char[]) {
                System.out.print(Arrays.toString((char[]) obj));
            } else if (obj instanceof int[]) {
                System.out.print(Arrays.toString((int[]) obj));
            } else if (obj instanceof long[]) {
                System.out.print(Arrays.toString((long[]) obj));
            } else if (obj instanceof float[]) {
                System.out.print(Arrays.toString((float[]) obj));
            } else if (obj instanceof double[]) {
                System.out.print(Arrays.toString((double[]) obj));
            } else if (obj instanceof Object[]) {
                debug((Object[]) obj);
            } else {
                System.out.print(obj);
            }
            System.out.print(end);
        }
    }

    public static void debug(Object... args) {
        if (DEBUG) {
            System.out.print("#");
            for (Object arg : args) {
                debug(arg, " ");
            }
            System.out.println();
        }
    }

    public static void debug(Suspended sus) {
        if (DEBUG) {
            debug(sus.eval());
        }
    }

    public static void debugGrid(int[][] grid) {
        if (DEBUG) {
            for (int[] row : grid) {
                System.out.print("#");
                for (int cell : row) {
                    System.out.print(String.format("%3d ", cell));
                }
                System.out.println();
            }
        }
    }

    static class FastScan {
        BufferedReader br;
        StringTokenizer st;

        public FastScan() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        public String nextLine() throws Exception {
            return br.readLine();
        }

        public String nextToken() throws Exception {
            while (st == null || !st.hasMoreTokens()) {
                st = new StringTokenizer(nextLine(), " ");
            }
            return st.nextToken();
        }

        public int nextInt() throws Exception {
            return Integer.parseInt(nextToken());
        }

        public long nextLong() throws Exception {
            return Long.parseLong(nextToken());
        }

        public double nextDouble() throws Exception {
            return Double.parseDouble(nextToken());
        }

        public void close() throws Exception {
            br.close();
        }
    }
}

interface Suspended {
    Object eval();
}