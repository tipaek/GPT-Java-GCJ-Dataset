import java.util.*;
import java.io.*;
public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
        
        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt();
            
            int[][] grid = new int[n][n];
            for(int row = 0; row < n; row++){
                for(int col = 0; col < n; col++){
                    int cell = in.nextInt();
                    
                    grid[row][col] = cell;
                }
            }
            
            
            int k = getTrace(grid);
            int r = getRepeatedRows(grid);
            int c = getRepeatedCols(grid);
            
            System.out.println("Case #" + i + ": " + k + " " + r + " " + c);
        }
    }
    
    private static int getRepeatedCols(int[][] grid){
        Set<Integer> vals = new HashSet<>();
        int badCols = 0;
        
        for(int j = 0; j < grid.length; j++){
            vals.clear();
            for(int i = 0; i < grid.length; i++){
                if(vals.contains(grid[i][j])){
                    badCols++;
                    break;
                }
                
                vals.add(grid[i][j]);
            }
        }
        
        return badCols;
    }
    
    private static int getRepeatedRows(int[][] grid){
        Set<Integer> vals = new HashSet<>();
        int badRows = 0;
        
        for(int i = 0; i < grid.length; i++){
            vals.clear();
            for(int j = 0; j < grid[i].length; j++){
                if(vals.contains(grid[i][j])){
                    badRows++;
                    break;
                }
                
                vals.add(grid[i][j]);
            }
        }
        
        return badRows;
    }
    
    private static int getTrace(int[][] grid){
        int sum = 0;
        for(int i = 0; i < grid.length; i++){
            sum += grid[i][i];
        }
        
        return sum;
    }
}