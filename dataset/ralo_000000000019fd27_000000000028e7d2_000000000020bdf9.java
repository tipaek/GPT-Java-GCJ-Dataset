import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        try (PrintWriter out = new PrintWriter(System.out)) {
            FastReader in = new FastReader(System.in);
            Task.solve(in, out);
        }
    }

    static class Task {
        public static void solve(FastReader in, PrintWriter out) {
            int t = in.nextInt();

            for (int x = 1; x <= t; x++) {
                int n = in.nextInt();

                boolean isImpossible = false;
                StringBuilder sb = new StringBuilder();
                Node nodeC = null;
                Node nodeJ = null;

                for (int i = 0; i < n; i++) {
                    Interval activity = new Interval(in.nextInt(), in.nextInt());
                    if (i == 0) {
                        nodeC = insert(null, activity);
                        sb.append("C");
                    } else {
                        Interval res = search(nodeC, activity);
                        if (res != null) {
                            Interval resJ = search(nodeJ, activity);
                            if (resJ != null) {
                                isImpossible = true;
                            } else {
                                nodeJ = insert(nodeJ, activity);
                                sb.append("J");
                            }
                        } else {
                            nodeC = insert(nodeC, activity);
                            sb.append("C");
                        }
                    }
                }
                out.printf("Case #%d: %s\n", x, (isImpossible ? "IMPOSSIBLE" : sb.toString()));
            }
        }

        static Node insert(Node node, Interval interval) {
            if (node == null) {
                return new Node(interval);
            }
            int low = node.interval.start;
            if (node.low() < low) {
                node.left = insert(node.left, interval);
            } else {
                node.right = insert(node.right, interval);
            }
            node.max = Math.max(node.max, interval.end);
            return node;
        }

        static Interval search(Node node, Interval interval) {
            if (node == null) return null;

            if (node.interval.isConflict(interval)) {
                return node.interval;
            }

            if (node.left != null && node.left.max >= interval.start) {
                return search(node.left, interval);
            }
            return search(node.right, interval);
        }
    }

    static class Node {
        private Interval interval;
        private Node left;
        private Node right;
        private int max;

        Node(Interval interval) {
            this.interval = interval;
            this.max = interval.end;
        }

        int low() {
            return interval.start;
        }

    }

    static class Interval {
        int start;
        int end;

        Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }

        boolean isConflict(Interval interval) {
            return start < interval.end && interval.start < end;
        }
    }

    static class FastReader {
        BufferedReader reader;
        StringTokenizer tokenizer;

        public FastReader(InputStream f) {
            reader = new BufferedReader(new InputStreamReader(f), 32768);
        }

        String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }
}
