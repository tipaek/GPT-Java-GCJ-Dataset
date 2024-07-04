import java.util.*;

public class Solution {

  public static void main(String args[]) {
    (new Solution()).solve();
  }

  void solve() {

    Scanner cin = new Scanner(System.in);

    int T = cin.nextInt();
    for(int C=1; C<=T; ++C) {

      int N = cin.nextInt();
      int mat[][] = new int[N][N];
      
      for( int i = 0; i < N; ++ i ) {
    	  for( int j = 0; j < N; ++j ) {
    		  mat[i][j] = cin.nextInt();
    	  }
      }
      
      int trace = 0;
      int rows = 0;
      int cols = 0;
      for( int i = 0; i < N; ++i ) {
    	  trace += mat[i][i];
    	  Set<Integer> rowC = new HashSet<Integer>();
    	  Set<Integer> colC = new HashSet<Integer>();
    	  for( int j = 0; j < N; ++j ) {
    		  rowC.add(mat[i][j]);
    		  colC.add(mat[j][i]);
    	  }
    	  if( rowC.size() != N ) { ++rows; }
    	  if( colC.size() != N ) { ++cols; }
      }
      
      System.out.println("Case #" + C + ": " + trace + " " + rows + " " + cols);
      
    }

    cin.close();

  }

}
