

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
//			bundling.generate(n);
		}

		in.close();
//		new Indicium().generate(9);
	}

	private void solve(Scanner in, int tt) {
		int n = in.nextInt();
		int trace = in.nextInt();
		int remainder = trace % n;

		if ((remainder != 0 && n * (n + 1) / 2 != trace) || (n * (n + 1) / 2 == trace && n == 2)) {
			printLine("Case #" + tt + ": IMPOSSIBLE");
			return;
		}

		printLine("Case #" + tt + ": POSSIBLE");
		if (remainder != 0)
			generate(n);
		else {
			generate(n, trace / n);
		}

	}

	private static void printLine(String str) {
		System.out.println(str);
		System.out.flush();
	}

	void generate(int n) {

		int matrix[][] = new int[n][n];
		int start=n;
		for (int i = 0; i < n; i++) {
			
				fill(i, start, matrix);
				start-=2;
		}
		for (int a[] : matrix) {
			StringBuilder sb = new StringBuilder();
			for (int y : a) {
				sb.append(y);
				sb.append(" ");

			}
			sb.setLength(sb.length() - 1);
			printLine(sb.toString());
		}
	}

	void generate(int n, int x) {

		int matrix[][] = new int[n][n];
//		StringBuilder sb = new StringBuilder();
		int start = 0;
		for (int i = 0; i < n; i++) {
			fill(i, x - i - 1, matrix);
		}

		for (int a[] : matrix) {
			StringBuilder sb = new StringBuilder();
			for (int y : a) {
				sb.append(y);
				sb.append(" ");

			}
			sb.setLength(sb.length() - 1);
			printLine(sb.toString());
		}
	}

	void fill(int col, int n, int matrix[][]) {

		for (int i = 0; i < matrix.length; i++) {
			matrix[i][col] = n;
			matrix[i][col] += matrix.length;
			matrix[i][col] %= matrix.length;
			matrix[i][col]++;
			n++;
		}
	}

}
