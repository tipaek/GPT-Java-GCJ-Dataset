import java.util.*;

public class Solution {

  public static void main(String args[]) {
    (new Solution()).solve();
  }

  int dx[] = { 1, 0, -1, 0 };
  int dy[] = { 0, 1, 0, -1 };
  void solve() {

    Scanner cin = new Scanner(System.in);

    int T = cin.nextInt();
    for(int C=1; C<=T; ++C) {
    	
    	int Row = cin.nextInt();
    	int Col = cin.nextInt();
    	
    	int value[][] = new int[Row][Col];
    	for( int i = 0; i < Row; ++i ) {
    		for( int j = 0; j < Col; ++j ) {
    			value[i][j] = cin.nextInt();
    		}
    	}
    	
    	long answer = 0;
    	boolean rem[][] = new boolean[Row][Col];
    	while( true ) {
    		
    		int score = 0;
    		boolean addR = false;
    		
    		boolean next[][] = new boolean[Row][Col];
    		
    		for( int i = 0; i < Row; ++i ) {
    			for( int j = 0; j < Col; ++j ) {
    				next[i][j] |= rem[i][j];
    				if( rem[i][j] ) { continue; }
					score += value[i][j];
					int self = 0;
					int opp = 0;
    				for( int k = 0; k < 4; ++k ) {
    					int I = i + dx[k];
    					int J = j + dy[k];
    					while( true ) {
	    					if( I < 0 || I >= Row || J < 0 || J >= Col ) { break; }
	    					if( rem[I][J] ) {
	    						I += dx[k];
	    						J += dy[k];
	    					} else { break; }
    					}
    					if( I < 0 || I >= Row || J < 0 || J >= Col ) { continue; }
    					self += value[i][j];
    					opp += value[I][J];
    				}
    				if( self < opp ) { next[i][j] = addR = true; }
    			}
    		}

    		rem = next;
    		answer += score;
    		if( addR == false ) {
    			break;
    		}
    		
    	}
    	
      System.out.println("Case #" + C + ": " + answer);

    }

    cin.close();

  }

}
