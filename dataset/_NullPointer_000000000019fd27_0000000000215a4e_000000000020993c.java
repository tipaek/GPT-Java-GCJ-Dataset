import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;



class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt();
// printLine(""+1);
		for (int tt = 1; tt <= t; tt++) {
			Solution bundling = new Solution();
			bundling.solve(in, tt);
		}

		in.close();
	}

	private void solve(Scanner in, int tt) {
		int n = in.nextInt();
		int ans = 0;
//		int matrix[][] = new int[n][n];
		boolean cols[][] = new boolean[n][n];
		boolean rows[][] = new boolean[n][n];
		int dupRows[] = new int[n];
		int dupCols[] = new int[n];
		int trace = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				int element = in.nextInt();
				if (cols[j][element - 1]) {
					dupCols[j] = 1;
				}
				cols[j][element - 1] = true;

				if (rows[i][element - 1]) {
					dupRows[i] = 1;
				}
				rows[i][element - 1] = true;
				if (i == j) {
					trace += element;
				}

			}
		}
		int col = 0;
		int row = 0;
		for (int i = 0; i < dupRows.length; i++) {
			col += dupCols[i];
			row += dupRows[i];
		}
		printLine("Case #" + tt + ": " + trace + " " + row + " " + col);

	}

	private static void printLine(String str) {
		System.out.println(str);
		System.out.flush();
	}

}
