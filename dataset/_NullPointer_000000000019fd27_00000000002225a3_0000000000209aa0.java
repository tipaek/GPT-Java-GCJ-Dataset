
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
//		generate(9);
	}

	private void solve(Scanner in, int tt) {
		int n = in.nextInt();
		int trace = in.nextInt();
		int remainder = trace % n;

		if (remainder != 0) {
			printLine("Case #" + tt + ": IMPOSSIBLE");
			return;
		}

		printLine("Case #" + tt + ": POSSIBLE");
	
			generate(n, trace / n);

	}

	private static void printLine(String str) {
		System.out.println(str);
		System.out.flush();
	}

	static void generate(int n) {

		int matrix[][] = new int[n][n];
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
//				
				if (i == 0 && j == 0)
					matrix[i][j] = 1;
				else if (i == 0) {
					matrix[i][j] = matrix[i][j - 1] + 1;
				} else {
					matrix[i][j] = matrix[i - 1][j] + 1;
				}
				matrix[i][j] = matrix[i][j] % (n + 1);

				if (matrix[i][j] == 0)
					matrix[i][j] = 1;
				sb.append(matrix[i][j]);
				sb.append(" ");

			}
			sb.setLength(sb.length() - 1);

			printLine(sb.toString());
			sb.setLength(0);
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
