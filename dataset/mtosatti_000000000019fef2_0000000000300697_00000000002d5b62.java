import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
	static int xp = 0, xn = 0, yp = 0, yn = 0, s = Integer.MAX_VALUE;

	public static int getNextPower(int x) {
		int y = 1;
		while (x >= y) {
			y <<= 1;
		}
		return y;
	}

	public static int countBits(int n) {
		int c;
		for (c = 0; n > 0; n >>= 1) {
			c += n & 1;
		}
		return c;
	}

	public static boolean test(int x, int xd, int y, int yd) {
		if (((x | xd) & (y | yd)) > 0)
			return false;
		int lxp = countBits(x);
		int lyp = countBits(y);
		int lxn = countBits(xd);
		int lyn = countBits(yd);
		if (lxp + lxn + lyp + lyn < s) {
			s = lxp + lxn + lyp + lyn;
			xp = lxp;
			yp = lyp;
			xn = lxn;
			yn = lyn;
		}
		return true;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int T = in.nextInt();
		for (int t = 1; t <= T; ++t) {
			int X = in.nextInt();
			int Y = in.nextInt();
			int x = X >= 0 ? X : X * -1;
			int y = Y >= 0 ? Y : Y * -1;

			xp = 0;
			xn = 0;
			yp = 0;
			yn = 0;
			s = Integer.MAX_VALUE;

			int npx = getNextPower(x);
			int npy = getNextPower(y);

			boolean f = false;
			if (test(x, 0, y, 0))
				f = true;
			if (test(x, 0, npy, npy - y))
				f = true;
			if (test(npx, npx - x, y, 0))
				f = true;
			if (test(npx, npx - x, npy, npy - y))
				f = true;

			System.out.print("Case #" + t + ": ");
			if (!f) {
				System.out.println("IMPOSSIBLE");
			} else {
				for (int i = 0; i < xp; i++) {
					System.out.print(X >= 0 ? 'E' : 'W');
				}
				for (int i = 0; i < xn; i++) {
					System.out.print(X >= 0 ? 'W' : 'E');
				}
				for (int i = 0; i < yp; i++) {
					System.out.print(Y >= 0 ? 'N' : 'S');
				}
				for (int i = 0; i < yn; i++) {
					System.out.print(Y >= 0 ? 'S' : 'N');
				}
				System.out.println();
			}

		}
	}

}
