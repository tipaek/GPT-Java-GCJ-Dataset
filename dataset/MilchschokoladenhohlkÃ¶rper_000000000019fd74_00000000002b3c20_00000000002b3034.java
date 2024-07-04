import java.util.Arrays;
import java.util.Scanner;

public class Solution {

	Scanner in = new Scanner(System.in);

	void solve() throws Exception {
		int			n	= in.nextInt();
		String[]	a	= new String[n];

		for (int i = 0; i < n; ++i)
			a[i] = in.next();

		// Longest string
		String max = Arrays.stream(a).max((s1, s2) -> Integer.compare(s1.length(), s2.length())).get().substring(1);

		// Compare endings
		for (String s : a)
			if (!max.endsWith(s.substring(1))) {
				System.out.println("*");
				return;
			}

		System.out.println(max);
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
