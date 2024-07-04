import java.util.*;
public class Solution {
	static boolean sortFlag = false;
	public static void main (String [] arg) {
		Scanner sc = new Scanner(System.in);
		int T = Integer.parseInt(sc.nextLine());
		boolean [] used = new boolean [256];
		char [] iter = {'C', 'J'};

		for (int ii = 1; ii<=T; ++ii) {
			int N = sc.nextInt();
			Pair [] Ps = new Pair[N];
			Pair [] Pe = new Pair[N];
			char [] ans = new char [N];
			Arrays.fill(used, false);

			for (int i = 0; i<N; ++i) {
				int s = sc.nextInt();
				int e = sc.nextInt();
				Ps[i] = new Pair(s, e, i);
				Pe[i] = Ps[i];
			}
			sortFlag = true;
			Arrays.sort(Ps);
			sortFlag = false;
			Arrays.sort(Pe);

			int eptr = 0, sptr = 0, iptr = 0;
			LinkedList<Pair> cur = new LinkedList<Pair>();
			boolean possible = true;
			for (int t = 0; t<=24*60 && possible; ++t) {
				while (eptr < Pe.length && Pe[eptr].j == t) {
					for (Pair p : cur) if (p == Pe[eptr]) {
						cur.remove(p);
						used[p.A] = false;
					}
					eptr++;
				}
				while (sptr < Pe.length && Ps[sptr].i == t) {
					Pair p = Ps[sptr];
					cur.add(p);
					A : for (char c : iter) {
						if (!used[c]) {
							p.A = c;
							ans[p.k] = c;
							used[c] = true;
							break A;
						}
					}
					if (p.A == 0) possible = false;
					sptr++;
				}
			}

			System.out.printf("Case #%d: %s\n",ii, (possible) ? new String(ans) : "IMPOSSIBLE");
		}
	}
	static class Pair implements Comparable<Pair> {

		int i,j,k;char A = (char)0;
		public Pair(int xx, int yy, int kk){i=xx;j=yy;;k=kk;}
		public int compareTo(Pair p) {
			if (sortFlag) return (i < p.i) ? -1 : (i == p.i) ? j - p.j : 1;
			else return (j < p.j) ? -1 : (j == p.j) ? i-p.i : 1;
		}
	}
}
