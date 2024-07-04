import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int t = in.nextInt();
		in.nextLine();
		for (int i = 0; i < t; ++i) {
			String s = in.nextLine();
			StringBuilder S = new StringBuilder();
			int open = 0;
			for (int j = 0; j < s.length(); ++j) {
				int digit = getInt(s.charAt(j));
				if (digit > open) {
					S.append(repeated("(", digit - open));
				} else if (digit < open) {
				    S.append(repeated(")", open - digit));
				}
				S.append(digit);
				open = digit;
			}
			S.append(repeated(")", open));
			
			System.out.printf("Case #%d: %s\n", i + 1, S);
		}
	}
	
	public static int getInt(char c) {
		return c - '0';
	}
	
	public static String repeated(String s, int r) {
	    StringBuilder sb = new StringBuilder();
	    for (int i = 0; i < r; ++i) {
	        sb.append(s);
	    }
	    return sb.toString();
	}
}
