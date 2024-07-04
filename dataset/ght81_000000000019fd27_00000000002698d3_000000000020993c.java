import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Solution {

	public static void main(String[] args) {
		try (Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
				PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)))) {
			for (int testCases = in.nextInt(), testCase = 1; testCase <= testCases; testCase++) {
				final int n = in.nextInt();
				int[][] a = new int[n][n];
				for (int i = 0; i < n; i++) {
					for (int j = 0; j < n; j++) {
						a[i][j] = in.nextInt();
					}
				}
				int[] ans = solve(a);
				out.println("Case #" + testCase + ": " + ans[0] + " " + ans[1] + " " + ans[2]);
			}
		}
	}

	private static int[] solve(int[][] a) {
		int k = 0, r = 0, c = 0;
		final int n = a.length;
		List<Set<Integer>> row = new ArrayList<>(n);
		for (int i = 0; i < n; i++) {
			row.add(new HashSet<>());
		}
		List<Set<Integer>> col = new ArrayList<>(n);
		for (int i = 0; i < n; i++) {
			col.add(new HashSet<>());
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (i == j) {
					k += a[i][j];
				}
				row.get(i).add(a[i][j]);
				col.get(j).add(a[i][j]);
			}
		}
		for (Set<Integer> s : row) {
			if (s.size() < n) {
				r++;
			}
		}
		for (Set<Integer> s : col) {
			if (s.size() < n) {
				c++;
			}
		}
		return new int[] { k, r, c };
	}

}
