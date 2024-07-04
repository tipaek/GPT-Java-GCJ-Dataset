import java.util.*;
import java.io.*;
public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
    for (int i = 1; i <= t; ++i) {
      int n = in.nextInt();
      
      int[][] matrix = new int[n][n];
      
      for(int j=0;j<n;j++) {
          for(int k=0;k<n;k++){
              matrix[j][k] = in.nextInt();
          }
      }
      
      int[] res = new int[3];
      
      res = solve(n, matrix);
      
      System.out.println("Case #" + i + ": " + res[0] + " " + res[1] + " " + res[2]);
    }
  }
  
  public static int[] solve(int n, int[][] matrix) {
      int[] ans  = new int[3];
      
      int sum = 0;
      int rowCount = 0;
      int colCount = 0;
      int flag = 0;
      
      HashSet<Integer> hs = new HashSet<Integer>();
      
      for(int i = 0;i<n;i++){
          hs.clear();
          flag = 0;
          for(int j=0;j<n;j++){
              int value = matrix[i][j];
              if(i==j){
                  sum+=value;
              }
              if(hs.contains(value) && flag==0){
                  rowCount++;
                  flag = 1;
              } else {
                  hs.add(value);
              }
          }
      }
      
      for(int i=0;i<n;i++){
          hs.clear();
          flag = 0;
          for(int j=0;j<n;j++){
              int value = matrix[j][i];
              if(hs.contains(value) && flag==0){
                  colCount++;
                  flag = 1;
              } else {
                  hs.add(value);
              }
          }
      }
      
      ans[0] = sum;
      ans[1] = rowCount;
      ans[2] = colCount;
      
      return ans;
  }
}