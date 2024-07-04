import java.util.*;
import java.io.*;

public class Solution {
   public static void main(String[] args) {
      Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
      int t = in.nextInt();
      for (int i = 1; i <= t; i++){
         computeSquare(in.nextInt(), in, i);
      }
   }
   public static void computeSquare(int n, Scanner in, int x) {
      int[][] square = new int[n][n];
      int k = 0;
      int r = 0;
      int c = 0;
      // fill 2d array
      for (int i = 0; i < n; i++) {
         for (int j = 0; j < n; j++) {
            square[i][j] = in.nextInt();
         }
      }
      // compute k
      for (int i = 0; i < n; i++) {
         k += square[i][i];
      }
      // count duplicates in row
      for (int i = 0; i < n; i++) {
         Set<Integer> set = new HashSet<>();
         for (int j = 0; j < n; j++) {
            set.add(square[i][j]);
         }
         if (set.size() != n) {
            r++;
         }
      }      
      // count duplicates in col
      for (int i = 0; i < n; i++) {
         Set<Integer> set = new HashSet<>();
         for (int j = 0; j < n; j++) {
            set.add(square[j][i]);
         }
         if (set.size() != n) {
            c++;
         }
      }
      System.out.println("Case #" + x + ": " + k + " " + r + " " + c);
   }
}