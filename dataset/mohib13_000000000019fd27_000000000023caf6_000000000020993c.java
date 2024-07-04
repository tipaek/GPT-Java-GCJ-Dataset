import java.util.*;
import java.io.*;

public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt(); 
    for (int i = 1; i <= t; ++i) {
      int N = in.nextInt();
      
      int trace = 0;
      HashSet<Integer> rowSet = new HashSet<Integer>();
      int repeatRowCount = 0;
      int[][] matrix = new int[N][N];
      boolean seen = false;
      
      for(int r = 0; r < matrix.length; r++) {
          rowSet = new HashSet<Integer>();
          seen = false;
          
          for(int c = 0; c < matrix.length; c++) {
              matrix[r][c] = in.nextInt();
              if(r == c){
                  trace += matrix[r][c];
              }
              
              //if already seen in this row
              if(rowSet.contains(matrix[r][c]) && !seen) {
                  seen = true;
                  repeatRowCount++;
              }
              // add val to rowSet
              rowSet.add(matrix[r][c]);
          }
      }
      
      int repeatColCount = 0;
      for(int c = 0; c < matrix.length; c++) {
          rowSet = new HashSet<Integer>();
          seen = false;
          
          for(int r = 0; r < matrix.length; r++) {
              //if already seen in this row
              if(rowSet.contains(matrix[r][c]) && !seen) {
                  seen = true;
                  repeatColCount++;
              }
              
              // add val to rowSet
              rowSet.add(matrix[r][c]);
          }
      }
      
      System.out.println("Case #" + i + ": " + trace + " " + repeatRowCount + " " +  repeatColCount);
    }
  }
}