import java.util.*;
import java.io.*;

public class Solution {
	public static void main(String[] args){
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int numCases = in.nextInt();
		in.nextLine();
		
		for (int i = 1; i <= numCases; i++) {
		    String input = in.nextLine().trim();
		    String output = parenStr(input);
			System.out.printf("Case #%d: %s", i, output);
			if (i != numCases) System.out.print("\n");
		}
	}
	
	private static String parenStr(String digits) {
		int n = digits.length();
		StringBuilder sb = new StringBuilder();
		int prev = 0;
		for (int i = 0; i < n; i++) {
			int digit = digits.charAt(i)-'0';
			if (prev < digit) {
				int j = digit;
				while (j > prev) {
					sb.append('(');
					j--;
				}
			} else if (prev > digit){
				int j = digit;
				while (j < prev) {
					sb.append(')');
					j++;
				}
			}
			prev = digit;
			sb.append(digit);
		}
		
		while (prev > 0) {
			sb.append(')');
			prev--;
		}
		
		return sb.toString();
	}
}
