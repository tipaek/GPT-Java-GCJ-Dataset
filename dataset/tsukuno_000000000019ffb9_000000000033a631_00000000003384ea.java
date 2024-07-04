import java.util.*;

public class Solution {

  public static void main(String args[]) {
    (new Solution()).solve();
  }

  void solve() {

    Scanner cin = new Scanner(System.in);

    int T = cin.nextInt();
    for(int C=1; C<=T; ++C) {
    	
    	long L = cin.nextLong();
    	long R = cin.nextLong();
    	
    	int cur = 1;
    	while( true ) {
    		if( L >= R ) {
    			if( L >= cur ) {
    				L -= cur;
    				++cur;
    			}
    			else { break; }
    		}
    		else {
    			if( R >= cur ) {
    				R -= cur;
    				++cur;
    			}
    			else { break; }
    		}
    	}
    	
    	
      System.out.println("Case #" + C + ": " + (cur - 1) + " " + L + " " + R);

    }

    cin.close();

  }

}
