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
      HashMap<Integer, HashMap<Integer, Integer>> rows = new HashMap<Integer, HashMap<Integer, Integer>>();
      HashMap<Integer, HashMap<Integer, Integer>> columns = new HashMap<Integer, HashMap<Integer, Integer>>();
      int counterr = 0;
      int counterc = 0;
      int traccia = 0;
      int memo = 0;
      for (int i = 1; i <= size; ++i) {
          for (int j = 1; i <= size; ++i) {
              memo = in.nextInt();
              if(columns.get(j).keySet().contains(memo)){
                  counterc++;
                  
              }else{
                  columns.get(j).put(memo, 0);
              }
              
              if(rows.get(i).keySet().contains(memo)){
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
