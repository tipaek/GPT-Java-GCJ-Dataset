import java.util.Arrays;
import java.util.Scanner;

public class Solution {

	Scanner in = new Scanner(System.in);

	void solve() throws Exception {
		int	n		= in.nextInt(), c = 0, j = 0;
		int	a[][]	= new int[n][2];

		for (int i = 0; i < n; ++i) {
			a[i][0]	= in.nextInt();
			a[i][1]	= in.nextInt();
		}

		// Sort by start time
		Arrays.parallelSort(a, (a1, a2) -> Integer.compare(a1[0], a2[0]));

		StringBuilder sb = new StringBuilder(n);

		for (int[] b : a) {
			if (c <= b[0]) {
				c = b[1];
				sb.append('C');
			} else if (j <= b[0]) {
				j = b[1];
				sb.append('J');
			} else {
				System.out.println("IMPOSSIBLE");
				return;
			}
		}

		System.out.println(sb);
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
