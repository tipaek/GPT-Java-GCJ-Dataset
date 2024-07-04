import java.util.*;

public class Solution {

  public static void main(String args[]) {
    (new Solution()).solve();
  }

  
  int gcd(int a, int b) {
	  if( a == 0 ) { return b; }
	  return gcd( b % a, a );
  }
  
  boolean same(int dx, int dy, int dx2, int dy2) {
	  if( dx == dx2 && dy == dy2 ) { return true; }
	  if( dx == -dx2 && dy == -dy2 ) { return true; }
	  return false;
  }
  
  int count(int x[], int y[], int N, int id1, int id2) {
	  boolean used[] = new boolean[N];
	  int g = gcd(Math.abs(x[id1] - x[id2]), Math.abs(y[id1] - y[id2]));
	  int dx = (x[id1] - x[id2]) / g;
	  int dy = (y[id1] - y[id2]) / g;
	  int oddC = 0;
	  int oneC = 0;
	  int score = 0;
	  for( int i = 0; i < N; ++i ) {
		  if( used[i] ) { continue; }
		  used[i] = true;
		  int total = 1;
		  for( int j = i + 1; j < N; ++j ) {
			  if( used[j] ) { continue; }
			 int g2 = gcd(Math.abs( x[i] - x[j] ), Math.abs( y[i] - y[j] ) );
			 int dx2 = (x[i] - x[j]) / g2;
			 int dy2 = (y[i] - y[j]) / g2;
			 if( same(dx, dy, dx2, dy2) ) {
				 ++total;
				 used[j] = true;
			 }
		  }
		 if( total % 2 == 0 ) {
			 score += total;
		 }
		 else {
			 if( total == 1 ) {
				 ++oneC;
			 }
			 else {
				 ++oddC;
				 score += total;
			 }
		 }
	  }
	  if( oddC % 2 != 0 ) {
		  --score;
		  ++oneC;
	  }
	  return score + Math.min(2, oneC);
  }
  
  void solve() {

    Scanner cin = new Scanner(System.in);

    int T = cin.nextInt();
    for(int C=1; C<=T; ++C) {

    	int N = cin.nextInt();
    	int x[] = new int[N];
    	int y[] = new int[N];
    	for( int i = 0; i < N; ++i ) {
    		x[i] = cin.nextInt();
    		y[i] = cin.nextInt();
    	}
    	
    	int max = Math.min(3, N);
    	for( int i = 0; i < N; ++i ) {
    		for( int j = i + 1; j < N; ++j ) {
    			max = Math.max(max, count(x, y, N, i, j));
    		}
    	}
    	
      System.out.println("Case #" + C + ": " + max);

    }

    cin.close();

  }

}
