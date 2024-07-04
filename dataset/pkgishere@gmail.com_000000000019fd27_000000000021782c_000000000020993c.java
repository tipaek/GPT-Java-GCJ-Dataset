import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Solution {
    
    public static void main(String args[]){

    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int test_cases = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
    for (int i = 1; i <= test_cases; ++i) {
      int n = in.nextInt();
      int[][] array = new int[n][n];
      int trace = 0;
      Map<Integer,Set<Integer>> columnTrace= new HashMap<>();
      Map<Integer,Set<Integer>> rowTrace= new HashMap<>();
      boolean[] isColumnNRepeated = new boolean[n];
      boolean[] isRowNRepeated = new boolean[n];
      for(int row=0;row<n;row++){
          for(int column=0;column<n;column++){
              array[row][column] = in.nextInt();
              if(row ==column) trace += array[row][column];
              
              Set<Integer> currentColumnValues = columnTrace.getOrDefault(column,new HashSet<>());
              Set<Integer> currentRowValues = rowTrace.getOrDefault(row,new HashSet<>());
              
              if(currentRowValues.contains(array[row][column])) isRowNRepeated[row] = true;
              if(currentColumnValues.contains(array[row][column])) isColumnNRepeated[column] = true;
              
              currentColumnValues.add(array[row][column]);
              currentRowValues.add(array[row][column]);
              
              columnTrace.put(column, currentColumnValues);
              rowTrace.put(row,currentRowValues);
          }
      }
      int numberOfRowsRepeated=0;
      int numberOfColumnsRepeated=0;
      for(int k=0;k<n;k++){
          if(isColumnNRepeated[k]) numberOfColumnsRepeated++;
          if(isRowNRepeated[k]) numberOfRowsRepeated++;
      }
      System.out.println("Case #" + i + ": " + trace + " " + numberOfRowsRepeated + " "+ numberOfColumnsRepeated);
    }
  }
}