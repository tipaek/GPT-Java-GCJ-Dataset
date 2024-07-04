import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Scanner;


public class Solution { 
	
	public Solution() {}
	
	
	public static int N;
	
	public static int[][] m;
	

	public static class State {
		// result variables
		public int k, r, c;
	}
	
	
	public static State solve() {
		State res = new State();
		
		res.k = 0;
		for(int i = 0; i < N; i++) {
			res.k += m[i][i]; 
		}
		
		int[] dups = new int[N];
		
		res.r = 0;
		for(int i = 0; i < N; i++) {
			boolean hasDups = false;
			for(int j = 0; j < N; j++) dups[j] = 0;
			for(int j = 0; j < N; j++) {
				dups[m[i][j] - 1]++;
				if (dups[m[i][j] - 1] > 1) hasDups = true;
			}
			if (hasDups) res.r++;
		}
		
		res.c = 0;
		for(int j = 0; j < N; j++) {
			boolean hasDups = false;
			for(int i = 0; i < N; i++) dups[i] = 0;
			for(int i = 0; i < N; i++) {
				dups[m[i][j] - 1]++;
				if (dups[m[i][j] - 1] > 1) hasDups = true;
			}
			if (hasDups) res.c++;
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
	      N = in.nextInt();
	      m = new int[N][N];
	      
	      for(int i = 0; i < N; i++) {
	    	  for(int j = 0; j < N; j++) {
	    		  m[i][j] = in.nextInt();
	    	  }
	      }
	      
	      if ((DEBUG_TEST_CASE <= 0) || (t == DEBUG_TEST_CASE)) {
	    	  
	    	  State res = solve();
	    	  
	    	  System.out.println("Case #"+t+": "+res.k+" "+res.r+" "+res.c);
	      }
	    }
	}

}
