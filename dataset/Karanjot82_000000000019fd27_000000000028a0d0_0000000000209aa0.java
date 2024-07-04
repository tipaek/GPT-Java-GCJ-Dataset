import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
	public static boolean isSafe(int[][] board, int row, int col, int num) {
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

		int sqrt = (int) Math.sqrt(board.length);
		if(board.length==5)
			sqrt--;
		int rStart = row - row % sqrt;
		int cStart = col - col % sqrt;

		for (int r = rStart; r < rStart + sqrt; r++) {
			for (int d = cStart; d < cStart + sqrt; d++) {
				if (board[r][d] == num) {
					return false;
				}
			}
		}

		return true;
	}

	public static boolean solve(int[][] board, int n) {
		int row = -1;
		int col = -1;
		boolean isEmpty = true;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (board[i][j] == 0) {
					row = i;
					col = j;

					isEmpty = false;
					break;
				}
			}
			if (!isEmpty) {
				break;
			}
		}

		if (isEmpty) {
			return true;
		}

		for (int num = 1; num <= n; num++) {
			if (isSafe(board, row, col, num)) {
				board[row][col] = num;
				if (solve(board, n)) {
					return true;
				} else {
					board[row][col] = 0;
				}
			}
		}
		return false;
	}

	public static void print(int[][] board, int N) {
		// we got the answer, just print it
		for (int r = 0; r < N; r++) {
			for (int d = 0; d < N; d++) {
				System.out.print(board[r][d]);
				System.out.print(" ");
			}
			System.out.print("\n");

			if ((r + 1) % (int) Math.sqrt(N) == 0) {
				System.out.print("");
			}
		}
	}

	public static void main(String args[]) {

		Scanner in = new Scanner(System.in);
		int test = in.nextInt();
		for (int t = 1; t <= test; t++) {
			int N = in.nextInt();
			int sum = in.nextInt();

			List<String> data = findNDigitNums(N, sum, N);
			boolean isFound = false;
			System.out.print("Case #" + t + ": ");
			
			for (String s : data) {
				int[][] board = new int[N][N];
				for (int i = 0; i < s.trim().length(); i++) {
					board[i][i] = (int) (s.charAt(i) - '0');
				}
				if (solve(board, N)) {
					System.out.println("POSSIBLE");
					print(board, N);
					isFound = true;
					break;
				}
			}
			if (!isFound)
				System.out.println("IMPOSSIBLE");

		}
	}

	public static void findNDigitNumsUtil(int n, int sum, char out[], int index, int k, ArrayList<String> list) {
		if (index > n || sum < 0)
			return;
		if (index == n) {
			if (sum == 0) {
				list.add(new String(out));
			}
			return;
		}

		for (int i = 1; i <= k; i++) {

			out[index] = (char) (i + '0');

			findNDigitNumsUtil(n, sum - i, out, index + 1, k, list);
		}
	}

	static ArrayList<String> findNDigitNums(int n, int sum, int k) {

		char[] out = new char[n + 1];
		ArrayList<String> list = new ArrayList<>();
		for (int i = 1; i <= k; i++) {
			out[0] = (char) (i + '0');
			findNDigitNumsUtil(n, sum - i, out, 1, k, list);
		}
		return list;
	}

}
