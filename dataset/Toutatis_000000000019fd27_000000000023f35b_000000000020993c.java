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

	public static class State {
		int trace = 0 ; 
		int badLines = 0 ; 
		boolean[][] checkVal = new boolean[0][0]; 
		boolean[] badCol = new boolean[0] ; 
		
		public void init(int numberOfElements) {
			trace =  0; 
			badLines = 0 ; 
			checkVal = new boolean[numberOfElements][numberOfElements]; 
			badCol = new boolean[numberOfElements] ; 
		}		
	}
	
	
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
		int caseLines  = IS_FIXED_CASE_LINES ? NB_FIXED_CASE_LINES : 0 ;
		int nbRemainingLines = 0 ;
		
		int caseId = 0 ; 
		State state = new State();
		int size = 0 ; 
		int caseLine= 0 ; 
		while (in.hasNextLine() && NB_CASES > 0 ) {			
			if ( !IS_FIXED_CASE_LINES ) {
				if ( nbRemainingLines == 0 ) {
					caseLine = -1 ;
					nbRemainingLines = in.nextInt();
					in.nextLine();
					size = nbRemainingLines;
					caseId++; 
					//Create state temp
					state.init(size);
					continue;
				}
				nbRemainingLines--; 		
				caseLine++ ; 
			}
			
			String line = in.nextLine();
			debug("read " + line);
			Set<Integer> setLine = new TreeSet<>(); 
			int c = 0 ; 
			boolean isBadLine = false; 
			for ( String s : line.split(" ")) {
				Integer val = Integer.valueOf(s);
				if ( !setLine.add(val) ) {
					//Wrong line 
					isBadLine = true ; 
				}
				if ( c == caseLine ) {
					state.trace += val ; 
				}
				if ( state.checkVal[c][val-1] ) {
					state.badCol[c] = true ; 
				}
				state.checkVal[c][val-1] = true ; 
				c++; 
			}
			
			if ( isBadLine ) {
				state.badLines++; 
			}

		
			
			/***
			 * PRINT RESULT IF END OF CASE
			 */
			if ( nbRemainingLines == 0 ) {				
				int nbBadCol = 0 ; 
				for ( boolean isbad : state.badCol ) {
					if ( isbad )  {
						nbBadCol++;
					}
				}
				
				String result = state.trace + " " + state.badLines + " " + nbBadCol; 
				System.out.println("Case #" + caseId + ": " + result);
				NB_CASES--;
			}					
		}
	}

	
}