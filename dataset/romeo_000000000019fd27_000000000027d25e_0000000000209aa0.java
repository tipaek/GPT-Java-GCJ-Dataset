import java.io.BufferedReader;
import java.io.InputStreamReader;

class Solution {
	public static boolean isSafe(int[][] matrix, int row, int col, int N, int num) {
		boolean isPresentInRow = false;
		for (int i = 0; i < N; i++) {
			if (matrix[row][i] == num) {
				isPresentInRow = true;
				break;
			}
		}
		boolean isPresentInCol = false;
		for (int i = 0; i < N; i++) {
			if (matrix[i][col] == num) {
				isPresentInCol = true;
				break;
			}
		}
		return isPresentInRow || isPresentInCol;
	}

	public static int getTrace(int[][] matrix, int N) {
		int trace = 0;
		for (int i = 0; i < N; i++)
			trace += matrix[i][i];
		return trace;
	}

	public static boolean compute(int[][] matrix, int N, int K) {
		boolean isEmpty = true;
		int row = -1;
		int col = -1;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (matrix[i][j] == 0) {
					row = i;
					col = j;
					isEmpty = false;
					break;
				}
			}
			if (!isEmpty)
				break;
		}

		if (isEmpty) {
			if (getTrace(matrix, N) == K)
				return true;
			return false;
		}

		for (int num = 1; num <= N; num++) {
			if (!isSafe(matrix, row, col, N, num)) {
				matrix[row][col] = num;
				if (compute(matrix, N, K))
					return true;
				else
					matrix[row][col] = 0;
			}
		}
		return false;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test = Integer.parseInt(br.readLine());
		for (int t = 1; t <= test; t++) {
			String[] str = br.readLine().split(" ");
			int N = Integer.parseInt(str[0]);
			int K = Integer.parseInt(str[1]);

			int[][] matrix = new int[N][N];
			boolean isPossible = compute(matrix, N, K);

			String result = isPossible ? "POSSIBLE" : "IMPOSSIBLE";
			System.out.println("Case #" + t + ": " + result);

			if (isPossible) {
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < N; j++) {
						System.out.print(matrix[i][j] + " ");
					}
					System.out.println();
				}
			}
		}
	}

}
