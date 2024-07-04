import java.util.Scanner;

public class Solution {

	int t, a, b;
	String s = "";

	int px, py, pk, pc, xx, yy, ii, jj;
	boolean c1, c2;

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
		} else if (!c2){
			if (s.equals("HIT")) {
				pc++;
				ans = "" + (px + pc * pk) + " " + py;
			} else {
				xx = (px + (pc - 1) * pk) / 2;

				long tmpY = (long) a * a - (long) xx * xx;
				yy = py + (int) Math.sqrt(tmpY);

				c2 = true;
				
				ans = xx + " " + yy;
			}
		} else {
			ii++;
			if (ii == 6) {
				ii = -5;
				jj++;
			}
			
			ans = (xx + ii) + " " + (yy + jj);
		}

		return ans;
	}

	void reset() {
		px = 0;
		py = (int) -Math.pow(10, 9);
		s = "";
		c1 = false;
		c2 = false;
		pk = 0;
		pc = 1;
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
