import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

	private static Map<Point, Integer> pascal = new HashMap<>();
	private static Set<Point> visited;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int testCount = scanner.nextInt();

		for (int i = 0; i < testCount; i++) {
			int sum = scanner.nextInt();
			visited = new HashSet<>();
			List<Point> result = new ArrayList<>();
			Point start = new Point(1, 1);
			result.add(start);
			visited.add(start);
			pascal.put(start, 1);
			solve(sum - 1, start, result);
			StringBuilder sb = new StringBuilder();
			sb.append("Case #").append(i + 1).append(":\n");
			for (Point point : result) {
				sb.append(point.r).append(" ").append(point.k).append("\n");
			}
			System.out.println(sb.toString());
		}

	}

	private static boolean solve(int sum, Point current, List<Point> result) {
		if (sum == 0) {
			return true;
		}
		if (sum < 0) {
			return false;
		}
		if (visited.size() >= 500) {
			return false;
		}
		//(ri - 1, ki - 1), (ri - 1, ki), (ri, ki - 1), (ri, ki + 1), (ri + 1, ki), (ri + 1, ki + 1).
		List<Point> points = new ArrayList<>();
		points.add(new Point(current.r - 1, current.k - 1));
		points.add(new Point(current.r - 1, current.k));
		points.add(new Point(current.r, current.k - 1));
		points.add(new Point(current.r, current.k + 1));
		points.add(new Point(current.r + 1, current.k));
		points.add(new Point(current.r + 1, current.k + 1));
		for (Point point : points) {
			if (isAvailablePosition(point, sum)) {
				int value = calculate(point);
				result.add(point);
				visited.add(point);
				int index = result.size() - 1;
				boolean move = solve(sum - value, point, result);
				if (move) {
					return true;
				}
				visited.remove(point);
				result.remove(index);
			}
		}
		return false;
	}

	private static int calculate(Point point) {
		if (point.r < 1 || point.k < 1) {
			return 0;
		}
		if (point.r < point.k) {
			return 0;
		}
		if (pascal.containsKey(point)) {
			return pascal.get(point);
		}
		int upperLeft = calculate(new Point(point.r - 1, point.k - 1));
		int upperRight = calculate(new Point(point.r - 1, point.k));
		int value = upperLeft + upperRight;
		pascal.put(point, value);
		return value;
	}

	private static boolean isAvailablePosition(Point point, int sum) {
		if (point.r < 1 || point.k < 1) {
			return false;
		}
		if (point.r < point.k) {
			return false;
		}
		if (visited.contains(point)) {
			return false;
		}

		int value = calculate(point);
		return sum - value >= 0;
	}

	public static class Point {
		int r;
		int k;

		public Point(int r, int k) {
			this.r = r;
			this.k = k;
		}

		@Override
		public boolean equals(Object o) {
			if (this == o)
				return true;
			if (o == null || getClass() != o.getClass())
				return false;
			Point point = (Point) o;
			return r == point.r && k == point.k;
		}

		@Override
		public int hashCode() {
			return Objects.hash(r, k);
		}
	}

}
