import java.util.*;
import java.io.*;
public class Solution {
  public static void main(String[] args) {
    Scanner scan = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = scan.nextInt();
    int result[][] = new int[t][3];
    for (int i = 0; i < t; ++i) {
      int n = scan.nextInt();
      int matrix[][] = new int[n][n];
      int row_count = 0, col_count = 0, trace = 0;
    
      
      for(int j = 0; j < n; ++j) { 
          for(int k = 0; k < n; ++k) {
              matrix[j][k] = scan.nextInt();
          }
      }
      
  
      
      for(int j = 0; j < n; ++j) { 
          for(int k = 0; k < n; ++k) {
             
              if (j == k)
              {
                  trace = trace + matrix [j][k];
              }
          }
      }
      
      loop: for(int j = 0; j < n; ++j) {
          for(int k = 0; k < n; ++k) {
              for(int l = k+1; l < n; ++l) {
                  if (matrix[j][k] == matrix[j][l]) {
                      row_count++;
                      continue loop;
                  }
              }
          }
      }

      loop1: for(int j = 0; j < n; ++j) {
          for(int k = 0; k < n; ++k) {
              for(int l = k+1; l < n; ++l) {
                  if (matrix[k][j] == matrix[l][j]) {
                      col_count++;
                      continue loop1;
                  }
              }
          }
      }
      result[i][0] = trace;
      result[i][1] = row_count;
      result[i][2] = col_count;
    }

    for(int i = 0; i < t; ++i){
        System.out.println("Case #" + (i + 1) + ": " + result[i][0] + " " + result[i][1] + " " + result[i][2]);   
    }
  }
}