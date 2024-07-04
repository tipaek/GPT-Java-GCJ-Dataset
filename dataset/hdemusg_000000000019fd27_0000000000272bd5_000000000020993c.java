import java.util.Scanner;
import java.util.HashMap;

public class Solution {
    static Scanner input;
    
    public static void solve(int x) {
        int n = input.nextInt();
        int[][] square = new int[n][n];
        for (int a = 0; a < n; a++) {
            for (int b = 0; b < n; b++) {
                square[a][b] = input.nextInt();
            }
        }
        int k = 0;
        for (int d = 0; d < n; d++) {
            k = k + square[d][d];
        }
        int r = 0;
        for (int e = 0; e < n; e++) {
            HashMap<Integer,Integer> row = new HashMap<>();
            for (int f = 0; f < n; f++) {
                row.put(square[e][f], 0);
            }
            if (row.keySet().size() != n) {
                r++;
            }
        }
        int c = 0;
        for (int g = 0; g < n; g++) {
            HashMap<Integer,Integer> col = new HashMap<>();
            for (int h = 0; h < n; h++) {
                col.put(square[h][g], 0);
            }
            if (col.keySet().size() != n) {
                c++;
            }
        }
        System.out.println("Case " + x + ": " + k + " " + r + " " + c);
    }
    
    public static void main(String args[]) {
      input = new Scanner(System.in);
      int t = input.nextInt();
      for (int i = 0; i < t; i++) {
          solve(i + 1);
      }
    }
}