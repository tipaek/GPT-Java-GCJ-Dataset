import java.io.*;
import java.util.*;

public class Solution {

private static final String IMPOSSIBLE = "IMPOSSIBLE";

	public static void main(String[] args) {
		Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = sc.nextInt();
		for (int i = 1; i <= t; i++) {
			int n = sc.nextInt();
			List<int[]> ranges = new ArrayList<>(n);
			List<Point> points = new ArrayList<>(2 * n);
			for (int j = 0; j < n; j++) {
				int s = sc.nextInt();
				int e = sc.nextInt();
				points.add(new Point(s, true));
				points.add(new Point(e, false));
				ranges.add(new int[] { s, e });
			}
			Collections.sort(points);
			ranges.sort(new RangeComparator());
			int m = 0;
			int curr = 0;
			for (Point p : points) {
				if (p.starting) {
					curr++;
					m = Math.max(m, curr);
				} else {
					curr--;
				}
			}
			if (m > 2) {
				System.out.println(String.format("Case #%d: %s", i, IMPOSSIBLE));
				continue;
			}
			char[] result = new char[n];
			int[] c = ranges.get(0);
			result[0] = 'C';
			for (int j = 1; j < n; j++) {
				int[] r = ranges.get(j);
				if (c[1] <= r[0]) {
					result[j] = 'C';
					c = r;
				}
			}
			for (int j = 0; j < n; j++) {
				if (result[j] != 'C') {
					result[j] = 'J';
				}
			}
			for (int j = 0; j < n - 1; j++) {
				if ((result[j] == result[j + 1]) && (ranges.get(j)[1] > ranges.get(j + 1)[0])) {
					result = IMPOSSIBLE.toCharArray();
					break;
				}
			}
			System.out.println(String.format("Case #%d: %s", i, String.valueOf(result)));
		}
	}

	private static class Point implements Comparable {

		private final int time;
		private final boolean starting;

		private Point(int t, boolean s) {
			time = t;
			starting = s;
		}

		@Override
		public int compareTo(Object o) {
			Point another = (Point) o;
			if (time == another.time) {
				return Boolean.compare(starting, another.starting);
			}
			return Integer.compare(time, another.time);
		}
	}

	private static class RangeComparator implements Comparator<int[]> {

		@Override
		public int compare(int[] o1, int[] o2) {
			if (o1[0] == o2[0]) {
				return Integer.compare(o1[1], o2[1]);
			}
			return Integer.compare(o1[0], o2[0]);
		}
	}
}
