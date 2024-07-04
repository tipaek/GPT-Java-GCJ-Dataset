import java.util.*;
import java.io.*;

public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
    
    for (int tcase = 1; tcase <= t; tcase++) {
      int n = in.nextInt();
      int k = 0, r = 0, c = 0;
      int[][] matrix = new int[n][n];
      
      //input
      for(int i = 0; i < n; i++){
          for(int j = 0; j < n; j++){
              matrix[n][n] = in.nextInt();
          }
      }
      
      //find trace
      for(int i = 0; i < n; i++) k += matrix[i][i];
      
      //comb
      for(int row = 0; row < n; row++){
          boolean[] found = new boolean[n];
          for(int at = 0; at < n; at++){
              
              if(matrix[row][at] < 1 || matrix[row][at] > n || found[matrix[row][at]]){
                  r++;
                  break;
              }
              
              found[matrix[row][at]] = true;
          }
      }
      
      for(int col = 0; col < n; col++){
          boolean[] found = new boolean[n];
          for(int at = 0; at < n; at++){
              
              if(matrix[at][col] < 1 || matrix[at][col] > n || found[matrix[at][col]]){
                  c++;
                  break;
              }
              
              found[matrix[at][col]] = true;
          }
      }
      
      //output
      System.out.println("Case #" + tcase + ": " + k + " " + r + " " + c);
    }
  }
}