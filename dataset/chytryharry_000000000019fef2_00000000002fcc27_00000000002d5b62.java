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
			System.out.println("Case #" + i + ": " + findPath(x,y));
		}
	}

	private static String findPath(int targetX, int targetY) {
		int startx = 0;
		int starty = 0;
		StringBuilder sb = new StringBuilder();

		int max = 30;
		int cnt=1;
		int jumpLength = 1;
		while (cnt <= max) {
			if (targetX == startx && targetY == starty) {
				break;
			}
			if (startx - jumpLength == targetX) {
				sb.append("W");
				startx = startx -jumpLength;
				jumpLength = jumpLength << 1;
				continue;
			} else if (startx + jumpLength == targetX) {
				sb.append("E");
				startx+=jumpLength;
				jumpLength = jumpLength << 1;
				continue;
			} else if (starty - jumpLength == targetY) {
				sb.append("S");
				starty-=jumpLength;
				jumpLength = jumpLength << 1;
				continue;
			} else if (starty + jumpLength == targetY) {
				sb.append("N");
				starty= starty +jumpLength;
				jumpLength = jumpLength << 1;
				continue;
			}

			if (targetX >= 0 && (targetX - jumpLength % 2) == 0) {
				sb.append("W");
				startx-=jumpLength;
			} else if (targetX >= 0 && (targetX + jumpLength) % 2 == 0) {
				sb.append("E");
				startx+=jumpLength;
			} else if (targetY >= 0 && (targetY - jumpLength)  % 2 == 0) {
				sb.append("S");
				starty-=jumpLength;
			} else if (targetY >= 0 && (targetY + jumpLength)  % 2 == 0) {
				sb.append("N");
				starty+=jumpLength;
			} else if ( (-targetX - jumpLength) % 2 == 0 ) {
				sb.append("E");
				startx+=jumpLength;
			} else if ( (-targetX + jumpLength) % 2 == 0 ) {
				sb.append("W");
				startx-=jumpLength;
			} else if ( (-targetY - jumpLength) % 2 == 0 ) {
				sb.append("N");
				starty+=jumpLength;
			} else if ( (-targetY + jumpLength) % 2 == 0 ) {
				sb.append("S");
				starty-=jumpLength;
			}

			if (targetX == startx && targetY == starty) {
				break;
			}
			jumpLength = jumpLength << 1;
			cnt++;
		}
		if (targetX != startx || targetY != starty) {
			return "IMPOSSIBLE";
		}
		return sb.toString();
	}
}