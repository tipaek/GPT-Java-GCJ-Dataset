
import java.util.*;
import java.io.*;
import java.util.Arrays;
public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
    for (int i = 1; i <= t; i++) {
      int n = in.nextInt();
      Integer[][] matrix = new Integer[n][n];
      
      for(int row = 0; row<n;row++) {
    	  for (int col = 0; col<n; col++) {
    		  matrix[row][col] = in.nextInt();
    	  }
      }
      System.out.print("Case #"+i+": ");
      System.out.print(trace(matrix) + " ");
      System.out.print(row(matrix) + " ");
      System.out.print(col(matrix));
      System.out.println();
    }
  }
  public static int trace(Integer[][] mat){
		 int count = 0;
		 for(int r = 0; r<mat.length;r++) {
	 		for(int c = 0; c<mat[0].length;c++) {
	 			if(c==r)count+=mat[r][c];
	     	}
	 	}
		return count;  
	  }
	  
  public static Integer[] getColumn(Integer[][] array, int index){
	    Integer[] column = new Integer[array[0].length]; // Here I assume a rectangular 2D array! 
	    for(int i=0; i<column.length; i++){
	       column[i] = array[i][index];
	    }
	    return column;
	}
	  public static int col(Integer[][] mat) {
		  int count = 0;
		  for (int col = 0; col < mat[0].length; col++) {
		        Integer[] curCol = getColumn(mat, col);
		        Set<Integer> set = new HashSet<>(Arrays.asList(curCol)); 
		        if (set.size() < curCol.length) {
		            count++;
		        }
		    }
		    return count;
	  }
	  public static int row(Integer[][] mat) {
		  int count = 0;
		  for (int row = 0; row < mat[0].length; row++) {
		        Integer[] curRow = mat[row];
		        Set<Integer> set = new HashSet<>(Arrays.asList(curRow)); 
		        if (set.size() < curRow.length) {
		            count++;
		        }
		    }
		    return count;
	  }
}