
import java.util.*;
import java.io.*;
public class Solution {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int numCases = scanner.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
    for (int curCase = 1; curCase <= numCases; curCase++) {
    	int size = scanner.nextInt();
    	int[][] matrix = new int[size][size];
    	for(int row = 0; row < size; row++) {
    		for(int col = 0; col < size; col++) {
    			matrix[row][col] = scanner.nextInt();
    		}
    	}
    	System.out.println("Case #" + curCase + ": " + getTrace(matrix) + " " + getNumRepeatedRows(matrix) + " " + getNumRepeatedCols(matrix));
    }
  }
  
  public static int getTrace(int[][] matrix) {
		int sum = 0;
		for(int i = 0; i < matrix.length; i++) {
			sum += matrix[i][i];
		}
		return sum;
  }
  
  public static int getNumRepeatedRows(int[][] matrix) {
	  int count = 0;
	  HashSet<Integer> cache = new HashSet<Integer>();
	  for(int row = 0; row < matrix.length; row++) {
		  cache.clear();
		  for(int col = 0; col < matrix.length; col++) {
			  if(cache.contains(matrix[row][col])) {
				  count++;
				  break;
			  }
			  cache.add(matrix[row][col]);
		  }
	  }
	  return count;
  }
  
  public static int getNumRepeatedCols(int[][] matrix) {
	  int count = 0;
	  HashSet<Integer> cache = new HashSet<Integer>();
	  for(int col = 0; col < matrix.length; col++) {
		  cache.clear();
		  for(int row = 0; row < matrix.length; row++) {
		   if(cache.contains(matrix[row][col])) {
				  count++;
				  break;
			  }
			  cache.add(matrix[row][col]);
		  }
	  }
	  return count;
  }
}

