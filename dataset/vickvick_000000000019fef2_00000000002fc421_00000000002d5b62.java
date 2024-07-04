
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner scan = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		long t = scan.nextInt();
		for (long it = 1; it <= t; ++it) {
			long x = scan.nextLong();
			long y = scan.nextLong();
			String res = cal(x, y);
			System.out.println("Case #" + it + ":" + res);
		}
		scan.close();
	}

	private static String cal(long x, long y) {
		long absX = Math.abs(x);
		long absY = Math.abs(y);
		long min, max;
		boolean minIsY;
		if (absX > absY) {
			min = absY;
			max = absX;
			minIsY = true;
		} else {
			min = absX;
			max = absY;
			minIsY = false;
		}
		if (min == 0) {
			if (max == 1) {
				if (!minIsY) {// 0 1
					return y > 0 ? "N" : "S";
				} else {// 1 0
					return x > 0 ? "E" : "W";
				}
			}
			if (max == 3) {
				if (!minIsY) {// 0 3
					return y > 0 ? "NN" : "SS";
				} else {// 3 0
					return x > 0 ? "EE" : "WW";
				}
			}
		}
		if (min == 1) {
			if (max == 2) {
				if (!minIsY) {// 1 2
					return (x > 0 ? "E" : "W") + (y > 0 ? "N" : "S");
				} else {// 2 1
					return (y > 0 ? "N" : "S") + (x > 0 ? "E" : "W");
				}
			}
			if (max == 4) {
				if (!minIsY) {// 1 4
					return (x > 0 ? "W" : "E") + (x > 0 ? "E" : "W") + (y > 0 ? "N" : "S");
				} else {// 4 1
					return (y > 0 ? "S" : "N") + (y > 0 ? "N" : "S") + (x > 0 ? "E" : "W");
				}
			}
		}
		if (min == 2) {
			if (max == 3) {
				if (!minIsY) {// 2 3
					return (y > 0 ? "S" : "N") + (x > 0 ? "E" : "W") + (y > 0 ? "N" : "S");
				} else {// 3 2
					return (x > 0 ? "W" : "E") + (y > 0 ? "N" : "S") + (x > 0 ? "E" : "W");
				}
			}
		}
		if (min == 3) {
			if (max == 4) {
				if (!minIsY) {// 3 4
					return (x > 0 ? "E" : "W") + (x > 0 ? "E" : "W") + (y > 0 ? "N" : "S");
				} else {// 4 3
					return (y > 0 ? "N" : "S") + (y > 0 ? "N" : "S") + (x > 0 ? "E" : "W");
				}
			}
		}

		return "IMPOSSIBLE";
	}

}