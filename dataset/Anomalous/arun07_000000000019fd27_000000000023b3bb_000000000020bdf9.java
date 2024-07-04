import java.util.LinkedList;
import java.util.Scanner;

class BipartiteGraphChecker {
    private int vertexCount;
    private int[][] graph;
    private int[] colorArray;

    public BipartiteGraphChecker(int[][] graph) {
        this.vertexCount = graph.length;
        this.graph = graph;
        this.colorArray = new int[vertexCount];
    }

    private boolean isBipartiteFromSource(int src) {
        colorArray[src] = 1;
        LinkedList<Integer> queue = new LinkedList<>();
        queue.add(src);

        while (!queue.isEmpty()) {
            int u = queue.poll();

            if (graph[u][u] == 1) return false;

            for (int v = 0; v < vertexCount; v++) {
                if (graph[u][v] == 1 && colorArray[v] == -1) {
                    colorArray[v] = 1 - colorArray[u];
                    queue.add(v);
                } else if (graph[u][v] == 1 && colorArray[v] == colorArray[u]) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isBipartite() {
        for (int i = 0; i < vertexCount; i++) colorArray[i] = -1;

        for (int i = 0; i < vertexCount; i++) {
            if (colorArray[i] == -1 && !isBipartiteFromSource(i)) return false;
        }
        return true;
    }

    public int[] getColorArray() {
        return colorArray;
    }
}

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int t = 1; t <= testCases; t++) {
            int n = scanner.nextInt();
            int[][] intervals = new int[n][2];

            for (int i = 0; i < n; i++) {
                intervals[i][0] = scanner.nextInt();
                intervals[i][1] = scanner.nextInt();
            }

            int[][] adjacencyMatrix = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    if (intervals[i][1] > intervals[j][0] && intervals[j][1] > intervals[i][0]) {
                        adjacencyMatrix[i][j] = adjacencyMatrix[j][i] = 1;
                    }
                }
            }

            BipartiteGraphChecker checker = new BipartiteGraphChecker(adjacencyMatrix);
            boolean isBipartite = checker.isBipartite();
            StringBuilder result = new StringBuilder("Case #" + t + ": ");

            if (!isBipartite) {
                result.append("IMPOSSIBLE");
            } else {
                int[] colors = checker.getColorArray();
                for (int color : colors) {
                    result.append(color == 1 ? 'J' : 'C');
                }
            }
            System.out.println(result.toString());
        }
        scanner.close();
    }
}