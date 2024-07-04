import java.util.*;
import java.io.*;
public class Solution {
    class NumberHashSet extends HashSet<Integer> {}
    public static void main(String[] args) {
    int res = 0;
    
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
    for (int i = 1; i <= t; ++i) {
      
      int n = in.nextInt();
      Set<Integer>[] col = new NumberHashSet[n];
      Set<Integer>[] row = new NumberHashSet[n];
      Boolean[] col1 = new Boolean[n];
      Boolean[] row1 = new Boolean[n];
      for(int y = 0; y < n; y++){
          row[y] = new HashSet<Integer>();
          col[y] = new HashSet<Integer>();
      }
      System.out.println(n);
      for(int j = 0; j < n; j++){
          for(int k = 0; k < n; k++){
              
              int line = in.nextInt();
              if(j==k){
                  res += line;
              }
              if(col[k].contains(line)){
                  col1[k] = true;
              }else{
                  col[k].add(line);
              }
              if(row[j].contains(line)){
                  row1[j] = true;
              }else{
                  row[j].add(line);
              }
            //   System.out.println(line);
          }
      }
      int r = 0;
      int c = 0;
      for(int a = 0; a < row1.length; a++){
          if(row1[a]){
              r++;
          }
      }
      for(int b = 0; b < col1.length; b++){
          if(col1[b]){
              c++;
          }
      }
      int m = in.nextInt();
      System.out.println("Case #" + n + ": " + r + " " + c);
    }
  }
}