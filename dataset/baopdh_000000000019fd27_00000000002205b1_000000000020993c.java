import java.util.*;

public class Solution {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int t = scanner.nextInt();
		for (int i = 1; i <= t; ++i) {
			int n = scanner.nextInt();
			boolean[][] rowSet = new boolean[n][n];
			boolean[][] colSet = new boolean[n][n];
			
			int trace = 0;
			for (int j = 0; j < n; ++j)
				for (int k = 0; k < n; ++k) {
					int a = scanner.nextInt();
					rowSet[j][a - 1] = true;
					colSet[k][a - 1] = true;
					if (j == k)
						trace += a;
				}

			int rowRepeated = 0, colRepeated = 0;
			boolean[] row = new boolean[n];
			boolean[] col = new boolean[n];
			for (int j = 0; j < n; ++j)
				for (int k = 0; k < n; ++k) {
					if (!rowSet[j][k]) {
						row[j] = true;
					}
					if (!colSet[j][k]) {
						col[j] = true;
					}
				}
			for (int j = 0; j < n; ++j) {
				if (row[j])
					++rowRepeated;
				if (col[j])
					++colRepeated;
			}
			System.out.printf("Case #%d: %d %d %d\n", i, trace, rowRepeated, colRepeated);
		}
		scanner.close();
	}
}