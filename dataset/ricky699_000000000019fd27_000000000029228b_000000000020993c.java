import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    
  public static int getRows(int n, int[][] grid){
      int rows=0;
      for(int j=0;j<n;j++){
        Set<Integer> uniqueRowNums = new HashSet<> ();
        int k;
        for(k=0;k<n;k++){
            if(uniqueRowNums.contains(grid[j][k])){
                break;
            }else{
                uniqueRowNums.add(grid[j][k]);
            }
        }
        if(k!=n){
            rows++;
        }
    }
    return rows;
  }
  
  public static int getCols(int n, int[][] grid){
      int cols=0;
      for(int j=0;j<n;j++){
        Set<Integer> uniqueColNums = new HashSet<> ();
        int k;
        for(k=0;k<n;k++){
            if(uniqueColNums.contains(grid[k][j])){
                break;
            }else{
                uniqueColNums.add(grid[k][j]);
            }
        }
        if(k!=n){
            cols++;
        }
    }
    return cols;
  }
  
  
    
  public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();  
        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt();
            int trace=0;
            int[][] grid = new int[n][n];
            for(int j=0;j<n;j++){
                for(int k=0;k<n;k++){
                    grid[j][k] = in.nextInt();
                    if(j==k){
                        trace+=grid[j][k];
                    }
                }
            }
            int r = getRows(n, grid);
            int c = getCols(n, grid);
            System.out.println("Case #"+i+": "+trace+" "+r+" "+c);
        }
    }
}