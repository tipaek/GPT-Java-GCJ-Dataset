import java.util.*;
import java.io.*;
public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
    for (int i = 1; i <= t; ++i) {
      int N = in.nextInt();
      int[][] A = new int[N][N];
      int trace = 0, nr = 0, nc = 0;
      for ( int r = 0; r < N; r++ ) {
          for ( int c = 0; c < N; c++ ) {
              A[r][c] = in.nextInt();
              if ( r == c ) {
                  trace += A[r][c];
              }
          }
      }
      
      for ( int r = 0; r < N; r++ ) {
          int[] countRow = new int[N+1];
          for ( int c = 0; c < N; c++ ) {
              countRow[A[r][c]]++;
              if ( countRow[A[r][c]] > 1 ) {
                  nr++;
                  break;
              }
          }
      }
      
      for ( int c = 0; c < N; c++ ) {
          int[] countCol = new int[N+1];
          for ( int r = 0; r < N; r++ ) {
              countCol[A[r][c]]++;
              if ( countCol[A[r][c]] > 1 ) {
                  nc++;
                  break;
              }
          }
      }
      
      System.out.println("Case #" + i + ": " + trace + " " + nr + " " + nc);
    }
  }
}