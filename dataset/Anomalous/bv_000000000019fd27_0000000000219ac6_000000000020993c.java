import java.util.*;
import java.io.*;

class CodeJamTest {
    private int sum = 0;
    private int rowSum = 0;
    private int colSum = 0;

    public int[] processGrid(int[][] grid) {
        // Calculate the sum of the main diagonal
        for (int i = 0; i < grid.length; i++) {
            sum += grid[i][i];
        }

        // Calculate the number of rows with duplicate elements
        for (int[] row : grid) {
            Set<Integer> uniqueElements = new HashSet<>();
            for (int element : row) {
                uniqueElements.add(element);
            }
            if (uniqueElements.size() < grid.length) {
                rowSum++;
            }
        }

        // Calculate the number of columns with duplicate elements
        for (int col = 0; col < grid.length; col++) {
            Set<Integer> uniqueElements = new HashSet<>();
            for (int[] row : grid) {
                uniqueElements.add(row[col]);
            }
            if (uniqueElements.size() < grid.length) {
                colSum++;
            }
        }

        return new int[]{sum, rowSum, colSum};
    }
}

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int i = 1; i <= testCases; i++) {
            int n = scanner.nextInt();
            int[][] grid = new int[n][n];

            for (int row = 0; row < n; row++) {
                for (int col = 0; col < n; col++) {
                    grid[row][col] = scanner.nextInt();
                }
            }

            CodeJamTest codeJamTest = new CodeJamTest();
            int[] results = codeJamTest.processGrid(grid);

            System.out.println("Case #" + i + ": " + results[0] + " " + results[1] + " " + results[2]);
        }
    }
}