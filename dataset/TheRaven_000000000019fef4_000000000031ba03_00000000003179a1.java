import java.util.*;
public class Solution {
	public static void main (String [] arg) {
		Scanner sc = new Scanner(System.in);
		int T = Integer.parseInt(sc.nextLine());
		for (int ii = 1; ii<=T; ++ii) {
			char [] ans = new char [10];
			int U = sc.nextInt();
			int [] count = new int [256];
			HashSet<Character> c = new HashSet<Character>();
			for (int i = 0; i<10000; ++i) {
				int Mi = sc.nextInt();
				char [] Ai = sc.next().toCharArray();
				if (Ai.length == U) {
					count[Ai[0]]++;
				}
				if (c.size() != 10)
					for (int j = 1; j<Ai.length; ++j) c.add(Ai[j]);
			}
			for (Character c2 : c) if (count[c2] == 0) ans[0] = c2;
			LinkedList<Pair> P = new LinkedList<Pair>();
			for (int i = 0; i<count.length; ++i)
				if (count[i] != 0)
					P.add(new Pair(i, i, count[i]));
			Collections.sort(P);

			int start = 9;
			for (Pair p : P) {
				ans[start] = (char)p.i;
				start--;
			}
			System.out.printf("Case #%d: %s\n",ii, new String(ans));
		}
	}
	static class Pair implements Comparable<Pair> {
		int i,j;long L; public Pair(int xx, int yy, long LL){i=xx;j=yy;L=LL;}
		public int compareTo(Pair p) { return (this.L < p.L) ? -1 : (this.L == p.L) ? this.i - p.i : 1;}
	}
}
