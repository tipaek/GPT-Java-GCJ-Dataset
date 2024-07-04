import java.util.*;
import java.io.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
            int testCases = scanner.nextInt();
            for (int t = 1; t <= testCases; ++t) {
                System.out.print("Case #" + t + ": ");
                int rows = scanner.nextInt();
                int cols = scanner.nextInt();
                int[][] matrix = new int[rows][cols];
                int[][][] neighborCount = new int[rows][cols][2];
                int totalCells = rows * cols;
                int score = 0;
                Set<Integer> activeCells = IntStream.range(0, totalCells).boxed().collect(Collectors.toSet());

                for (int i = 0; i < rows; i++) {
                    for (int j = 0; j < cols; j++) {
                        matrix[i][j] = scanner.nextInt();
                        updateNeighborCount(matrix, neighborCount, i, j, rows, cols);
                    }
                }

                int previousSize;
                do {
                    previousSize = activeCells.size();
                    List<Integer> cellsToRemove = new ArrayList<>();

                    for (int cell : activeCells) {
                        int r = cell / cols;
                        int c = cell % cols;
                        score += matrix[r][c];
                        if (neighborCount[r][c][0] > matrix[r][c] * neighborCount[r][c][1]) {
                            cellsToRemove.add(cell);
                        }
                    }

                    activeCells.removeAll(cellsToRemove);
                    for (int cell : cellsToRemove) {
                        int r = cell / cols;
                        int c = cell % cols;
                        updateActiveCells(matrix, neighborCount, activeCells, cell, r, c, rows, cols);
                    }
                } while (activeCells.size() != previousSize);

                System.out.println(score);
            }
        }
    }

    private static void updateNeighborCount(int[][] matrix, int[][][] neighborCount, int i, int j, int rows, int cols) {
        if (i - 1 >= 0) {
            neighborCount[i - 1][j][0] += matrix[i][j];
            neighborCount[i - 1][j][1]++;
        }
        if (i + 1 < rows) {
            neighborCount[i + 1][j][0] += matrix[i][j];
            neighborCount[i + 1][j][1]++;
        }
        if (j - 1 >= 0) {
            neighborCount[i][j - 1][0] += matrix[i][j];
            neighborCount[i][j - 1][1]++;
        }
        if (j + 1 < cols) {
            neighborCount[i][j + 1][0] += matrix[i][j];
            neighborCount[i][j + 1][1]++;
        }
    }

    private static void updateActiveCells(int[][] matrix, int[][][] neighborCount, Set<Integer> activeCells, int cell, int r, int c, int rows, int cols) {
        updateDirection(matrix, neighborCount, activeCells, cell, r, c, -cols, rows, cols);
        updateDirection(matrix, neighborCount, activeCells, cell, r, c, cols, rows, cols);
        updateDirection(matrix, neighborCount, activeCells, cell, r, c, -1, rows, cols);
        updateDirection(matrix, neighborCount, activeCells, cell, r, c, 1, rows, cols);
    }

    private static void updateDirection(int[][] matrix, int[][][] neighborCount, Set<Integer> activeCells, int cell, int r, int c, int direction, int rows, int cols) {
        int idx = cell;
        while ((idx += direction) >= 0 && idx < rows * cols) {
            int newR = idx / cols;
            int newC = idx % cols;
            if (activeCells.contains(idx)) {
                neighborCount[newR][newC][0] -= matrix[r][c];
                neighborCount[newR][newC][1]--;
                int newIdx = cell;
                while ((newIdx -= direction) >= 0 && newIdx < rows * cols) {
                    int neighborR = newIdx / cols;
                    int neighborC = newIdx % cols;
                    if (activeCells.contains(newIdx)) {
                        neighborCount[newR][newC][0] += matrix[neighborR][neighborC];
                        neighborCount[newR][newC][1]++;
                        break;
                    }
                }
                break;
            }
        }
    }
}