import java.util.*;
import java.io.*;
public class Solution {
	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        in.nextLine();
        for (int testCase = 1; testCase <= testCases; ++testCase) {
	        String testCaseValue = in.nextLine();
	        System.out.println("Case #" + testCase + ": " + getFormattedString(testCaseValue) );
        }
        in.close();
      }

	private static String getFormattedString(String rawValue) {
		StringBuilder resultString = new StringBuilder();
		// string must contain numeric values - each char is a digit
		int[] originalNums = new int[rawValue.length()];
		for(int i=0; i< rawValue.length(); i++) {
			originalNums[i] =  Character.getNumericValue(rawValue.charAt(i));
		}
		int openParen = 0;
		//go from left to right  
		/*
		 * if openParen is the same as current value = append that value
		 * if openParen is smaller than current value at given index append that many opening parenthesis and append that value also increse value of openParen
		 * if value of openParam is larger than current value append that many closing paranthesis and decrese the value by number of closing paren
		*/
		for(int i = 0; i< originalNums.length; i++) {
			int currentValue = originalNums[i];
			int differenceOfValueVsOpenParen = currentValue - openParen;
			if(differenceOfValueVsOpenParen > 0) {
				openParen += differenceOfValueVsOpenParen;
				for(int p = 0; p<differenceOfValueVsOpenParen; p++) resultString.append("(");
			}
			else if(differenceOfValueVsOpenParen < 0) {
				openParen += differenceOfValueVsOpenParen;
				for(int p = 0; p< (differenceOfValueVsOpenParen*(-1)); p++) resultString.append(")");
			}
			resultString.append(currentValue);			
		}		
		//append remaining open paranthesis
		while(openParen > 0) {
			resultString.append(")");
			openParen--;
		}
		
		return resultString.toString();
	}
      
}