import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int T = s.nextInt();
        for (int t = 1; t <= T; ++t) {
            int n = s.nextInt();
            int[][] m = new int[n][n];
            for (int i = 0; i < n; ++i) {
                for (int j = 0; j < n; ++j) {
                    m[i][j] = s.nextInt();
                }
            }
            System.out.println(
                String.format("Case #%d: %s",
                    t, new Solution().solve(n, m)));
        }
    }
    
    public String solve(int n, int[][] m) {
        int sum = 0;
        int rows = 0;
        int cols = 0;
        
        int[] badRow = new int[n];
        int[] badCol = new int[n];
        for (int i = 0; i < n; ++i) {
            sum += m[i][i];
            
            int[] fRow = new int[n + 1];
            int[] fCol = new int[n + 1];
            for (int j = 0; j < n; ++j) {
                if (fRow[m[i][j]] > 0) {
                    badRow[i] |= 1;
                }
                if (fCol[m[j][i]] > 0) {
                    badCol[i] |= 1;
                }
                fRow[m[i][j]]++;
                fCol[m[j][i]]++;
            }
        }
        
        for (int x : badRow) rows += x;
        for (int x : badCol) cols += x;
        
        return String.format("%d %d %d", sum, rows, cols);
    }
}