import java.util.HashSet;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int gridSize = scanner.nextInt();
            int[][] grid = new int[gridSize][gridSize];

            for (int row = 0; row < gridSize; row++) {
                for (int col = 0; col < gridSize; col++) {
                    grid[row][col] = scanner.nextInt();
                }
            }

            int[] result = calculateGridProperties(grid, gridSize);
            System.out.printf("Case #%d: %d %d %d%n", caseNumber, result[0], result[1], result[2]);
        }
        scanner.close();
    }

    private static int[] calculateGridProperties(int[][] grid, int gridSize) {
        int traceSum = 0;
        int rowDuplicateCount = 0;
        int colDuplicateCount = 0;

        for (int i = 0; i < gridSize; i++) {
            HashSet<Integer> rowSet = new HashSet<>();
            HashSet<Integer> colSet = new HashSet<>();
            boolean rowHasDuplicate = false;
            boolean colHasDuplicate = false;

            for (int j = 0; j < gridSize; j++) {
                if (i == j) {
                    traceSum += grid[i][j];
                }

                if (!rowHasDuplicate && !rowSet.add(grid[i][j])) {
                    rowDuplicateCount++;
                    rowHasDuplicate = true;
                }

                if (!colHasDuplicate && !colSet.add(grid[j][i])) {
                    colDuplicateCount++;
                    colHasDuplicate = true;
                }
            }
        }

        return new int[]{traceSum, rowDuplicateCount, colDuplicateCount};
    }
}