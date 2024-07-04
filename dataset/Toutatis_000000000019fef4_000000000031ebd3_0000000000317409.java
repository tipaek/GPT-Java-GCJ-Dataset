import java.util.*;
import java.io.*;

public class Solution {

	// T : tests cases
	// N : remaining lines
	private static final boolean IS_LOCAL = false ; 
	private static final boolean IS_FIXED_CASE_LINES = true ;
	private static final int NB_FIXED_CASE_LINES = 1 ;

	public static final void debug(String str)  {
		if ( IS_LOCAL ) {
			System.out.println(str);
		}
	}


	// ###########################################
	// 		EDIT STATE AFTER THIS LINE
	// ###########################################

	public static class State {
		public State(int numberOfElements) {			
		}

		public String compute(long x, long y, String m) {
			//Un pair, un impair
			//Nombre de tour pour aller jusqu'au robot : 
			int minWest = Math.abs((int) x) ;
			int totalDist = minWest ;
			int posEnnemy = (int)y ; 
			int posMe = 0 ;
			
			if (minWest > m.length()) {
				return "IMPOSSIBLE";
			}
			String start = m.substring(0, minWest);
			String end = m.substring(minWest);
			
			if ( start != null && start.length() > 0 ) {
				for (char c : start.toCharArray()) {
					if ( c == 'N' ) {
						posEnnemy++;					
					}
					else if ( c == 'S') {
						posEnnemy--;					
					}
					System.err.println("Tour robot "  + posEnnemy + " me " + posMe);
					System.err.flush();
				}
			}

			if ( end != null && end.length() > 0 ) {
				for (char c : end.toCharArray()) {
					if ( c == 'N' ) {
						posEnnemy++;
						if (posEnnemy == posMe) {
							totalDist++;
							break ; 
						}
						else {
							if ( posMe > posEnnemy) {posMe-- ;}
							else { posMe++ ; }
							totalDist++;
						}

					}
					else if ( c == 'S') {
						posEnnemy--;
						if (posEnnemy == posMe) {
							//STOP 
							totalDist++;
							break ; 
						}
						else {
							if ( posMe > posEnnemy) {posMe-- ;}
							else { posMe++ ; }
							totalDist++;
						}

					}
					System.err.println("Tour robot "  + posEnnemy + " me " + posMe);
					System.err.flush();
				}
			}

			if ( posMe == posEnnemy ) {
				return String.valueOf(totalDist) ;	
			}


			return "IMPOSSIBLE"; 
		}

	}

	// ###########################################
	// 		EDIT STATE BEFORE THIS LINE
	// ###########################################

	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));		
		if ( IS_LOCAL ) {
			try {
				in = new Scanner(new BufferedReader(new FileReader("E:\\tmp\\in.txt")));
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		int T = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
		in.nextLine(); 

		//System.out.println("Need to split " + l1);
		int N  = IS_FIXED_CASE_LINES ? NB_FIXED_CASE_LINES : 0 ;
		int caseId = 0 ; 
		int caseLine= 0 ; 
		State state = new State(0); 

		while (in.hasNextLine() && T > 0 ) {			
			if ( !IS_FIXED_CASE_LINES ) {
				if ( N == 0 ) {
					caseLine = -1 ;
					N = in.nextInt();
					in.nextLine();
					state =  new State(N);
					continue;
				}
				N--; 		
				caseLine++ ; 
			}
			else {
				if ( N == 0 ) {
					N = NB_FIXED_CASE_LINES;
				}
				N--; 		
			}



			// ##############################################
			// EDIT AFTER THIS LINE ONLY
			// ##############################################

			long X = in.nextLong();
			long Y = in.nextLong();
			String M = in.nextLine().trim() ;
			//in.nextLine();
			//			String[] split = line.split(" ");
			//			for (int j = 0 ; j < split.length ; j++) {
			//			
			//			}


			/***
			 * COMPUTE RESULT IF END OF CASE
			 */
			if ( N == 0 ) {
				String res = state.compute(X,Y,M) ; 				
				System.out.println("Case #" + ++caseId + ": " + res);
				T--;
			}					

			// ##############################################
			// EDIT BEFORE THIS LINE ONLY
			// ##############################################
			// System.out.println("Case #" + ++caseId + ": " + result);
		}
		in.close();
	}


}