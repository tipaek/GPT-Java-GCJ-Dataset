import java.util.Scanner;

public class Solution {

	Scanner in = new Scanner(System.in);

	void solve() throws Exception {
		int n = in.nextInt(), k = in.nextInt();

		// Check if the trace is possible
		if (k % n != 0) {
			System.out.println("IMPOSSIBLE");
			return;
		}

		System.out.println("POSSIBLE");

		// Value of every trace element
		int t = k / n;

		// Output matrix
		for (int i = 0; i < n; ++i) {

			// Shift / Position of 1
			int s = (i - t + 1) % n;
			if (s < 0) s = n + s;

			// Numbers until 1
			for (int j = 0; j < s; ++j) {
				System.out.print(n - s + 1 + j);
				System.out.print(' ');
			}

			// Numbers after 1
			for (int j = s; j < n; ++j) {
				System.out.print(1 + j - s);
				if (j < n - 1) System.out.print(' ');
			}

			System.out.println();
		}
	}

	void run() throws Exception {
		int t = in.nextInt();
		for (int i = 1; i <= t; ++i) {
			System.out.printf("Case #%d: ", i);
			solve();
		}
	}

	public static void main(String[] args) throws Exception { new Solution().run(); }
}
