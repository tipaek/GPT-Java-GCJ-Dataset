    import java.util.*;
    import java.io.*;
    public class Solution {
      public static int[][] rows;
      public static int[][] cols;
      public static int[][] sol;
      public static int kVal;
      public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int tc = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int t = 1; t <= tc; ++t) {
          int n = in.nextInt();
          int k = in.nextInt();
          kVal = k;
          boolean possible = true;
          /* reset solution matrix */
          sol = null;
          /* for storing used values */          
          rows = new int[n+1][n+1];
          cols = new int[n+1][n+1];
          
          if( k < n ) possible = false;
          if( k > n*n ) possible = false;
          int[][] m = new int[n][n];






          String retStr = "IMPOSSIBLE";
          if( possible ) {
              bt(m, 0, 0);
              if( sol != null ) {
                  retStr = "POSSIBLE\n";
                  for( int r=0; r<n; r++ ) {
                      for( int c=0; c<n; c++ ) {
                          retStr += sol[r][c] + " ";
                      }
                      retStr += "\n";
                  }
                  retStr = retStr.substring(0, retStr.length()-1);
              }
          }
          System.out.println("Case #" + t + ": " + retStr);
        }
      }
      public static void bt( int[][] m, int r, int c ) {  
          if( sol != null ) return;
          if( c >= m[0].length ) {
              c = 0;
              r++;
              if( r >= m.length ) {
                  int sum = 0;
                  sol = new int[m.length][m.length];
                  for( int i=0; i<m.length; i++ ) {
                     for( int j=0; j<m[i].length; j++ ){
                        sol[i][j] = m[i][j];
                        if( i==j ) sum += m[i][j];
                     }
                  }
                  if( sum != kVal ) {
                      sol = null;
                  }
                  return;
              }
          }
          if( m[r][c] > 0 ) {
            bt(m, r, c+1);
            return;
          }
          for( int i=1; i<=m.length; i++ ) {
            m[r][c] = i;
            if(rows[r+1][i] == 0 && cols[i][c+1] == 0) {
              rows[r+1][i]++;
              cols[i][c+1]++;
              bt(m, r, c+1);                    
              rows[r+1][i]--;
              cols[i][c+1]--;
            }
          }  
          m[r][c] = 0;
      }
    }
