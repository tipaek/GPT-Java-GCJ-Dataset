import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Scanner;


public class Solution { 
	
	public Solution() {}
	
	public static int N;
	
	public static class Interval {
		public int i,s,e;
		public int getS() { return s; }
	}
	public static Interval[] intervals;

	
	public static String solve() {
		char[] res = new char[N];
		Arrays.sort(intervals, Comparator.comparing(Interval::getS));
		
		int endJ = 0, endC = 0;
		for(int i = 0; i < N; i++) {
			if (intervals[i].s >= endJ) {
				res[intervals[i].i] = 'J';
				endJ = intervals[i].e;
			}
			else if (intervals[i].s >= endC) {
				res[intervals[i].i] = 'C';
				endC = intervals[i].e;
			}
			else {
				return "IMPOSSIBLE";
			}
		}
		
		return new String(res);
	}
	
	
	public static int DEBUG_TEST_CASE = 0;
	public static boolean SIMULATE_TEST_CASES = false;
	
	
	public static Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
	
	public static void main(String[] args) {
	    int tmax;
	    tmax = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
	    for (int t = 1; t <= tmax; ++t) {
	      N = in.nextInt();
	      intervals = new Interval[N];
	      for(int i = 0; i < N; i++) {
	    	  intervals[i] = new Interval();
	    	  intervals[i].s = in.nextInt(); 
	    	  intervals[i].e = in.nextInt(); 
	    	  intervals[i].i = i; 
	      }
	      
	      if ((DEBUG_TEST_CASE <= 0) || (t == DEBUG_TEST_CASE)) {
	    	  String res = solve();
	    	  System.out.println("Case #"+t+": "+res);
	      }
	    }
	}
}
