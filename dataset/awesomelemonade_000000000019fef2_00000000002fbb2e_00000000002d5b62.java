import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public class Solution {
	public static void main(String[] args) throws Exception {
		/*System.out.println(100);
		for (int i = 0; i < 100; i++) {
			int billion = 1000000000;
			int rand = new java.util.Random().nextInt(2 * billion) - billion;
			int rand2 = new java.util.Random().nextInt(2 * billion) - billion;
			System.out.println(rand + " " + rand2);
		}*/

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter writer = new PrintWriter(System.out);

		int t = Integer.parseInt(reader.readLine());
		for (int tt = 0; tt < t; tt++) {
			StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
			int x = Integer.parseInt(tokenizer.nextToken());
			int y = Integer.parseInt(tokenizer.nextToken());
			Point p = new Point(x, y);
			Map<Integer, Map<Integer, Point>> map = new HashMap<Integer, Map<Integer, Point>>();
			Map<Integer, Map<Integer, Character>> map2 = new HashMap<Integer, Map<Integer, Character>>();
			Deque<Point> queue = new ArrayDeque<Point>();
			queue.add(p);
			boolean found = false;
			while (!queue.isEmpty()) {
				Point polled = queue.poll();
				//writer.println("Polled: " + polled.x + " - " + polled.y);
				if (polled.x == 0 && polled.y == 0) {
					// found solution?
					found = true;
					break;
				}
				int modX = ((polled.x % 2) + 2) % 2;
				int modY = ((polled.y % 2) + 2) % 2;
				if (modX == 1 && modY == 1) {
					// impossible
					continue;
				}
				if (modX == 1) {
					Point p1 = new Point((polled.x - 1) / 2, polled.y / 2);
					Point p2 = new Point((polled.x + 1) / 2, polled.y / 2);
					if (!visited(map, p1.x, p1.y)) {
						queue.add(p1);
						put(map, p1.x, p1.y, polled);
						put(map2, p1.x, p1.y, 'E');
					}
					if (!visited(map, p2.x, p2.y)) {
						queue.add(p2);
						put(map, p2.x, p2.y, polled);
						put(map2, p2.x, p2.y, 'W');
					}
				} else if (modY == 1) {
					Point p1 = new Point(polled.x / 2, (polled.y - 1) / 2);
					Point p2 = new Point(polled.x / 2, (polled.y + 1) / 2);
					if (!visited(map, p1.x, p1.y)) {
						queue.add(p1);
						put(map, p1.x, p1.y, polled);
						put(map2, p1.x, p1.y, 'N');
					}
					if (!visited(map, p2.x, p2.y)) {
						queue.add(p2);
						put(map, p2.x, p2.y, polled);
						put(map2, p2.x, p2.y, 'S');
					}
				} else {
					// we're forced to jump
					continue;
				}
			}
			if (found) {
				StringBuilder builder = new StringBuilder();
				Point current = new Point(0, 0);
				while (current.x != p.x || current.y != p.y) {
					char c = map2.get(current.x).get(current.y);
					builder.append(c);
					current = map.get(current.x).get(current.y);
					//writer.println("Trace: " + current.x + " - " + current.y);
				}
				writer.printf("Case #%d: %s\n", tt + 1, builder.reverse().toString());
			} else {
				writer.printf("Case #%d: IMPOSSIBLE\n", tt + 1);
			}
		}

		reader.close();
		writer.close();
	}
	public static boolean visited(Map<Integer, Map<Integer, Point>> map, int x, int y) {
		if (!map.containsKey(x)) {
			return false;
		}
		return map.get(x).containsKey(y);
	}
	public static void put(Map<Integer, Map<Integer, Point>> map, int x, int y, Point p) {
		if (!map.containsKey(x)) {
			map.put(x, new HashMap<Integer, Point>());
		}
		map.get(x).put(y, p);
	}
	public static void put(Map<Integer, Map<Integer, Character>> map, int x, int y, char c) {
		if (!map.containsKey(x)) {
			map.put(x, new HashMap<Integer, Character>());
		}
		map.get(x).put(y, c);
	}
	static class Point {
		int x;
		int y;
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
