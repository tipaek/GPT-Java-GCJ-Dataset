import java.util.*;
public class Solution {
	static boolean sortFlag = false;
	public static void main (String [] arg) {
		Scanner sc = new Scanner(System.in);

		int T = Integer.parseInt(sc.nextLine());
		for (int ii = 1; ii<=T; ++ii) {
			int N = sc.nextInt();
			Point [] P = new Point [N];
			for (int i = 0; i<N; ++i) P[i] = new Point(sc.nextInt(), sc.nextInt());
			int ans = 1;

			for (int i = 0; i<N; ++i) {
				for (int j = 0; j<N && ans < N; ++j) {
						if (i == j) continue;
						long m0 = (P[i].y - P[j].y);
						long m1 = (P[i].x - P[j].x);
						ans = Math.max(ans, trySlope(P, m0, m1,N));
				}
			}

			System.out.printf("Case #%d: %d\n",ii, Math.min(ans,N));
		}
	}
	static int trySlope(Point[] P, long m0, long m1, int N) {
		int tot = 0;
		boolean [] used = new boolean [N];
		boolean haveodd = false;
		for (int k = 0; k<N; ++k) {
			if (used[k]) continue;
			Line test = new Line(P[k], m0, m1);
			used[k] = true;
			int howmany = 1;
			for (int z = 0; z<N; ++z) {
				if (!used[z] && test.contains(P[z])) {
						used[z] = true;
						howmany++;
				}
			}
			if (howmany >= 2) {
				if (howmany % 2 == 0 || haveodd) tot += howmany;
				else {
						haveodd = true;
						tot += howmany - 1;
				}
			}
		}
		int extra = (N - tot);
		if (extra <= 1) return N;
		else return tot + 2;
	}
	static class Point implements Comparable<Point>{
		int x,y;
		public Point(int xx, int yy){x=xx;y=yy;}
		public int compareTo(Point p) {
			return (x == p.x) ? y - p.y : x - p.x;
		}
	}
	static class Line {
		Point p1;
		long m0, m1; // m0 / m1
		public Line (Point p1, long m0, long m1) {
			this.p1 = p1;
			this.m0 = m0;
			this.m1 = m1;
		}
		public boolean contains( Point p2) {
			long delx = (p2.x - p1.x) + 0L;
			long dely = (p2.y - p1.y) + 0L;
			return (dely * m1 == delx * m0);
		}
	}
}
