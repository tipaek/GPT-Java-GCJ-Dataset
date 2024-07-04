import java.util.Scanner;

public class Solution {

	private static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		int testCaseCount = sc.nextInt();
		for (int i = 0; i < testCaseCount; i++) {
			String s = sc.next();
			solve(s, i);
		}
	}

	public static void solve(String s, int testCase) {
		StringBuilder finalVal = new StringBuilder();
		int lim = Integer.parseInt(s);
		
		if (lim == 0) {
			System.out.println("Case #" + (testCase + 1) + ": " + s);
			return;
		}
		
		if (s.length() == 1) {
			finalVal.append("(".repeat(lim));
			finalVal.append(s);
			finalVal.append(")".repeat(lim));
			System.out.println("Case #" + (testCase + 1) + ": " + finalVal);
			return;
		}
		
		int length = s.length();
		finalVal.append(s.charAt(0));
		for (int i = 0; i < length - 1; i++) {
			int currentDigit = Character.getNumericValue(s.charAt(i));
			int nextDigit = Character.getNumericValue(s.charAt(i + 1));
			int diff = nextDigit - currentDigit;
			
			if (diff > 0) {
				finalVal.append("(".repeat(diff));
			} else if (diff < 0) {
				finalVal.append(")".repeat(-diff));
			}
			
			finalVal.append(s.charAt(i + 1));
		}
		
		int firstDigit = Character.getNumericValue(s.charAt(0));
		int lastDigit = Character.getNumericValue(s.charAt(s.length() - 1));
		finalVal.insert(0, "(".repeat(firstDigit));
		finalVal.append(")".repeat(lastDigit));
		
		System.out.println("Case #" + (testCase + 1) + ": " + finalVal);
	}
}