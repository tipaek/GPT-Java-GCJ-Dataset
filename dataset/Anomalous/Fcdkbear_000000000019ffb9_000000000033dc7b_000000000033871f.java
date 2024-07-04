import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public class Solution {

    private static final int INF = 1000000;

    private static class Node {
        int number;
        int value;

        Node(int number, int value) {
            this.number = number;
            this.value = value;
        }
    }

    private static class Edge {
        int from;
        int to;
        int length;

        Edge(int from, int to) {
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
            
            knownCount.sort(Comparator.comparingInt(n1 -> n1.value));
            knownDistance.sort(Comparator.comparingInt(n1 -> n1.value));
            
            List<Edge> edges = new ArrayList<>();
            List<List<Integer>> adjacentEdges = new ArrayList<>(Collections.nCopies(n, new ArrayList<>()));
            
            for (int i = 0; i < m; ++i) {
                int l = in.nextInt() - 1;
                int r = in.nextInt() - 1;
                edges.add(new Edge(l, r));
                adjacentEdges.get(l).add(i);
                adjacentEdges.get(r).add(i);
            }
            
            int index1 = knownCount.size() - 1;
            int lastUsedDistance = INF;
            List<Boolean> processed = new ArrayList<>(Collections.nCopies(n, false));
            List<Integer> distance = new ArrayList<>(Collections.nCopies(n, 0));
            
            processed.set(0, true);
            for (Node node : knownDistance) {
                distance.set(node.number, node.value);
            }
            
            while (index1 >= 0) {
                int oldIndex1 = index1;
                while (index1 > 0 && knownCount.get(index1 - 1).value == knownCount.get(index1).value) {
                    index1--;
                }
                
                int lessThanMe = index1 + 1;
                int needOthers = knownCount.get(index1).value - lessThanMe;
                int maxAllowed = lastUsedDistance - 1;
                
                if (needOthers < knownDistance.size()) {
                    if (needOthers == 0 || knownDistance.get(needOthers).value - knownDistance.get(needOthers - 1).value > 1) {
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
            knownDistance.sort(Comparator.comparingInt(n1 -> n1.value));
            
            for (Node node : knownDistance) {
                int nodeIndex = node.number;
                for (Integer neighbour : adjacentEdges.get(nodeIndex)) {
                    Edge edge = edges.get(neighbour);
                    int to = edge.to == nodeIndex ? edge.from : edge.to;
                    if (distance.get(to) < distance.get(nodeIndex)) {
                        edge.length = distance.get(nodeIndex) - distance.get(to);
                        break;
                    }
                }
            }
            
            out.printf("Case #%d:", testNumber);
            for (Edge edge : edges) {
                out.printf(" %d", edge.length);
            }
            out.println();
            out.flush();
        }
        out.close();
    }

    private static class InputReader {
        private BufferedReader reader;
        private StringTokenizer tokenizer;

        InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
            tokenizer = null;
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

        long nextLong() {
            return Long.parseLong(next());
        }
    }
}