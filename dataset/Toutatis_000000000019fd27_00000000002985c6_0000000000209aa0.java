import java.util.*;
import java.io.*;

public class Solution {

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
	}

	public static class Carre {
		int dim = 0 ;
		int[][] map = new int[0][0] ; 

		public Carre(int dim) {
			this.dim = dim ; 
			map = new int[dim][dim] ; 
		}

		public static boolean isComplete(int n, int[][] carre) {
			for (int i = 0 ; i < n ; i++ ) {				
				for ( int j = 0 ; j < n ; j++ ) {
					if (carre[i][j] == 0) { return false ;} 
				}
			}
			return true;
		}

		public static boolean isValid(int n, int[][] carre) {
			//Check lignes
			for (int i = 0 ; i < n ; i++ ) {
				boolean[] checkLine = new boolean[n];
				boolean[] checkCol = new boolean[n]; 
				for ( int j = 0 ; j < n ; j++ ) {
					//Line
					int val = carre[i][j];
					if ( val > 0 ) {
						if ( checkLine[val-1] ) {
							return false;
						}
						checkLine[val-1] = true; 
					}

					//Col
					int val2 = carre[j][i];
					if ( val2 > 0 ) {
						if ( checkCol[val2-1] ) {
							return false;
						}
						checkCol[val2-1] = true; 
					}
				}
			}			

			return true;
		}

		public static int[][] fillRec(int n, int[] diagonale) {
			int[][] ret = new int[n][n] ; 
			for ( int i  = 0 ; i < n ; i++ ) {
				ret[i][i] = diagonale[i];  
			}

			if ( tryPopulate(n, 0, 0, 0, copyOf(n, ret), ret) ) { 
				return ret;
			}
			return null; 
		}

		public static Set<Integer> alreadyUsed(int n, int[][] carre, int iToUse, int jToUse) {
			Set<Integer> ret = new TreeSet<>();
			for (int i = 0 ; i < n ; i++) {
				int val = carre[i][jToUse];
				if ( val > 0 ) {
					ret.add(val); 
				}
			}

			for (int j = 0 ; j < n ; j++) {
				int val = carre[iToUse][j];
				if ( val > 0 ) {
					ret.add(val); 
				}
			}
			return ret ; 
		}
		
		public static boolean tryPopulate(int n, int i, int j, int k, int[][] carre, int[][] result) {
			if ( carre[i][j] == 0 ) { //Verifie que la case est libre
				carre[i][j] = k; 
			}
			if ( !isValid(n, carre)) {
				return false;
			}
			if ( isComplete(n, carre)) {
				//register carre
				copyToResult(n, carre, result);
				return true ; 
			}

			//Copy this state
			int nexti = j+1 < n ? i : i+1 ;
			int nextj = j+1 < n ? j+1 : 0 ;
			
			Set<Integer> alreadyUsed = alreadyUsed(n, carre, nexti, nextj); 
			if ( nexti == nextj ) {
				if ( tryPopulate(n, nexti, nextj, 1, copyOf(n,carre), result) ) {
					return true;
				}
			}
			else {
				for (int nextk = 1 ; nextk <= n ; nextk++ ) {
					if ( !alreadyUsed.contains(nextk) ) {
						if ( tryPopulate(n, nexti, nextj, nextk, copyOf(n,carre), result) ) {
							return true;
						}
					}
				}
			}
			return false;
		}

		public static void copyToResult(int n, int[][] carre, int[][] result) {
			for (int i = 0 ; i < n ; i++) {
				for (int j = 0 ; j < n ; j++) {
					result[i][j] = carre[i][j]; 
				}
			}
		}

		public static int[][] copyOf(int n, int[][] carre) {
			int[][] ret = new int[n][n]; 
			for (int i = 0 ; i < n ; i++) {
				for (int j = 0 ; j < n ; j++) {
					ret[i][j] = carre[i][j]; 
				}
			}
			return ret; 
		}


		public static int[] maxK(int n, int k) {
			int rest = k ;
			int[] ret = new int[n];  
			for (int i = 0 ; i < n ; i++ ) {
				int val = Math.min(rest - (n - i - 1) , n);
				ret[i] = val;
				rest -= val; 
			}
			return ret;
		}
		
		public static int[] meanK(int n, int k) {
			int rest = k ;
			int[] ret = new int[n];  
			for (int i = 0 ; i < n ; i++ ) {
				int val = rest / (n - i);
				ret[i] = val;
				rest -= val; 
			}
			return ret;
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

			String line = in.nextLine();
			debug("read " + line);
			String[] split = line.split(" ");
			// ##############################################
			// EDIT AFTER THIS LINE ONLY
			// ##############################################


			Integer n = Integer.valueOf(split[0]) ; 
			Integer k = Integer.valueOf(split[1]) ;

			//Que des chiffres max (n)apres puis des 1.
			int[] maxDiag = Carre.meanK(n, k);
			int[][] res = Carre.fillRec(n, maxDiag);



			/***
			 * PRINT RESULT IF END OF CASE
			 */
			if ( nbRemainingLines == 0 ) {			
				String result = res == null ? "IMPOSSIBLE" : "POSSIBLE" ; 
				System.out.println("Case #" + caseId++ + ": " + result);
				if ( res != null ) {
					for (int i = 0 ; i < n ; i++) {
						String resultTemp = "" ; 
						for (int j = 0 ; j < n ; j++ ) {
							resultTemp += res[i][j] + " " ; 
						}
						System.out.println(resultTemp.trim());		
					}
				}
				NB_CASES--;
			}					

			// ##############################################
			// EDIT BEFORE THIS LINE ONLY
			// ##############################################
		}
		in.close();
	}


}