import java.util.Scanner;

public class Solution {

	Scanner in = new Scanner(System.in);

	void solve() throws Exception {
		int		x	= in.nextInt(), y = in.nextInt();
		char[]	m	= in.next().toCharArray();

		for (int i = 0; i < m.length; ++i) {

			// Pepurr's move
			switch (m[i]) {
				case 'N':
					++y;
					break;
				case 'S':
					--y;
					break;
				case 'E':
					++x;
					break;
				case 'W':
					--x;
					break;
			}

			// Can reach this position in i steps
			if (Math.abs(x) + Math.abs(y) <= i + 1) {
				System.out.println(i + 1);
				return;
			}
		}

		System.out.println("IMPOSSIBLE");
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
