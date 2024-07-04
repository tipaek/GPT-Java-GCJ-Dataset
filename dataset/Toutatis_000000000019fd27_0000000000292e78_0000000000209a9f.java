import java.util.*;
import java.io.*;

public class Solution {

	private static final boolean IS_LOCAL = false ; 

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


		int caseId = 0 ; 
		while (in.hasNextLine() && NB_CASES > 0 ) {			
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
			String result = res; 
			System.out.println("Case #" + caseId + ": " + result);
			NB_CASES--;

		}
		in.close();
	}
}