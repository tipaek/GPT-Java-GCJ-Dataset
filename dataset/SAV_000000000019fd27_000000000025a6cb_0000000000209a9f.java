import java.util.*;
import java.io.*;

public class Solution {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		System.out.println("T: " + T);
		int r = 1;
		String openStr = "(";
		String closeStr = ")";
		String buf = sc.nextLine();
		while (r <= T) {
			int open = 0;
			String str = sc.nextLine();
			StringBuilder ans = new StringBuilder();
			for (int i = 0; i < str.length(); i++) {
				char ch = str.charAt(i);
				int c = ch - '0';
				if (c > open) {
					int diff = c - open;
					ans.append(repeat(openStr, diff));
					open += diff;
					ans.append(c);
				} else if ( c == open ){
					ans.append(c);
				} else {
					int diff = open - c;
					ans.append(repeat(closeStr, diff));
					ans.append(c);
					open -= diff;
				}
			}
			ans.append(repeat(closeStr, open));
			System.out.println("Case #" + r + ": " + ans.toString());
			r++;
		}
	}
		
	public static String repeat(String str, int n) {
	    StringBuilder ans = new StringBuilder();
		for (int i = 1; i <= n; i++) {
		    ans.append(str);
		}
		return ans.toString();
	}
}
