
import java.util.*;
import java.io.*;
public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
    for (int i = 1; i <= t; ++i) {
      int n = in.nextInt();
      int[][] matrix = new int[n][n];
      
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
  public static int trace(int[][] mat){
		 int count = 0;
		 for(int r = 0; r<mat.length;r++) {
	 		for(int c = 0; c<mat[0].length;c++) {
	 			if(c==r)count+=mat[r][c];
	     	}
	 	}
		return count;  
	  }
	  
	  public static int col(int[][] mat) {
		  int count = 0;  
			 for(int c = 0; c<mat[0].length;c++) {
				 String s = "";
		 		for(int r = 0; r<mat.length;r++) {
		 			if(s.contains(mat[r][c]+"")) {
		 				count++;
		 				break;
		 			}
		 			else{
		 			   s+=mat[r][c]+"";
		 			}
		     	}
		 	}
		  return count;
	  }
	  public static int row(int[][] mat) {
		  int count = 0;  
			 for(int r = 0; r<mat.length;r++) {
				 String s = "";
		 		for(int c = 0; c<mat[0].length;c++) {
		 			if(s.contains(mat[r][c]+"")) {
		 				count++;
		 				break;
		 			}
		 			else {
		 			    s+=mat[r][c]+"";
		 			}
		     	}
		 	}
		  return count;
	  }
}