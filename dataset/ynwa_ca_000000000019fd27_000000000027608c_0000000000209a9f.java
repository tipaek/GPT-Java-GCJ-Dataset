
import java.util.*;
import java.io.*;

public class Solution {
	private static boolean debug = false;
	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int testCases = in.nextInt(); 
		if (debug) System.out.println("testCases: " + testCases);
		for (int testCase = 1; testCase <= testCases; testCase++) {
			String input = in.next();
			int[] inputArray = new int[input.length()];
			for (int i=0;i < input.length(); i++) {
				inputArray[i] = Character.getNumericValue(input.charAt(i));
				if (debug) System.out.println("inputArray[" + i + "]: " + inputArray[i]);
			}
			StringBuilder result = new StringBuilder();
			int currentOpenParens = 0;
			for (int i=0; i < inputArray.length; i++) {
				if (inputArray[i] > 0 && inputArray[i] > currentOpenParens) {
					for (int j = currentOpenParens; j < inputArray[i]; j++) {
						result.append("(");
						currentOpenParens++;
					}
				} 
				if (inputArray[i] < currentOpenParens) {
					for (;inputArray[i] < currentOpenParens; currentOpenParens--) {
						result.append(")");
					}
				}
				result.append(inputArray[i]);
			}
			if (currentOpenParens > 0) {
				for (int j = 0; j < currentOpenParens; ) {
					result.append(")");
					currentOpenParens--;
				}
			}
			System.out.println("Case #" + testCase + ": " + result);
		}
	}
}
