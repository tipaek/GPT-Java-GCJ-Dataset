import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		for (int i = 1; i <= t; i++) {
			System.out.print("Case #" + i + ": " + solution(s));
		}
	}

	private static String solution(Scanner s) {
		int n = s.nextInt();
		int k = s.nextInt();

		int[][] matrix = new int[n][n];
		if (dioganal(matrix, n, 0, k)) {
			return "POSSIBLE\n" + printMatrix(matrix);
		} else {
			return "IMPOSSIBLE\n";
		}
	}

	private static String printMatrix(int[][] matrix) {
		StringBuilder b = new StringBuilder();
		for (int i = 0; i < matrix.length; i++) {
			if (i != 0) {
				b.append('\n');
			}
			line(matrix[i], b);
		}
		return b.toString();
	}

	private static void line(int[] line, StringBuilder b) {
		for (int i = 0; i < line.length; i++) {
			if (i != 0) {
				b.append(' ');
			}
			b.append(line[i]);
		}
	}

	static boolean dioganal(final int[][] matrix, final int n, int i, int k) {
		if (n == i) {
			if (k == 0) {
				// fill the matrix
				Set<Integer>[] cols = new HashSet[n];
				Set<Integer>[] rows = new HashSet[n];
				for (int j = 0; j < n; j++) {
					cols[j] = new HashSet<>();
					rows[j] = new HashSet<>();
					cols[j].add(matrix[j][j]);
					rows[j].add(matrix[j][j]);
				}
				for (i = 0; i < n; i++) {
					for (int j = 0; j < n; j++) {
						if (i != j) {
							boolean notFound = true;
							for (int l = 1; l <= n; l++) {
								if (!rows[i].contains(l) && !cols[j].contains(l)) {
									cols[j].add(l);
									rows[i].add(l);
									matrix[i][j] = l;
									notFound = false;
									break;
								}
							}
							if (notFound) {
								return false;
							}
						}
					}
				}
				return true;
			}
			return false;
		}
		int left = n - i;
		if (left * n >= k) {
			int min = Math.max(1, k - (left - 1) * n);
			int max = Math.min(n, k - left + 1);
			for (int j = min; j <= max; j++) {
				matrix[i][i] = j;
				if (dioganal(matrix, n, i + 1, k - j)) {
					return true;
				}
			}
		}
		return false;
	}

}
