import java.util.*;
import java.io.*;

public class Solution {
    
    private int checkNumberOfRowForDuplicatcy(int[][] mat, int matrixLength) {
        int sum = 0;
        
        for (int j = 0; j < matrixLength; j++) {
            int[] temp = new int[matrixLength + 1];
            int flag = 0;
            for (int k = 0; k < matrixLength; k++) {
                temp[k] = mat[j][k];
            }
            Arrays.sort(temp); 
            for (int k = 0; k < matrixLength; k++) {
                if ( temp[k] == temp[k + 1] ) {
                    flag = 1;
                }
            }
            if ( flag == 1 ) sum++;
        }
        
        return sum;
    }
    
    private int calDignalSum(int[][] mat, int matrixLength){
        int sum = 0;
        
        for (int j = 0; j < matrixLength; j++) {
            for (int k = 0; k < matrixLength; k++) {
                if ( j == k ) sum+=mat[j][k];
            }
        }
        
        return sum;
    }
    
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    Solution sol = new Solution();
    int cases = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
    for (int i = 1; i <= cases; ++i) {
      int matrixLength = in.nextInt(); // N
      int[][] matrix = new int[matrixLength][matrixLength] ;
      int[][] matrixTranspose = new int[matrixLength][matrixLength] ;
      for (int j = 0; j < matrixLength; j++) {
        for (int k = 0; k < matrixLength; k++) {
            matrix[j][k] = in.nextInt();
        }
      }
      int digonalSum = sol.calDignalSum(matrix, matrixLength);
      int rowDuplicate = sol.checkNumberOfRowForDuplicatcy(matrix, matrixLength);
      
    for(int ij=0; ij<matrixLength; ij++){    
        for(int jk=0; jk<matrixLength; jk++){    
            matrixTranspose[ij][jk]=matrix[jk][ij];  
        }    
    }  
      
      int columnDuplicate = sol.checkNumberOfRowForDuplicatcy(matrixTranspose, matrixLength);
      System.out.println("Case #" + i + ": " + digonalSum + " " + rowDuplicate + " " + columnDuplicate);
     // System.exit(0);
    }
  }
}