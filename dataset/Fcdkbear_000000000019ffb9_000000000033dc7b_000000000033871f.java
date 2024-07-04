import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;
import java.util.function.Function;

public class Solution {

    public static final int INF = 1000000;

    static class Node {
        public int number;
        public int value;

        public Node(int number, int value) {
            this.number = number;
            this.value = value;
        }
    }

    static class Edge {
        public int from;
        public int to;
        public int length;

        public Edge(int from, int to) {
            this.from = from;
            this.to = to;
            this.length = INF;
        }
    }

    public static void main(String[] args) {

        InputReader in = new InputReader(System.in);
        PrintWriter out = new PrintWriter(System.out);
        int tests = in.nextInt();
        for (int testNumber = 1; testNumber <= tests; ++testNumber) {
            int n = in.nextInt();
            int m = in.nextInt();
            List<Node> knownCount = new ArrayList<>();
            List<Node> knownDistance = new ArrayList<>();
            for (int i = 1; i < n; ++i) {
                int x = in.nextInt();
                if (x < 0) {
                    knownCount.add(new Node(i, -x));
                } else {
                    knownDistance.add(new Node(i, x));
                }
            }
            knownCount.sort((n1, n2) -> (n1.value - n2.value));
            knownDistance.sort((n1, n2) -> (n1.value - n2.value));
            List<Edge> edges = new ArrayList<>();
            List<List<Integer>> adjacentEdges = new ArrayList<>();
            for (int i = 0; i < n; ++i) {
                adjacentEdges.add(new ArrayList<>());
            }
            for (int i = 0; i < m; ++i) {
                int l = in.nextInt();
                int r = in.nextInt();
                l--;
                r--;
                edges.add(new Edge(l, r));
                adjacentEdges.get(l).add(i);
                adjacentEdges.get(r).add(i);
            }
            int index1 = knownCount.size();
            index1--;
            int lastUsedDistance = INF;
            List<Boolean> processed = new ArrayList<>();
            List<Integer> distance = new ArrayList<>();
            processed.add(true);
            for (int i = 0; i < n - 1; ++i) {
                processed.add(false);
            }
            for (int i = 0; i < n; ++i) {
                distance.add(0);
            }
            for (int i = 0; i < knownDistance.size(); ++i) {
                distance.set(knownDistance.get(i).number, knownDistance.get(i).value);
            }
            while (index1 >= 0) {
                int oldIndex1 = index1;
                while ((index1 - 1 >= 0) && (knownCount.get(index1 - 1).value == knownCount.get(index1).value)) {
                    index1--;
                }
                int lessThanMe = 1 + index1;
                int needOthers = knownCount.get(index1).value - lessThanMe;
                int maxAllowed = lastUsedDistance - 1;
                if (needOthers < knownDistance.size()) {
                    if ((needOthers == 0) || (knownDistance.get(needOthers).value - knownDistance.get(needOthers - 1).value > 1)) {
                        maxAllowed = Math.min(maxAllowed, knownDistance.get(needOthers).value - 1);
                    } else {
                        maxAllowed = Math.min(maxAllowed, knownDistance.get(needOthers).value);
                    }
                }
                for (int i = index1; i <= oldIndex1; ++i) {
                    distance.set(knownCount.get(i).number, maxAllowed);
                }
                lastUsedDistance = maxAllowed;
                index1--;
            }
            knownDistance.clear();
            for (int i = 0; i < n; ++i) {
                knownDistance.add(new Node(i, distance.get(i)));
            }
            knownDistance.sort((n1, n2) -> (n1.value - n2.value));
            for (int i = 0; i < n; ++i) {
                int node = knownDistance.get(i).number;
                for (Integer neighbour : adjacentEdges.get(node)) {
                    Edge edge = edges.get(neighbour);
                    int to = edge.to;
                    if (to == node) {
                        to = edge.from;
                    }
                    if (distance.get(to) < distance.get(node)) {
                        edge.length = distance.get(node) - distance.get(to);
                        break;
                    }
                }
            }
            out.printf("Case #%d:", testNumber);
            for (int i = 0; i < edges.size(); ++i) {
                out.printf(" %d", edges.get(i).length);
            }
            out.println();
            out.flush();
        }
        out.close();

    }

    static class InputReader {
        public BufferedReader reader;
        public StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
            tokenizer = null;
        }

        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }
        public long nextLong() {
            return Long.parseLong(next());
        }


    }
}
