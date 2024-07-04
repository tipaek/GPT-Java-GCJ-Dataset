import java.util.Arrays;
import java.util.Scanner;

public class Solution {	
	static Interval intvs[];
	static Pair[][] next;
	public static void main (String[] args) {
		Scanner in = new Scanner(System.in);		
		int t = in.nextInt();
		for (int c=1; c<=t; c++) {
			int n = in.nextInt();
			intvs = new Interval[n];
			next = new Pair[n+4][n+4];
			for (int i=0; i<n; i++)
				intvs[i] = new Interval(in.nextInt(), in.nextInt(), i);
			Arrays.sort(intvs);
			solve(-1, -1);
			Pair curr = next[0][0];
			if (curr == null) {
				System.out.println("Case #"+c+": IMPOSSIBLE");
			} else {
				int j = 0, k = 0;
				char res[] = new char[n];
				while (curr != null) {
					int index = Math.max(j, k);
					if (curr.a > j)
						res[intvs[index].pos] = 'C';
					if (curr.b > k)
						res[intvs[index].pos] = 'J';
					j = curr.a;
					k = curr.b;
					curr = next[curr.a][curr.b];
				}
				System.out.println("Case #"+c+": "+new String(res));
			}
		}
	}
	static boolean solve(int j, int k) {
		int i = Math.max(j, k)+1;
		if (i == intvs.length) {
			return true;
		}
		
		if (j == -1 || intvs[j].end <= intvs[i].start) {
			if (solve(i, k)) {
				next[j+1][k+1] = new Pair(i+1, k+1);
				return true;
			}
		}
		if (k == -1 || intvs[k].end <= intvs[i].start) {
			if (solve(j, i)) {
				next[j+1][k+1] = new Pair(j+1, i+1);
				return true;
			}
		}
		return false;
	}
	static class Interval implements Comparable<Interval> {
		int start, end, pos;
		public Interval(int start, int end, int pos) {
			this.start = start;
			this.end = end;
			this.pos = pos;
		}
		@Override
		public int compareTo(Interval o) {
			if (start == o.start)
				return o.end - end;
			return start - o.start;
		}
	}
	static class Pair {
		int a,b;
		public Pair(int a, int b) {
			this.a = a;
			this.b = b;
		}
	}
}