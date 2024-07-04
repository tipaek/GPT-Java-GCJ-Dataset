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
			System.out.println("str: " + str);
			StringBuilder ans = new StringBuilder();
			for (int i = 0; i < str.length(); i++) {
				char ch = str.charAt(i);
				int c = ch - '0';
				if (c > open) {
					int diff = c - open;
					ans.append(openStr.repeat(diff));
					open += diff;
					ans.append(c);
				} else if ( c == open ){
					ans.append(c);
				} else {
					int diff = open - c;
					ans.append(closeStr.repeat(diff));
					ans.append(c);
					open -= diff;
				}
			}
			ans.append(closeStr.repeat(open));
			System.out.println("Case #" + r + ": " + ans.toString());
			r++;
		}
	}
}
