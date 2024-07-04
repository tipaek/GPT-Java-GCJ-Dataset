import java.util.Scanner;
public class Solution {
    public static void main(String args[]) {
		final Scanner input = new Scanner(System.in);
		int T = input.nextInt();
		for (int ks = 1; ks <= T; ks++) {
			int N = input.nextInt();
			int K = input.nextInt();
			int[][] board = new int[N][N];
			if (solve(board, K)) {
				System.out.println("Case #" + ks + ": POSSIBLE");
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < N; j++) {
						System.out.print(board[i][j] + " ");
					}
					System.out.println();
				}
			} else {
				System.out.println("Case #" + ks + ": IMPOSSIBLE");
			}
		}
	}

	static boolean solve(int[][] board, int K) {
		int row = -1;
		int col = -1;
		boolean allFull = true;
		int N = board.length;
		int total = 0;
		outer: for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(i==j)
					total += board[i][j];
				if (board[i][j] == 0) {
					row = i;
					col = j;
					allFull = false;
					break outer;
				}
			}
		}
		if (allFull) {
			if (total == K) {
				return true;
			} else {
				return false;
			}
		}
		for (int num = 1; num <= N; num++) {
			if (isSafe(board, row, col, num, K)) {
				board[row][col] = num;
				if (solve(board, K)) {
					return true;
				} else {
					board[row][col] = 0;
				}
			}
		}
		return false;
	}

	public static boolean isSafe(int[][] board, int row, int col, int num, int K) {
		for (int d = 0; d < board.length; d++) {
			if (board[row][d] == num) {
				return false;
			}
		}

		for (int r = 0; r < board.length; r++) {
			if (board[r][col] == num) {
				return false;
			}
		}
		int total = 0;
		for (int i = 0; i < board.length; i++) {
			total += board[i][i];
			if (total > K)
				return false;
		}
		return true;
	}
  
}