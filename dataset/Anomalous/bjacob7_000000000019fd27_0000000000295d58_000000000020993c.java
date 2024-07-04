import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
            int testCases = scanner.nextInt();
            for (int t = 1; t <= testCases; t++) {
                int size = scanner.nextInt();
                int[][] grid = new int[size][size];
                scanner.nextLine(); // Consume the newline character
                
                for (int i = 0; i < size; i++) {
                    String[] line = scanner.nextLine().split(" ");
                    for (int j = 0; j < size; j++) {
                        grid[i][j] = Integer.parseInt(line[j]);
                    }
                }

                int trace = calculateTrace(grid, size);
                int rowDuplicates = countRowDuplicates(grid, size);
                int colDuplicates = countColDuplicates(grid, size);

                System.out.println("Case #" + t + ": " + trace + " " + rowDuplicates + " " + colDuplicates);
            }
        }
    }

    private static int calculateTrace(int[][] grid, int size) {
        int trace = 0;
        for (int i = 0; i < size; i++) {
            trace += grid[i][i];
        }
        return trace;
    }

    private static int countRowDuplicates(int[][] grid, int size) {
        int duplicateRows = 0;
        for (int i = 0; i < size; i++) {
            if (!hasUniqueElements(grid[i])) {
                duplicateRows++;
            }
        }
        return duplicateRows;
    }

    private static int countColDuplicates(int[][] grid, int size) {
        int duplicateCols = 0;
        for (int j = 0; j < size; j++) {
            HashSet<Integer> set = new HashSet<>();
            for (int i = 0; i < size; i++) {
                if (!set.add(grid[i][j])) {
                    duplicateCols++;
                    break;
                }
            }
        }
        return duplicateCols;
    }

    private static boolean hasUniqueElements(int[] array) {
        HashSet<Integer> set = new HashSet<>();
        for (int value : array) {
            if (!set.add(value)) {
                return false;
            }
        }
        return true;
    }
}