import java.io.*;
import java.util.*;
import java.math.BigInteger;
import java.util.Map.Entry;
import java.util.function.DoubleUnaryOperator;
import java.util.function.ToDoubleBiFunction;

import static java.lang.Math.*;

public class Solution extends PrintWriter {
    class Edge {
        int id;
        Node u, v;

        public Edge(int id, Node u, Node v) {
            this.id = id;
            this.u = u;
            this.v = v;
        }

        Node to(Node from) {
            if (from == u) {
                return v;
            } else {
                return u;
            }
        }
    }

    class Node {
        int id;
        int pos = -1;
        int time = -1;

        public Node(int id, int x) {
            this.id = id;

            if (x >= 0) {
                this.time = x;
            }
            if (x <= 0) {
                this.pos = -x;
            }
        }

        @Override
        public String toString() {
            return "Node [id=" + id + ", pos=" + pos + ", time=" + time + "]";
        }

        List<Edge> edges = new ArrayList<Edge>();
    }

    void solve(int n, int m, Node[] nodes) {

        List<Node> times = new ArrayList<Node>();
        for (Node node : nodes) {
            if (node.time >= 0) {
                times.add(node);
            }
        }
        Collections.sort(times, Comparator.comparingInt(node -> node.time));



        Arrays.sort(nodes, Comparator.comparingInt(node -> node.pos));

        for (Node node : nodes) {
            if (node.time < 0) {
                times.add(node.pos, node);
                node.time = times.get(node.pos - 1).time + 1;
            }
        }



    }

    void run() {
        int t = nextInt();
        for (int test = 1; test <= t; test++) {
            int n = nextInt();
            int m = nextInt();

            Node[] nodes = new Node[n];
            nodes[0] = new Node(0, 0);
            for (int i = 1; i < n; i++) {
                nodes[i] = new Node(i, nextInt());
            }

            Edge[] edges = new Edge[m];
            for (int i = 0; i < m; i++) {
                Node u = nodes[nextInt() - 1];
                Node v = nodes[nextInt() - 1];

                edges[i] = new Edge(i, u, v);
                u.edges.add(edges[i]);
                v.edges.add(edges[i]);
            }

            solve(n, m, nodes.clone());

            printf("Case #%d:", test);

            for (Edge edge : edges) {
                print(' ');
                print(max(1, abs(edge.u.time - edge.v.time)));
            }

            println();
        }
    }

    public static boolean nextPermutation(int[] permutation) {
        int n = permutation.length, a = n - 2;
        while (0 <= a && permutation[a] >= permutation[a + 1]) {
            a--;
        }
        if (a == -1) {
            return false;
        }

        int b = n - 1;
        while (permutation[b] <= permutation[a]) {
            b--;
        }

        swap(permutation, a, b);
        for (int i = a + 1, j = n - 1; i < j; i++, j--) {
            swap(permutation, i, j);
        }
        return true;
    }

    public static void swap(int[] array, int i, int j) {
        if (i == j) {
            return;
        }
        array[i] ^= array[j];
        array[j] ^= array[i];
        array[i] ^= array[j];
    }

    String next() {
        while (!tokenizer.hasMoreTokens())
            tokenizer = new StringTokenizer(nextLine());
        return tokenizer.nextToken();
    }

    boolean hasNext() {
        while (!tokenizer.hasMoreTokens()) {
            String line = nextLine();
            if (line == null) {
                return false;
            }
            tokenizer = new StringTokenizer(line);
        }
        return true;
    }

    int[] nextArray(int n) {
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = nextInt();
        }
        return array;
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

    String nextLine() {
        try {
            return reader.readLine();
        } catch (IOException err) {
            return null;
        }
    }

    public Solution(OutputStream outputStream) {
        super(outputStream);
    }

    static BufferedReader reader;
    static StringTokenizer tokenizer = new StringTokenizer("");
    static Random rnd = new Random();

    public static void main(String[] args) throws IOException {
        reader = new BufferedReader(new InputStreamReader(System.in));
        Solution solution = new Solution(System.out);
        solution.run();
        solution.close();
        reader.close();
    }
}