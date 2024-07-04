import java.util.*;
import java.io.*;
public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
    for (int i = 1; i <= t; ++i) {
      int n = in.nextInt(); //matrix size
      int[][] m = new int[n][n];
      int rows = 0;
      int col = 0; 
      int trace = 0; 
      List<Integer> list = new ArrayList<Integer>(); 
      boolean rowFlag = false; 
      boolean colFlag = false; 
      for (int r = 0; r<n; r++){
          for(int c = 0; c<n; c++){
              m[r][c] = in.nextInt(); 
          }
      }
      //trace 
      for(int d=0; d<n; d++){
          trace+=m[d][d];
          list.add(d+1);
      }
      List<Integer> listR = new ArrayList<Integer>(list);
      List<Integer> listC = new ArrayList<Integer>(list); 
      //rows and columns 
      for (int r = 0; r<n; r++){
          for(int c = 0; c<n; c++){
              listR.remove(Integer.valueOf(m[r][c]));
              listC.remove(Integer.valueOf(m[c][r])); 
          }
          if(!listR.isEmpty()){
              rows+=1; 
          }
          if(!listC.isEmpty()){
              col+=1; 
          }
          listR.clear();
          listC.clear();
          listR.addAll(list);
          listC.addAll(list);
      }
      
      System.out.println("Case #" + i + ": " + trace + " " + rows + " " + col);
    }
  }
}