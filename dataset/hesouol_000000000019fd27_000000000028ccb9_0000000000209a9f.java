import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt();
		for(int t1=0; t1<t; t1++) {
			String s = in.next();
			System.out.format("Case #%d: %s\n",t1+1, solve(s));
		}
		in.close();
	}
	
	public static String solve(String s) {
		StringBuilder r = new StringBuilder();
		int parenthesisOppened = 0;

		char[] s1 = s.toCharArray();

		for (int i = 0; i < s1.length; i++) {
			int c = s1[i] - '0';
			if (i == 0) {
				for (int j = 0; j < c; j++) {
					r.append('(');
				}
				parenthesisOppened = c;
				r.append((char) (c + '0'));
				continue;
			}

			if (c < parenthesisOppened) {
				int mustClose = parenthesisOppened - c;
				for (int j = 0; j < mustClose; j++) {
					r.append(')');
				}
				parenthesisOppened = c;
				r.append((char) (c + '0'));
				continue;
			}

			if (c > parenthesisOppened) {
				int mustOpen = c - parenthesisOppened;
				for (int j = 0; j < mustOpen; j++) {
					r.append('(');
				}
				parenthesisOppened = c;
				r.append((char) (c + '0'));
				continue;
			}

			r.append((char) (c + '0'));
		}

		for (int i = 0; i < parenthesisOppened; i++) {
			r.append(')');
		}

		return r.toString();

	}

}
