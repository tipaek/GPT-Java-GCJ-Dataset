import java.io.*;
import java.util.*;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws Exception {
        InputStream in = System.in;
        Scanner sc = new Scanner(in);
//        sc.useDelimiter(Pattern.compile("[\n /]"));

x:        for (int cs = 1, cases = sc.nextInt(); cs <= cases; cs++) {
            int n = sc.nextInt();
            int[][] grid= new int[n][n];
            for (int i = 0 ;i < n; i++) {
                for (int j = 0 ;j < n; j++) {
                    grid[i][j] = sc.nextInt();
                }
            }
            int r = 0; for (int i = 0;i < n;i++) if (dups(grid, i, 0, 0, 1)) r++;
            int c = 0; for (int i = 0;i < n;i++) if (dups(grid, 0, i, 1, 0)) c++;
            int t = 0; for (int i = 0;i < n;i++) t+=grid[i][i];
            System.out.printf("Case #%d: %d %d %d%n", cs, t, r, c);
        }
    }

    private static boolean dups(int[][] grid, int r, int c, int dr, int dc) {
        Set<Integer> v = new HashSet<>();
        for (int i = 0; i < grid.length; i++) {
            v.add(grid[r+i*dr][c+i*dc]);
        }
        return v.size()!=grid.length;
    }
}
