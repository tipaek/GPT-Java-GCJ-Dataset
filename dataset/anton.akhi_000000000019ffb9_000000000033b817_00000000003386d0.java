import java.io.*;
import java.util.*;

public class Solution {
	public static void main(String[] args) {
		new Solution().run();
	}

	BufferedReader br;
	StringTokenizer st;
	PrintWriter out;
	boolean eof = false;

	void run() {
		br = new BufferedReader(new InputStreamReader(System.in));
		out = new PrintWriter(System.out);
		solve();
		out.close();
	}

	String nextToken() {
		while (st == null || !st.hasMoreTokens()) {
			try {
				st = new StringTokenizer(br.readLine());
			} catch (Exception e) {
				eof = true;
				return "0";
			}
		}
		return st.nextToken();
	}

	int nextInt() {
		return Integer.parseInt(nextToken());
	}

	long nextLong() {
		return Long.parseLong(nextToken());
	}

	double nextDouble() {
		return Double.parseDouble(nextToken());
	}

	long gcd(long x, long y) {
		x = Math.abs(x);
		y = Math.abs(y);
		while (y > 0) {
			long t = x % y;
			x = y;
			y = t;
		}
		return x;
	}

	class Point {
		public Point(long x2, long y2) {
			x = x2;
			y = y2;
		}

		public Point(long l, long m, Point point, Point point2) {
			x = l;
			y = m;
			start = point;
			end = point2;
		}

		public int hashCode() {
			return (int) (x * 997 + y);
		}

		public boolean equals(Object o) {
			if (!(o instanceof Point)) {
				return false;
			}
			Point p = (Point) o;
			return p.x == x && p.y == y;
		}

		long x, y;
		Point start, end;
		Point next;
		Point prev;

		public long distTo(Point p) {
			return (p.x - x) * (p.x - x) + (p.y - y) * (p.y - y);
		}
	}

	private void solve() {
		int testn = nextInt();
		for (int test = 1; test <= testn; test++) {
			out.print("Case #" + test + ": ");
			int n = nextInt();
			Point[] p = new Point[n];
			for (int i = 0; i < p.length; i++) {
				p[i] = new Point(nextInt(), nextInt());
			}
			HashMap<Point, ArrayList<Point>> directions = new HashMap<>();
			for (int i = 0; i < p.length; i++) {
				for (int j = i + 1; j < p.length; j++) {
					long dx = p[j].x - p[i].x;
					long dy = p[j].y - p[i].y;
					long gcd = gcd(dx, dy);
					Point direction = new Point(dx / gcd, dy / gcd, p[i], p[j]);
					if (!directions.containsKey(direction)) {
						directions.put(direction, new ArrayList<>());
					}
					directions.get(direction).add(direction);
					direction = new Point(-dx / gcd, -dy / gcd, p[j], p[i]);
					if (!directions.containsKey(direction)) {
						directions.put(direction, new ArrayList<>());
					}
					directions.get(direction).add(direction);
				}
			}
			int best = 1;
			for (Point prime : directions.keySet()) {
				for (int i = 0; i < p.length; i++) {
					p[i].prev = null;
					p[i].next = null;
				}
				for (Point direction : directions.get(prime)) {
					if (direction.start.next == null
							|| direction.start.distTo(direction.start.next) > direction.start.distTo(direction.end)) {
						direction.start.next = direction.end;
					}
				}
				for (int i = 0; i < p.length; i++) {
					if (p[i].next != null) {
						p[i].next.prev = p[i];
					}
				}
				int ans = 0;
				int ones = 0;
				int odds = 0;
				for (int i = 0; i < p.length; i++) {
					if (p[i].prev != null) {
						continue;
					}
					int len = 0;
					Point pp = p[i];
					while (pp != null) {
						pp = pp.next;
						len++;
					}
					if (len > 1) {
						ans += len;
						if (len % 2 == 1) {
							odds++;
						}
					} else {
						ones++;
					}
				}
				ans += Math.min(ones, odds > 1 ? 2 : 1);
				best = Math.max(best, ans);
			}
			out.println(best);
		}
	}
}
