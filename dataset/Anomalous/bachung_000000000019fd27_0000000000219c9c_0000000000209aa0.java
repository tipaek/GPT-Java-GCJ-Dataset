import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(reader.readLine());
        for (int i = 0; i < T; i++) {
            processCase(reader, i + 1);
        }
    }

    private static void processCase(BufferedReader reader, int caseNumber) throws Exception {
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int N = Integer.parseInt(tokenizer.nextToken());
        int K = Integer.parseInt(tokenizer.nextToken());

        if (K % N == 0 && K > 0) {
            System.out.printf("Case #%d: POSSIBLE%n", caseNumber);
            int[][] grid = generateGrid(N);
            int targetValue = K / N;
            adjustGrid(grid, targetValue);
            printGrid(grid);
        } else {
            System.out.printf("Case #%d: IMPOSSIBLE%n", caseNumber);
        }
    }

    private static int[][] generateGrid(int size) {
        int[][] grid = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                grid[i][j] = (j + i) % size + 1;
            }
        }
        return grid;
    }

    private static void adjustGrid(int[][] grid, int targetValue) {
        for (int i = 0; i < grid.length; i++) {
            if (grid[i][i] != targetValue) {
                int swapCol = findColumnWithTargetValue(grid[i], targetValue);
                if (swapCol != -1) {
                    swapColumns(grid, i, swapCol);
                }
            }
        }
    }

    private static int findColumnWithTargetValue(int[] row, int targetValue) {
        for (int j = 0; j < row.length; j++) {
            if (row[j] == targetValue) {
                return j;
            }
        }
        return -1;
    }

    private static void swapColumns(int[][] grid, int col1, int col2) {
        for (int i = 0; i < grid.length; i++) {
            int temp = grid[i][col1];
            grid[i][col1] = grid[i][col2];
            grid[i][col2] = temp;
        }
    }

    private static void printGrid(int[][] grid) {
        for (int[] row : grid) {
            System.out.println(Arrays.toString(row).replaceAll("[\\[\\],]", ""));
        }
    }
}