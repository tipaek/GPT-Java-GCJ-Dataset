
import java.util.*;
import java.io.*;

public class Solution {
	
    public static String makeBracket(int braketNumber, boolean openingBraket) {
		String result ="";
		for (int i=0; i<braketNumber; i++) {
			if (openingBraket) {
				result += "(";
			} else {
				result += ")";
			}	
		}
		return result;
    }
    
    public String resolve2 (String input) {
    	String result = "";
    	int currentState=0;
    	for (int i=0; i<input.length(); i++) {
    		int expectedState = Character.getNumericValue(input.charAt(i));
    		if (currentState < expectedState) {
    			result += Solution.makeBracket(expectedState - currentState, true);
    		} else if (currentState > expectedState) {
    			result += Solution.makeBracket(currentState - expectedState, false);
    		}
    		result += input.charAt(i);
    		currentState = expectedState;
    	}
    	//closing brackets
    	 if (currentState > 0) {
 			result += Solution.makeBracket(currentState, false);
 		}
    	return result;
    	
    }

      
      public static void main(String[] args) {
          Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
          int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
          for (int i = 1; i <= t; ++i) {
            String s = in.next();
            Solution sol = new Solution();
            System.out.println("Case #"+i+": "+sol.resolve2(s));
          }
        }
}
