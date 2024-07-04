import java.util.Scanner;

public class Solution {
	
	public static void main(String args[]) {
		Scanner s = new Scanner(System.in);
		int testCases = s.nextInt();
		for(int i=1;i<=testCases;i++) {
			String inputString = s.next();
			System.out.println("Case #"+i+": "+getParentheses(inputString));
		}
	}
	
	private static String getParentheses(String inputString) {
		StringBuffer strBuffer = new StringBuffer(); 
		int addedBraces = 0;
		for(int i=0;i<inputString.length();i++) {
			int currElement = inputString.codePointAt(i)-48;
			if(currElement>addedBraces) {
				while(addedBraces!=currElement) {
					strBuffer.append("(");
					addedBraces++;
				}
			}
			else if(currElement<addedBraces) {
				while(addedBraces!=currElement) {
					strBuffer.append(")");
					addedBraces--;
				}
			}
			strBuffer.append(inputString.charAt(i));
		}
		while(addedBraces!=0) {
			strBuffer.append(")");
			addedBraces--;
		}
		return strBuffer.toString();
	}

}
