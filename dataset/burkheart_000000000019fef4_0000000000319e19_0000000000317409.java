import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Scanner;


public class Solution { 
	
	public Solution() {}
	
	
	public static int X, Y;
	public static String P;
	

	public static String solve() {
		
		int xp = X;
		int yp = Y;
		for(int i = 0; i <= P.length(); i++) {
			
			int d = Math.abs(xp) + Math.abs(yp);
			
			if (i >= d) {
				return ""+i;
			}
			
			if (i < P.length() ) {
				char dir = P.charAt(i);
				if (dir == 'E') xp++;
				else if (dir == 'W') xp--;
				else if (dir == 'N') yp++;
				else if (dir == 'S') yp--;
			}			
		}
		
		
		return "IMPOSSIBLE";
	}
		
		
	
	
	public static int DEBUG_TEST_CASE = 0;
	public static boolean SIMULATE_TEST_CASES = false;
	
	
	public static Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
	
	public static void main(String[] args) {
	    int tmax;
	    
	    
	    if (!SIMULATE_TEST_CASES) {
		    tmax = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
		    for (int t = 1; t <= tmax; ++t) {
		      X = in.nextInt();
		      Y = in.nextInt();
		      P = in.next();
		      
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
