import java.util.*;
import java.io.*;
public class Solution {
  public static void main(String[] args) {
    Scanner scan = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = scan.nextInt();
    int result[][] = new int[t][3];
    for (int i = 0; i < t; i++) {
      int n = scan.nextInt();
      int mat[][] = new int[n][n];
      int row_count = 0, col_count = 0, trace = 0;
      
      // taking input
      
      for(int j = 0; j < n; j++) { 
          for(int k = 0; k < n; k++) {
              mat[j][k] = scan.nextInt();
          }
      }
      
      // Process
      
      for(int j = 0; j < n; j++) { 
          for(int k = 0; k < n; k++) {
              // Calculating trace of matrix
              if (j == k)
              {
                  trace = trace + mat [j][k];
              }
          }
      }
      // Calculating Duplicated values in rows
      loop1: for(int j = 0; j < n; j++) {
          for(int k = 0; k < n; k++) {
              for(int l = k+1; l < n; l++) {
                  if (mat[j][k] == mat[j][l]) {
                      row_count++;
                      continue loop1;
                  }
              }
          }
      }
      // Calculating Duplicated values in cols
      loop2: for(int j = 0; j < n; j++) {
          for(int k = 0; k < n; k++) {
              for(int l = k+1; l < n; l++) {
                  if (mat[k][j] == mat[l][j]) {
                      col_count++;
                      continue loop2;
                  }
              }
          }
      }
      // Storing Output
      result[i][0] = trace;
      result[i][1] = row_count;
      result[i][2] = col_count;
    }
    // Printing Values
    for(int i = 0; i < t; i++){
        System.out.println("Case #" + (i + 1) + ": " + result[i][0] + " " + result[i][1] + " " + result[i][2]);   
    }
  }
}