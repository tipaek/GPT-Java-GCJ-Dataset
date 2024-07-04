import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
	private static final Scanner scanner = new Scanner(System.in);

	private static final String CLS = ")";
	private static final String OPN = "(";

	public static void main(String[] args) throws IOException {
		int t = scanner.nextInt();

		for (int qItr = 0; qItr < t; qItr++) {

			String s = scanner.next();
			String returnVal = prepareString(s, '0', 0);

			System.out.println("Case #" + (qItr + 1) + ": " + returnVal);
		}

		scanner.close();
	}

	private static String prepareString(String s, char ch, int currentCount) {
		String newS = "";
		
		String []strs = null;
		
		strs = s.split(String.valueOf(ch),-1);
		
		for(int i=0;i<strs.length;i++) {
			if(strs[i].length() > 0)
				newS+= prepareString(strs[i],Character.forDigit((Character.getNumericValue(ch)+1),10),s.indexOf(ch) >=0? Character.getNumericValue(ch): currentCount);
			
			if(s.indexOf(ch) >= 0 && i+1 < strs.length)
				newS+= ch;
		}
		
		if(s.indexOf(ch) >=0)
			newS = appendParentheses(newS, Character.getNumericValue(ch)-currentCount);
		
		return newS;
	}

	private static String appendParentheses(String s, int n) {
		String returnVal = "";

		for (int i = 0; i < n; i++) {
			returnVal += OPN;
			s += CLS;
		}

		return returnVal + s;
	}

}
