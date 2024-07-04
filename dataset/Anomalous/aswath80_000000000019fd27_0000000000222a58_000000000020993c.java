import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        
        for (int t = 1; t <= testCases; t++) {
            int n = scanner.nextInt();
            int[][] grid = new int[n][n];
            
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    grid[i][j] = scanner.nextInt();
                }
            }
            
            processTestCase(t, grid, n);
        }
    }

    private static void processTestCase(int testCaseNumber, int[][] grid, int size) {
        int diagonalSum = 0;
        int rowDuplicates = 0;
        int columnDuplicates = 0;
        
        for (int i = 0; i < size; i++) {
            diagonalSum += grid[i][i];
            if (hasDuplicates(grid[i])) {
                rowDuplicates++;
            }
            if (hasColumnDuplicates(grid, i, size)) {
                columnDuplicates++;
            }
        }
        
        System.out.println(String.format("Case #%d: %d %d %d", testCaseNumber, diagonalSum, rowDuplicates, columnDuplicates));
    }

    private static boolean hasDuplicates(int[] array) {
        Set<Integer> set = new HashSet<>();
        for (int value : array) {
            if (!set.add(value)) {
                return true;
            }
        }
        return false;
    }

    private static boolean hasColumnDuplicates(int[][] grid, int columnIndex, int size) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < size; i++) {
            if (!set.add(grid[i][columnIndex])) {
                return true;
            }
        }
        return false;
    }
}