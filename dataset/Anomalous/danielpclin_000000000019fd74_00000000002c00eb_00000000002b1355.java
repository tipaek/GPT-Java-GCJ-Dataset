import java.util.*;
import java.io.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
            int T = scanner.nextInt();
            for (int t = 1; t <= T; ++t) {
                System.out.print("Case #" + t + ": ");
                int R = scanner.nextInt();
                int C = scanner.nextInt();
                int[][] matrix = new int[R][C];
                int[][][] count = new int[R][C][2];
                int totalCells = R * C, score = 0;
                Set<Integer> aliveCells = IntStream.range(0, totalCells).boxed().collect(Collectors.toSet());

                for (int i = 0; i < R; i++) {
                    for (int j = 0; j < C; j++) {
                        matrix[i][j] = scanner.nextInt();
                        updateNeighbors(count, matrix, i, j, R, C);
                    }
                }

                while (true) {
                    int currentAliveCount = aliveCells.size();
                    List<Integer> toRemove = new ArrayList<>();

                    for (int cell : aliveCells) {
                        int r = cell / C, c = cell % C;
                        score += matrix[r][c];
                        if (count[r][c][0] > matrix[r][c] * count[r][c][1]) {
                            toRemove.add(cell);
                        }
                    }

                    for (int cell : toRemove) {
                        int r = cell / C, c = cell % C;
                        updateCountForRemoval(count, matrix, aliveCells, cell, r, c, R, C);
                    }

                    aliveCells.removeAll(toRemove);
                    if (aliveCells.size() == currentAliveCount) {
                        break;
                    }
                }

                System.out.println(score);
            }
        }
    }

    private static void updateNeighbors(int[][][] count, int[][] matrix, int i, int j, int R, int C) {
        if (i - 1 >= 0) {
            count[i - 1][j][0] += matrix[i][j];
            count[i - 1][j][1]++;
        }
        if (i + 1 < R) {
            count[i + 1][j][0] += matrix[i][j];
            count[i + 1][j][1]++;
        }
        if (j - 1 >= 0) {
            count[i][j - 1][0] += matrix[i][j];
            count[i][j - 1][1]++;
        }
        if (j + 1 < C) {
            count[i][j + 1][0] += matrix[i][j];
            count[i][j + 1][1]++;
        }
    }

    private static void updateCountForRemoval(int[][][] count, int[][] matrix, Set<Integer> aliveCells, int cell, int r, int c, int R, int C) {
        updateDirection(count, matrix, aliveCells, cell, r, c, R, C, -C, R * C);
        updateDirection(count, matrix, aliveCells, cell, r, c, R, C, C, R * C);
        updateDirection(count, matrix, aliveCells, cell, r, c, R, C, -1, c);
        updateDirection(count, matrix, aliveCells, cell, r, c, R, C, 1, C - c - 1);
    }

    private static void updateDirection(int[][][] count, int[][] matrix, Set<Integer> aliveCells, int cell, int r, int c, int R, int C, int step, int limit) {
        int idx = cell;
        while ((idx += step) >= 0 && idx < R * C && (idx - cell) / step <= limit) {
            if (aliveCells.contains(idx)) {
                count[idx / C][idx % C][0] -= matrix[r][c];
                count[idx / C][idx % C][1]--;
                int new_idx = cell;
                while ((new_idx -= step) >= 0 && new_idx < R * C && (cell - new_idx) / step <= limit) {
                    if (aliveCells.contains(new_idx)) {
                        count[idx / C][idx % C][0] += matrix[new_idx / C][new_idx % C];
                        count[idx / C][idx % C][1]++;
                        break;
                    }
                }
                break;
            }
        }
    }
}