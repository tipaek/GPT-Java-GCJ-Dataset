import java.util.*;

public class Solution {

  public static void main(String args[]) {
    (new Solution()).solve();
  }

  String create(int len) {
	  String result = "";
	  for( int i = 0; i < len; ++i ) {
		  result += "2";
	  }
	  return result;
  }

  String flip(String current) {
	  String result = "";
	  for( int i = 0; i < current.length(); ++i ) {
		  switch( current.charAt(i) ) {
		  case '0':
			  result += "1";
			  break;
		  case '1':
			  result += "0";
			  break;
		  case '2':
			  result += "2";
			  break;
		  }
	  }
	  return result;
  }
  
  String reverse(String current) {
	  return (new StringBuilder(current)).reverse().toString();
  }
  
  String check(Scanner cin, String current) {
	  String flip = flip(current);
	  String rev = reverse(current);
	  String both = reverse(flip);
	  List<String> cand = new ArrayList<String>();
	  cand.add(current);
	  cand.add(flip);
	  cand.add(rev);
	  cand.add(both);
	  boolean invalid[] = new boolean[4];
	  CHECK:
	  for( int i = 0; i < 2; ++i ) {
		  boolean query = false;
		  INDEX:
		  for( int j = 0; j < current.length(); ++j ) {
			  boolean one = false;
			  boolean zero = false;
			  for( int k = 0; k < 4; ++k ) {
				  if( invalid[k] ) { continue; }
				  switch( cand.get(k).charAt(j) ) {
				  case '2':
					  continue INDEX;
				  case '1':
					  one = true;
					  break;
				  case '0':
					  zero = true;
					  break;
				  }
			  }
			  if( one && zero ) {
				  System.out.println(j + 1);
				  System.out.flush();
				  String result = cin.next();
				  query = true;
				  for( int k = 0; k < 4; ++k ) {
					  if( invalid[k] ) { continue; }
					  if( cand.get(k).charAt(j) != result.charAt(0) ) {
      						invalid[k] = true;
					  }
				  }
				  continue CHECK;
			  }
		  }
		  if( query == false ) {
			  // skip execution;
			  System.out.println(1);
			  System.out.flush();
			  cin.next();
		  }
	  }
	  for( int i = 0; i < 4; ++i ) {
		  if( invalid[i] == false ) { return cand.get(i); }
	  }
	  return null;
  }

  String replace(String current, int index, char value) {
	  return current.substring(0, index) + value + current.substring(index + 1);
  }
  
  String read(Scanner cin, String current, int index) {
		System.out.println(index);
		System.out.flush();
		String response = cin.next();
		switch( response.charAt(0) ) {
		case 'N':
			return null;
		case '0':
			return replace(current, index - 1, '0');
		case '1':
			return replace(current, index - 1, '1');
		}
		return null;
  }
  
  void solve() {

    Scanner cin = new Scanner(System.in);

    int T = cin.nextInt();
    int B = cin.nextInt();

    MAIN:
    for(int C=1; C<=T; ++C) {
    	
    	String current = create(B);

    	int step = 0;
    	
    	do {
    		
    		current = check(cin, current);
    		step += 2;
    		
    		for( int i = 0; i < 4; ++i ) {
    			int index = current.indexOf('2');
    			if( index == -1 ) {
    				break;
    			}
    			current = read(cin, current, index + 1);
    			current = read(cin, current, B - index);
    			step += 2;
    		}
    		
    		if( current.indexOf('2') == -1 ) {
    			System.out.println(current);
    			String result = cin.next();
    			if( result.equals("Y") ) { continue MAIN; }
    			if( result.equals("N") ) { return; }
    		}
    		
    	} while( step < 150 );
    	
    }

    cin.close();

  }

}
