
import java.util.Scanner;

/**
 * Google CodeJam 2020 Quals
 */
public class Solution {

	private final int size;
	private final int[][] matrix;

	public Solution(Scanner scanner) {
		this.size = scanner.nextInt();
		this.matrix = new int[this.size][this.size];
		for (int i = 0; i < this.size; i++) {
			for (int j = 0; j < this.size; j++) {
				this.matrix[i][j] = scanner.nextInt();
			}
		}
	}

	private int getTrace() {
		int sum = 0;
		for (int i = 0; i < this.size; i++) {
			sum += this.matrix[i][i];
		}
		return sum;
	}

	private boolean checkRow(int r) {
		int[] counts = new int[this.size];
		for (int i = 0; i < this.size; i++) {
			int val = this.matrix[r][i] - 1;
			counts[val]++;
			if (counts[val] > 1) {
				return false;
			}
		}
		return true;
	}

	private boolean checkColumn(int c) {
		int[] counts = new int[this.size];
		for (int i = 0; i < this.size; i++) {
			int val = this.matrix[i][c] - 1;
			counts[val]++;
			if (counts[val] > 1) {
				return false;
			}
		}
		return true;
	}

	public String solve() {
		int trace = this.getTrace();
		int numRows = 0;
		int numCols = 0;
		for (int i = 0; i < this.size; i++) {
			if (!this.checkRow(i)) {
				numRows++;
			}
			if (!this.checkColumn(i)) {
				numCols++;
			}
		}

		return trace + " " + numRows + " " + numCols;
	}

	public static void main(String args[]) {
		try (Scanner scanner = new Scanner(System.in);) {
			int T = scanner.nextInt();
			for (int i = 1; i <= T; i++) {
				String solution = new Solution(scanner).solve();
				System.out.println("Case #" + i + ": " + solution);
			}
		}
		System.exit(0);
	}

}
