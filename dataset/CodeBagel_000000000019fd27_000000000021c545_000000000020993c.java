import java.util.*;
import java.io.*;

public class Solution {
  
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int cases = in.nextInt();  
    
    for (int i = 1; i <= cases; ++i) {
        
        int n = in.nextInt();
        int[][] matrix = new int[n][n];
        int trace = 0;
        int duplicateRows = 0;
        int duplicateCols = 0;
        
        for(int j = 0; j < n; j++){
            
            for(int k = 0; k < n; k++){
                
                int val = in.nextInt();
                matrix[j][k] = val;
                // System.out.print(val + " ");
                
            }
            
            // System.out.println(" ");
            
        }
        
        boolean[] duplicateRow = new boolean[n];
        boolean[] duplicateCol = new boolean[n];
        
        for(int j = 1; j <= n; j++){
            
            for(int k = 0; k < n; k++){
            
                int row = -1;
                
                for(int l = 0; l < n; l++){
                    
                    if(matrix[k][l] == j){
                        
                        if(row == -1){
                            row = k;
                        } else{
                            duplicateRow[l] = true;
                            duplicateRow[row] = true;
                            row = -1;
                            break;
                        }
                        
                    }
                    
                }
                
                int col = -1;
                
                for(int l = 0; l < n; l++){

                    if(matrix[l][k] == j){
                        if(col == -1){
                            col = k;
                        } else{
                            // System.out.println("l: " + l + " col: " + col);
                            duplicateCol[l] = true;
                            duplicateCol[col] = true;
                            col = -1;
                            break;
                        }
                    }
                    
                }
                
            } 
                
        }
        
        // System.out.print("[");
        for(int j = 0; j < n; j++){
            // System.out.print(duplicateRow[j] + " ");
            if(duplicateRow[j]){
                duplicateRows++;
            }
        }
        // System.out.print("]\n");
        
        // System.out.print("[");
        for(int j = 0; j < n; j++){
            // System.out.print(duplicateCol[j] + " ");
            if(duplicateCol[j]){
                duplicateCols++;
            }
        }
        // System.out.print("]\n");
        
        for(int j = 0; j < n; j++){
            trace += matrix[j][j];
        }
        

        System.out.println("Case #" + i + ": " + trace + " " + duplicateRows + " " + duplicateCols);
        
        
    }
    
  }
  
}