import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Scanner;


public class Solution { 
	
	public Solution() {}
	
	
	public static int N;
	public static String[] patterns;
	

	public static class Substring {
		public String str;
		int iMin, iMax; 
		
		Substring prevSub, nextSub;
	}
	
	
	
	public static String solve() {
		
		String wordStart[] = new String[N];
		String wordMiddle[] = new String[N];
		String wordEnd[] = new String[N];
		
		for(int i = 0; i < N; i++) {
			String pattern = patterns[i];
			
			int pos1 = pattern.indexOf('*');
			assert pos1 >= 0;
			if (pos1 > 0) {
				wordStart[i] = pattern.substring(0, pos1); 
			}
			
			int pos2 = pattern.lastIndexOf('*');
			assert pos2 >= 0;
			if (pos2 < pattern.length()-1 ) {
				wordEnd[i] = pattern.substring(pos2+1); 
			}
			
			
			if (pos1 < pos2) {
				wordMiddle[i] = pattern.substring(pos1+1, pos2);
			}
		}
		
		// determine if the beginning of word can be created
		String resWordStart = "";
		for(int i = 0; i < N; i++) {
			String substr = wordStart[i];
			if (substr == null) continue;
			
			if (substr.length() > resWordStart.length()) {
				if (substr.startsWith(resWordStart)) {
					resWordStart = substr;
				}
				else { 
					return "*";
				}
			}
			else {
				if (resWordStart.startsWith(substr)) {
					// keep wordStart
				}
				else { 
					return "*";
				}
			}
		}
		
		String resWordEnd = "";
		for(int i = 0; i < N; i++) {
			String substr = wordEnd[i];
			if (substr == null) continue;

			if (substr.length() > resWordEnd.length()) {
				if (substr.endsWith(resWordEnd)) {
					resWordEnd = substr;
				}
				else { 
					return "*";
				}
			}
			else {
				if (resWordEnd.endsWith(substr)) {
					// keep wordEnd
				}
				else { 
					return "*";
				}
			}
		}
		
		String res = resWordStart;
		for(int i = 0; i < N; i++) {
			if (wordMiddle[i] != null) res += wordMiddle[i].replaceAll("\\*","");
		}
		res += resWordEnd;
		
		return res;
	}

	
	
	public static int DEBUG_TEST_CASE = 0;
	public static boolean SIMULATE_TEST_CASES = false;
	
	
	public static Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
	
	public static void main(String[] args) {
	    int tmax;
	    
	    
	    if (!SIMULATE_TEST_CASES) {
		    tmax = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
		    for (int t = 1; t <= tmax; ++t) {
		      N = in.nextInt();
		      patterns = new String[N];
		      for(int i = 0; i < N; i++) {
		    	  patterns[i] = in.next();
		      }
		      
		      
		      if ((DEBUG_TEST_CASE <= 0) || (t == DEBUG_TEST_CASE)) {
		    	  String res = solve();
		    	  
		    	  System.out.println("Case #"+t+": "+res);
		      }
		    }
	    }
	    else {
	    	// Simulating test cases
		    /*
		    tmax = 10000000;
		    for (int t = 1; t <= tmax; ++t) {
		    	N = ""+(long)Math.ceil(Math.random() * 100000 + 1);
			      
		    	State res = solve();
			    	  
		    	System.out.println("Case #"+t+": "+N+" "+res.a+" "+res.b);
		    	
		    	assert !res.a.startsWith("0");
		    	assert !res.b.startsWith("0");
		    	assert !res.a.contains("4");
		    	assert !res.b.contains("4");
		    	assert Long.parseLong(res.a) + Long.parseLong(res.b) == Long.parseLong(N); 
		    }
		    */
	    }
	}

}
