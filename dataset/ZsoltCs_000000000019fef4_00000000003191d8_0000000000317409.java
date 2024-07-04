
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
	static class Coords {
		int x, y;

		Coords(int x, int y) {
			this.x = x;
			this.y = y;
		}

		void move(char dir) {
			switch (dir) {
			case 'N':
				y += 1;
				break;
			case 'S':
				y -= 1;
				break;
			case 'E':
				x += 1;
				break;
			case 'W':
				x -= 1;
				break;
			default:
				throw new IllegalArgumentException("Unexpected direction: " + dir);
			}
		}
	}

	public static void main(String[] args) {
		try (Scanner scan = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
			int numOfTestCases = scan.nextInt();
			for (int i = 1; i <= numOfTestCases; ++i) {
				int x = scan.nextInt();
				int y = scan.nextInt();
				String route = scan.next();
				System.out.println("Case #" + i + ": " + solve(x, y, route));
			}
		}
	}

	private static String solve(int x, int y, String route) {
		if (x == 0 && y == 0) {
			return "1";
		}
		Coords peppur = new Coords(x, y);
		int best = route.length() + 1;
		for (int minutes = 0; minutes < route.length(); ++minutes) {
			peppur.move(route.charAt(minutes));
			int distance = distance(peppur.x, peppur.y);
			if (distance <= minutes + 1 && minutes < best) {
				best = minutes;
			}
		}
		if (best <= route.length()) {
			return String.valueOf(best + 1);
		} else {
			return "IMPOSSIBLE";
		}
	}

	private static int distance(int x, int y) {
		return Math.abs(x) + Math.abs(y);
	}
}