import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Scanner;


public class Solution { 
	
	static String S;
	
	public Solution() {}
	
	public static String solve() {
		String res = "";
		String S2 = S;
		
		int depth = 0;
		int prevVal = 0;
		for(int i = 0; i < S2.length()+1; i++) {
			int val;
			if (i < S2.length()) val = Integer.parseInt(""+S2.charAt(i));
			else val = 0;
			
			int delta = val - prevVal;
			if (delta > 0) {
				for(int j = 0; j < delta; j++) {
					res += "(";
					depth++;
				}
			}
			else {
				for(int j = 0; j < -delta; j++) {
					res += ")";
					depth--;
				}
			}
			
			if (i < S2.length()) res += S2.charAt(i);
			
			prevVal = val;
		}
					
		
		return res;
	}
		
		
	
	
	public static int DEBUG_TEST_CASE = 0;
	public static boolean SIMULATE_TEST_CASES = false;
	
	
	public static Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
	
	public static void main(String[] args) {
	    int tmax;
	    tmax = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
	    for (int t = 1; t <= tmax; ++t) {
	      S = in.next();
	      
	      if ((DEBUG_TEST_CASE <= 0) || (t == DEBUG_TEST_CASE)) {
	    	  String res = solve();
	    	  
	    	  System.out.println("Case #"+t+": "+res);
	      }
	    }
	}

}
