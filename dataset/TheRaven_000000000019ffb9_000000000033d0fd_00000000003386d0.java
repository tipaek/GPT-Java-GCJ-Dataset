import java.util.*;
public class Solution {
	public static void main (String [] arg) {
		Scanner sc = new Scanner(System.in);
		int T = Integer.parseInt(sc.nextLine());
		for (int ii = 1; ii<=T; ++ii) {
			int N = sc.nextInt();
			Point [] P = new Point [N];
			for (int i = 0; i<N; ++i) P[i] = new Point(sc.nextInt(), sc.nextInt());
			int ans = Math.min(2, N);
			boolean [] used = new boolean [N];

			for (int i = 0; i<N; ++i) {
				for (int j = 0; j<N; ++j) {
						if (i == j) continue;
						long m0 = (P[i].y - P[j].y);
						long m1 = (P[i].x - P[j].x);
						Arrays.fill(used, false);
						int tot = 0;
						int extra = 0;
						for (int k = 0; k<N; ++k) {
							if (used[k]) continue;
							Line test = new Line(P[k], m0, m1);
							used[k] = true;
							int howmany = 1;
							for (int z = 0; z<N; ++z) {
								if (z != k && test.contains(P[z])) {
										used[z] = true;
										howmany++;
								}
							}
							if (howmany == 1) extra++;
							else if (howmany >= 2) tot += howmany;
						}
						if (extra == 1) tot++;
						else if (extra >= 2) tot+=2;
						ans = Math.max(ans, tot);
				}
			}



			System.out.printf("Case #%d: %d\n",ii, ans);
		}
	}
	static class Point {
		int x,y;
		public Point(int xx, int yy){x=xx;y=yy;}
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
			long denom = (p2.x - p1.x);
			long num = (p2.y - p1.y);
			if (m0 == 0) return p1.y == p2.y;
			if (m1 == 0) return p1.x == p2.x;
			return (num * m1 == denom * m0);
		}
	}
}
