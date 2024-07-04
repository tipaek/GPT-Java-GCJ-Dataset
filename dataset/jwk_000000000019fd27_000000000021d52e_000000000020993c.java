import java.util.*;
import java.io.*;
public class Solution {
   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      int t = sc.nextInt();
      int n;
      for(int i = 1; i <= t; i++) {
         n = sc.nextInt();
         int[][] mat = new int[n][n];
         for(int j = 0; j < n; j++) {
            for(int k = 0; k < n; k++) {
               mat[j][k] = sc.nextInt();
            }
         }
         
         int trace = 0;
         for(int j = 0; j < n; j++) {
            trace += mat[j][j];
         }
         
         int duprow = 0;
         for(int j = 0; j < n; j++) {
            boolean dup = false;
            HashSet<Integer> h = new HashSet<Integer>();
            for(int k = 0; k < n; k++) {
               if(h.contains(mat[j][k])) {
                  dup = true;
                  break;
               } else {
                  h.add(mat[j][k]);
               }
            }
            if(dup) duprow++;
         }
         
         int dupcol = 0;
         for(int j = 0; j < n; j++) {
            boolean dup = false;
            HashSet<Integer> h = new HashSet<Integer>();
            for(int k = 0; k < n; k++) {
               if(h.contains(mat[k][j])) {
                  dup = true;
                  break;
               } else {
                  h.add(mat[k][j]);
               }
            }
            if(dup) dupcol++;
         }
         
         System.out.println("Case #" + i + ": " + trace + " " + duprow + " " + dupcol);
      }
   }
}