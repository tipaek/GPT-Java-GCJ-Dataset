import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Scanner;


public class Solution { 
	
	public Solution() {}
	
	
	public static int X,Y;
	

	public static class State {
		static HashMap<String, State> states = new HashMap<String, State>();		
		boolean isCashed = false;
		
		// key state variables
		long posX, posY;
		int exp;
		
		// result variables
		int score;
		
		// linked state(s)
		State linkedState;
		//HashMap<Integer,State> linkedStates = new HashMap<Integer,State>(10); 
		
		
		public State(long posX, long posY, int exp) {
			this.posX = posX;
			this.posY = posY;
			this.exp = exp;
		}
		
		public static State get(long posX, long posY, int exp) {
			String key = posX+"|"+posY+"|"+exp;
			
			State state = states.get(key);
			if (state == null) {
				state = new State(posX, posY, exp);
				states.put(key,state);
			}
			else {
				state.isCashed = true;
			}
			return state;
		}

		/*
		public void enumerate(ArrayList< int[] > list, int[] current) {
			for(int j: linkedStates.keySet()) {
				current[i] = j;
				State state = linkedStates.get(j);
				if (state == null) {
					list.add( current.clone() );
				}
				else {
					state.enumerate(list, current);
				}
				current[i] = 0;
			}
		}
		*/		
		
		public static State solve(long posX, long posY, int exp) {
			State res = State.get(posX, posY, exp);
			if (res.isCashed) {
				return res;
			}
			
			if ((posX == X) && (posY ==Y)) {
				res.score = exp;
				return res;
			}
			
			long d = 1 << exp;
			
			if (exp > 8) {
				res.score = Integer.MAX_VALUE;
				return res;
			}
			
			/*
			if (Math.abs(posX - X) < d) {
				res.score = Integer.MAX_VALUE;
				return res;
			}
			else if (Math.abs(posY - Y) < d) {
				res.score = Integer.MAX_VALUE;
				return res;
			}
			*/

			
			State stateN =  solve(posX, posY - d, exp+1);
			State stateS =  solve(posX, posY + d, exp+1);
			State stateE =  solve(posX + d, posY, exp+1);
			State stateW =  solve(posX - d, posY, exp+1);

			State stateMin = stateN;
			if (stateS.score < stateMin.score) stateMin = stateS;
			if (stateE.score < stateMin.score) stateMin = stateE;
			if (stateW.score < stateMin.score) stateMin = stateW;
			
			res.score = stateMin.score;
			res.linkedState = stateMin;
			
			return res;
		}
	
	}
	
	
	public static String solve() {
		State.states.clear();
		
		State state = State.solve(0,0,0);
		
		
		String res = "";
		if (state.score < Integer.MAX_VALUE) {
			while(state.linkedState != null) {
				if (state.linkedState.posY > state.posY) res += "N"; 
				else if (state.linkedState.posY < state.posY) res += "S"; 
				else if (state.linkedState.posX > state.posX) res += "E"; 
				else res += "W"; 
				state = state.linkedState;
			}
		}
		else {
			res = "IMPOSSIBLE";
		}
	
//		ArrayList<int[]> list = new ArrayList<int[]>();
//		res.enumerate(list, new int[n+1]);
		
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
			      X = in.nextInt();
			      Y = in.nextInt();
		      
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
