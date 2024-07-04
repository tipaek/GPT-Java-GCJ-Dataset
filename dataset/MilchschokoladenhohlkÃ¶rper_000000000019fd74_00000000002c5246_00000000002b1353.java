import java.util.Scanner;

public class Solution {

	Scanner in = new Scanner(System.in);

	void solve() throws Exception {
		int n = in.nextInt();

		System.out.println("1 1");

		switch (n) {
			case 1:
				return;
			case 2:
				System.out.println("2 2");
				return;
			default:

				// n for arithmetic sum
				int s = (int) Math.floor((-1 + Math.sqrt(1 + 8 * n) / 2));

				// Rest
				int r = n - (s * s + s) / 2;

				// Row and col
				int r1 = 3, r2 = 2;

				// Arithmetic sum
				for (int i = 0; i < s - 1; ++i)
					System.out.printf("%d %d%n", r1++, r2++);

				// Rest
				if (r > 0) {
					--r1;
					for (int i = 0; i < r; ++i)
						System.out.printf("%d %d%n", r1++, r2++);
				}

		}
	}

	void run() throws Exception {
		int t = in.nextInt();
		for (int i = 1; i <= t; ++i) {
			System.out.printf("Case #%d:%n", i);
			solve();
		}
	}

	public static void main(String[] args) throws Exception { new Solution().run(); }
}
