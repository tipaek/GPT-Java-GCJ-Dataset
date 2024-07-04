import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int i = 1; i <= t; ++i) {
            int n = Integer.parseInt(br.readLine());
            int[][] points = new int[n][2];

            for (int j = 0; j < n; j++) {
                String[] arr = br.readLine().split(" ");
                points[j][0] = Integer.parseInt(arr[0]);
                points[j][1] = Integer.parseInt(arr[1]);
            }

            int[][] graph = createGraph(points, n);

            boolean[] visited = new boolean[n];
            int[] color = new int[n];

            boolean isBipartite = checkBipartite(graph, visited, color, n);

            if (!isBipartite) {
                System.out.println("Case #" + i + ": IMPOSSIBLE");
            } else {
                StringBuilder result = new StringBuilder();
                for (int v = 0; v < n; v++) {
                    result.append(color[v] == 1 ? "C" : "J");
                }
                System.out.println("Case #" + i + ": " + result.toString());
            }
        }
    }

    private static int[][] createGraph(int[][] points, int n) {
        int[][] graph = new int[n][n];
        for (int v = 0; v < n; v++) {
            for (int w = 0; w < n; w++) {
                if (v != w && overlap(points[v], points[w])) {
                    graph[v][w] = 1;
                }
            }
        }
        return graph;
    }

    private static boolean checkBipartite(int[][] graph, boolean[] visited, int[] color, int n) {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(0);
        color[0] = 1;

        while (!queue.isEmpty()) {
            int curr = queue.remove();
            int currentColor = color[curr];

            for (int w = 0; w < n; w++) {
                if (graph[curr][w] == 1) {
                    if (visited[w]) {
                        if (color[w] == currentColor) {
                            return false;
                        }
                    } else {
                        visited[w] = true;
                        color[w] = (currentColor == 1) ? 2 : 1;
                        queue.add(w);
                    }
                }
            }
        }
        return true;
    }

    private static boolean overlap(int[] first, int[] second) {
        if (first[0] > second[0]) return overlap(second, first);
        return first[1] > second[0];
    }
}