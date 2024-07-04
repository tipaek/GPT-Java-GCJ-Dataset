import java.io.InputStream;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {
    public static void main(String[] args) throws Exception {
        InputStream in = System.in;
        Scanner sc = new Scanner(in);

        int cases = sc.nextInt();
        for (int cs = 1; cs <= cases; cs++) {
            int n = sc.nextInt();
            int[][] grid = new int[n][n];
            
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    grid[i][j] = sc.nextInt();
                }
            }
            
            int rowDuplicates = 0;
            for (int i = 0; i < n; i++) {
                if (hasDuplicates(grid, i, 0, 0, 1)) {
                    rowDuplicates++;
                }
            }
            
            int colDuplicates = 0;
            for (int i = 0; i < n; i++) {
                if (hasDuplicates(grid, 0, i, 1, 0)) {
                    colDuplicates++;
                }
            }
            
            int trace = 0;
            for (int i = 0; i < n; i++) {
                trace += grid[i][i];
            }
            
            System.out.printf("Case #%d: %d %d %d%n", cs, trace, rowDuplicates, colDuplicates);
        }
    }

    private static boolean hasDuplicates(int[][] grid, int r, int c, int dr, int dc) {
        Set<Integer> values = new HashSet<>();
        for (int i = 0; i < grid.length; i++) {
            values.add(grid[r + i * dr][c + i * dc]);
        }
        return values.size() != grid.length;
    }
}