import java.util.Scanner;

public class Solution {

	Scanner in = new Scanner(System.in);

	void solve() throws Exception {
		String s = in.next();
		int		a[]	= new int[s.length()];
		int		d	= 0;

		for (int i = 0; i < a.length; ++i)
			a[i] = Integer.valueOf(s.substring(i, i + 1));

		StringBuilder sb = new StringBuilder();

		for (int n : a) {

			// Add opening
			if (n > d) for (int i = 0; i < n - d; ++i)
				sb.append('(');
			// Add closing
			else if (d > n) for (int i = 0; i < d - n; ++i)
				sb.append(')');
			d = n;
			sb.append(d);
		}

		// Last closing
		for (int i = 0; i < d; ++i)
			sb.append(')');

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
