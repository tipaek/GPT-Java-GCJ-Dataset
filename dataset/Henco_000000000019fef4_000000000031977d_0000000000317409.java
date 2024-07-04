import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Scanner;

public class Solution {
	private static final boolean DEBUG = false;
	private static Scanner scanner;
	private static final char N = 'N';
	private static final char S = 'S';
	private static final char E = 'E';
	private static final char W = 'W';
	private static final String IMPOSSIBLE = "IMPOSSIBLE";

	public static void main(String[] args) throws Exception {
		InputStream input = DEBUG ? new FileInputStream(new File(Solution.class.getResource("input.txt").toURI()))
				: System.in;
		scanner = new Scanner(input);
		run();
	}

	private static void run() {
		final int n = scanner.nextInt();
		long time = 0;
		if (DEBUG) {
			time = System.currentTimeMillis();
		}
		for (int i = 0; i < n; i++) {
			solve(i);
		}
		if (DEBUG) {
			System.out.println(System.currentTimeMillis() - time);
		}
	}

	private static void solve(int i) {
		int x = scanner.nextInt();
		int y = scanner.nextInt();
		char[] tour = scanner.next().toCharArray();
		Point[] tourStops = new Point[tour.length + 1];
		int[] dists = new int[tourStops.length];
		tourStops[0] = new Point(x, y);
		dists[0] = Math.abs(x) + Math.abs(y);
		for (int j = 0; j < tour.length; j++) {
			Point newPoint = move(tourStops[j], tour[j]);
			tourStops[j + 1] = newPoint;
			dists[j + 1] = Math.abs(newPoint.x) + Math.abs(newPoint.y);
		}
		int time = -1;
		for (int j = 0; j < dists.length; j++) {
			if (dists[j] <= j) {
				time = j;
				break;
			}
		}
//		System.out.println(Arrays.toString(tour));
//		System.out.println(Arrays.toString(tourStops));
//		System.out.println(Arrays.toString(dists));
		String mins = time < 0 ? IMPOSSIBLE : Integer.toString(time);
		printCase(i, mins);
	}

	private static Point move(Point point, char c) {
		switch (c) {
		case N:
			return new Point(point.x, point.y + 1);
		case S:
			return new Point(point.x, point.y - 1);
		case E:
			return new Point(point.x + 1, point.y);
		case W:
			return new Point(point.x - 1, point.y);
		default:
			throw new RuntimeException();
		}
	}

	private static void printCase(int i, String str) {
		System.out.println("Case #" + (i + 1) + ": " + str);
	}

	static class Point {
		int x;
		int y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + x;
			result = prime * result + y;
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj) {
				return true;
			}
			if (obj == null) {
				return false;
			}
			if (getClass() != obj.getClass()) {
				return false;
			}
			Point other = (Point) obj;
			if (x != other.x) {
				return false;
			}
			if (y != other.y) {
				return false;
			}
			return true;
		}

		@Override
		public String toString() {
			return "Point [x=" + x + ", y=" + y + "]";
		}

	}

}
