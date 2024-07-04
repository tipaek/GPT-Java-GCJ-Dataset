import java.util.*;
import java.io.*;
public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
    for (int i = 1; i <= t; ++i) {
        int trace = 0;
        int r = 0;
        int c = 0;
          int size = in.nextInt();
          int[][] matrix = new int[size][];
          for(int j = 0; j < size; j++){
          List<Integer> rows = new ArrayList<>();
          matrix[j] = new int[size];
    	  for(int k = 0; k < size; k++) {
    		  int elem = in.nextInt();
    		  matrix[j][k] = elem;
    		  if(rows != null) {
    			  if(rows.contains(elem)){
    				  r++;
    				  rows = null;
		          }
    			  else {
	    			  rows.add(elem);
    			  }
    		  }
	          if(k == j){
	              trace += matrix[j][k];
	          }
    	  }
      }
      for(int j = 0; j < size; j++){
          List<Integer> cols = new ArrayList<>();
    	  for(int k = 0; k < size; k++) {
    		  int elem = matrix[k][j];
    		  if(cols != null) {
    			  if(cols.contains(elem)){
    				  c++;
    				  cols = null;
		          }
    			  else {
    				  cols.add(elem);
    			  }
    		  }
    		  
    	  }
      }
      System.out.println("Case #"+i+": "+trace+" "+r+" "+c);
     }
  }
}