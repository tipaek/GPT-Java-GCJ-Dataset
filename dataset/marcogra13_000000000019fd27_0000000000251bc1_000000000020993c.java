import java.util.*;
import java.io.*;

public class Solution{

static void printResult(int input,int k ,int r ,int c){
    System.out.println("Case #" + input + ": " + k + " " + r + " " + " " + c);
}


public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int totalMatrices = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        int[][] result = new int[totalMatrices][3];
        
        for (int m = 0; m < totalMatrices ; m++) { // cycle on all the inputs
        int s1 = in.nextInt(); // Size of first matrix
        int[][] mat1 = new int[s1][s1];
        // Build the matrix
        int trace = 0;
        int equalRows = 0;
        int equalCol = 0;
      
        for (int i = 0; i < s1; i++) { // Scan rows
          int[] provvRow = new int[s1];
            for (int j = 0; j < s1; j++){ // Scan coloumns
              mat1[i][j] = in.nextInt();
              // Add to the row to compute duplicates
              for(int k = 0; k < s1; k++){
                  if (k == mat1[i][j] - 1 ) {
                      provvRow[k]++;
                  }
                
              }

              // Calculate trace
                if (i == j){
                    trace += mat1[i][j];
                }
                
            }
            // Compute number of rows with duplicates
            for(int k = 0; k < s1; k++){
              if (provvRow[k] > 1){
                      equalRows++;
                      break;
                  }
            }
        }
        
        // Check duplicates in coloumns
        
         for (int i = 0; i < s1; i++) { // Scan coloumns
         int[] provvCol = new int[s1];
            for (int j = 0; j < s1; j++){ // Scan raws
            for(int k = 0; k < s1; k++){
                if(mat1[j][i] - 1 == k){
                    provvCol[k]++;
                }
            }
            }
            for(int k = 0; k < s1; k++){
              if (provvCol[k] > 1){
                      equalCol++;
                      break;
                  }
            }
         }
             result[m][0] = trace;
         result[m][1] = equalRows;
         result[m][2] = equalCol;
        }
        
        for(int y = 0; y < totalMatrices; y++){
            Solution.printResult(y+1, result[y][0], result[y][1], result[y][2]);
        }
      }



}