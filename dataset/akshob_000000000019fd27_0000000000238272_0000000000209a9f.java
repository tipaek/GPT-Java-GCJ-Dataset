
import java.util.Scanner;
import java.util.Stack;

public class Solution {

	public static void main(String[] args) {
		int inputs;
		Scanner sc = new Scanner(System.in);
		inputs = sc.nextInt();
		sc.nextLine();
		for(int k=0;k<inputs;k++) {
			String str = sc.nextLine();
			char[] digits = str.toCharArray();
			processInput(digits, k);
		}
	}

	private static void processInput(char[] digits, int caseNumber) {
		caseNumber += 1;
		Stack<String> bracketStack = new Stack<>();
		StringBuilder result = new StringBuilder();
		for(int i=0;i<digits.length;i++) {
			int num = Integer.parseInt(String.valueOf(digits[i]));
			if(num == 0) {
				while(!bracketStack.isEmpty()) {
					result.append(bracketStack.pop());
				}
				result.append(num);
			} else if(i == 0 && num != 0) {
				for(int j=0;j<num;j++) {
					result.append("(");
					bracketStack.push(")");
				}
				result.append(num);
			} else {
				int num1 = Integer.parseInt(String.valueOf(digits[i-1]));
				if(num1 > num) {
					int difference = Math.abs(num1 - num);
					for(int j=0;j<difference;j++) {
						result.append(bracketStack.pop());
					}
					result.append(num);
				} else if(num1 < num) {
					int difference = Math.abs(num1 - num);
					for(int j=0;j<difference;j++) {
						result.append("(");
						bracketStack.push(")");
					}
					result.append(num);
				} else if(num1 == num) {
					result.append(num);
				}
			}
		}
		while(!bracketStack.isEmpty()) {
			result.append(bracketStack.pop());
		}
		
		System.out.println("Case #"+caseNumber+": "+result);
		
	}
}
