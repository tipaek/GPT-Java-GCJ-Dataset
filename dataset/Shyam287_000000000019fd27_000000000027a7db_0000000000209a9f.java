import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

class Solution {

	public static void main(String[] args) {

		Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int testCases = sc.nextInt();
		sc.nextLine();

		for(int testCase =1; testCase <=testCases ; testCase++) {
			String s = sc.nextLine();
			deriveBalancedDigits(s,testCase);
		}
	}

	private static void deriveBalancedDigits(String s, int testCase) {

		int closingBracketCount = 0;
		StringBuilder balancedDigits = new StringBuilder();
		for(int i=0; i<s.length() ; i++) {

			int digit = Integer.parseInt(s.substring(i,i+1));

			if(digit > closingBracketCount) {
				int diff = digit - closingBracketCount;
				closingBracketCount += diff;
				appendBracket(balancedDigits,digit, true, diff);
			} else if (digit == closingBracketCount) {
				appendBracket(balancedDigits, digit, false, 0);
			}
			else {
				int diff = closingBracketCount - digit;
				closingBracketCount =digit ;
				appendBracket(balancedDigits, digit, false, diff);	
			}
		}

		appendBracket(balancedDigits, -1, false, closingBracketCount);
		display(balancedDigits.toString(), testCase);
	}

	private static void appendBracket(StringBuilder s, int digit, boolean openingBracket,int times)  {

		for(int i=1; i <= times; i++) {
			if(openingBracket) {
				s.append("(");
			} else {
				s.append(")");
			}

		}

		if(digit != -1) {
			s.append(digit);
		}
	}

	private static void display(String balancedDigits, int testCase) {

		System.out.println("Case #" +testCase + ": " + balancedDigits);
	}


}
