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
    	int start[] = new int[N];
    	int end[] = new int[N];
    	char result[] = new char[N];
    	for( int i = 0; i < N; ++i ) {
    		start[i] = cin.nextInt();
    		end[i] = cin.nextInt();
    		result[i] = 'G';
    	}
    	
    	int cVal = 0;
    	int jVal = 0;
    	boolean failed = false;
    	for( int i = 0; i < N; ++i ) {
    		int value = 24 * 60 * 2;
    		int index = -1;
    		for( int j = 0; j < N; ++j ) {
    			// assigned;
    			if( result[j] != 'G' ) { continue; }
    			if( start[j] < value ) {
    				value = start[j];
    				index = j;
    			}
    		}
    		
    		if( index == -1 ) {
    			new RuntimeException("unknown error...");
    		}
    		if( value >= cVal ) {
    			cVal = end[index];
    			result[index] = 'C';
    			continue;
    		}
    		
    		if( value >= jVal ) {
    			jVal = end[index];
    			result[index] = 'J';
    			continue;
    		}
    		
    		failed = true;
    		break;
    		
    	}
    	
    	String answer = "";
    	if( failed ) {
    		answer = "IMPOSSIBLE";
    	}
    	else {
    		for( int i = 0; i < N; ++i ) {
    			answer += result[i];
    		}
    	}
      System.out.println("Case #" + C + ": " + answer);

    }

    cin.close();

  }

}
