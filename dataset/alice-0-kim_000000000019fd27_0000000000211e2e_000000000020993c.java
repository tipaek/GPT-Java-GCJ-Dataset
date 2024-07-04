import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for (int t = 1; t <= T; t++) {
            int N = in.nextInt();
            int k = 0;
            int r = 0;
            int c = 0;
            int[][] grid = new int[N][N];
            Set<Integer> rows = new HashSet();
            Set<Integer> cols = new HashSet();
            
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    grid[i][j] = in.nextInt();
                }
            }
            for (int i = 0; i < N; i++) {
                rows.clear();
                cols.clear();
                for (int j = 0; j < N; j++) {
                    rows.add(grid[i][j]);
                    cols.add(grid[j][i]);
                }
                if (rows.size() < N) r++;
                if (cols.size() < N) c++;
                k += grid[i][i];
            }
            
            System.out.printf("Case #%d: %d %d %d\n", t, k, r, c);
        }
    }
}