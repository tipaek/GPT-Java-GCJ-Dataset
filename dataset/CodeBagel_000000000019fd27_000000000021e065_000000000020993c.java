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
                
            }
            
        }

        int expectedLatinSum = 0;
        for(int j = 0; j < n; j++){
            trace += matrix[j][j];
            expectedLatinSum += (j + 1);
        }

        //System.out.println("Expected: " + expectedLatinSum);
        
        for(int j = 0; j < n; j++){
            
            int rowSum = 0;
            int colSum = 0;
            int[] numRowCount = new int[n];
            int[] numColCount = new int[n];
            
            for(int k = 0; k < n; k++){
                rowSum += matrix[j][k];
                colSum += matrix[k][j];
                numRowCount[matrix[j][k] - 1]++;
                numColCount[matrix[k][j] - 1]++;
            }
            
            for(int k = 0; k < n; k++){
                if(numRowCount[k] != 1){
                    duplicateRows++;
                    break;
                }
            }
            
            for(int k = 0; k < n; k++){
                if(numColCount[k] != 1){
                    duplicateCols++;
                    break;
                }
            }
            
        }

        System.out.println("Case #" + i + ": " + trace + " " + duplicateRows + " " + duplicateCols);
        
        
    }
    
  }
  
}