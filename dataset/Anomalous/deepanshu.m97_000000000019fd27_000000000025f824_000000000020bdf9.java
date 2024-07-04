import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(reader.readLine());

        for (int t = 1; t <= testCases; ++t) {
            int numPoints = Integer.parseInt(reader.readLine());
            int[][] points = new int[numPoints][2];

            for (int i = 0; i < numPoints; i++) {
                String[] input = reader.readLine().split(" ");
                points[i][0] = Integer.parseInt(input[0]);
                points[i][1] = Integer.parseInt(input[1]);
            }

            int[][] adjacencyMatrix = new int[numPoints][numPoints];
            for (int i = 0; i < numPoints; i++) {
                for (int j = 0; j < numPoints; j++) {
                    if (i == j) continue;
                    if (doOverlap(points[i], points[j])) {
                        adjacencyMatrix[i][j] = 1;
                    }
                }
            }

            boolean[] visited = new boolean[numPoints];
            int[] colors = new int[numPoints];
            boolean isBipartite = true;

            for (int i = 0; i < numPoints; i++) {
                if (visited[i]) continue;

                Queue<Integer> queue = new ArrayDeque<>();
                queue.add(i);
                colors[i] = 1;

                while (!queue.isEmpty()) {
                    int current = queue.poll();
                    int currentColor = colors[current];

                    for (int j = 0; j < numPoints; j++) {
                        if (adjacencyMatrix[current][j] == 1) {
                            if (visited[j] && colors[j] != currentColor) {
                                continue;
                            } else if (visited[j] && colors[j] == currentColor) {
                                isBipartite = false;
                                break;
                            } else {
                                visited[j] = true;
                                colors[j] = (currentColor == 1) ? 2 : 1;
                                queue.add(j);
                            }
                        }
                    }
                }
            }

            if (!isBipartite) {
                System.out.println("Case #" + t + ": IMPOSSIBLE");
            } else {
                StringBuilder result = new StringBuilder();
                for (int color : colors) {
                    result.append(color == 1 ? "C" : "J");
                }
                System.out.println("Case #" + t + ": " + result);
            }
        }
    }

    private static boolean doOverlap(int[] first, int[] second) {
        if (first[0] > second[0]) return doOverlap(second, first);
        return first[1] > second[0];
    }
}