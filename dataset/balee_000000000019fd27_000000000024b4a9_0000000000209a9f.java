import java.io.FileInputStream;
import java.util.Scanner;

public class Solution {

	static String open = "((((((((((";
	static String close = "))))))))))";
	
	private static String process(Scanner in) {
		char[] s = in.next().toCharArray();
		StringBuilder result = new StringBuilder();
		int openCount = 0;
		for(int i = 0; i < s.length; i++) {
			int digit = s[i] - '0';
			if (digit > openCount) 
				result.append(open.substring(openCount, digit));
			else if (digit < openCount) 
				result.append(close.substring(digit, openCount));
			result.append(s[i]);
			openCount = digit;
		}
		result.append(close.substring(0, openCount));
		return result.toString();
	}

	public static void main(String[] args) throws Exception {
		Scanner in = new Scanner(System.in.available() > 0 ? System.in : 
			new FileInputStream(Thread.currentThread().getStackTrace()[1].getClassName() + ".practice.in"));
		int T = in.nextInt();
		for(int i = 1; i <= T; i++) 
			System.out.format("Case #%d: %s\n", i, process(in));
	}
}
