import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(System.out);

        int testCases = Integer.parseInt(reader.readLine());

        for (int t = 1; t <= testCases; t++) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());

            int n = Integer.parseInt(tokenizer.nextToken());
            int m = Integer.parseInt(tokenizer.nextToken());

            int[] ranks = new int[n + 1];
            ranks[1] = 0;
            tokenizer = new StringTokenizer(reader.readLine());
            for (int i = 2; i <= n; i++) {
                ranks[i] = -Integer.parseInt(tokenizer.nextToken());
            }

            List<List<Edge>> adjacencyList = new ArrayList<>(n + 1);
            for (int i = 0; i <= n; i++) {
                adjacencyList.add(new ArrayList<>());
            }

            for (int i = 0; i < m; i++) {
                tokenizer = new StringTokenizer(reader.readLine());

                int a = Integer.parseInt(tokenizer.nextToken());
                int b = Integer.parseInt(tokenizer.nextToken());

                adjacencyList.get(a).add(new Edge(b, i));
                adjacencyList.get(b).add(new Edge(a, i));
            }

            PriorityQueue<Node> priorityQueue = new PriorityQueue<>();
            boolean[] visited = new boolean[n + 1];
            priorityQueue.add(new Node(1, ranks[1]));
            visited[1] = true;

            int[] results = new int[m];
            while (!priorityQueue.isEmpty()) {
                Node currentNode = priorityQueue.poll();

                for (Edge edge : adjacencyList.get(currentNode.vertex)) {
                    if (visited[edge.to]) {
                        results[edge.index] = ranks[currentNode.vertex] - ranks[edge.to];
                        break;
                    }
                }

                for (Edge edge : adjacencyList.get(currentNode.vertex)) {
                    if (!visited[edge.to]) {
                        visited[edge.to] = true;
                        priorityQueue.add(new Node(edge.to, ranks[edge.to]));
                    }
                }
            }

            StringJoiner resultJoiner = new StringJoiner(" ");
            for (int i = 0; i < m; i++) {
                if (results[i] == 0) {
                    resultJoiner.add("1000000");
                } else {
                    resultJoiner.add(String.valueOf(results[i]));
                }
            }

            writer.println("Case #" + t + ": " + resultJoiner.toString());
        }

        writer.close();
    }

    static class Node implements Comparable<Node> {
        int vertex;
        int rank;

        Node(int vertex, int rank) {
            this.vertex = vertex;
            this.rank = rank;
        }

        @Override
        public int compareTo(Node other) {
            return Integer.compare(this.rank, other.rank);
        }
    }

    static class Edge {
        int to;
        int index;

        Edge(int to, int index) {
            this.to = to;
            this.index = index;
        }
    }
}