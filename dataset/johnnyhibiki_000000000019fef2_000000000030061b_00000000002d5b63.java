import java.util.Scanner;

public class Solution {

	int t, a, b;

	int ii, jj;

	String fnc() {
		String ans = ii + " " + jj;

		ii++;
		if (ii == 6) {
			ii = -5;
			jj++;
		}

		return ans;
	}

	void reset() {
		ii = -5;
		jj = -5;
	}

	void run() {
		try (Scanner sc = new Scanner(System.in)) {
			t = sc.nextInt();
			a = sc.nextInt();
			b = sc.nextInt();
			reset();

			while (true) {
				System.out.println(fnc());
				System.out.flush();

				String s = sc.next();
				if (s.equals("CENTER")) {
					reset();
				}
			}
		}
	}

	public static void main(String[] args) {
		new Solution().run();
	}
}
