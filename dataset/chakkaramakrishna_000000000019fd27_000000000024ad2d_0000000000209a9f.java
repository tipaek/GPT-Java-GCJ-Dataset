import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String nextLine = null;
		// Read number of test cases
		nextLine = scanner.nextLine();
		int n = Integer.parseInt(nextLine);
		String [] output = new String[n];
		
		for(int i=0; i < n; i++) {
			// Read input i+1;
			nextLine = scanner.nextLine();
			output[i] = "Case #" + (i+1) + ": " + depthNest(nextLine);
		}
		//Print output
		for(int i=0; i < n; i++) {
			System.out.println(output[i]);
		}
		
		//close scanner
		scanner.close();
	}

	private static String depthNest(String inputStr) {
		
		int currentDepth = 0;
		int currentDigit = 0;
		StringBuilder sb = new StringBuilder();
		
		for(int i=0; i < inputStr.length(); i++) {
			currentDigit = Integer.parseInt("" + inputStr.charAt(i));
			correctNesting(sb, currentDigit, currentDepth);
			currentDepth = currentDigit;
			sb.append(inputStr.charAt(i));
		}
		while(currentDepth > 0) {
			sb.append(')');
			currentDepth--;
		}
		return sb.toString();
	}
	
	private static void correctNesting(StringBuilder sb, int currentDigit, int currentDepth) {
		if (currentDigit == currentDepth) {
			return;
		}
		if (currentDigit > currentDepth) {
			correctNesting(sb.append('('), currentDigit, currentDepth+1);
		} else {
			correctNesting(sb.append(')'), currentDigit, currentDepth-1);
		}
	}
	
}