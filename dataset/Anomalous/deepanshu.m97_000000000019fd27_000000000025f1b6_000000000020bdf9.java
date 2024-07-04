import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(reader.readLine());

        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
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
                    if (i != j && doOverlap(points[i], points[j])) {
                        adjacencyMatrix[i][j] = 1;
                    }
                }
            }

            boolean[] visited = new boolean[numPoints];
            int[] colors = new int[numPoints];
            Queue<Integer> queue = new ArrayDeque<>();
            queue.add(0);
            colors[0] = 1;

            boolean isBipartiteGraph = true;
            while (!queue.isEmpty() && isBipartiteGraph) {
                int current = queue.remove();
                int currentColor = colors[current];

                for (int j = 0; j < numPoints; j++) {
                    if (adjacencyMatrix[current][j] == 1) {
                        if (visited[j]) {
                            if (colors[j] == currentColor) {
                                isBipartiteGraph = false;
                                break;
                            }
                        } else {
                            visited[j] = true;
                            colors[j] = (currentColor == 1) ? 2 : 1;
                            queue.add(j);
                        }
                    }
                }
            }

            if (!isBipartiteGraph) {
                System.out.println("Case #" + caseNumber + ": IMPOSSIBLE");
            } else {
                StringBuilder result = new StringBuilder();
                for (int color : colors) {
                    result.append(color == 1 ? "C" : "J");
                }
                System.out.println("Case #" + caseNumber + ": " + result);
            }
        }
    }

    private static boolean doOverlap(int[] interval1, int[] interval2) {
        if (interval1[0] > interval2[0]) {
            return doOverlap(interval2, interval1);
        }
        return interval1[1] > interval2[0];
    }
}