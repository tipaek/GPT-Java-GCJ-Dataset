
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
		int n = in.nextInt();
		int start[] = new int[n];
		int end[] = new int[n];
		for (int i = 0; i < n; i++) {
			start[i] = in.nextInt();
			end[i] = in.nextInt();
		}
		String ans = solve(n, start, end);

		printLine("Case #" + tt + ": " + ans);

	}

	private String solve(int n, int start[], int[] end) {

		int c[] = new int[] { 0, 0 };
		int j[] = new int[] { 0, 0 };
		char res[] = new char[start.length];

		for (int i = 0; i < start.length; i++) {

			if (start[i] >= c[1] || end[i] <= c[0]) {
				res[i] = 'C';
				c[0] = start[i];
				c[1] = end[i];
			} else if (start[i] >= j[1] || end[i] <= j[0]) {
				res[i] = 'J';
				j[0] = start[i];
				j[1] = end[i];
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
