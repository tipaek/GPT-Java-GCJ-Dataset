import java.util.Scanner;

public class Solution{
	
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int testCases = sc.nextInt();
		for(int j=1;j<=testCases;j++) {
			String inputString = sc.next();
			System.out.println("Case #"+j+": "+getParentheses(inputString));
		}
	}
	
	private static String getParentheses(String inputString) {
		StringBuffer strBuffer = new StringBuffer(); 
		int addedBraces = 0;
		for(int j=0;j<inputString.length();j++) {
			int currElement = inputString.codePointAt(j)-48;
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
			strBuffer.append(inputString.charAt(j));
		}
		while(addedBraces!=0) {
			strBuffer.append(")");
			addedBraces--;
		}
		return strBuffer.toString();
	}
}