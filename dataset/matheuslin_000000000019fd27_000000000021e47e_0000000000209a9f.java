import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
		in.nextLine();
		for (int i = 1; i <= t; ++i) {

			// read input
			String line = in.nextLine();
			String answer = processLine(line);
			

			System.out.println("Case #" + i + ": " + answer);
		}
	}
	
	public static String processLine(String line) {
		int currentDepth = 0;
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < line.length(); i++) {
			int currentDigit = Integer.parseInt(line.substring(i, i+1));
			while(currentDepth < currentDigit) {
				sb.append("(");
				currentDepth++;
			}
			while(currentDepth > currentDigit) {
				sb.append(")");
				currentDepth--;
			}
			sb.append(currentDigit);
		}
		
		while(currentDepth > 0) {
			sb.append(")");
			currentDepth--;
		}
		
		return sb.toString();
	}

}