import java.util.*;

public class Solution {

	static class Pair {
		String ans;
		int len;
	}

	static int max = Integer.MIN_VALUE;

	public static String expogo(int x, int y) {
		if (x == 0 && y == 0)
			return "";
		if (x % 2 == 1 && y % 2 == 1)
			return "IMPOSSIBLE";
		if (x % 2 == 0 && y % 2 == 0)
			return "IMPOSSIBLE";
		if (x == 0) {
			switch (y) {
			case -3:
				return "SS";
			case -1:
				return "S";
			case 1:
				return "N";
			case 3:
				return "NN";
			}
		}
		if (x == 2) {
			switch (y) {
			case -3:
				return "NES";
			case -1:
				return "SE";
			case 1:
				return "NE";
			case 3:
				return "SEN";
			}
		}
		if (x == 4) {
			switch (y) {
			case -3:
				return "SSE";
			case -1:
				return "NSE";
			case 1:
				return "SNE";
			case 3:
				return "NNE";
			}
		}
		if (x == -2) {
			switch (y) {
			case -3:
				return "NWS";
			case -1:
				return "SW";
			case 1:
				return "NW";
			case 3:
				return "SWN";
			}
		}
		if (x == -4) {
			switch (y) {
			case -3:
				return "SSW";
			case -1:
				return "NSW";
			case 1:
				return "SNW";
			case 3:
				return "NNW";
			}
		}
		return "";
	}

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int t = scn.nextInt();
		for (int u = 1; u <= t; u++) {
			int x = scn.nextInt();
			int y = scn.nextInt();
			String ans = "";
			if (!(x == 0 && y == 0) && Math.abs(x % 2) == Math.abs(y % 2))
				System.out.println("Case #" + u + ": " + "IMPOSSIBLE");
			else {
				if (x % 2 == 0)
					ans = expogo(x, y);
				else {
					String an = "";
					ans = expogo(y, x);
					if (!ans.equals("IMPOSSIBLE")) {
						for (int i = 0; i < ans.length(); i++) {
							switch (ans.charAt(i)) {
							case 'N':
								an += "E";
								break;
							case 'S':
								an += "W";
								break;
							case 'E':
								an += "N";
								break;
							case 'W':
								an += "S";
								break;
							}
						}
						ans = an;
					}
				}

				System.out.println("Case #" + u + ": " + ans);
			}
		}
	}

}