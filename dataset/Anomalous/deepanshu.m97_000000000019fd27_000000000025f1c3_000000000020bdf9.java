package qualRound.ParentingPartneringReturns;

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
            int[][] intervals = new int[n][2];

            for (int j = 0; j < n; j++) {
                String[] input = br.readLine().split(" ");
                intervals[j][0] = Integer.parseInt(input[0]);
                intervals[j][1] = Integer.parseInt(input[1]);
            }

            int[][] conflictGraph = new int[n][n];
            for (int v = 0; v < n; v++) {
                for (int w = 0; w < n; w++) {
                    if (v != w && hasConflict(intervals[v], intervals[w])) {
                        conflictGraph[v][w] = 1;
                    }
                }
            }

            boolean[] visited = new boolean[n];
            int[] colors = new int[n];

            Queue<Integer> queue = new ArrayDeque<>();
            queue.add(0);
            colors[0] = 1;

            boolean isBipartite = true;
            while (!queue.isEmpty() && isBipartite) {
                int current = queue.poll();
                int currentColor = colors[current];

                for (int w = 0; w < n; w++) {
                    if (conflictGraph[current][w] == 1) {
                        if (!visited[w]) {
                            visited[w] = true;
                            colors[w] = (currentColor == 1) ? 2 : 1;
                            queue.add(w);
                        } else if (colors[w] == currentColor) {
                            isBipartite = false;
                            break;
                        }
                    }
                }
            }

            if (!isBipartite) {
                System.out.println("Case #" + i + ": IMPOSSIBLE");
            } else {
                StringBuilder result = new StringBuilder();
                for (int v = 0; v < n; v++) {
                    result.append(colors[v] == 1 ? "C" : "J");
                }
                System.out.println("Case #" + i + ": " + result.toString());
            }
        }
    }

    private static boolean hasConflict(int[] first, int[] second) {
        return first[0] < second[1] && first[1] > second[0];
    }
}