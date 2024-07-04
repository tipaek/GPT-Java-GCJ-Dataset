import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int size = scanner.nextInt();
            int[][] grid = new int[size][size];

            // Reading the grid
            for (int row = 0; row < size; row++) {
                for (int col = 0; col < size; col++) {
                    grid[row][col] = scanner.nextInt();
                }
            }

            // Calculating the trace
            int trace = 0;
            for (int i = 0; i < size; i++) {
                trace += grid[i][i];
            }

            // Counting columns with duplicates
            int duplicateColumns = 0;
            for (int col = 0; col < size; col++) {
                Set<Integer> seenNumbers = new HashSet<>();
                boolean hasDuplicate = false;
                for (int row = 0; row < size; row++) {
                    if (!seenNumbers.add(grid[row][col])) {
                        hasDuplicate = true;
                        break;
                    }
                }
                if (hasDuplicate) {
                    duplicateColumns++;
                }
            }

            // Counting rows with duplicates
            int duplicateRows = 0;
            for (int row = 0; row < size; row++) {
                Set<Integer> seenNumbers = new HashSet<>();
                boolean hasDuplicate = false;
                for (int col = 0; col < size; col++) {
                    if (!seenNumbers.add(grid[row][col])) {
                        hasDuplicate = true;
                        break;
                    }
                }
                if (hasDuplicate) {
                    duplicateRows++;
                }
            }

            // Printing the result
            System.out.println("Case #" + caseNumber + ": " + trace + " " + duplicateRows + " " + duplicateColumns);
        }
    }
}