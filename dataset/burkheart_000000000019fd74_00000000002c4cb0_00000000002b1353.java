import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Scanner;


public class Solution { 
	
	public Solution() {}
	
	
	public static int N;
	

	public static class State {
		public int score;
	}
	
	
	public static State solve() {
		
		boolean[] selectedRows = new boolean[30+1];
		
		boolean found = false;
		int n = N;
		for(int r = 30; r > 1; r--) {
			int v = 0;
			if (!found) v += r-1; 
			v += (1 << (r-1)) - 1;
			
//			System.out.println("r="+r+" v="+v);
			if (v < n) {
				n = n - v;
				found = true;
				selectedRows[r] = true;
//				System.out.println("> "+r+": n="+n);
			}
		}

		boolean isLeft = true;
		int sum = 0;
		for(int r = 1; r <= 500; r++) {
//	    	System.out.println("> r="+r);
			if (r == 1) {
				System.out.println("1 1");
				sum++;
			}
			else {
				if (selectedRows[r]) {
//			    	System.out.println(">>> selected");
					
					if (isLeft) {
						for(int k = 1; k <= r; k++) {
							System.out.println(r+" "+k);
						}
						isLeft = false;
					}
					else {
						for(int k = r; k >= 1; k--) {
							System.out.println(r+" "+k);
						}
						isLeft = true;
					}
					sum += 1 << (r-1);
				}
				else {
					if (isLeft) {
						System.out.println(r+" "+1);
					}
					else {
						System.out.println(r+" "+r);
					}
					sum++;
				}

//		    	System.out.println(">>> sum="+sum);
			}
			
			if (sum >= N) break; 
		}
		
//		System.out.println(N+" "+sum);
		assert N == sum;
		return null;
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
		      
		      if ((DEBUG_TEST_CASE <= 0) || (t == DEBUG_TEST_CASE)) {
		    	  System.out.println("Case #"+t+":");
		    	  solve();
		      }
		    }
	    }
	    else {
	    	// Simulating test cases
		    tmax = 1000;
		    for (int t = 1; t <= tmax; ++t) {
		    	N = t;
		    	solve();
		    }
	    }
	}

}
