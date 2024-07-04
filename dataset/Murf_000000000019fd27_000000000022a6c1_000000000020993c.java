 import java.util.*;
    import java.io.*;
    public class Solution {
      public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int TC = in.nextInt();
        for( int i=1; i<=TC; i++ ) {
          int n = in.nextInt();
          int[][] rowDups = new int[n+1][n+1];
          int[][] colDups = new int[n+1][n+1];

          int trace = 0;
          for( int r=1; r<=n; r++ ) {
            for( int c=1; c<=n; c++ ) {
              int v = in.nextInt();
              if( r==c ) trace += v;
              
              if( rowDups[r][v] != 0 ) {
                rowDups[r][0] = 1;
              }
              rowDups[r][v] = v;
              
              if( colDups[v][c] != 0 ) {
                  colDups[0][c] = 1;
              }
              colDups[v][c] = v;
            }
          }
          int rowDup = 0;
          int colDup = 0;
          for( int j=1; j<=n; j++ ) {
            colDup += colDups[0][j];  
            rowDup += rowDups[j][0];
          }
          System.out.println( "Case #" + i + ": " + trace + " " + rowDup + " " + colDup );
        }
      }
    }
  