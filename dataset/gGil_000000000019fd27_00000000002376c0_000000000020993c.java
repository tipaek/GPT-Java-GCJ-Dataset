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
      ArrayList<ArrayList<Integer>> rows = new ArrayList<ArrayList<Integer>>();
      ArrayList<ArrayList<Integer>> columns = new ArrayList<ArrayList<Integer>>();
      int counterr = 0;
      int counterc = 0;
      int traccia = 0;
      for (int i = 1; i <= size; ++i) {
          for (int j = 1; i <= size; ++i) {
              int memo = in.nextInt();
              if(columns.get(j).contains(memo)){
                  counterc++;
                  
              }else{
                  columns.get(j).add(memo);
              }
              
              if(rows.get(i).contains(memo)){
                  counterr++;
                  
              }else{
                  rows.get(i).add(memo);
              }
              
              if(i == j){
                  traccia += memo;
              }
            }
              
        }
        System.out.println("Case #" + cases + ": " + (traccia) + " " + (counterr) + " " + (counterc));
  }
}
