import java.util.*;
import java.io.*;

public class Solution {
	
  public static void main(String[] args) {  
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt();
    for (int i = 1; i <= t; ++i) {
        int n = in.nextInt();
    	int d = 0;
    	int c = 0;
    	int r = 0;
    	int[][] matrix = new int[n][n];
  	  
	    for (int j = 0; j < n; j++) {
	  	  	Set<Integer> row = new HashSet<>();
	    	boolean rowRepeat = false;
	    	for (int k = 0; k < n; k++) {
		      int s = in.nextInt();
		      matrix[j][k] = s;
		      
		      // diagonal
		      if (j == k) {
		    	  d += s;
		      }
		      
		      // row repeat
		      if (!rowRepeat && row.contains(s)) {
		    	  r += 1;
		    	  rowRepeat = true;
		      } else {
		    	  row.add(s);
		      }
	    	}
	    }
  	  	
	    for (int j = 0; j < n; j++) {
	    	Set<Integer> col = new HashSet<>();
	    	boolean colRepeat = false;
	    	for (int k = 0; k < n; k++) {
	    		int s = matrix[k][j];
			    // column repeat
				if (!colRepeat && col.contains(s)) {
					c += 1;
					colRepeat = true;
				} else {
					col.add(s);
				}
	    	}
	    }
	    
	    System.out.println("Case #" + i + ": " + d + " " + r + " " + c);
    }
  }

}
