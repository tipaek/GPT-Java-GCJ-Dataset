import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
	    int t = in.nextInt(); 
	    for (int i = 1; i <= t; ++i) {
	      int n = in.nextInt();
	      Integer[][] matrix = new Integer[n][n];
	      int trace = 0;
	      int repeatingRows = 0;
	      int repeatingColumns = 0;
	      for(int j = 0; j < n; j++) {
	    	  for(int k = 0; k < n; k++) {
	    		  matrix[j][k] = in.nextInt();
	    		  if (j == k) {
	    			  trace = trace + matrix[j][j];
	    		  }
	    	  }
	    	  Set<Integer>uniqueElements = new HashSet<Integer>(
	    			  Arrays.asList(matrix[j]));
	    	  if (uniqueElements.size() != n) {
	    		  repeatingRows++;
	    	  }
	      }
	      for(int k = 0; k < n; k++) {
	    	  Integer[] column = new Integer[n];
	    	  for(int j = 0; j< n; j++) {
	    		  column[j] = matrix[j][k];
	    	  }
	    	  Set<Integer>uniqueElements = new HashSet<Integer>(
	    			  Arrays.asList(column));
	    	  if (uniqueElements.size() != n) {
	    		  repeatingColumns++;
	    	  }
	      }
	      System.out.println("Case #" + i + ": " + trace + " " + repeatingRows + " " +
	    		  repeatingColumns);
	    }
	    in.close();
	}
}
