import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		long t = in.nextLong();

		for (long i = 0; i < t; ++i) {
			long a = in.nextLong();
			long b = in.nextLong();

			long x = Math.abs(a);
			long y = Math.abs(b);

			if ((x % 2) == (y % 2)) {
				System.out.println("Case #" + (i + 1) + ": IMPOSSIBLE");
				continue;
			}

			String ans = "";

			while (x != 0 || y != 0) {
				if (x == 0 && y == 1) {
					ans += "N";
				} else if (y == 0 && x == 1) {
					ans += "E";
				} else {
					if ((x & 2) != (y & 2)) {
						if (x % 2 == 1) {
							ans += "E";
						} else {
							ans += "N";
						}
					} else {
						if (x % 2 == 1) {
							ans += "W";
							x += 1;
						} else {
							ans += "S";
							y += 1;
						}
					}
				}

				x >>= 1;
				y >>= 1;
			}

			String def = "";

			for (char c : ans.toCharArray()) {
				switch (c) {
				case 'E':
					def += (a < 0 ? 'W' : 'E');
					break;
				case 'W':
					def += (a < 0 ? 'E' : 'W');
					break;
				case 'N':
					def += (b < 0 ? 'S' : 'N');
					break;
				case 'S':
					def += (b < 0 ? 'N' : 'S');
				}
			}

			System.out.println("Case #" + (i + 1) + ": " + def);
		}
	}
}