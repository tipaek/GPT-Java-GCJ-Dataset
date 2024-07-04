import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        
        for (int i = 1; i <= testCases; ++i) {
            int n = scanner.nextInt();
            int trace = scanner.nextInt();
            int[][] grid = new int[n][n];
            
            // Initialize the first row of the grid
            for (int j = 0; j < n; j++) {
                grid[0][j] = j + 1;
            }
            
            // Fill the rest of the grid
            for (int k = 1, s = 1; k < n; k++, s++) {
                for (int j = 0, count = s; j < n; j++, count++) {
                    grid[k][j] = grid[0][count % n];
                }
            }
            
            if (trace >= n && trace <= n * n && trace % n == 0) {
                int num = trace / n;
                int[][] resultGrid = new int[n][n];
                
                for (int m = 0; m < n; m++) {
                    int res = findPosition(grid, m, num);
                    resultGrid[res] = grid[m];
                }
                
                System.out.println("Case #" + i + ": POSSIBLE");
                printGrid(resultGrid);
            } else {
                System.out.println("Case #" + i + ": IMPOSSIBLE");
            }
        }
    }

    private static int findPosition(int[][] grid, int start, int target) {
        for (int i = 0; i < grid.length; i++) {
            if (grid[start][i] == target) {
                return i;
            }
        }
        return 0;
    }

    private static void printGrid(int[][] grid) {
        for (int[] row : grid) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }
}