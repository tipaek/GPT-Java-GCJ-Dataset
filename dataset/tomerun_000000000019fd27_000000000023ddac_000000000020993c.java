import java.util.Arrays;
import java.util.Scanner;

public final class Main {
	private static final Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		int T = sc.nextInt();
		for (int i = 1; i <= T; i++) {
			System.out.print("Case #" + i + ": ");
			solve();
		}
	}

	static void solve() {
		int N = sc.nextInt();
		int[][] M = new int[N][N];
		int sum = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				M[i][j] = sc.nextInt();
			}
			sum += M[i][i];
		}
		int row = 0;
		int col = 0;
		boolean[] has = new boolean[N + 1];
		for (int i = 0; i < N; i++) {
			Arrays.fill(has, false);
			for (int j = 0; j < N; j++) {
				if (has[M[i][j]]) {
					row++;
					break;
				}
				has[M[i][j]] = true;
			}
			Arrays.fill(has, false);
			for (int j = 0; j < N; j++) {
				if (has[M[j][i]]) {
					col++;
					break;
				}
				has[M[j][i]] = true;
			}
		}
		System.out.println(sum + " " + row + " " + col);
	}
}
