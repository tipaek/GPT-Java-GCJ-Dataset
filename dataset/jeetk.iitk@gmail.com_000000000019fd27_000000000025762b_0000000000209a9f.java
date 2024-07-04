import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
	public static String nesting(String s) {
		int numOpenPar = 0;
		String retval = "";
		int previousInt = 0;
		for (int i = 0; i <= s.length(); i++) {
			char thisChar =  i < s.length() ? s.charAt(i) : '0';
			int thisInt = Integer.parseInt(thisChar + "");
			if (i == 0) {
				numOpenPar = thisInt;
				previousInt = thisInt;
				for (int j = 0; j < thisInt; j ++) {
					retval = retval + "(";
				}
				retval = retval + thisChar;
			}
			else if (i == s.length()) {
				//no new chars, append numOpenPar closing braces
				//retval = retval + thisChar;
				for (int j = 0; j < numOpenPar; j ++) {
					retval = retval + ")";
				}
			}
			else {
				if (thisInt == previousInt) {
					retval = retval + thisChar;
				}
				else if (thisInt > previousInt) {
					for (int j = 0; j < thisInt - previousInt; j++) {
						retval = retval + "(";
					}
					retval = retval + thisChar;
					numOpenPar = numOpenPar + thisInt - previousInt;
					previousInt = thisInt;
				}
				else if (thisInt < previousInt) {
					for (int j = 0; j < previousInt - thisInt; j++) {
						retval = retval + ")";
					}
					retval = retval + thisChar;
					numOpenPar = numOpenPar - (previousInt - thisInt);
					previousInt = thisInt;
				}
			}
			
		}
		
		return retval;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
	    int numCases = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
	    for (int i = 1; i <= numCases; ++i) {
	      String thisString = in.next();
	      System.out.println("Case #" + i + ": " + nesting(thisString));
	    }
	    in.close();

	}

}
