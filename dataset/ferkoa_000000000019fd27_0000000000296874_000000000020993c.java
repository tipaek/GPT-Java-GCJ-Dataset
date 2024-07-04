import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.Scanner;

public class Solution {

	private static String solve(int[][] matrix) {
		int n = matrix.length;
		int k = 0;
		int r = 0;
		int c = 0;
		boolean[][] rows = new boolean[n][n];
		boolean[][] cols = new boolean[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (i == j) {
					k += matrix[i][j];
				}
				int val = matrix[i][j] - 1;
				if (rows[i] != null) {
					if (!rows[i][val]) {
						rows[i][val] = true;
					} else {
						rows[i] = null;
						r++;
					}
				}
				if (cols[j] != null) {
					if (!cols[j][val]) {
						cols[j][val] = true;
					} else {
						cols[j] = null;
						c++;
					}
				}
			}
		}
		return k + " " + r + " " + c;
	}

	//////////////////////////////////////////////////
	public static void main(String[] args) throws Exception {

		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		PrintStream out = System.out;

		int t = in.nextInt();
		in.nextLine();
		for (int i = 1; i <= t; ++i) {
			int n = in.nextInt();
			int[][] matrix = new int[n][n];
			for (int j = 0; j < n; j++) {
				for (int k = 0; k < n; k++) {
					matrix[j][k] = in.nextInt();
				}
			}
			out.println("Case #" + i + ": " + solve(matrix));
		}
		in.close();
	}
}