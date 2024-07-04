import java.util.*;
import java.io.*;
public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int _t = 1; _t <= t; ++_t) {
            System.out.println("Case #" + _t + ": " + solve(in));
        }
    }
  
    static String solve(Scanner in) {
        int n = in.nextInt();
        int k = 0;
        boolean[][] col = new boolean[n][n];
        boolean[][] row = new boolean[n][n];
        boolean[] invalidCol = new boolean[n];
        boolean[] invalidRow = new boolean[n];
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int val = in.nextInt() - 1;
                if (i == j) k += val + 1;
                if (col[j][val]) {
                    invalidCol[j] = true;
                }
                col[j][val] = true;
                if (row[i][val]) {
                    invalidRow[i] = true;
                }
                row[i][val] = true;
            }
        }
        int r = 0, c = 0;
        for (int i = 0; i < n; i++) {
            if (invalidRow[i]) r++;
        }
        for (int i = 0; i < n; i++) {
            if (invalidCol[i]) c++;
        }
        
        return "" + k + " " + r + " " + c;
    }
}