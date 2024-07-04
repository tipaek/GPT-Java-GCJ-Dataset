import java.util.*;

public class Solution {

  public static void main(String args[]) {
    (new Solution()).solve();
  }

  String checkLeft(String all[], int N) {
	  String longest = "";
	  for( String s : all ) {
		  int index = s.indexOf('*');
		  String head = s.substring(0, index);
		  for( int i = 0; i < Math.min(longest.length(), index); ++i) {
			  // not match;
			  if( longest.charAt(i) != head.charAt(i) ) { return null; }
		  }
		  if( longest.length() < index ) { longest = head; }
	  }
	  return longest;
  }
  
  String checkRight(String all[], int N) {
	  String longest = "";
	  for( String s : all ) {
		  int index = s.lastIndexOf('*');
		  String tail = s.substring(index + 1);
		  for( int i = 0; i < Math.min(longest.length(), tail.length()); ++i) {
			  // not match;
			  if( longest.charAt(longest.length() - i - 1) != tail.charAt(tail.length() - i - 1) ) { return null; }
		  }
		  if( longest.length() < tail.length() ) { longest = tail; }
	  }
	  return longest;
  }
  
  void solve() {

    Scanner cin = new Scanner(System.in);

    int T = cin.nextInt();
    for(int C=1; C<=T; ++C) {
    	
    	int N = cin.nextInt();
    	
    	String all[] = new String[N];
    	for( int i = 0; i < N; ++i ) {
    		all[i] = cin.next();
    	}
    	
    	String left = checkLeft(all, N);
    	String right = checkRight(all, N);
    	String center = "";
    	for( String s : all ) {
    		int start = s.indexOf('*');
    		int end = s.lastIndexOf('*');
    		for( int i = start + 1; i < end; ++i ) {
    			if( s.charAt(i) == '*' ) { continue; }
    			center += s.charAt(i);
    		}
    	}

    	if( left == null || right == null ) {
    	      System.out.println("Case #" + C + ": *");
    	}
    	else {
    	      System.out.println("Case #" + C + ": " + left + center + right);
    	}

    }

    cin.close();

  }

}
