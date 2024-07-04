import java.util.*;

public class Solution {

  public static void main(String args[]) {
    (new Solution()).solve();
  }

  int inf = 1000000;
  void solve() {

    Scanner cin = new Scanner(System.in);

    int T = cin.nextInt();
    for(int C=1; C<=T; ++C) {

    	int N = cin.nextInt();
    	int D = cin.nextInt();

    	int score[] = new int[N];
    	int st[] = new int[D];
    	int ed[] = new int[D];
    	for( int i = 1; i < N; ++i ) {
    		score[i] = cin.nextInt();
    	}
    	for( int i = 0; i < D; ++i ) {
    		st[i] = cin.nextInt();
    		ed[i] = cin.nextInt();
    	}
    	
    	boolean used[] = new boolean[N];
    	int depth[] = new int[N];
    	int prev = 0;
    	int total = 1;
    	while( total < N ) {
    		int match = 0;
    		for( int i = 1; i < N; ++i ) {
	    		if( used[i] ) { continue; }
	    		if( score[i] == -total ) {
	    			++match;
	    			depth[i] = prev + 1;
	    			used[i] = true;
	    		}
    		}
    		if( total > 0 ) {
	    		total += match;
	    		++prev;
	    		continue;
    		}
    		int min = inf;
    		for( int i = 1; i < N; ++i ) {
    			if( used[i] ) { continue; }
    			if( score[i] < min ) {
    				min = score[i];
    			}
    		}
    		for( int i = 1; i < N; ++i ) {
    			depth[i] = score[i];
    			++total;
    		}
    	}
   	
      System.out.print("Case #" + C + ":");
	  	for( int i = 0; i < D; ++i ) {
	  		int result = inf;
			if( depth[st[i] - 1] != depth[ed[i] - 1] ) {
				result = Math.abs(depth[st[i] - 1] - depth[ed[i] - 1]);
			}
			System.out.print(" " + result);
	  	}
	  	System.out.println();

    }

    cin.close();

  }

}
