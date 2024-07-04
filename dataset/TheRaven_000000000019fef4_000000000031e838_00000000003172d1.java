import java.util.*;
public class Solution {
	public static void main (String [] arg) {
		Scanner sc = new Scanner(System.in);
		int T = Integer.parseInt(sc.nextLine());
		for (int ii = 1; ii<=T; ++ii) {
			int N = sc.nextInt();
			int D = sc.nextInt();
			long [] A = new long [N];
			HashMap<Long,Integer> count = new HashMap<Long,Integer>();
		 	long has2 = Long.MAX_VALUE;
			boolean has3 = false;
			long max = -1;
			for (int i = 0; i<N; ++i) {
				A[i] = sc.nextLong();
				max = Math.max(A[i], max);
				if (!count.containsKey(A[i])) {
					count.put(A[i], 1);
				} else {
					int c = count.get(A[i])+1;
					if (c == 2) has2 = Math.min(A[i], has2);
					if (c == 3) has3 = true;
					count.put(A[i], c);
				}
			}

			int ans = 2;
			if (D == 2) {
				ans = (has2 != Long.MAX_VALUE) ? 0 : 1;
			} else if (D == 3) {
				if (has3) ans = 0;
				else if (has2 != Long.MAX_VALUE && has2 != max) ans = 1;
				else {
					for (Long L : count.keySet()) {
						if (count.containsKey(L*2)) ans = 1;
					}
				}

			} else {
				// TODO
			}




			System.out.printf("Case #%d: %s\n",ii, ans+"");
		}
	}
	static class Pair implements Comparable<Pair> {
		int i,j;long L; public Pair(int xx, int yy, long LL){i=xx;j=yy;L=LL;}
		public int compareTo(Pair p) { return (this.L < p.L) ? -1 : (this.L == p.L) ? this.i - p.i : 1;}
	}
}
