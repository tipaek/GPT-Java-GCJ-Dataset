import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int numCases = sc.nextInt();
            for (int caseIndex = 0; caseIndex < numCases; caseIndex++) {
                int n = sc.nextInt();
                int[][] grid = new int[n][n];
                int duplicateRows = 0;
                int duplicateCols = 0;

                for (int row = 0; row < n; row++) {
                    Set<Integer> rowSet = new HashSet<>();
                    for (int col = 0; col < n; col++) {
                        grid[row][col] = sc.nextInt();
                        rowSet.add(grid[row][col]);
                    }
                    if (rowSet.size() < n) {
                        duplicateRows++;
                    }
                }

                for (int col = 0; col < n; col++) {
                    Set<Integer> colSet = new HashSet<>();
                    for (int row = 0; row < n; row++) {
                        colSet.add(grid[row][col]);
                    }
                    if (colSet.size() < n) {
                        duplicateCols++;
                    }
                }

                int trace = 0;
                for (int i = 0; i < n; i++) {
                    trace += grid[i][i];
                }

                System.out.printf("Case #%d: %d %d %d%n", caseIndex + 1, trace, duplicateRows, duplicateCols);
            }
        }
        sc.close();
    }
}