import java.util.*;
import java.io.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
            int testCases = scanner.nextInt();
            for (int t = 1; t <= testCases; t++) {
                System.out.print("Case #" + t + ": ");
                int rows = scanner.nextInt();
                int cols = scanner.nextInt();
                int[][] matrix = new int[rows][cols];
                int[][][] neighborCounts = new int[rows][cols][2];
                int totalCells = rows * cols;
                int score = 0;
                Set<Integer> activeCells = IntStream.range(0, totalCells).boxed().collect(Collectors.toSet());

                for (int i = 0; i < rows; i++) {
                    for (int j = 0; j < cols; j++) {
                        matrix[i][j] = scanner.nextInt();
                        updateNeighborCounts(matrix, neighborCounts, i, j, rows, cols);
                    }
                }

                while (true) {
                    int previousSize = activeCells.size();
                    List<Integer> toRemove = new ArrayList<>();

                    for (int cell : activeCells) {
                        int r = cell / cols;
                        int c = cell % cols;
                        score += matrix[r][c];
                        if ((double) neighborCounts[r][c][0] / neighborCounts[r][c][1] > matrix[r][c]) {
                            toRemove.add(cell);
                        }
                    }

                    if (toRemove.isEmpty()) break;

                    for (int cell : toRemove) {
                        int r = cell / cols;
                        int c = cell % cols;
                        updateNeighborCells(matrix, neighborCounts, activeCells, r, c, rows, cols);
                    }
                    activeCells.removeAll(toRemove);

                    if (previousSize == activeCells.size()) break;
                }
                System.out.println(score);
            }
        }
    }

    private static void updateNeighborCounts(int[][] matrix, int[][][] neighborCounts, int i, int j, int rows, int cols) {
        if (i - 1 >= 0) {
            neighborCounts[i - 1][j][0] += matrix[i][j];
            neighborCounts[i - 1][j][1]++;
        }
        if (i + 1 < rows) {
            neighborCounts[i + 1][j][0] += matrix[i][j];
            neighborCounts[i + 1][j][1]++;
        }
        if (j - 1 >= 0) {
            neighborCounts[i][j - 1][0] += matrix[i][j];
            neighborCounts[i][j - 1][1]++;
        }
        if (j + 1 < cols) {
            neighborCounts[i][j + 1][0] += matrix[i][j];
            neighborCounts[i][j + 1][1]++;
        }
    }

    private static void updateNeighborCells(int[][] matrix, int[][][] neighborCounts, Set<Integer> activeCells, int r, int c, int rows, int cols) {
        int cell = r * cols + c;
        updateVerticalNeighbors(matrix, neighborCounts, activeCells, r, c, rows, cols, cell, -1);
        updateVerticalNeighbors(matrix, neighborCounts, activeCells, r, c, rows, cols, cell, 1);
        updateHorizontalNeighbors(matrix, neighborCounts, activeCells, r, c, rows, cols, cell, -1);
        updateHorizontalNeighbors(matrix, neighborCounts, activeCells, r, c, rows, cols, cell, 1);
    }

    private static void updateVerticalNeighbors(int[][] matrix, int[][][] neighborCounts, Set<Integer> activeCells, int r, int c, int rows, int cols, int cell, int direction) {
        int idx = cell;
        while ((idx += direction * cols) >= 0 && idx < rows * cols) {
            if (activeCells.contains(idx)) {
                int newR = idx / cols;
                neighborCounts[newR][c][0] -= matrix[r][c];
                neighborCounts[newR][c][1]--;
                int newIdx = cell;
                while ((newIdx -= direction * cols) >= 0 && newIdx < rows * cols) {
                    if (activeCells.contains(newIdx)) {
                        neighborCounts[newR][c][0] += matrix[newIdx / cols][newIdx % cols];
                        neighborCounts[newR][c][1]++;
                        break;
                    }
                }
                break;
            }
        }
    }

    private static void updateHorizontalNeighbors(int[][] matrix, int[][][] neighborCounts, Set<Integer> activeCells, int r, int c, int rows, int cols, int cell, int direction) {
        int cIdx = c;
        while ((cIdx += direction) >= 0 && cIdx < cols) {
            if (activeCells.contains(r * cols + cIdx)) {
                neighborCounts[r][cIdx][0] -= matrix[r][c];
                neighborCounts[r][cIdx][1]--;
                int newCIdx = c;
                while ((newCIdx -= direction) >= 0 && newCIdx < cols) {
                    if (activeCells.contains(r * cols + newCIdx)) {
                        neighborCounts[r][cIdx][0] += matrix[r][newCIdx];
                        neighborCounts[r][cIdx][1]++;
                        break;
                    }
                }
                break;
            }
        }
    }
}