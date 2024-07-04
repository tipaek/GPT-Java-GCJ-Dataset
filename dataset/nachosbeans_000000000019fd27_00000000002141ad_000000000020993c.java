import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        
        for (int test = 1; test <= T; test++) {
            int N = scanner.nextInt();
            int[][] ar = new int[N][N];
            int trace = 0;
            for (int r = 0; r < N; r++) {
                for (int c = 0; c < N; c++) {
                    int cur = scanner.nextInt();
                    ar[r][c] = cur;
                    
                    if (r == c)
                        trace += cur;
                }
            }
            
            int rows = 0;
            
            outer: for (int[] row : ar) {
                HashSet<Integer> set = new HashSet<>();
                for (int col : row) {
                    if (set.contains(col)) {
                        rows++;
                        continue outer;
                    }
                    set.add(col);
                }
            }
            
            int cols = 0;
            
            outer: for (int c = 0; c < N; c++) {
                HashSet<Integer> set = new HashSet<>();
                for (int r = 0; r < N; r++) {
                    int cur = ar[r][c];
                    
                    if (set.contains(cur)) {
                        cols++;
                        continue outer;
                    }
                    set.add(cur);
                }
            }
            
            System.out.printf("Case #%d: %d %d %d\n", test, trace, rows, cols);
        }
        
        scanner.close();
    }
}