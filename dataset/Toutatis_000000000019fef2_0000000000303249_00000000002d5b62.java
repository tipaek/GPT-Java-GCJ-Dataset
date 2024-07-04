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

		
		public String decompose(String binStr, String binStr2 ) {
			String ret = "" ; 
			String previous = "" ;
			for (int i = 1 ; i < Math.max(binStr.length(), binStr2.length()) ; i++) {
				if ( binStr.length() > i && binStr.charAt(binStr.length() - i - 1) == '1' ) {
					ret += "E" ;  
					}
				else if ( binStr2.length() > i && binStr2.charAt(binStr2.length() - i - 1) == '1') {
					ret += "N" ;
				}
				else {
					//if 0, duplicates previous one
					char c = ret.charAt(ret.length()-1);
					if ( c == 'N') {
						ret = ret.substring(0, ret.length() - 1) + "SN" ;
					}
					else if ( c == 'S') {
						ret = ret.substring(0, ret.length() - 1) + "NS" ;
					}
					else if ( c == 'E') {
						ret = ret.substring(0, ret.length() - 1) + "WE" ;
					}

					else if ( c == 'W') {
						ret = ret.substring(0, ret.length() - 1) + "EW" ;
					}
				}
			}
			return ret;
		}
		
		//A = X , b = X
		public boolean isCompatible(String a, String b) {
			String ret = "" ;
			//Check lenght
			int alength = a.length();
			int blength = b.length();
			int l = Math.min(alength, blength) ; 
			boolean retenue = false ;
			boolean isPrevA = false; 
			boolean isPrevB = false ; 
			for (int i = 1 ; i < l  ; i++ ) {
				char charX = a.charAt(alength-i-1);
				char charY = b.charAt(blength-i-1);
				boolean isA = charX == '1' ;
				boolean isB = charY == '1' ;
				if ( charX == charY ) {
					if ( !retenue) {
						retenue = true ; 
					}
					return false;
				}
				else {
					retenue = false ;
				}
				isPrevA = isA;
				isPrevB = isB;
			}
			String sMax = alength > l ? a : b ; 
			retenue = retenue && alength > l ? isPrevA : isPrevB ;
			for (int i = 0 ; i <  sMax.length() - l ; i++) {
				if (sMax.charAt(i) != '1' ) {
					if ( !retenue ) {
						retenue = true;  
					}
					else {
						return false;
					}
				}
				else {
					retenue = false;
				}
			}
			return true  ; 	
		}
		
		public String compute(long X, long Y) {
			//Un pair, un impair
			boolean isXPair = X % 2 == 0 ;
			boolean isYPair = Y % 2 == 0 ;
			if ( isXPair == isYPair) {
				return "IMPOSSIBLE";
			}
			
			long absX = Math.abs(X) ; 
			long absY = Math.abs(Y) ; 
			long toUpdate = isXPair ? absY : absX ;
			//Soit +1 , soit -1
			long updatedPlus = toUpdate + 1 ;
			long updatedLess = toUpdate - 1 ; 
			
			long stayLong = isXPair ? absX : absY ; 
		
			String upL = Long.toBinaryString(updatedLess);
			String upP = Long.toBinaryString(updatedPlus);
			String up = Long.toBinaryString(toUpdate);
			String stay = Long.toBinaryString(stayLong);
			
			boolean isOKP = isCompatible(upP, stay) ; 
			boolean isOKL = isCompatible(upL, stay); 
			
			if ( !isOKL && !isOKP ) {
				return "IMPOSSIBLE"; 
			}
			
			String res = "" ; 
			if ( isYPair && isOKL ) {
				res += "E" ; 				
			}
			else if ( isYPair && isOKP ) {
				res += "W" ; 				
			}
			else if ( isXPair && isOKL ) {
				res += "N" ; 				
			}
			else if ( isXPair && isOKP ) {
				res += "S" ; 				
			}
			
			String YtoUse = isYPair ? stay : isOKL ? upL : upP ;
			String XtoUse = isXPair ? stay : isOKL ? upL : upP ;
			
			String afterRes = res + decompose(XtoUse, YtoUse) ;
			
			
			if ( X < 0 ) {
				afterRes =	afterRes.replace("W", "O") ;
				afterRes =	afterRes.replace("E", "W") ;
				afterRes =	afterRes.replace("O", "W") ;
			}
			if ( Y < 0 ) {
				afterRes = afterRes.replace("S", "O") ;
				afterRes = afterRes.replace("N", "S") ;
				afterRes = afterRes.replace("O", "N") ;
			}
			
			return afterRes; 
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
			//in.nextLine();
//			String[] split = line.split(" ");
//			for (int j = 0 ; j < split.length ; j++) {
//			
//			}
			
			
			/***
			 * COMPUTE RESULT IF END OF CASE
			 */
			if ( N == 0 ) {
				String res = state.compute(X,Y) ; 				
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