

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
		for (int i = 1; i <= t; ++i) {
			
			String letters = in.next();
			String constructed = "";
			for(int j=0;j<letters.length();j++) {
				Integer numberOfRequiredParentheses = Integer.parseInt(letters.charAt(j)+"");
				int indexOfInsertion=constructed.length();
				for(;indexOfInsertion>0&&numberOfRequiredParentheses>0;indexOfInsertion--) {
					if(Character.isDigit(constructed.charAt(indexOfInsertion-1))) 
					break;
					else
						numberOfRequiredParentheses--;
				}
				String leftParantheses = repeatString("(", numberOfRequiredParentheses);
				String rightParantheses = repeatString(")", numberOfRequiredParentheses);
				if(indexOfInsertion<0)indexOfInsertion =0;
				String leftCnstructed = constructed.substring(0, indexOfInsertion);
				String rightConstructed = constructed.substring(indexOfInsertion);
				constructed = leftCnstructed+leftParantheses+letters.charAt(j)+
						rightParantheses+rightConstructed;
				 			}
			
			
			System.out.println("Case #" + i + ": " + constructed);

			
			}

	
	}
	
	static String  repeatString(String str,int n) {
		String constructed = "";
		for(int i=0;i<n;i++) {
			constructed += str;
		}
		return constructed;
	}

}
