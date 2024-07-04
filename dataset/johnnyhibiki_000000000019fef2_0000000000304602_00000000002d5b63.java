import java.util.Scanner;

public class Solution {

	int t, a, b;
	String s = "";

	int px, py, pk, pc;
	boolean c1;

	String fnc() {
		String ans = "";

		if (!c1) {
			if (s.equals("HIT")) {
				c1 = true;
				ans = "" + (px + 1) + " " + py;
			} else {
				if (!s.equals("")) {
					py++;
				}
				ans = "" + px + " " + py;
			}
		} else if (pk == 0) {
			if (s.equals("HIT")) {
				pk = 1;
			} else {
				pk = -1;
			}

			ans = "" + (px + pc * pk) + " " + py;
		} else {
			if (s.equals("HIT")) {
				pc++;
				ans = "" + (px + pc * pk) + " " + py;
			} else {
				int ansX = (px + (pc - 1) * pk) / 2;

				long yy = (long) a * a - (long) ansX * ansX;
				int ansY = py + (int) Math.sqrt(yy);

				ans = ansX + " " + ansY;
			}
		}

		return ans;
	}

	void reset() {
		px = 0;
		py = (int) -Math.pow(10, 9);
		s = "";
		c1 = false;
		pk = 0;
		pc = 1;
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

				s = sc.next();
				if (s.equals("CENTER")) {
					reset();
					t--;

					if (t == 0) {
						break;
					}
				}
			}
		}
	}

	public static void main(String[] args) {
		new Solution().run();
	}
}
