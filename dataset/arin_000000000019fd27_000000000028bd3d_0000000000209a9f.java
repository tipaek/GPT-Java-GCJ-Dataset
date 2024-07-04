
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
		for (int i = 1; i <= t; ++i) {
			String s = in.next();
			String result = "";
			int nesting = 0;
			
			for (int l = 0; l < s.length(); l++) {
				char c = s.charAt(l);
				int j = c - '0';
				if (j > nesting) {
					// append j-nesting (
					int temp = j - nesting;
					while (temp-- > 0) {
						result += '('; nesting++;
					}
				} else if (j < nesting) {
					// append nesting - j )
					int temp = nesting - j;
					while (temp-- > 0) {
						result += ')'; nesting--;
					}
				}
				result += c;
			}
			//close the remaining parenthesis
			while(nesting-->0)  result+=')'; 
			System.out.println("Case #" + i + ": " + result);
		}
	}
}
