import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
	public static final String CASE = "Case #";
	public static String minPath = "";

	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int testCaseNumber = in.nextInt();

		for (int currentTestCase = 1; currentTestCase <= testCaseNumber; ++currentTestCase) {
			int x = in.nextInt();
			int y = in.nextInt();
			minPath = "";

			if (((x % 2) == 1) && ((y % 2) == 1)) {
				System.out.println(CASE + currentTestCase + ": IMPOSSIBLE");
			} else if (rec(new Point(), new Point(x, y), "", 0.0d)) {
				System.out.println(CASE + currentTestCase + ": " + minPath);
			} else {
				System.out.println(CASE + currentTestCase + ": IMPOSSIBLE");
			}
		}
		in.close();

	}

	private static boolean rec(Point s, Point d, String path, double pow) {
		if ((s.x == d.x) && (s.y == d.y)) { // reached dest
			if (minPath.isEmpty() || (path.length() < minPath.length())) {
				minPath = path;
			}
			return true;
		}

		int len = (int) Math.pow(2.0d, pow);
		if ((Math.abs(s.x) > d.x) || (Math.abs(s.y) > d.y)) {
			return false; // impossible
		}

		if (len == 1) { // first jump on the coordinate thats odd
			if ((s.x % 2) == 1) {
				boolean east = rec(new Point(s.x + len, s.y), d, path + "E", pow + 1); // E
				if (east) {
					return true;
				}
				boolean west = rec(new Point(s.x - len, s.y), d, path + "W", pow + 1); // W
				return (west);
			} else {
				boolean north = rec(new Point(s.x, s.y + len), d, path + "N", pow + 1); // N
				if (north) {
					return true;
				}
				boolean south = rec(new Point(s.x, s.y - len), d, path + "S", pow + 1); // S
				return (south);
			}
		} else {
			boolean east = rec(new Point(s.x + len, s.y), d, path + "E", pow + 1); // E
			if (east) {
				return true;
			}
			boolean west = rec(new Point(s.x - len, s.y), d, path + "W", pow + 1); // W
			if (west) {
				return true;
			}
			boolean north = rec(new Point(s.x, s.y + len), d, path + "N", pow + 1); // N
			if (north) {
				return true;
			}
			boolean south = rec(new Point(s.x, s.y - len), d, path + "S", pow + 1); // S

			return (south); // found any path?
		}
	}

	public static class Point {
		public int x = 0;
		public int y = 0;

		public Point() {
			super();
		}

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
