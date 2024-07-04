import java.util.*;
import java.io.*;

public class Solution {

	// T : tests cases
	// N : remaining lines
	private static final boolean IS_LOCAL = false ; 
	private static final boolean IS_FIXED_CASE_LINES = true ;
	private static final int NB_FIXED_CASE_LINES = 4001 ;

	public static final void debug(String str)  {
		if ( IS_LOCAL ) {
			System.out.println(str);
		}
	}


	// ###########################################
	// 		EDIT STATE AFTER THIS LINE
	// ###########################################

	public static class Store implements Comparable<Store>  {
		int m ;
		String val ;

		public Store(int m, String v ) {
			this.m = m ; 
			this.val = v.trim() ; 
		}

		@Override
		public int compareTo(Store o) {
			return Integer.compare(m, o.m);
		}

	}

	public static class State {
		List<Store> storeList = new ArrayList<Store>() ; 
		public State(int numberOfElements) {
		}

		public void add(int m, String val) {
			storeList.add(new Store(m, val) ) ;
		}

		private String[] tabStr(int l) {
			String[] res = new String[l] ; 
			for (int i=0; i<l ;i++) {
				res[i] = ""; 
			}
			return res;
		}

		public String compute() {
			Collections.sort(storeList);
			String[] res = tabStr(10) ;
			String[] sure = tabStr(10);
			String sureItems = "" ;
			for ( Store s : storeList) {
				int m = s.m ;
				String val = s.val ; 
				//Can be from 1 to m
				List<Store> candidates =  new ArrayList<>();  ; 
				for (int i = 1 ; i <= m ; i++) {
					String str = String.valueOf(i) ; 
					if (str.length() == val.length()) {
						for (int k = 0 ; k < str.length() ; k++) {
							String s1 = "" + str.charAt(k) ;
							String val1 = "" + val.charAt(k) ; 
							int index = Integer.valueOf(s1).intValue();
							if ( sure[index].length() == 0 && !sureItems.contains(val1) ) {							
								candidates.add(new Store(index,val1));
							}
						}
					}
				}

				if ( candidates.size() == 1 ) {
					//FOUND
					sure[candidates.get(0).m] = candidates.get(0).val;			
					sureItems += candidates.get(0).val;
				}
			}
			
			String result = ""; 
			for (String s : sure) {
				result += s ; 
			}
			return result;
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

			if ( N == NB_FIXED_CASE_LINES - 1 ) {
				int size = in.nextInt();
				in.nextLine();
			}

			else {
				int x = in.nextInt();
				String s = in.nextLine();
				state.add(x, s);
			}

			//			long X = in.nextLong();
			//			long Y = in.nextLong();
			//			String M = in.nextLine().trim() ;
			//in.nextLine();
			//			String[] split = line.split(" ");
			//			for (int j = 0 ; j < split.length ; j++) {
			//			
			//			}


			/***
			 * COMPUTE RESULT IF END OF CASE
			 */
			if ( N == 0 ) {
				String res = state.compute() ; 				
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