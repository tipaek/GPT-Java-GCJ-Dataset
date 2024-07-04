import java.util.*;
import java.io.*;
public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
    for (int i = 1; i <= t; ++i) {
      solve(in, i);
    }
  }
  
  public static void solve(Scanner in, int cases){
      int size = in.nextInt();
      HashMap<HashMap<Integer, Integer>> rows = new HashMap<HashMap<Integer, Integer>>();
      HashMap<HashMap<Integer, Integer>> columns = new HashMap<HashMap<Integer, Integer>>();
      int counterr = 0;
      int counterc = 0;
      int traccia = 0;
      for (int i = 1; i <= size; ++i) {
          for (int j = 1; i <= size; ++i) {
              int memo = in.nextInt();
              if(HashMap.get(j).containsKey(memo)){
                  counterc++;
                  
              }else{
                  columns.get(j).put(memo, 0);
              }
              
              if(rows.get(i).containsKey(memo)){
                  counterr++;
                  
              }else{
                  rows.get(i).put(memo, 0);
              }
              
              if(i == j){
                  traccia += memo;
              }
            }
              
        }
        System.out.println("Case #" + cases + ": " + (traccia) + " " + (counterr) + " " + (counterc));
  }
}
