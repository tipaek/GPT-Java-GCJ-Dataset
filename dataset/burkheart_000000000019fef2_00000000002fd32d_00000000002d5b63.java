import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Scanner;


public class Solution { 
	
	public Solution() {}
	
	
	public static long POS_MIN = -1000000000;
	public static long POS_MAX = +1000000000;
	
	public static long A, B;
	

	public static void sendToJudge(String val) {
		out.println(val);
		out.flush();
	}
	
	public static String retrieveFromJudge() {
		return in.next();
	}
	

	public static int numInteractions = 0;
	
	public static String interact(long x, long y) {
		numInteractions++;
		
//		System.err.println("DEBUG:   > Query #"+numInteractions+": "+x+" "+y);
		
		sendToJudge(x+" "+y);
		String val = retrieveFromJudge();
		
//		System.err.println("DEBUG:   > Response: "+val);
		
		return val;
	}
	
	
	public static void solve() {
//		System.err.println("DEBUG: solve");
		numInteractions = 0;
		
		long r = A;
		
		for(long x = POS_MIN + r; x <= POS_MAX - r; x++) {
			for(long y = POS_MIN + r; y <= POS_MAX - r; y++) {
				String res = interact(x,y);
				if (res.equals("MISS")) {
					
				}
				else if (res.equals("HIT")) {
					
				}
				else if (res.equals("CENTER")) {
					return;
				}
				else assert 1== 0;
			}
		}
	}
		
		
	
	public static boolean SIMULATE_TEST_CASES = false;
	public static boolean USE_LOCAL_JUDGE = true;
	public static int DEBUG_TEST_CASE = 0;
	
	
	public static Scanner in = null;
	public static PrintStream out = null;
	public static Process judgeProcess = null;

	
	public static void main(String[] args) throws IOException {
	    int tmax;

	    if (!USE_LOCAL_JUDGE) {
	    	in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
	    	out = System.out;
	    }
	    else {
	    	judgeProcess = Runtime.getRuntime().exec("python src/judge.py 0");
	    	in = new Scanner(new BufferedReader(new InputStreamReader( judgeProcess.getInputStream() )));
	    	out = new PrintStream(judgeProcess.getOutputStream());
	    }
	    
	    if (!SIMULATE_TEST_CASES) {
		    tmax = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
		    A = in.nextInt();
		    B = in.nextInt();
		    for (int t = 1; t <= tmax; ++t) {
		    	solve();
		    }
	    }
	    else {
	    	/*
	    	// Simulating test cases
		    tmax = 1;
		    N = 10;
		    for (int t = 1; t <= tmax; ++t) {
				System.err.println("DEBUG: Test "+t);
		    	solve();
		    }
		    */
	    }
	}

}
