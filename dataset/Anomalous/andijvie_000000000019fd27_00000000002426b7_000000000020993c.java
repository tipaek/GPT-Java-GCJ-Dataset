import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numGrids = readInt(scanner);
        for (int i = 1; i <= numGrids; i++) {
            int gridSize = readInt(scanner);
            int[][] grid = readGrid(scanner, gridSize, gridSize);
            System.out.printf("Case #%d: %d %d %d%n", i, calculateTrace(grid), countDuplicateRows(grid), countDuplicateColumns(grid));
        }
    }

    private static int readInt(Scanner scanner) {
        int value = scanner.nextInt();
        scanner.nextLine();  // Consume the newline character
        return value;
    }

    private static int[][] readGrid(Scanner scanner, int rows, int cols) {
        int[][] grid = new int[rows][cols];
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                grid[row][col] = scanner.nextInt();
            }
            scanner.nextLine();  // Consume the newline character
        }
        return grid;
    }

    private static int calculateTrace(int[][] grid) {
        int trace = 0;
        for (int i = 0; i < grid.length; i++) {
            trace += grid[i][i];
        }
        return trace;
    }

    private static int countDuplicateRows(int[][] grid) {
        int duplicates = 0;
        for (int row = 0; row < grid.length; row++) {
            if (hasDuplicates(grid[row])) {
                duplicates++;
            }
        }
        return duplicates;
    }

    private static int countDuplicateColumns(int[][] grid) {
        int duplicates = 0;
        for (int col = 0; col < grid[0].length; col++) {
            if (hasDuplicates(getColumn(grid, col))) {
                duplicates++;
            }
        }
        return duplicates;
    }

    private static boolean hasDuplicates(int[] array) {
        boolean[] seen = new boolean[array.length + 1]; // Assuming values are 1 to n
        for (int value : array) {
            if (seen[value]) {
                return true;
            }
            seen[value] = true;
        }
        return false;
    }

    private static int[] getColumn(int[][] grid, int colIndex) {
        int[] column = new int[grid.length];
        for (int row = 0; row < grid.length; row++) {
            column[row] = grid[row][colIndex];
        }
        return column;
    }
}