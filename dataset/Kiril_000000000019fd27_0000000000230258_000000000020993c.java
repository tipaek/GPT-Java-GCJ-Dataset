import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		for (int i = 1; i <= t; i++) {
			System.out.println("Case #" + i + ": " + solution(s));
		}
	}

	private static String solution(Scanner s) {
		int n = s.nextInt();
		int trace = 0;

		int[][] cols = new int[n][n + 1];
		int rowCount = 0;
		for (int i = 0; i < n; i++) {
			int[] rows = new int[n + 1];
			for (int j = 0; j < n; j++) {
				int cell = s.nextInt();
				if (i == j) {
					trace += cell;
				}
				rows[cell]++;
				cols[j][cell]++;
			}
			for (int j = 1; j <= n; j++) {
				if (rows[j] > 1) {
					rowCount++;
					break;
				}
			}
		}
		int columnCount = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 1; j <= n; j++) {
				if (cols[i][j] > 1) {
					columnCount++;
					break;
				}
			}
		}
		return trace + " " + rowCount + " " + columnCount;
	}
}
