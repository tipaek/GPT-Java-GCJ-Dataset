import java.util.*;
import java.io.*;

public class Solution {
    public static final boolean DEBUG = false;

    public static void main(String[] args) throws Exception {
        PrintWriter pw = new PrintWriter(System.out);
        FastScanner sc = new FastScanner();

        int testCases = sc.nextInt();

        for (int t = 1; t <= testCases; t++) {
            int c = sc.nextInt();
            int d = sc.nextInt();
            debug(c, d);

            Node[] nodes = new Node[c];

            for (int i = 0; i < c; i++) {
                nodes[i] = new Node(i + 1, i == 0 ? 0 : sc.nextInt());
            }

            Edge[] edges = new Edge[d];

            for (int i = 0; i < d; i++) {
                int a = sc.nextInt() - 1;
                int b = sc.nextInt() - 1;
                edges[i] = new Edge(nodes[a], nodes[b]);
            }

            nodes[0].d = 0;

            Arrays.sort(nodes);

            for (Node node : nodes) {
                if (node.i == 1) {
                    continue;
                }

                node.d = -node.info;
                debug(node.i, node.info);

                for (Edge e : node.edges) {
                    Node other = e.other(node);

                    if (other.d != -1) {
                        e.w = node.d - other.d;
                    }
                }
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
        int info;

        public Node(int id, int info) {
            this.edges = new HashSet<>();
            this.d = -1;
            this.i = id;
            this.info = info;
        }

        @Override
        public int compareTo(Node other) {
            return other.info - this.info;
        }
    }

    static class Edge {
        int w;
        Node a;
        Node b;

        public Edge(Node a, Node b) {
            this.a = a;
            this.b = b;
            this.a.edges.add(this);
            this.b.edges.add(this);
            this.w = -1;
        }

        public Node other(Node node) {
            return node == a ? b : a;
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

    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        public FastScanner() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        public String nextLine() throws IOException {
            return br.readLine();
        }

        public String nextToken() throws IOException {
            while (st == null || !st.hasMoreTokens()) {
                st = new StringTokenizer(nextLine());
            }
            return st.nextToken();
        }

        public int nextInt() throws IOException {
            return Integer.parseInt(nextToken());
        }

        public long nextLong() throws IOException {
            return Long.parseLong(nextToken());
        }

        public double nextDouble() throws IOException {
            return Double.parseDouble(nextToken());
        }

        public void close() throws IOException {
            br.close();
        }
    }
}

interface Suspended {
    Object eval();
}