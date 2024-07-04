import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution {
	static Scanner reader = new Scanner(System.in);
	static int max = Integer.MAX_VALUE;
	static String res = "";

	public static void main(String[] args) {
		int T = reader.nextInt();
		for (int t = 0; t < T; t++) {
			int X = reader.nextInt();
			int Y = reader.nextInt();

			int XX = Math.abs(X);
			int YY = Math.abs(Y);
			Queue<Pos> q = new LinkedList<>();
			q.add(new Pos(0, 0, "", 1));
			while (!q.isEmpty()) {
				Pos p = q.remove();
				if (p.x == X && p.y == Y) {
					res = p.partial;
					break;
				}
				if(p.step > 64) {
					res = "IMPOSSIBLE";
					break;
				}
				q.add(new Pos(p.x + p.step, p.y, p.partial + "E", p.step * 2));
				q.add(new Pos(p.x - p.step, p.y, p.partial + "W", p.step * 2));

				q.add(new Pos(p.x, p.y + p.step, p.partial + "N", p.step * 2));

				q.add(new Pos(p.x, p.y - p.step, p.partial + "S", p.step * 2));

			}

			System.out.printf("Case #%d: %s\n", t + 1, res);
		}
	}

	static void solve(int X, int Y, int x, int y, String partial) {
		if (x == X && y == Y) {
			res = partial;
		}

	}

	static class Pos {
		int x;
		int y;
		String partial;
		int step = 1;

		public Pos(int x, int y, String partial, int step) {
			super();
			this.x = x;
			this.y = y;
			this.partial = partial;
			this.step = step;
		}

	}
}
