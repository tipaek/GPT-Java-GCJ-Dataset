import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Locale;
import java.util.Scanner;


public class Solution {
	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt();
		for (int tc=1; tc<=t; tc++) {
			int x = in.nextInt();
			int y = in.nextInt();

			String solution = solve(x, y);
			if (solution == null) solution = "IMPOSSIBLE";
			System.out.format(Locale.ROOT, "Case #%d: %s%n", tc, solution);
		}
		in.close();
	}
	
	static String solve(int dx, int dy) {
		switch (dx) {
		case -1:
			switch (dy) {
			case -1:
				return null;
			case 0:
				return "W";
			case 1:
				return null;
			}
			break;
		case 0:
			switch (dy) {
			case -1:
				return "S";
			case 0:
				return "";
			case 1:
				return "N";
			}
			break;
		case 1:
			switch (dy) {
			case -1:
				return null;
			case 0:
				return "E";
			case 1:
				return null;
			}
			break;
		}
		
		if ((dx & 1) == 0) {
			if ((dy & 1) == 0) {
				return null;
			} else {
				String plusResult = solve(dx/2, (dy-1) / 2);
				if (plusResult != null) {
					return "N" + plusResult;
				}
				String minusResult = solve(dx/2, (dy+1) / 2);
				if (minusResult != null) {
					return "S" + minusResult;
				}
				return null;
			}
		} else {
			if ((dy & 1) == 0) {
				String plusResult = solve((dx-1)/2, dy/2);
				if (plusResult != null) {
					return "E" + plusResult;
				}
				String minusResult = solve((dx+1)/2, dy/2);
				if (minusResult != null) {
					return "W" + minusResult;
				}
				return null;
			} else {
				return null;
			}
		}
	}
}
