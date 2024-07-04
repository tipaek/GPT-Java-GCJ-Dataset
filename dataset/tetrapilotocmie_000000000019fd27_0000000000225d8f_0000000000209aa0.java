import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

/* **************************** */

public class Solution {

	void solve() {
		int N = scanner.nextInt();
		int K = scanner.nextInt();

		if (K % N == 0) {
			out(N, -1, -1, 0, K / N);
			return;
		}

		for (int x = 2; x <= N; x++) {
			for (int y = 2; y <= N; y++) {
				for (int z = 0; z <= N / 2; z++) {
					for (int r = 1; r <= N; r++) {
						if (x == y || x == r || y == r) continue;
						int posibil = N + (x + y - 2) * z + (N - z * 2) * (r - 1);
						if (K == posibil) {
							out(N, x, y, z, r);
							return;
						}
					}
				}
			}
		}
		System.out.println("IMPOSSIBLE");
	}

	private void out(int N, int x, int y, int z, int r) {
		System.out.println("POSSIBLE");

		int[] numbers = new int[N];
		for (int i = 0; i < N; i++) {
			int number = i + 1;
			if (number == r) {
				number = 1;
			} else if (number == 1) {
				number = r;
			}

			numbers[i] = number;
		}
		if (x >= 0) {
			numbers[x - 1] = numbers[1];
			numbers[1] = x;
			numbers[y - 1] = numbers[N - 1];
			numbers[N - 1] = y;
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (j > 0) System.out.print(" ");

				int shifting = 0;
				if (z > 0) {
					if (j / 2 < z) {
						if (j % 2 == 0) {
							shifting = 1;
						} else {
							shifting = -1;
						}
					}
				}

				int pos = (j - i + shifting + N) % N;


				System.out.print(numbers[pos]);
			}
			System.out.println();
		}
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