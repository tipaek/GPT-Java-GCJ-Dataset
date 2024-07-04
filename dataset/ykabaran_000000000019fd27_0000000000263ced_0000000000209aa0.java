
import java.util.Scanner;

/**
 * Google CodeJam 2020 Quals
 */
public class Solution {

	private final int size;
	private final int sum;

	public Solution(Scanner scanner) {
		this.size = scanner.nextInt();
		if (this.size > 5) {
			throw new RuntimeException("max size is 5");
		}
		this.sum = scanner.nextInt();
	}

	private String printMatrix(int[][][] matrix) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < this.size; i++) {
			if (i > 0) {
				sb.append("\n");
			}
			for (int j = 0; j < this.size; j++) {
				if (j > 0) {
					sb.append(" ");
				}
				sb.append(Integer.toString(matrix[i][j][0]));
			}
		}
		return sb.toString();
	}

	private int[] markCell(int[][][] matrix, int r, int c, int k) {
		if (matrix[r][c][0] > 0 || matrix[r][c][k] > 0) {
			return null;
		}
		matrix[r][c][0] = k;
		int[] prev = new int[this.size * 2];
		for (int i = 0; i < this.size; i++) {
			prev[i] = matrix[i][c][k];
			prev[this.size + i] = matrix[r][i][k];
		}

		for (int i = 0; i < this.size; i++) {
			matrix[i][c][k] = 1;
			matrix[r][i][k] = 1;
		}
		return prev;
	}

	private void unmarkCell(int[][][] matrix, int r, int c, int k, int[] prev) {
		for (int i = 0; i < this.size; i++) {
			matrix[i][c][k] = prev[i];
			matrix[r][i][k] = prev[this.size + i];
		}
		matrix[r][c][0] = 0;
	}

	private boolean solveMatrix(int[][][] matrix) {
		for (int i = 0; i < this.size; i++) {
			for (int j = 0; j < this.size; j++) {
				if (matrix[i][j][0] > 0) {
					continue;
				}
				for (int k = 1; k <= this.size; k++) {
					if (matrix[i][j][k] != 0) {
						continue;
					}
					int[] prev = this.markCell(matrix, i, j, k);
					if (prev == null) {
						continue;
					}
					if (this.solveMatrix(matrix)) {
						return true;
					}
					this.unmarkCell(matrix, i, j, k, prev);
				}
				return false;
			}
		}

		return true;
	}

	private boolean getNext(int[] comb) {
		for (int i = this.size - 1; i >= 0; i--) {
			if (comb[i] == this.size) {
				comb[i] = 1;
				continue;
			}
			comb[i]++;
			return true;
		}
		return false;
	}

	private int getTotal(int[] comb) {
		int total = 0;
		for (int i = 0; i < this.size; i++) {
			total += comb[i];
		}
		return total;
	}

	private boolean getNextSum(int[] comb) {
		while (this.getNext(comb)) {
			if (this.getTotal(comb) == this.sum) {
				return true;
			}
		}
		return false;
	}

	private int[][][] solveSum(int[] sum) {
		int[][][] matrix = new int[this.size][this.size][this.size + 1];
		for (int i = 0; i < this.size; i++) {
			int value = ((i + sum[0] - 1) % this.size) + 1;
			this.markCell(matrix, 0, i, value);
		}
		for (int i = 1; i < this.size; i++) {
			if (this.markCell(matrix, i, i, sum[i]) == null) {
				return null;
			}
		}
		if (!this.solveMatrix(matrix)) {
			return null;
		}
		return matrix;
	}

	private int[][][] constructMatrix() {
		int[] maxSum = new int[this.size];
		for (int i = 0; i < this.size - 1; i++) {
			maxSum[i] = 1;
		}
		maxSum[this.size - 1] = 0;

		while (this.getNextSum(maxSum)) {
			int[][][] matrix = this.solveSum(maxSum);
			if (matrix == null) {
				continue;
			}
			return matrix;
		};

		return null;
	}

	public String solve() {
		int[][][] matrix = this.constructMatrix();
		if (matrix == null) {
			return "IMPOSSIBLE";
		}
		return "POSSIBLE\n" + this.printMatrix(matrix);
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
