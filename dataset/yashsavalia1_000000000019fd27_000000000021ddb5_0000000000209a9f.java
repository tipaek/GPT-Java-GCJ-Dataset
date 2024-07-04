import java.util.*;
import java.io.*;

public class Solution {
	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int testCases = Integer.parseInt(in.nextLine());
		String[] outputs = new String[testCases];
		for (int i = 1; i <= testCases; ++i) {
			String input = in.nextLine();
			String parenthesized = parenthesizeInput(input);
			outputs[i - 1] = "Case #" + i + ": " +  parenthesized;
		}
		for(int i = 0; i < testCases; i++) {
			System.out.println(outputs[i]);
		}
	}

	private static String parenthesizeInput(String input) {
		StringBuilder newStr = new StringBuilder(input);
		for(int i = 0; i < newStr.length(); i++) {
			if(newStr.charAt(i) == '1') {
				if(i != 0 && (newStr.charAt(i - 1) == '1' || newStr.charAt(i - 1) == '(')) {
					
				} else {
					newStr.insert(i, '(');
				}
				if(i != newStr.length() - 1 && (newStr.charAt(i + 1) == '1' || newStr.charAt(i + 1) == ')')) {
					
				} else {
					newStr.insert(i+1, ')');
				}
			}
		}
		return newStr.toString();
	}
}