import java.util.*;
import java.io.*;

import java.util.*;
import java.io.*;

public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int numTestCases = in.nextInt();  
    for (int i = 1; i <= numTestCases; ++i) {
      int rc = in.nextInt();
      int trace = 0;
      int arr[][] = new int [rc][rc];
      /*
      for(int r=0;r<rc;r++){
          for(int c=0; c<rc;c++){
              arr[r][c] = in.nextInt(); 
          }
      }
      */
    HashSet<Integer> [] rows = new HashSet[rc];
    HashSet<Integer> [] columns = new HashSet[rc];
 
    for (int n = 0; n < rc; n++) {
      rows[n] = new HashSet<Integer>();
      columns[n] = new HashSet<Integer>();
    }   
    
    HashSet<Integer> rowsCount = new HashSet<>();
    HashSet<Integer> colmsCount = new HashSet<>();
    
    for(int r=0;r<rc;r++){
          for(int c=0; c<rc;c++){
              arr[r][c] = in.nextInt(); 
              if (r==c){
                  trace += arr[r][c];
              }
              if(rows[r].contains(arr[r][c])){
            	  rowsCount.add(r);
              }
              rows[r].add(arr[r][c]);
              
              if(columns[c].contains(arr[r][c])){
            	  colmsCount.add(c);
              }
              
              columns[c].add(arr[r][c]);

          }
      }
      System.out.println("Case #" + i + ": " + trace  + " " + rowsCount.size() + " " + colmsCount.size());
      
    }
    
  }
}