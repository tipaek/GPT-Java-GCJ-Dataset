import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Solution {

	private static int[][] cand;
	private static int n, k;

	public static void main(String[] args) {
		Locale.setDefault(Locale.ENGLISH);
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		solve(in, System.out);
		in.close();
	}

	protected static void solve(Scanner in, PrintStream out) {
		int t = in.nextInt();
		for (int i = 1; i <= t; ++i) {
			n = in.nextInt();
			k = in.nextInt();
			String ret = solveLine();
			out.printf(Locale.ENGLISH, "Case #%d: %s%n", i, ret);
		}
	}

	private static String solveLine() {
		cand = new int[n][n];
		if (k > n * n) return "IMPOSSIBLE";
		boolean found = false;
		ArrayList<int[]> comb = getDiagonals();
		ArrayList<int[]> perm = getPermutations();
		for (int[] ar : comb) {
			if (eval(ar,perm)) {
				found = true;
				break;
			}
		}
		if (!found) return "IMPOSSIBLE";
		StringBuilder ans = new StringBuilder();
		ans.append("POSSIBLE\n");
		for (int row = 0; row < n; row++) {
			for (int col = 0; col < n; col++) {
				ans.append(cand[row][col]).append(col == n - 1 ? "" : " ");
			}
			if (row != n - 1) ans.append("\n");
		}
		return ans.toString();
	}

	private static boolean eval(int[] diag, List<int[]>perm) {
		cand = new int[n][n];
		for (int i = 0; i < n; i++) cand[i][i] = diag[i];
		return rece(0, 0, diag, new boolean[n+1][n], perm);
	}

	static boolean rece(int row, int mask, int[] diag, boolean[][] cols, List<int[]>perm) {
		if (row == n) {
			return true;
		}
		for (int[] pr : perm) {
			if (pr[row] != diag[row]) continue;
			boolean [][] col2 = clone(cols);
			boolean valid = true;
			for (int col = 0; col < n && valid; col++) {
				if (cols[pr[col]][col]) valid = false;
				col2[pr[col]][col] = true;
			}
			if (valid && rece(row + 1, mask, diag, col2, perm)) {
				for (int i = 0; i < n; i++) cand[row][i] = pr[i];
				return true;
			}
		}
		return false;
	}

	private static boolean[][] clone(boolean[][] cols) {
		boolean[][] ans = new boolean[cols.length][cols.length];
		for (int i = 0; i < n; i++) for (int j =  0; j < n; j++) ans[i][j] = cols[i][j];
		return ans;
	}

	protected static ArrayList<int[]> getDiagonals() {
		ArrayList<int[]> ret = new ArrayList<int[]>();
		diagHelper(0, 0, new int[n], ret);
		return ret;
	}

	static void diagHelper(int sum, int pos, int[] result, ArrayList<int[]> comb) {
		if (pos == n) {
			if (sum == k) comb.add((result.clone()));
			return;
		}
		for (int i = 1; i <= n; i++) {
			if (sum + i > k) break; // sum + i + n - pos
			result[pos] = i;
			diagHelper(sum + i, pos + 1, result, comb);
		}
	}

	protected static ArrayList<int[]> getPermutations() {
		ArrayList<int[]> perm = new ArrayList<int[]>();
		int[] arr = new int[n];
		for (int i= 0; i < n; i++) arr[i] = i+1;
		permuteHelper(perm, arr, 0);
		return perm;
	}

	private static void permuteHelper(ArrayList<int[]> perm, int[] arr, int index) {
		if (index >= arr.length - 1) {
			perm.add(arr.clone());
			return;
		}
		for (int i = index; i < arr.length; i++) {
			int t = arr[index];
			arr[index] = arr[i];
			arr[i] = t;
			permuteHelper(perm, arr, index + 1);
			arr[i] = arr[index];
			arr[index] = t;
		}
	}
	
}
