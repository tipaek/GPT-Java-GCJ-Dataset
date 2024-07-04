
import java.util.*;
import java.io.*;

public class Solution {
	  public static void main(String[] args) {
		    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		    int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
		    for (int i = 1; i <= t; ++i) {
		      int n = in.nextInt();
		      boolean[] rowflags = new boolean [n];
		      boolean[] colflags = new boolean [n];
		      int trace = 0;
		      int rowCount=0;
		      int colCount=0;
		      int[][] mat = new int[n][n];
		      for(int k=0;k<n;k++) {
		    	  for(int j=0;j<n;j++)
		    	  {
		    		  int m = in.nextInt();
		    		  mat[k][j] = m;
		    		  if(k==j)
		    			  trace+=m;
		    	  }
		      }
		      
		      for(int row=0;row<n;row++) {
		    	  for(int col=0;col<n;col++)
		    	  {
		    		  int val=mat[row][col];
		    		  
		    		  if(rowflags[val-1]==true) { rowCount++; break; }
		    		  rowflags[val-1]=true;
		    	  }
		    	  rowflags = new boolean [n];
		      }
		      
		      for(int col=0;col<n;col++) {
		    	  for(int row=0;row<n;row++)
		    	  {
		    		  int val=mat[row][col];
		    		  if(colflags[val-1]==true) { colCount++; break; }
		    		  colflags[val-1]=true;
		    	  }
		    	  colflags = new boolean [n];
		      }
		      System.out.println("Case #" + i + ": " + trace + " " + rowCount + " " + colCount);
		    }
		  }
}


