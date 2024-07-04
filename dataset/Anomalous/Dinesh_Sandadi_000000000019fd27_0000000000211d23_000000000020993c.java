import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {

    private void printAnswer(int caseNum, int trace, int rows, int cols) {
        System.out.println("Case #" + caseNum + ": " + trace + " " + rows + " " + cols);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        Solution solution = new Solution();

        for (int caseNum = 1; caseNum <= testCases; caseNum++) {
            int n = scanner.nextInt();
            int[][] grid = new int[n][n];

            int trace = 0;
            int rowDuplicates = 0;
            int colDuplicates = 0;

            // Read the grid and calculate the trace and row duplicates
            for (int i = 0; i < n; i++) {
                Set<Integer> rowSet = new HashSet<>();
                boolean rowHasDuplicate = false;
                for (int j = 0; j < n; j++) {
                    grid[i][j] = scanner.nextInt();
                    if (i == j) {
                        trace += grid[i][j];
                    }
                    if (!rowSet.add(grid[i][j]) && !rowHasDuplicate) {
                        rowDuplicates++;
                        rowHasDuplicate = true;
                    }
                }
            }

            // Calculate the column duplicates
            for (int j = 0; j < n; j++) {
                Set<Integer> colSet = new HashSet<>();
                boolean colHasDuplicate = false;
                for (int i = 0; i < n; i++) {
                    if (!colSet.add(grid[i][j]) && !colHasDuplicate) {
                        colDuplicates++;
                        colHasDuplicate = true;
                    }
                }
            }

            solution.printAnswer(caseNum, trace, rowDuplicates, colDuplicates);
        }

        scanner.close();
    }
}