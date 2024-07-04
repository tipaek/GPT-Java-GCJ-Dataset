import java.util.*;
import java.io.*;
public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int numTests = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
    for (int i = 0; i < numTests; i++) {
      int numRowsAndCols = in.nextInt();
      int trace = 0;
      int numRowsWithDuplicates = 0;
      int numColsWithDuplicates = 0;

      ArrayList<Set<Integer>> maxtrixCols = new ArrayList<>();
      for(int j = 0; j < numRowsAndCols ; j++) {
    	  maxtrixCols.add(new HashSet<Integer>());
      }
      
      for(int j = 0; j < numRowsAndCols ; j++) {
    	  Set<Integer> row = new HashSet<>();
    	  
    	  for(int k = 0; k < numRowsAndCols ; k++) {
    		  int value = in.nextInt();
    		  row.add(value);
    		  maxtrixCols.get(k).add(value);
    		  if(j==k) {
    			  trace += value;
    		  }
    	  }
    	  if(row.size() < numRowsAndCols) {
    		  numRowsWithDuplicates++;
    	  }
      }
      
      for(int j = 0; j < maxtrixCols.size(); j++) {
    	  if(maxtrixCols.get(j).size() < numRowsAndCols) {
    		  numColsWithDuplicates++;
    	  }
      }
      
      
      System.out.println("Case #" + i+1 + ": " + trace + " " + numRowsWithDuplicates + " " + numColsWithDuplicates);
    }
  }
}