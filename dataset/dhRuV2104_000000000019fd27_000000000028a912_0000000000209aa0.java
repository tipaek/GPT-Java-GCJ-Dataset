import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

class Cell {
	int r, c;
}

public class Solution {

	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
		for (int i = 1; i <= t; ++i) {
			int n = in.nextInt();
			int k = in.nextInt();

			String ans = isLatinPossible(n, k);

			System.out.println("Case #" + i + ": " + ans);

			if (ans.equals("POSSIBLE")) {
				for (int m = 0; m < n; m++) {
					for (int j = 0; j < n; j++) {
						System.out.print(ansBoard[m][j] + " ");
					}
					System.out.println();
				}

			}

		}

	}

	private static String isLatinPossible(int n, int k) {
		results = new HashSet<>();
		dp = new boolean[n + 1][k + 1];

		for (int i = 0; i <= n; i++) {
			for (int j = 0; j <= k; j++) {
				if (j == 0) {
					dp[i][j] = true;
					continue;
				}
				if (i == 0) {
					dp[i][j] = false;
					continue;
				}

				dp[i][j] = dp[i - 1][j];
				if (i <= j)
					dp[i][j] = dp[i][j] || dp[i][j - i];
			}
		}

		if (!dp[n][k])
			return "IMPOSSIBLE";

		List<Integer> temp = new ArrayList<>();
		findCombinations(n, k, n, temp);

		// System.out.println(results);
		for (List<Integer> list : results) {
			int[][] board = new int[n][n];
			for (int i = 0; i < n; i++)
				board[i][i] = list.get(i);

			boolean isPossible = makeLatinMatrix(board);
			if (isPossible)
				return "POSSIBLE";
		}

		return "IMPOSSIBLE";
	}

	private static boolean makeLatinMatrix(int[][] board) {
		Cell c = new Cell();
		int n = board.length;
		if (!findUnassigned(board, c)) {
			ansBoard = board;
			return true;
		}

		for (int i = 1; i <= n; i++) {
			if (isSafe(board, i, c.r, c.c)) {
				board[c.r][c.c] = i;
				if (makeLatinMatrix(board))
					return true;
				board[c.r][c.c] = 0;
			}
		}

		return false;
	}

	private static boolean isSafe(int[][] board, int num, int r, int c) {
		int n = board.length;

		for (int i = 0; i < n; i++)
			if (i != r && board[i][c] == num)
				return false;

		for (int i = 0; i < n; i++)
			if (i != c && board[r][i] == num)
				return false;

		return true;
	}

	private static boolean findUnassigned(int[][] board, Cell c) {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board.length; j++) {
				if (board[i][j] == 0) {
					c.r = i;
					c.c = j;
					return true;
				}
			}
		}
		return false;
	}

	static Set<List<Integer>> results;
	static int[][] ansBoard;
	static boolean[][] dp;

	private static void findCombinations(int ind, int target, int count, List<Integer> temp) {
		if (count == 0) {
			if (target == 0) {
				List<Integer> list = new ArrayList<>(temp);
				Collections.sort(list);
				results.add(list);
			}
			return;
		}

		if (ind == 0 || target <= 0 || count < 0 || dp[ind][target] == false)
			return;

		if (ind <= target && dp[ind][target - ind]) {
			temp.add(ind);
			findCombinations(ind, target - ind, count - 1, temp);
			temp.remove(temp.size() - 1);
		}

		if (dp[ind - 1][target])
			findCombinations(ind - 1, target, count, temp);

	}

}
