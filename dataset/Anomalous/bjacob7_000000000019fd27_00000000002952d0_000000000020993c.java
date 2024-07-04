import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int t = 0; t < testCases; t++) {
            int size = scanner.nextInt();
            int[][] grid = new int[size][size];
            scanner.nextLine(); // Consume the remaining newline

            for (int row = 0; row < size; row++) {
                String[] values = scanner.nextLine().split(" ");
                for (int col = 0; col < size; col++) {
                    grid[row][col] = Integer.parseInt(values[col]);
                }
            }

            int traceValue = calculateTrace(grid, size);
            int duplicateRows = countDuplicateRows(grid, size);
            int duplicateCols = countDuplicateCols(grid, size);

            System.out.println("Case #" + (t + 1) + ": " + traceValue + " " + duplicateRows + " " + duplicateCols);
        }
    }

    private static int calculateTrace(int[][] grid, int size) {
        int trace = 0;
        for (int i = 0; i < size; i++) {
            trace += grid[i][i];
        }
        return trace;
    }

    private static int countDuplicateRows(int[][] grid, int size) {
        int duplicateRows = 0;
        for (int row = 0; row < size; row++) {
            if (hasDuplicates(grid[row])) {
                duplicateRows++;
            }
        }
        return duplicateRows;
    }

    private static int countDuplicateCols(int[][] grid, int size) {
        int duplicateCols = 0;
        for (int col = 0; col < size; col++) {
            if (hasDuplicates(getColumn(grid, col))) {
                duplicateCols++;
            }
        }
        return duplicateCols;
    }

    private static boolean hasDuplicates(int[] array) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : array) {
            if (!set.add(num)) {
                return true;
            }
        }
        return false;
    }

    private static int[] getColumn(int[][] grid, int col) {
        int size = grid.length;
        int[] column = new int[size];
        for (int row = 0; row < size; row++) {
            column[row] = grid[row][col];
        }
        return column;
    }
}