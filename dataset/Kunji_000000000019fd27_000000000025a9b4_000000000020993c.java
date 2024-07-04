package solutions;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Vestigium {

	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int iteration = 1; iteration <= testCases; ++iteration) {
          int n = in.nextInt();
          int[][] matrix = new int[n][n];
          for(int i = 0; i < n; ++i) {
        	  for(int j = 0; j < n; ++j) {
        		  int m = in.nextInt();
        		  matrix[i][j] = m;
        	  }
          }
          int trace = 0;
          int rowCount = 0;
          int colCount = 0;
          for(int i = 0; i<n;i++) {
        	  trace += matrix[i][i];
        	  Set<Integer> uniqueRow = new HashSet<>();
        	  Set<Integer> uniqueCol = new HashSet<>();
        	  for(int j = 0; j<n;j++) {
        		  uniqueRow.add(matrix[i][j]);
        		  uniqueCol.add(matrix[j][i]);
              }
        	  rowCount = checkUniqueAndIncrement(n, rowCount, uniqueRow);
    		  colCount = checkUniqueAndIncrement(n, colCount, uniqueCol);
          }
          sop("Case #" + (iteration) + " " + trace + " " + rowCount + " " + colCount);
        }
	}

	private static int checkUniqueAndIncrement(int n, int rowCount, Set<Integer> uniqueRow) {
		int rowSum = n - uniqueRow.size();
		  if(rowSum != 0) {
			  rowCount++;
		  }
		return rowCount;
	}
	
	private static void sop(String s){
		System.out.println(s);
	}
}
