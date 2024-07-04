import java.util.*;
import java.io.*;

public class Solution {

      public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
          int n = in.nextInt();
          int [][] matrix = new int [n][n];
          for (int line = 0; line<n; line++) {
        	  for (int col = 0; col<n; col++) {
        	       int value = in.nextInt();
        	       matrix[line][col] = value;
        	  }
          }
          int[] currentResult = Solution.calculateValue(n, matrix);
          System.out.println("Case #"+i+": "+currentResult[0]+" "+currentResult[1]+" "+currentResult[2]);
        }
      }
      
      public static int[] calculateValue (int n, int [][] matrix) {
    	  int [] result = new int[3];
    	  
    	  int trace = 0;
    	  for (int i=0; i<n; i++) {
    		  trace+=matrix [i][i];
    	  }
    	  result [0] = trace;
    	  
    	  int cols = 0;
    	  for (int i=0; i<n; i++) {
    		  // check col i
    		  boolean[] currentColUsed = new boolean [n];
    		  for (int r=0; r<n; r++) {
    			  int value = matrix [r][i];
    			  if (currentColUsed [value - 1] == true) {
    				  cols += 1;
    				  break;
    			  } else {
    				  currentColUsed [value - 1] = true;
    			  }
    		  }
    	  }
    	  result [2] = cols;
    	  
    	  int rows = 0;
    	  for (int i=0; i<n; i++) {
    		  // check row i
    		  boolean[] currentRowUsed = new boolean [n];
    		  for (int c=0; c<n; c++) {
    			  int value = matrix [i][c];
    			  if (currentRowUsed [value - 1] == true) {
    				  rows += 1;
    				  break;
    			  } else {
    				  currentRowUsed [value - 1] = true;
    			  }
    		  }
    	  }
    	  result [1] = rows;
    	  
    	  return result;
      }
}
