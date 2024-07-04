import java.util.*;
import java.io.*;
public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
    for (int i = 1; i <= t; ++i) {
      int n = in.nextInt();
      in.nextLine();
      int traceSum = 0;
      int rowCount = 0;
      int colCount = 0;
      boolean isDup = false;
      int[][] arr = new int[n][n];
      int[] seen = new int[n];
      for (int j = 0; j < n; j++) {
    	  for (int k = 0; k < n; k++) {
    		  seen[k] = 0;
    	  }
    	  isDup = false;
    	  String row = in.nextLine();
    	  String[] r = row.split(" ");
    	  for (int k = 0; k < n; k++) {
    		  int curr = Integer.parseInt(r[k]);
    		  arr[j][k] = curr;
    		  if (seen[curr - 1] == 1 && !isDup) {
    			  isDup = true;
    			  rowCount++;
    		  }
    		  seen[curr - 1] = 1;
    		  if (j == k) {
    			  traceSum += curr;
    		  }
    	  }
      }
      
      for (int j = 0; j < n; j++) {
    	  for (int k = 0; k < n; k++) {
    		  seen[k] = 0;
    	  }
    	  isDup = false;
    	  for (int k = 0; k < n; k++) {
    		  int curr = arr[k][j];
    		  if (seen[curr - 1] == 1 && !isDup) {
    			  isDup = true;
    			  colCount++;
    		  }
    		  seen[curr - 1] = 1;
    	  }
      }
      
      System.out.println("Case #" + i + ": " + traceSum + " " + rowCount + " " + colCount);    
    }
  }
}