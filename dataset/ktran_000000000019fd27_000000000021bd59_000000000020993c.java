import java.util.*;
import java.io.*;
public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
    for (int i = 1; i <= t; ++i) {
      int N = in.nextInt();
      
      int trace = 0;
      int row = 0;
      int col = 0;
      int sum = N*(N+1)/2;
      
      int[] rows = new int[N];
      int[] cols = new int[N];
      
      for(int n1 = 0; n1 < N; n1++) {
          for(int n2 = 0; n2 < N; n2++) {
            int cell = in.nextInt();
            rows[n1] += cell;
            cols[n2] += cell;
            if(n1 == n2) {
                trace += cell;
            }
          }
      }
      
      for(int n = 0; n < N; n++){
          if(rows[n] != sum) row++;
          if(cols[n] != sum) col++;
      }
      
      
      
      System.out.println("Case #" + i + ": " + trace + " " + row + " "+col);
    }
  }
}