import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

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
			Set<Pos> visited = new HashSet();
			Queue<Pos> q = new LinkedList<>();
			q.add(new Pos(0, 0, "", 1));
			while (!q.isEmpty()) {
				Pos p = q.remove();
				if (p.x == X && p.y == Y) {
					res = p.partial;
					break;
				}
				if (p.step > 1024) {
					res = "IMPOSSIBLE";
					break;
				}
				Pos pp = new Pos(p.x + p.step, p.y, p.partial + "E", p.step * 2);
				if (!visited.contains(pp)) {
					q.add(pp);
					visited.add(pp);
				}
				 pp = new Pos(p.x - p.step, p.y, p.partial + "W", p.step * 2);
				if (!visited.contains(pp)) {
					q.add(pp);
					visited.add(pp);
				}
				 pp = new Pos(p.x, p.y + p.step, p.partial + "N", p.step * 2);
				if (!visited.contains(pp)) {
					q.add(pp);
					visited.add(pp);
				}
				 pp = new Pos(p.x, p.y - p.step, p.partial + "S", p.step * 2);
				if (!visited.contains(pp)) {
					q.add(pp);
					visited.add(pp);
				}

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
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Pos other = (Pos) obj;
			if (x != other.x)
				return false;
			if (y != other.y)
				return false;
			return true;
		}

	}
}
