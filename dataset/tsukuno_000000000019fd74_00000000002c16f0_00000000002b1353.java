import java.util.*;

public class Solution {

  public static void main(String args[]) {
    (new Solution()).solve();
  }

  int inf = 1000 * 1000 * 1000 + 9;
  int value[][] = new int[500][500];
  
  void init() {
	  for( int i = 0; i < 500; ++i ) {
		  for( int j = 0; j < 500; ++j ) {
			  value[i][j] = inf;
		  }
	  }
	  for( int i = 0; i < 500; ++i ) {
		  value[i][0] = value[i][i] = 1;
		  for( int j = 1; j < i; ++j ) {
			  value[i][j] = value[i - 1][j] + value[i - 1][j - 1];
			  if( value[i][j] > inf ) { value[i][j] = inf; }
		  }
	  }
  }
  
  int dfs(int rest, int path[][], boolean used[][], int Y, int X, int depth) {
	  if( Y < 0 || X < 0 ) { return -1; }
	  if( X > Y ) { return -1; }
	  if( depth > 500 ) { return -1; }
	  if( used[Y][X] ) { return -1; }
	  if( rest == 0 ) { return depth; }
	  if( rest < value[Y][X] ) { return -1; }
	  rest -= value[Y][X];
	  path[depth][0] = Y;
	  path[depth][1] = X;
	  used[Y][X] = true;
	  // center;
	  int a;
	  if( value[Y + 1][X + 1] <= value[Y + 1][X] ) {
		  a = dfs(rest, path, used, Y + 1, X, depth + 1);
		  if( a >= 0 ) { return a; }
		  a = dfs(rest, path, used, Y + 1, X + 1, depth + 1);
		  if( a >= 0 ) { return a; }
	  }
	  else {
		  a = dfs(rest, path, used, Y + 1, X + 1, depth + 1);
		  if( a >= 0 ) { return a; }
		  a = dfs(rest, path, used, Y + 1, X, depth + 1);
		  if( a >= 0 ) { return a; }
	  }
	  if( X < 0 ) {
		  a = dfs(rest, path, used, Y, X - 1, depth + 1);
		  if( a >= 0 ) { return a; }
	  }
	  if( X < Y ) {
		  a = dfs(rest, path, used, Y, X + 1, depth + 1);
		  if( a >= 0 ) { return a; }
	  }
	  if( Y > 0 ) {
		  a = dfs(rest, path, used, Y - 1, X - 1, depth + 1);
		  if( a >= 0 ) { return a; }
		  if( X < Y ) {
			  a = dfs(rest, path, used, Y - 1, X, depth + 1);
			  if( a >= 0 ) { return a; }
		  }
	  }
	  used[Y][X] = false;
	  return -1;
  }
  
  void solve() {

	  init();
    Scanner cin = new Scanner(System.in);
    
    int T = cin.nextInt();
    for(int C=1; C<=T; ++C) {
    	
    	int N = cin.nextInt();
    	int answer[][] = new int[500][2];
    	int index = dfs(N, answer, new boolean[500][500], 0, 0, 0);
      System.out.println("Case #" + C + ":");
    	for( int i = 0; i < index; ++i ) {
    		System.out.println((answer[i][0] + 1) + " " + (answer[i][1] + 1));
    	}

    }

    cin.close();

  }

}
