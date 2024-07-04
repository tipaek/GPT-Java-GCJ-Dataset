import java.util.*;
import java.io.*;

public class Solution {

	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numTestCase = in.nextInt();
        String []strArray = new String[numTestCase];
        
        for (int i = 0; i < numTestCase; ++i) {
        	strArray[i] = in.next();
        }
        in.close();
        
        for (int i = 0; i < numTestCase; ++i) {
        	addParenthesis(i+1, strArray[i]);
        }
	}
	
	private static void addParenthesis(int testCase, String str){
		String newStr = "";
		int numOpenBracket = 0;
		int currentDigit;
		int numAddBracket;
		
		for (int i = 0; i < str.length(); i++) {
			currentDigit = (int)str.charAt(i) - 48;
			numAddBracket = currentDigit - numOpenBracket;
			if(numAddBracket >= 0){
				for (int j = 0; j < numAddBracket; j++) {
					newStr += "(";
					numOpenBracket++;
				}
			}
			else{
				numAddBracket *= -1;
				for (int j = 0; j < numAddBracket; j++) {
					newStr += ")";
					numOpenBracket--;
				}
			}
			newStr += currentDigit;			
		}
		
		for (int j = 0; j < numOpenBracket; j++) {
			newStr += ")";
		}
		
		System.out.println("Case #" + testCase + ": " + newStr);
	}
}