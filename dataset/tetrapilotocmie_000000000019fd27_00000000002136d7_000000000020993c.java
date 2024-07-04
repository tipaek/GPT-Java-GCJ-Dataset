import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/* **************************** */

public class Solution {

	void solve() {
		int N = scanner.nextInt();

		int trace = 0;
		int[][] rowOccurence = new int[N][N];
		int[][] colOccurence = new int[N][N];
		Set<Integer> faultyRows = new HashSet<>();
		Set<Integer> faultyCols = new HashSet<>();
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				int number = scanner.nextInt();

				if (r == c) {
					trace += number;
				}
				rowOccurence[r][number-1]++;
				colOccurence[c][number-1]++;

				if (rowOccurence[r][number-1] > 1)
					faultyRows.add(r);
				if (colOccurence[c][number-1] > 1)
					faultyCols.add(c);
			}
		}

		System.out.print(trace + " " + faultyRows.size() + " " + faultyCols.size());
		System.out.println();
	}

	private static Scanner scanner;
	public static void main(String[] args) {
		scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int testCases = scanner.nextInt();
		scanner.nextLine();
		for (int i = 1; i <= testCases; i++) {
			System.out.print("Case #" + i + ": ");
			new Solution().solve();
		}
	}
}