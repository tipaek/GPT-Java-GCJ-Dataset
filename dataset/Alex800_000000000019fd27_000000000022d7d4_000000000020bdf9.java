import java.util.*;
import java.io.*;

public class Solution {
	static class Tuple implements Comparable<Tuple> {
		int n1;
		int n2;
		boolean s;

		public Tuple(int n1, int n2, boolean s) {
			this.n1 = n1;
			this.n2 = n2;
			this.s = s;
		}

		public int compareTo(Tuple a) {
			if (n1 == a.n1 && !s && a.s)
				return -1;
			else if (n1 == a.n1 && !a.s && s)
				return 1;
			else
				return n1 - a.n1;
		}
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(
				new BufferedReader(new InputStreamReader(System.in)));

		int T = in.nextInt(); // Scanner has functions to read ints, longs,
								// strings, chars, etc.
		for (int t = 1; t <= T; ++t) {
			int N = in.nextInt();
			PriorityQueue<Tuple> times = new PriorityQueue<Tuple>();
			int count = 0;

			for (int i = 0; i < N; i++) {
				times.add(new Tuple(in.nextInt(), count, true));
				times.add(new Tuple(in.nextInt(), count++, false));
			}

			int c = -1, j = -1;
			boolean fail = false;
			String ans = "";
			for (int i = 0; i < N; i++)
				ans += "C";
			
			for (int i = 0; i < 2 * N; i++) {
				Tuple next = times.poll();

				if (next.s) {
					if (c == -1) {
						c = next.n2;
					} else if (j == -1) {
						ans = ans.substring(0, next.n2) +  "J" + ans.substring(next.n2 + 1);
						j = next.n2;
						continue;
					} else {
						fail = true;
						break;
					}
				} else {
					if (next.n2 == c)
						c = -1;
					else
						j = -1;
				}
			}

			if (fail)
				System.out.println("Case #" + t + ": " + "IMPOSSIBLE");
			else
				System.out.println("Case #" + t + ": " + ans);
		}

		in.close();
	}
}