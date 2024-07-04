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
      
      int[][] matrix = new int[size][size];
      int counterr = 0;
      int counterc = 0;
      int traccia = 0;
      int memor = 0;
      int memoc = 0;
      int memo;
      HashMap<Integer, Integer> hashr;
      HashMap<Integer, Integer> hashc;
      for (int i = 0; i < size; i++) {
          for (int j = 0; j < size; j++) {
              memo = in.nextInt();
              matrix[i][j] = memo;
              if(i == j){
                  traccia += memo;
              }
          }  
       }
       
       for (int i = 0; i < size; i++) {
          hashr = new HashMap<Integer, Integer>();
          hashc = new HashMap<Integer, Integer>();
          boolean checkr = true;
          boolean checkc = true;
          for (int j = 0; j < size; j++) {
              memor = matrix[i][j];
              memoc = matrix[j][i];
              if(hashc.containsKey(memoc) && checkc){
                  counterc++;
                  checkc = false;
              }else{
                  hashc.put(memoc, 0);
              }
              
              if(hashr.containsKey(memor) && checkr){
                  counterr++;
                  checkr = false;
                  
              }else{
                  hashr.put(memor, 0);
              }
              
          }  
       }
       System.out.println("Case #" + cases + ": " + (traccia) + " " + (counterr) + " " + (counterc));
  }
}
