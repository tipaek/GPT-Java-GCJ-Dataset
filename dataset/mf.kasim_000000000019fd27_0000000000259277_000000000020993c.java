import java.util.Arrays;
import java.util.Scanner;

public class CodeJamProblem1 {

	public static void main(String[] args) {

		try (Scanner s = new Scanner(System.in)) {

			int T = s.nextInt();
			for (int i = 1; i <= T; i++) {
				int N = s.nextInt();

				int[][] M = new int[N][N];

				for (int j = 0; j < M.length; j++) {
					for (int k = 0; k < M[j].length; k++) {
						M[j][k] = s.nextInt();
						
					}

				}
				String result = solve(N, M);
				System.out.println("Case #" + i + ": " + result);
			}
		}
	}

	public static String solve(int N, int[][] M) {
		String result;

		int trace = 0;
		for (int i = 0; i < M.length; i++) {
			trace += M[i][i];

		}

		result = String.valueOf(trace);

		int[][] MTranspose = new int[N][N];
		for (int i = 0; i < M.length; i++) {
			for (int j = 0; j < M[i].length; j++)
				MTranspose[j][i] = M[i][j];

		}

		int repeatedRows = 0;

		for (int i = 0; i < M.length; i++) {
			int[] mi = M[i];
			Arrays.sort(mi);
			for (int k = 0; k < mi.length - 1; k++) {

				if (mi[k] == mi[k + 1]) {
					repeatedRows++;
					break;
				}

			}
		}
		result += " " + repeatedRows;

		int repeatedCols = 0;

		for (int i = 0; i < MTranspose.length; i++) {
			int[] mi = MTranspose[i];
			Arrays.sort(mi);
			for (int k = 0; k < mi.length - 1; k++) {

				if (mi[k] == mi[k + 1]) {
					repeatedCols++;
					break;
				}

			}
		}
		result += " " + repeatedCols;
		return result;
	}
}
