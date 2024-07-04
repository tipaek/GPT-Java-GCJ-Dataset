import java.util.*;
import java.io.*;

public class Solution {
   public static void main(String[] args) {
      Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
      int n = in.nextInt();
      for (int x = 1; x <= n; x++) {
         computeSquare(in.nextInt(), in.nextInt(), x);
      }
   }
   
   public static class Square {
      int n;
      int k;
      int x;
      int[][] latin;
      boolean printed;
      
      public Square(int n, int k, int x) {
         latin = new int[n][n];
         printed = false;
         this.n = n;
         this.k = k;
         this.x = x;
      }
      
      public boolean isSafe(int row, int col, int num) {
         for (int i = 0; i < n; i++) {
            if (latin[i][col] == num || latin[row][i] == num) {
               return false;
            }
         }
         return true;
      }
      
      public int trace() {
         int trace = 0;
         for (int i = 0; i < n; i++) {
            trace += latin[i][i];
         }
         return trace;
      }
      
      public void print() {
         System.out.println("Case #" + x + ": POSSIBLE");
         for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - 1; j++) {
               System.out.print(latin[i][j] + " ");
            }
            System.out.println(latin[i][n - 1]);
         }
         printed = true;
      }
      
   }
   public static void computeSquare(int n, int k, int x) {
      Square sqr = new Square(n, k, x);
      if (!explore(sqr, 0, 1)) {
         if (!sqr.printed) {
            System.out.println("Case #" + x + ": IMPOSSIBLE");
         }
      }
   }
   
   public static boolean explore(Square sqr, int col, int num) {
      if (sqr.printed || sqr.trace() > sqr.k) {
         return false;
      }
      if (col == sqr.n) {
         if (sqr.trace() == sqr.k) {
            sqr.print();
            return true;
         }
      } else if (num <= sqr.n) {
         for (int row = 0; row < sqr.n; row++) {
            if (sqr.latin[row][col] == 0 && sqr.isSafe(row, col, num)) {
               sqr.latin[row][col] = num;
               explore(sqr, col, num + 1);
               sqr.latin[row][col] = 0;
            }
         }
      } else {
         explore(sqr, col + 1, 1);
      }
      return false;
   }
}