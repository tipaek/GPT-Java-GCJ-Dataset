

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
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
		int n = in.nextInt();
		int start[][] = new int[n][3];
		int end[] = new int[n];
		for (int i = 0; i < n; i++) {
			start[i][0] = in.nextInt();
			start[i][1] = in.nextInt();
			start[i][2] = i;

		}
		String ans = solve(n, start);

		printLine("Case #" + tt + ": " + ans);

	}

	private String solve(int n, int start[][]) {

		int c[] = new int[] { 0, 0 };
		int j[] = new int[] { 0, 0 };
		char res[] = new char[start.length];
		Arrays.sort(start, (a, b) -> {

			int diff = a[0] - b[0];
			if (diff == 0)
				return a[1] - b[1];
			return diff;
		});
		for (int i = 0; i < start.length; i++) {

			if (start[i][0] >= c[1] || start[i][1] <= c[0]) {
				res[start[i][2]] = 'C';
				c[0] = start[i][0];
				c[1] = start[i][1];
			} else if (start[i][0] >= j[1] || start[i][1] <= j[0]) {
				res[start[i][2]] = 'J';
				j[0] = start[i][0];
				j[1] = start[i][1];
			} else {
				return "IMPOSSIBLE";
			}

		}
		return new String(res);
	}

	private static void printLine(String str) {
		System.out.println(str);
		System.out.flush();
	}

}
