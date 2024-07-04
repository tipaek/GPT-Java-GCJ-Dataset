import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int T = scan.nextInt();

        for (int i = 0; i < T; i++) solve(scan, i + 1);
    }

    static void solve(Scanner scan, int num) {
        int n = scan.nextInt();
        int[][] grid = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = scan.nextInt();
            }
        }
        int wrongRows = 0, wrongCols = 0, trace = 0;
        for (int i = 0; i < n; i++) {
            trace += grid[i][i];
        }
        boolean[] used = new boolean[n + 1];
        for (int row = 0; row < n; row++) {
            Arrays.fill(used, false);            
            for (int col = 0; col < n; col++) {
                if (used[grid[row][col]]) {
                    wrongRows++;
                    break;
                }
                used[grid[row][col]] = true;
            }
        }
        for (int col = 0; col < n; col++) {
            Arrays.fill(used, false);
            for (int row = 0; row < n; row++) {
                if (used[grid[row][col]]) {
                    wrongCols++;
                    break;
                }
                used[grid[row][col]] = true;
            }
        }
        System.out.printf("Case #%d: %d %d %d%n", num, trace, wrongRows, wrongCols);

    }
}