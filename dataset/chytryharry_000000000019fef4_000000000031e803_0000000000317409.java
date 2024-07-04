
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args)   {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
		for (int i = 1; i <= t; i++) {
			int x = in.nextInt();
			int y = in.nextInt();
			String route = in.next();
			System.out.println("Case #" + i + ": "  + method(x, y, route));
		}
	}

	public static String method(int startX, int startY, String route) {
		int howLong = route.length();
		for (int i = 0; i< route.length(); i++) {
			String move = String.valueOf(route.charAt(i));
			if (move.equals("N")) {
				startY += 1;
			} else if (move.equals("S")) {
				startY -= 1;
			} else if (move.equals("E")) {
				startX += 1;
			} else if (move.equals("W")) {
				startX -= 1;
			}

			if (startX == 0 && startY == 0) {
				return i+1 + "";
			}

			if (Math.abs(startX) + Math.abs(startY) <= i + 1) {
				return i+1 + "";
			}
		}
		if (startX + startY == howLong) {
			return howLong + "";
		}
		return "IMPOSSIBLE";
	}
}
