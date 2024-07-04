import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Solution {

	int t;
	Scanner s;
	int n;
	int matrix[][];

	public Solution(int t, Scanner s) {
		super();
		this.t = t;
		this.s = s;
	}

	public void solve() {
		n = s.nextInt();
		matrix = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				matrix[i][j] = s.nextInt();
			}
		}
		int trace = 0;
		for (int i = 0; i < n; i++) {
			trace += matrix[i][i];
		}
		int rowsWithDuplicate = 0;
		int colsWithDuplicate = 0;
		for (int i = 0; i < n; i++) {
			Set<Integer> rowSet = new TreeSet<>();
			Set<Integer> colSet = new TreeSet<>();
			for (int j = 0; j < n; j++) {
				rowSet.add(matrix[i][j]);
				colSet.add(matrix[j][i]);
			}
			if (rowSet.size() != n) {
				rowsWithDuplicate++;
			}
			if (colSet.size() != n) {
				colsWithDuplicate++;
			}

		}

		System.out.println("Case #" + t + ": " + trace + " " + rowsWithDuplicate + " " + colsWithDuplicate);
	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int testCases = s.nextInt();
		for (int i = 0; i < testCases; i++) {
			new Solution(i + 1, s).solve();
		}

		s.close();
	}

}
