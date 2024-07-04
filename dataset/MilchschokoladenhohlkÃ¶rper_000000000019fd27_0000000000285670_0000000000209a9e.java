import java.util.Scanner;

public class Solution {

	Scanner in = new Scanner(System.in);

	void reverse(int[] a) {
		for (int i = 0; i < a.length / 2; ++i) {
			int tmp = a[i];
			a[i]				= a[a.length - i - 1];
			a[a.length - i - 1]	= tmp;
		}
	}

	void flip(int[] a) {
		for (int i = 0; i < a.length; ++i)
			a[i] = 1 - a[i];
	}

	int ask(int i) {
		System.out.println(i + 1);
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

	void answer(int[] a) {
		for (int n : a)
			System.out.print(n);
		System.out.println();

		if (in.next().equals("N")) System.exit(-1);
	}

	void solve(int b) throws Exception {
		int	a[]	= new int[b];
		int	n	= 1;

		for (int i = 0; i < b / 2; ++i) {

			// Check for quantum flip
			if (n > 1 && n % 10 == 1) {
				int x[] = new int[2], y[] = new int[2];
				x[0]	= ask(0);
				x[1]	= ask(1);
				y[0]	= ask(b - 1);
				y[1]	= ask(b - 2);

				n += 4;

				// Flip
				if (x[0] == 1 - a[0] && x[1] == 1 - a[1] && y[0] == 1 - a[b - 1] && y[1] == 1 - a[b - 2]) flip(a);
				// Reverse
				else if (x[0] == a[b - 1] && x[1] == a[b - 2] && y[0] == a[0] && y[1] == a[1]) reverse(a);
				// Flip & Reverse
				else if (x[0] == 1 - a[b - 1] && x[1] == 1 - a[b - 2] && y[0] == 1 - a[0] && y[1] == 1 - a[1]) {
					flip(a);
					reverse(a);
				}
			}

			// Read from front and back
			a[i]			= ask(i);
			a[b - i - 1]	= ask(b - i - 1);

			n += 2;
		}
		answer(a);
	}

	void run() throws Exception {
		int t = in.nextInt(), b = in.nextInt();
		for (int i = 1; i <= t; ++i)
			solve(b);
	}

	public static void main(String[] args) throws Exception { new Solution().run(); }
}
