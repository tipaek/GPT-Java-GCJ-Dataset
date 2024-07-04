import java.util.Scanner;

public class Vestigium {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfGrids = readInt(scanner);
        for (int i = 1; i <= numberOfGrids; i++) {
            int size = readInt(scanner);
            int[][] grid = readGrid(scanner, size);
            System.out.printf("Case #%d: %d %d %d%n", i, calculateTrace(grid), countNonUniqueRows(grid), countNonUniqueColumns(grid));
        }
    }

    private static int readInt(Scanner scanner) {
        int value = scanner.nextInt();
        scanner.nextLine(); // consume the rest of the line
        return value;
    }

    private static int[][] readGrid(Scanner scanner, int size) {
        int[][] grid = new int[size][size];
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                grid[row][col] = scanner.nextInt();
            }
            scanner.nextLine(); // consume the rest of the line
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

    private static int countNonUniqueRows(int[][] grid) {
        int count = 0;
        for (int[] row : grid) {
            if (!isUnique(row)) {
                count++;
            }
        }
        return count;
    }

    private static int countNonUniqueColumns(int[][] grid) {
        int count = 0;
        for (int col = 0; col < grid.length; col++) {
            int[] column = new int[grid.length];
            for (int row = 0; row < grid.length; row++) {
                column[row] = grid[row][col];
            }
            if (!isUnique(column)) {
                count++;
            }
        }
        return count;
    }

    private static boolean isUnique(int[] array) {
        boolean[] seen = new boolean[array.length + 1];
        for (int value : array) {
            if (seen[value]) {
                return false;
            }
            seen[value] = true;
        }
        return true;
    }
}