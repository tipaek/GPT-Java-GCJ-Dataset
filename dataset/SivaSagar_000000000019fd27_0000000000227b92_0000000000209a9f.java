
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testCases = sc.nextInt();
		for (int i = 0; i < testCases; i++) {
			String s = sc.next();
			StringBuilder sb = new StringBuilder();
			int openedBrackets = 0;
			for(int charInd=0;charInd<s.length();charInd++) {
				int digit = s.charAt(charInd)-'0';
				
				if(openedBrackets> digit) {
					int opeBCount = openedBrackets-digit;
					
					while(opeBCount !=0 ) {
						sb.append(")");
						opeBCount--;
						openedBrackets--;
					}
					sb.append(String.valueOf(digit));
				}
				else if(openedBrackets < digit) {
					int closingBCount = digit -openedBrackets;
					while(closingBCount !=0 ) {
						sb.append("(");
						closingBCount--;
						openedBrackets++;
					}
					sb.append(String.valueOf(digit));
				}
				else {
					sb.append(String.valueOf(digit));
				}
			}
			if(openedBrackets> 0) {
				int opeBCount = openedBrackets;
				
				while(opeBCount !=0 ) {
					sb.append(")");
					opeBCount--;
					openedBrackets--;
				}
			}
			System.out.println("Case #" + (i + 1) + ": "+ sb);
		}
		sc.close();
	}

}
