import java.util.Arrays;
import java.util.Scanner;

public class Solution {

	static class Pair {

		public long		n;
		public String	s;
	}

	Scanner in = new Scanner(System.in);

	void solve() throws Exception {
		char	d[]	= new char[10];
		int		u	= in.nextInt();
		Pair[]	p	= new Pair[10000];

		for (int i = 0; i < 10000; ++i) {
			p[i]	= new Pair();
			p[i].n	= in.nextLong();
			p[i].s	= in.next();
		}

		Arrays.parallelSort(p, (p1, p2) -> Long.compare(p1.n, p2.n));

		int i = 0;
		for (int di = 1; di < 10;)
			o:
			{
				for (int dj = 1; dj < di; ++dj)
					if (d[dj] == p[i].s.charAt(p[i].s.length() - 1)) {
						++i;
						break o;
					}
				d[di++] = p[i].s.charAt(p[i].s.length() - 1);
			}

		// Find zero
		for (i = 0; i < 10000; ++i)
			for (char c : p[i].s.toCharArray())
				o:
				{
					for (int j = 1; j < 10; ++j)
						if (d[j] == c) break o;
					d[0] = c;
					break;
				}

		for (int z = 0; z < 10; ++z)
			System.out.print(d[z]);
		System.out.println();
	}

	void run() throws Exception {
		int t = in.nextInt();
		for (int i = 1; i <= t; ++i) {
			System.out.printf("Case #%d: ", i);
			solve();
		}
	}

	public static void main(String[] args) throws Exception { new Solution().run(); }
}
