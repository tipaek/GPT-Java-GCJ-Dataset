import java.util.*;
import java.io.*;

public class Solution {

	private static final boolean IS_LOCAL = false ; 
	private static final boolean IS_FIXED_CASE_LINES = false ;
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
		List<Interval> listC = new ArrayList<>() ; 
		List<Interval> listJ = new ArrayList<>() ;
		String result = "" ; 
		
		public State(int numberOfElements) {		
			
		}		
	}
	
	public static class Interval {
		private int start ; 
		private int end ; 
				
		public Interval(int start, int end) {
			super();
			this.start = start;
			this.end = end;
		}

		public boolean conflicts(Interval interval2) {
			boolean isBefore = interval2.end <= start ; 
			boolean isAfter = interval2.start >= end ;
			return !isBefore && !isAfter ; 
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

		int NB_CASES = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
		in.nextLine(); 

		//System.out.println("Need to split " + l1);
		int nbRemainingLines  = IS_FIXED_CASE_LINES ? NB_FIXED_CASE_LINES : 0 ;
		int caseId = 0 ; 
		int caseLine= 0 ; 
		State state = new State(0); 
		
		while (in.hasNextLine() && NB_CASES > 0 ) {			
			if ( !IS_FIXED_CASE_LINES ) {
				if ( nbRemainingLines == 0 ) {
					caseLine = -1 ;
					nbRemainingLines = in.nextInt();
					in.nextLine();
					caseId++; 
					state =  new State(nbRemainingLines);
					continue;
				}
				nbRemainingLines--; 		
				caseLine++ ; 
			}
			else {
				if ( nbRemainingLines == 0 ) {
					nbRemainingLines = NB_FIXED_CASE_LINES;
				}
				nbRemainingLines--; 		
			}

			
			// ##############################################
			// EDIT AFTER THIS LINE ONLY
			// ##############################################
			String line = in.nextLine();
			debug("read " + line);
			
			String[] split = line.split(" ");
			Integer start = Integer.valueOf(split[0]) ; 
			Integer end = Integer.valueOf(split[1]) ;
			
			//First check J, then C 
			if ( start > end ) {
				int c = start ; 
				start = end ; 
				end = c ; 
			}
			Interval currentInterval = new Interval(start, end); 
			boolean isJ = true ; 
			boolean isC = true ; 
			for ( Interval intJ : state.listJ ) {
				if (currentInterval.conflicts(intJ)) {
					isJ = false; 
				}
			}
			
			for ( Interval intC : state.listC ) {
				if (currentInterval.conflicts(intC)) {
					isC = false; 
				}
			}
			
			if ( isJ ) {
				state.listJ.add(currentInterval); 
				state.result += "J" ; 
			}
			else if ( isC ) {
				state.listC.add(currentInterval); 
				state.result += "C" ; 
			}
			else {
				state.result += "X" ; 
			}
			
			
			
			/***
			 * PRINT RESULT IF END OF CASE
			 */
			if ( nbRemainingLines == 0 ) {			
				String result = state.result.contains("X") ? "IMPOSSIBLE " : state.result ; 
				System.out.println("Case #" + caseId + ": " + result);
				NB_CASES--;
			}					

			// ##############################################
			// EDIT BEFORE THIS LINE ONLY
			// ##############################################
		}
		in.close();
	}


}