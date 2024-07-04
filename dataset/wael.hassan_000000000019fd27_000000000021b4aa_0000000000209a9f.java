import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner inputScanner = new Scanner(System.in);
		int count = inputScanner.nextInt();
		//cases
		for (int k = 1; k<= count; k++) {
			String numStr = inputScanner.next();
			char[] numStrArr = numStr.toCharArray();
			
			StringBuilder depthStrBuilder = new StringBuilder();
			
			int openBraces = 0;
			for(int i = 0; i < numStrArr.length; i++) {
				int numVal = Integer.parseInt(""+numStrArr[i]);
				if(openBraces < numVal) {
					//open braces
					while(openBraces < numVal) {
						depthStrBuilder.append("(");
						openBraces ++;
					}
				} else {
					//close braces
					while(openBraces > numVal) {
						depthStrBuilder.append(")");
						openBraces --;
					}
				}
				depthStrBuilder.append(numVal);
			}
			
			while(openBraces > 0) {
				depthStrBuilder.append(")");
				openBraces --;
			}
			
			System.out.printf("Case #%d: ", k);
			System.out.println(depthStrBuilder);
		}
		inputScanner.close();
	}
}
