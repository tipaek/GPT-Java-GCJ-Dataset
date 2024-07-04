import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    static final int INF = 1000000;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int t = 1; t <= testCases; t++) {
            int C = scanner.nextInt();
            int D = scanner.nextInt();
            int[] cs = new int[C];

            for (int i = 1; i < C; i++) {
                cs[i] = scanner.nextInt();
            }

            ArrayList<Edge>[] adjacencyList = new ArrayList[C];
            for (int i = 0; i < C; i++) {
                adjacencyList[i] = new ArrayList<>();
            }

            int[] results = new int[D];
            Arrays.fill(results, INF);

            for (int i = 0; i < D; i++) {
                int u = scanner.nextInt() - 1;
                int v = scanner.nextInt() - 1;
                adjacencyList[u].add(new Edge(v, i));
                adjacencyList[v].add(new Edge(u, i));
            }

            ArrayDeque<Integer> queue = new ArrayDeque<>();
            queue.offer(0);

            for (int wave = 1; wave <= C; wave++) {
                ArrayDeque<Integer> nextQueue = new ArrayDeque<>();
                while (!queue.isEmpty()) {
                    int current = queue.poll();
                    for (Edge edge : adjacencyList[current]) {
                        if (results[edge.index] != INF) {
                            continue;
                        }
                        if (cs[edge.vertex] == -wave) {
                            if (cs[edge.vertex] == cs[current]) {
                                results[edge.index] = 1;
                            } else {
                                results[edge.index] = 100;
                            }
                            queue.offer(edge.vertex);
                            nextQueue.offer(edge.vertex);
                        }
                    }
                }
                if (!nextQueue.isEmpty()) {
                    queue = nextQueue;
                }
            }

            System.out.printf("Case #%d:", t);
            for (int result : results) {
                System.out.print(" " + result);
            }
            System.out.println();
        }
    }

    static class Edge {
        int vertex, index;

        public Edge(int vertex, int index) {
            this.vertex = vertex;
            this.index = index;
        }
    }
}