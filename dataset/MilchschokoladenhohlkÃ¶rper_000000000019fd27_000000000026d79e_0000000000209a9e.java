import java.util.Scanner;

public class Solution {

	Scanner in = new Scanner(System.in);

	int read() {
		String s = in.next();
		switch (s) {
			case "0":
			case "1":
				return Integer.valueOf(s);
			default:
				System.exit(-1);
				return 0;
		}
	}

	void solve(int b) throws Exception {
		int a[] = new int[b];

		for (int i = 0; i < b; ++i) {
			System.out.println(i + 1);
			a[i] = read();
		}
		for (int n : a)
			System.out.print(n);
		System.out.println();

		// Read 'Y'
		in.next();
	}

	void run() throws Exception {
		int t = in.nextInt(), b = in.nextInt();
		for (int i = 1; i <= t; ++i)
			solve(b);
	}

	public static void main(String[] args) throws Exception { new Solution().run(); }
}
