import java.util.*;
import java.io.*;
public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
    for (int i = 1; i <= t; ++i) {
      int n = in.nextInt();
      int[][] matrix = new int[n][n];
      for(int j = 0; j<n; j++){
          for(int k=0; k<n; k++){
              matrix[j][k] = in.nextInt();
          }
      }
      int[] results = vestigium(matrix);
      System.out.println("Case #" + i + ": " + results[0] + " " + results[1] + " " + results[2]);
    }
  }
  
  public static int[] vestigium(int[][] matrix){
      int n = matrix.length;
      int rowDups = 0;
      int colDups = 0;
      int trace = 0;
      for(int i=0; i<n; i++){
          trace += matrix[i][i];
          int[] dupsList = dups(matrix, i);
          rowDups += dupsList[0];
          colDups += dupsList[1];
      }
      return new int[] {trace,rowDups,colDups};
  }
  
  private static int[] dups(int[][] matrix, int n) {
      Set<Integer> vals = new HashSet<>();
      int rowDups = 0;
      int colDups = 0;
      for(int i=0; i<matrix.length; i++){
          if(vals.contains(matrix[n][i])) rowDups = 1;
          else vals.add(matrix[n][i]);
      }
      vals = new HashSet<>();
      for(int i=0; i<matrix.length; i++){
          if(vals.contains(matrix[i][n])) colDups = 1;
          else vals.add(matrix[i][n]);
      }
      return new int[]{rowDups, colDups};
  }
}