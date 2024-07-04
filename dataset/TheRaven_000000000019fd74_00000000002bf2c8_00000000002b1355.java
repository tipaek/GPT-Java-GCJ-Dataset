import java.util.*;
		public class Solution {
				public static void main (String [] arg) {
		Scanner sc = new Scanner(System.in);
		int T = Integer.parseInt(sc.nextLine());

		for (int ii = 1; ii<=T; ++ii) {
			int R = sc.nextInt();
			int C = sc.nextInt();
			long ans = 0;
			Pair [][] P = new Pair[R][C];
			LinkedList<Pair> L = new LinkedList<Pair>();
			for (int i = 0; i<R; ++i) {
				for (int j = 0; j<C; ++j) {
					P[i][j] = new Pair(i,j, sc.nextInt());
					if (i > 0) {
						P[i][j].N = P[i-1][j];
						P[i-1][j].S = P[i][j];
					}
					if (j > 0) {
						P[i][j-1].E = P[i][j];
						P[i][j].W = P[i][j-1];
					}
					L.add(P[i][j]);
				}
			}
			int round = 0;
			boolean eliminated = false;
			while (true) {
				round++;
				LinkedList<Pair> L2 = new LinkedList<Pair>();
				for (Pair p : L) {
					ans += p.s;
					if (p.shouldEliminate()) p.eliminate = true;
					else L2.add(p);
				}
				for (Pair p : L) if (p.eliminate) p.eliminate();

				if (L2.size() == L.size()) break;
				L = L2;
				/*
				System.err.println(round + " :: Remaining skills : ");
				for (Pair p : L) {
					System.err.print(p.s +",");
				}
				System.err.println();
				*/
			}

			System.out.printf("Case #%d: %s\n",ii,ans+"");
		}
	}
	static class Pair  {
		int i,j,s; public Pair(int xx, int yy, int ss){i=xx;j=yy;s=ss;}
		Pair N,E,S,W;
		boolean eliminate = false;

		public boolean shouldEliminate() {
			int total = 0;
			int sum = 0;
			if (N != null) {total++;sum+=N.s;}
			if (E != null) {total++;sum+=E.s;}
			if (S != null) {total++;sum+=S.s;}
			if (W != null) {total++;sum+=W.s;}
		//	System.err.println(i + " , " + j + " comparison is " + s + " vs " + sum + " / " + total);
			return (sum > s*total);
		}
		public void eliminate() {
			if (N != null) N.S = S;
			if (E != null) E.W = W;
			if (W != null) W.E = E;
			if (S != null) S.N = N;
		}
	}

}
