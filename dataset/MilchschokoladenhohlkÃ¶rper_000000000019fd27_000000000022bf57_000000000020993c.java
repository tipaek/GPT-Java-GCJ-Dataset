import java.util.Scanner;

public class Solution {

	Scanner in = new Scanner(System.in);

	void solve() throws Exception {
		int	n		= in.nextInt(), t = 0, r = 0, c = 0;
		int	a[][]	= new int[n][n];

		for (int i = 0; i < n; ++i)
			for (int j = 0; j < n; ++j)
				a[i][j] = in.nextInt();

		// Trace
		for (int i = 0; i < n; ++i)
			t += a[i][i];

		// Rows
		for (int i = 0; i < n; ++i)
			row:
			{
				for (int j = 1; j < n; ++j)
					for (int k = 0; k < j; ++k)
						if (a[i][k] == a[i][j]) {
							++r;
							break row;
						}
			}

		// Cols
		for (int i = 0; i < n; ++i)
			col:
			{
				for (int j = 1; j < n; ++j)
					for (int k = 0; k < j; ++k)
						if (a[k][i] == a[j][i]) {
							++c;
							break col;
						}
			}

		System.out.printf("%d %d %d%n", t, r, c);
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
