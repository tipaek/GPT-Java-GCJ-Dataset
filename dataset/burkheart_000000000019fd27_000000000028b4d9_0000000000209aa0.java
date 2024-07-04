import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Scanner;


public class Solution { 
	
	public Solution() {}
	
	
	public static int N, K;
	

	
	public static boolean enumerateDiag(int p, int[][] m) {
		if (p >= N) {
			int trace = 0;
			for(int i = 0; i < N; i++) {
				trace += m[i][i];
			}

			if (trace == K) {
				/*
				System.out.println("Trace: "+trace);
				for(int i = 0; i < N; i++) {
					for(int j = 0; j < N; j++) {
						System.out.print(m[i][j]+" ");
					}
					System.out.println();
				}
				*/
				
				return enumerateRow(0, 0, m);
			}
			
			return false;
		}

		for(int i = 1; i <= N; i++) {
			m[p][p] = i;
			if (enumerateDiag(p+1, m)) return true;
			m[p][p] = 0;
		}
		
		return false;
	}
	

	public static boolean enumerateRow(int r, int c, int[][] m) {
		if (c >= N) {
			return enumerateRow(r+1, 0, m);
		}
		else if (r >= N) {
			return true;
		}
		
		if (r == c) {
			return enumerateRow(r, c+1, m);
		}

		boolean dups[] = new boolean[N];
		for(int i = 0; i < N; i++) if (m[r][i] > 0) dups[ m[r][i] - 1 ] = true;
		for(int i = 0; i < N; i++) if (m[i][c] > 0) dups[ m[i][c] - 1 ] = true;
		
		for(int i = 1; i <= N; i++) {
			if (!dups[i - 1]) {
				m[r][c] = i;
				if (enumerateRow(r, c+1, m)) return true;
				m[r][c] = 0;
			}
		}
		
		return false;
	}
		
	
	public static boolean solve(int t) {
		if (K >= N || K <= N*N) {
			int[][] m = new int[N][N];
			if (enumerateDiag(0, m)) {
		    	System.out.println("Case #"+t+": POSSIBLE");
				for(int i = 0; i < N; i++) {
					for(int j = 0; j < N; j++) {
						System.out.print(m[i][j]+" ");
					}
					System.out.println();
				}
				return true;
			}
		}
		
    	System.out.println("Case #"+t+": IMPOSSIBLE");
    	return false;
	}
		
		
	
	public static boolean enumerateSimulation(int r, int c, int[][] m) {
		if (c >= N) {
			return enumerateSimulation(r+1, 0, m);
		}
		else if (r >= N) {
			int trace = 0;
			for(int i = 0; i < N; i++) {
				trace += m[i][i];
			}
			
			return trace == K;
		}

		boolean dups[] = new boolean[N];
		for(int i = 0; i < N; i++) if (m[r][i] > 0) dups[ m[r][i] - 1 ] = true;
		for(int i = 0; i < N; i++) if (m[i][c] > 0) dups[ m[i][c] - 1 ] = true;
		
		for(int i = 1; i <= N; i++) {
			if (!dups[i - 1]) {
				m[r][c] = i;
				if (enumerateSimulation(r, c+1, m)) return true;
				m[r][c] = 0;
			}
		}
		
		return false;
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
			  K = in.nextInt();
		      
		      if ((DEBUG_TEST_CASE <= 0) || (t == DEBUG_TEST_CASE)) {
		    	  solve(t);
		      }
		    }
	    }
	    else {
	    	// Simulating test cases
		    tmax = 1;
		    for (int t = 1; t <= tmax; ++t) {
		    	N = 3;
		    	
		    	for(int k = N; k <= N*N; k++) {
		    		K = k;
					System.out.println("k="+k);
					int[][] m = new int[N][N];
		    		if (enumerateSimulation(0,0,m)) {
		    			System.out.println("Solve: N="+N+"K="+K);
						for(int i = 0; i < N; i++) {
							for(int j = 0; j < N; j++) {
								System.out.print(m[i][j]+" ");
							}
							System.out.println();
						}
				    	assert solve(t);
		    		}
		    	}
		    }
	    }
	}

}
