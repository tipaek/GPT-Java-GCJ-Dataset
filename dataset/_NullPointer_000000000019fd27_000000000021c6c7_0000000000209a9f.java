

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt();

		for (int tt = 1; tt <= t; tt++) {
			Solution bundling = new Solution();
			bundling.solve(in, tt);
		}

		in.close();
	}

	private void solve(Scanner in, int tt) {
	printLine("Case #" + tt + ": " + generate(in.next()));

	}

	private static void printLine(String str) {
		System.out.println(str);
		System.out.flush();
	}

	String generate(String str) {
		if (str.length() == 0)
			return "";
		StringBuilder res = new StringBuilder();
		int open = 0;
		for (int i = 0; i < str.length(); i++) {
			int n = str.charAt(i) - '0';
			if (open > n) {
				while (open != n) {
					res.append(')');
					open--;
				}
			} else if (open < n) {

				while (open != n) {
					res.append('(');
					open++;
				}
			}
			res.append(str.charAt(i));

		}

		while (open != 0) {
			res.append(')');
			open--;
		}
		return res.toString();
	}

}
