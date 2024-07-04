import java.util.*;

public class Solution {

	private static class Point {
		public int x = 0;
		public int y = 0;
		public String s = "";

		public Point(int x, int y, String s) {
			this.x = x;
			this.y = y;
			this.s = s;
		}
	}

	private static class Direction {
		public int dx;
		public int dy;
		public char c;

		public Direction(int dx, int dy, char c) {
			this.dx = dx;
			this.dy = dy;
			this.c = c;
		}
	}

	public static void main(String[] args) {
		Direction[] d = new Direction[]{
			new Direction(0, -1, 'S'),
			new Direction(1, 0, 'E'),
			new Direction(0, 1, 'N'),
			new Direction(-1, 0, 'W'),
		};

		Scanner scanner = new Scanner(System.in);
		int t = scanner.nextInt(), tmp;
		for (int k = 1; k <= t; ++k) {
			int x = scanner.nextInt();
			int y = scanner.nextInt();

			int step = Math.abs(x) + Math.abs(y);

			int max = 1;
			while (max <= step) {
				max <<= 1;
			}

			step = 1;
			Queue<Point> queue = new LinkedList<>();
			queue.add(new Point(0, 0, ""));
			boolean res = false;
			while (step < max && !res) {
				int size = queue.size();
				for (int i = 0; i < size && !res; ++i) {
					Point cur = queue.remove();
					for (int j = 0; j < 4; ++j) {
						int newX = cur.x + step*d[j].dx;
						int newY = cur.y + step*d[j].dy;
						if (newX == x && newY == y) {
							System.out.println("Case #" + k + ": " + cur.s + d[j].c);
							res = true;
							break;
						}
						queue.add(new Point(newX, newY, cur.s + d[j].c));
					}
				}
				step <<= 1;
			}

			if (!res)
				System.out.println("Case #" + k + ": " + "IMPOSSIBLE");
		}
		scanner.close();
	}
}