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

    static boolean[][] visited;
    static int[][] result;
    static int[] distance;
    static ArrayList<Integer>[] adjacencyList;

    static void solve(ArrayList<Integer> nodes, ArrayList<Edge> edges, int currentCost) {
        ArrayList<Edge> newEdges = new ArrayList<>();
        for (int node : nodes) {
            for (Edge edge : edges) {
                if (edge.cost != -1) continue;
                if (edge.from == node || edge.to == node) {
                    int otherNode = edge.from + edge.to - node;
                    int calculatedCost = currentCost - distance[otherNode];
                    edge.cost = calculatedCost;
                    distance[node] = currentCost;
                    result[otherNode][node] = calculatedCost;
                    result[node][otherNode] = calculatedCost;
                    for (int adjacent : adjacencyList[node]) {
                        if (!visited[adjacent][node]) {
                            newEdges.add(new Edge(adjacent, node));
                            visited[adjacent][node] = true;
                            visited[node][adjacent] = true;
                        }
                    }
                    break;
                }
            }
        }
        currentCost++;
        edges.addAll(0, newEdges);
    }

    public static void main(String[] args) {
        InputReader reader = new InputReader(System.in);
        int testCases = reader.nextInt();
        int testCaseNumber = 1;

        while (testCases-- > 0) {
            int n = reader.nextInt();
            int m = reader.nextInt();
            int[] values = new int[n - 1];
            TreeMap<Integer, ArrayList<Integer>> negativeMap = new TreeMap<>();
            TreeMap<Integer, Integer> positiveMap = new TreeMap<>();

            for (int i = 0; i < values.length; i++) {
                int x = reader.nextInt();
                if (x < 0) {
                    values[i] = -x;
                    negativeMap.computeIfAbsent(values[i], k -> new ArrayList<>()).add(i + 1);
                } else {
                    positiveMap.put(x, i + 1);
                }
            }

            adjacencyList = new ArrayList[n];
            for (int i = 0; i < n; i++) {
                adjacencyList[i] = new ArrayList<>();
            }

            ArrayList<Edge> solutionEdges = new ArrayList<>();
            for (int i = 0; i < m; i++) {
                int from = reader.nextInt() - 1;
                int to = reader.nextInt() - 1;
                adjacencyList[from].add(to);
                adjacencyList[to].add(from);
                solutionEdges.add(new Edge(from, to));
            }

            result = new int[n][n];
            for (int[] row : result) {
                Arrays.fill(row, 1000000);
            }

            ArrayList<Edge> edges = new ArrayList<>();
            visited = new boolean[n][n];
            for (int adjacent : adjacencyList[0]) {
                edges.add(new Edge(0, adjacent));
                visited[0][adjacent] = true;
                visited[adjacent][0] = true;
            }

            int currentCost = 1;
            distance = new int[n];
            int processedNodes = 1;

            for (Entry<Integer, ArrayList<Integer>> entry : negativeMap.entrySet()) {
                int key = entry.getKey();
                ArrayList<Integer> nodes = entry.getValue();

                while (processedNodes < key) {
                    ArrayList<Integer> tempNodes = new ArrayList<>();
                    Entry<Integer, Integer> firstEntry = positiveMap.pollFirstEntry();
                    tempNodes.add(firstEntry.getValue());
                    int cost = firstEntry.getKey();

                    while (true) {
                        Entry<Integer, Integer> nextEntry = positiveMap.firstEntry();
                        if (nextEntry != null && nextEntry.getKey() == cost) {
                            nextEntry = positiveMap.pollFirstEntry();
                            tempNodes.add(nextEntry.getValue());
                        } else {
                            break;
                        }
                    }

                    if (processedNodes + tempNodes.size() <= key) {
                        solve(tempNodes, edges, cost);
                        currentCost = cost + 1;
                        processedNodes += tempNodes.size();
                    } else {
                        nodes.addAll(tempNodes);
                        currentCost = cost;
                        break;
                    }
                }

                solve(nodes, edges, currentCost);
                processedNodes += nodes.size();
                currentCost++;
            }

            System.out.printf("Case #%d:", testCaseNumber++);
            for (Edge edge : solutionEdges) {
                System.out.print(" " + result[edge.from][edge.to]);
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