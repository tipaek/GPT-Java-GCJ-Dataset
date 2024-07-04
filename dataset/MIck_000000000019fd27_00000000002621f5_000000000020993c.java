import java.util.*;
import java.io.*;
public class Solution {
  public static void main(String[] args) {
	  
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt(); //Number of cases
    
    String unused = in.nextLine();
    for (int i = 1; i <= t; ++i) {//iterate over number of cases
	  int trace = 0;
	  int rowDuplicates = 0;
	  int colDuplicates = 0;
	  
      int N = in.nextInt();//
      unused = in.nextLine();
      boolean[] uniqueCols = new boolean[N];
      ArrayList<HashSet<String>> cols = new ArrayList<HashSet<String>>();
      for (int rowIndex = 0; rowIndex<N ; rowIndex++) {
    	  HashSet<String> rowSet = new HashSet<String>();
    	  
    	  String[] line = in.nextLine().split(" "); 
    	  trace += Integer.parseInt(line[rowIndex]);
    	  boolean uniqueRow = true;
    	  for(int colIndex = 0; colIndex<N ; colIndex++) {
    		  if(rowIndex == 0) {
    			  cols.add(new HashSet<String>());
    			  uniqueCols[colIndex] = true;
    		  }
    		  if(uniqueRow && rowSet.add(line[colIndex]) == false) {
    			  uniqueRow = false;
    			  rowDuplicates++;
    		  }
    		  if(uniqueCols[colIndex] && cols.get(colIndex).add(line[colIndex]) == false) {
    			  uniqueCols[colIndex] = false;
    			  colDuplicates++;
    		  }
    	  }
      }
      System.out.println("Case #" + i + ": " + trace + " " + rowDuplicates + " " + colDuplicates);     
    }
    in.close();
  }
}