    import java.util.*;
    import java.io.*;
    public class Solution {
      public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.

        for (int i = 1; i <= t; ++i) {
          int n = in.nextInt();
          int [][] matrix = new int[n][n];
          int [][] transpose;
          int trace = 0;
          int num = 0, row = 0, col = 0;
          
          for(int x = 0; x < n; x++) {
        	  for(int y = 0; y < n; y++) {
        		  num = in.nextInt();
        		  matrix[x][y] = num;
        		  if (x == y)
        			  trace += num;
        	  }
          }
          transpose =  transpose(matrix, n);
          
          for (int x = 0; x < n; x++) {
              Arrays.sort(matrix[x]);
          }
          
          for (int x = 0; x < n; x++) {
        	  for(int y = 0; y < (n-1); y++) {
        		  if (matrix[x][y] == matrix[x][y+1]) {
        			  row += 1;
        			  break;
        		  }
        	  }
          }
          
          for (int x = 0; x < n; x++) {
              Arrays.sort(transpose[x]);
          }
          
          for (int x = 0; x < n; x++) {
        	  for(int y = 0; y < (n-1); y++) {
        		  if (transpose[x][y] == transpose[x][y+1]) {
        			  col += 1;
        			  break;
        		  }
        	  }
          }
          
          System.out.println("Case #" + i + ": " + trace + " " + row + " " + col);
          trace = 0;
          row = 0;
          col = 0;
        }
      }
      
      public static int [][] transpose(int [][] matrix, int n ) {
    	    int[][] temp = new int[n][n];
    	    for (int i = 0; i < n; i++) {
    	      for (int j = 0; j < n; j++) {
    	        temp[i][j] = matrix[j][i];
    	      }
    	    }
    	    return temp;
    	  }
    }