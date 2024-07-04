import java.util.*;
import java.io.*;

public class Solution {

	private static final boolean IS_LOCAL = true ; 
	private static final boolean IS_FIXED_CASE_LINES = true ;
	private static final int NB_FIXED_CASE_LINES = 1 ;

	public static final void debug(String str)  {
		if ( IS_LOCAL ) {
			System.out.println(str);
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
		int nbRemainingLines  = IS_FIXED_CASE_LINES ? NB_FIXED_CASE_LINES : 0 ;
		
		int caseId = 0 ; 
		int caseLine= 0 ; 
		while (in.hasNextLine() && NB_CASES > 0 ) {			
			if ( !IS_FIXED_CASE_LINES ) {
				if ( nbRemainingLines == 0 ) {
					caseLine = -1 ;
					nbRemainingLines = in.nextInt();
					in.nextLine();
					caseId++; 
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
			
			String line = in.nextLine();
			debug("read " + line);
			
			String res = "" ; 
			int currentLevel = 0 ; 
			for ( char c : line.toCharArray()) {
				int val = c - '0' ;
				boolean isOK = false ; 
				while ( !isOK ) {
					if ( val == currentLevel ) {
						res += Integer.toString(val);
						isOK = true ;
					}			
					else if (val > currentLevel ) {
						res += "(" ; 
						currentLevel++; 
					}
					else if ( val < currentLevel ) {
						res += ")" ; 
						currentLevel--; 
					}
				}		
			}
			//Close all levels. 
			while (currentLevel > 0 ) {
				res+=")";
				currentLevel--;
			}
			
			
			/***
			 * PRINT RESULT IF END OF CASE
			 */
			if ( nbRemainingLines == 0 ) {			
				String result = res; 
				System.out.println("Case #" + caseId + ": " + result);
				NB_CASES--;
			}					
		}
	}

	
}