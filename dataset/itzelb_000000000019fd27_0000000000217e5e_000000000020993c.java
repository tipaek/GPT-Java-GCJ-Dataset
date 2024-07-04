import java.util.*;
import java.io.*;
public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt();
    for (int testCase = 1; testCase <= t; ++testCase) {
      int n = in.nextInt();
      
      boolean[] repInRow = new boolean[n], repInCol = new boolean[n];
      int[][] rowsHash = new int[n][n], colsHash = new int[n][n];
      int row = 0, col = 0, repRows = 0, repCols = 0, trace = 0, current = 0;  
        
      while(row<n){
        current = in.nextInt();

        rowsHash[row][current - 1]++;
        if(rowsHash[row][current - 1]==2 && !repInRow[row]){
            repRows++;
            repInRow[row] = true;
        }
        
        colsHash[col][current - 1]++;
        if(colsHash[col][current - 1]==2 && !repInCol[col]){
            repCols++;
            repInCol[col] = true;
        }
        
        if(row==col)
            trace+=current;
        
        col++;
        if(col==n){
            row++;
            col = 0;
        }
      }
      System.out.println("Case #"+ testCase +": "+trace+" "+repRows+" "+repCols);
    }
  }
}