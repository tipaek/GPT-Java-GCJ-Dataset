import java.util.*;

public class Solution {

	private static String solve(int X, int Y) {
		int t = Math.abs(X) + Math.abs(Y);
		int lo = -1, mask = 1;
		StringBuffer sb = new StringBuffer();

		for (int i = 0; i < 32; i++) {
			if ((t & (mask << i)) != 0) {
				lo = i;
			}
		}

		//System.err.println("lo: " + lo);

		while (lo >= 0 && Math.abs(X) != Math.abs(Y) && (X != 0 || Y != 0)) {
			//System.err.println("lo: " + lo + " -> " + X + "," + Y);

			int vr = ((int)1) << lo--;
			if (Math.abs(X) > Math.abs(Y)) {
				if (X > 0) {
					X -= vr;
					sb.insert(0, "E");
				} else {
					X += vr;
					sb.insert(0, "W");
				}
			} else {
				if (Y > 0) {
					Y -= vr;
					sb.insert(0, "N");
				} else {
					Y += vr;
					sb.insert(0, "S");
				}
			}
		}

		if ((X != 0 && Y != 0) || lo >= 0) {
			return "IMPOSSIBLE";
		}

		return sb.toString();
	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);

		int T = s.nextInt();
		for(int i = 1; i <= T; i++) {
			int X = s.nextInt();
			int Y = s.nextInt();

			System.out.println("Case #" + i + ": " + solve(X, Y));
		}

		s.close();
	}
}