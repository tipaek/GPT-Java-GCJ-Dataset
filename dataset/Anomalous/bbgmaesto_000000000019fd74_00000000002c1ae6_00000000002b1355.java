import java.util.*;
import java.io.*;

public class Solution {
    private static int[][] floor;
    private static int C;
    private static int R;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine().trim());

        for (int test = 0; test < t; test++) {
            StringTokenizer dimensions = new StringTokenizer(in.readLine());
            R = Integer.parseInt(dimensions.nextToken());
            C = Integer.parseInt(dimensions.nextToken());

            floor = new int[R][C];
            for (int i = 0; i < R; i++) {
                StringTokenizer rowTokens = new StringTokenizer(in.readLine());
                for (int j = 0; j < C; j++) {
                    floor[i][j] = Integer.parseInt(rowTokens.nextToken());
                }
            }

            int interestLevel = 0;
            boolean hasChanges = true;

            while (hasChanges) {
                List<int[]> toRemove = new ArrayList<>();
                for (int i = 0; i < R; i++) {
                    for (int j = 0; j < C; j++) {
                        if (floor[i][j] == 0) continue;

                        interestLevel += floor[i][j];
                        List<Integer> neighbors = getNeighbors(i, j);

                        if (!neighbors.isEmpty() && floor[i][j] < calculateAverage(neighbors)) {
                            toRemove.add(new int[]{i, j});
                        }
                    }
                }

                if (toRemove.isEmpty()) {
                    hasChanges = false;
                } else {
                    for (int[] cell : toRemove) {
                        floor[cell[0]][cell[1]] = 0;
                    }
                }
            }

            System.out.println("Case #" + (test + 1) + ": " + interestLevel);
        }
    }

    private static List<Integer> getNeighbors(int i, int j) {
        List<Integer> neighbors = new ArrayList<>();
        addNeighbor(neighbors, i + 1, j, R, C, 1, 0);
        addNeighbor(neighbors, i - 1, j, R, C, -1, 0);
        addNeighbor(neighbors, i, j + 1, R, C, 0, 1);
        addNeighbor(neighbors, i, j - 1, R, C, 0, -1);
        return neighbors;
    }

    private static void addNeighbor(List<Integer> neighbors, int i, int j, int maxR, int maxC, int di, int dj) {
        while (i >= 0 && i < maxR && j >= 0 && j < maxC) {
            if (floor[i][j] != 0) {
                neighbors.add(floor[i][j]);
                break;
            }
            i += di;
            j += dj;
        }
    }

    private static float calculateAverage(List<Integer> values) {
        float sum = 0;
        for (int value : values) {
            sum += value;
        }
        return sum / values.size();
    }
}