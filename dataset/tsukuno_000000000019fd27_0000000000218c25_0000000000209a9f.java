import java.util.*;

public class Solution {

  public static void main(String args[]) {
    (new Solution()).solve();
  }

  void solve() {

    Scanner cin = new Scanner(System.in);

    int T = cin.nextInt();
    for(int C=1; C<=T; ++C) {
    	
    	String s = cin.next() + "0";
    	int depth = 0;
    	String result = "";
    	for( int i = 0; i < s.length(); ++i ) {
    		int value = (s.charAt(i) - '0');
    		for( ; value > depth; ++depth ) {
    			result += "(";
    		}
    		for( ; value < depth; --depth ) {
    			result += ")";
    		}
    		if( i < s.length() - 1 ) {
    			result += value;
    		}
    	}

      System.out.println("Case #" + C + ": " + result);

    }

    cin.close();

  }

}
