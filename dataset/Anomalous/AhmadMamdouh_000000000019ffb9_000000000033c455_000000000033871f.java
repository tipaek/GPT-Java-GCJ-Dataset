import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map.Entry;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Solution {
    static class Edge {
        int from, to, cost;

        public Edge(int from, int to) {
            this.from = from;
            this.to = to;
            this.cost = -1;
        }
    }

    public static void main(String[] args) {
        InputReader reader = new InputReader(System.in);
        int testCases = reader.nextInt();
        int testCaseNumber = 1;

        while (testCases-- > 0) {
            int n = reader.nextInt();
            int m = reader.nextInt();
            int[] costs = new int[n - 1];
            TreeMap<Integer, ArrayList<Integer>> costToNodesMap = new TreeMap<>();

            for (int i = 0; i < costs.length; i++) {
                costs[i] = -1 * reader.nextInt();
                costToNodesMap.computeIfAbsent(costs[i], k -> new ArrayList<>()).add(i + 1);
            }

            ArrayList<Integer>[] adjacencyList = new ArrayList[n];
            for (int i = 0; i < n; i++) {
                adjacencyList[i] = new ArrayList<>();
            }

            ArrayList<Edge> edges = new ArrayList<>();
            for (int i = 0; i < m; i++) {
                int from = reader.nextInt() - 1;
                int to = reader.nextInt() - 1;
                adjacencyList[from].add(to);
                adjacencyList[to].add(from);
                edges.add(new Edge(from, to));
            }

            int[][] results = new int[n][n];
            for (int[] row : results) {
                Arrays.fill(row, 1000000);
            }

            ArrayList<Edge> edgeQueue = new ArrayList<>();
            boolean[][] visited = new boolean[n][n];
            for (int neighbor : adjacencyList[0]) {
                edgeQueue.add(new Edge(0, neighbor));
                visited[0][neighbor] = true;
                visited[neighbor][0] = true;
            }

            int currentCost = 1;
            for (Entry<Integer, ArrayList<Integer>> entry : costToNodesMap.entrySet()) {
                ArrayList<Edge> newEdges = new ArrayList<>();
                for (int node : entry.getValue()) {
                    for (Edge edge : edgeQueue) {
                        if (edge.cost != -1) continue;
                        if (edge.from == node || edge.to == node) {
                            edge.cost = currentCost;
                            int otherNode = edge.from + edge.to - node;
                            results[otherNode][node] = currentCost;
                            results[node][otherNode] = currentCost;
                            for (int neighbor : adjacencyList[node]) {
                                if (!visited[neighbor][node]) {
                                    newEdges.add(new Edge(neighbor, node));
                                    visited[neighbor][node] = true;
                                    visited[node][neighbor] = true;
                                }
                            }
                            break;
                        }
                    }
                }
                currentCost++;
                edgeQueue.addAll(0, newEdges);
            }

            System.out.printf("Case #%d:", testCaseNumber++);
            for (Edge edge : edges) {
                System.out.print(" " + results[edge.from][edge.to]);
            }
            System.out.println();
        }
    }

    static class InputReader {
        private BufferedReader reader;
        private StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream));
            tokenizer = null;
        }

        public InputReader(FileReader stream) {
            reader = new BufferedReader(stream);
            tokenizer = null;
        }

        public String nextLine() {
            try {
                return reader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }
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

        public double nextDouble() {
            return Double.parseDouble(next());
        }
    }
}