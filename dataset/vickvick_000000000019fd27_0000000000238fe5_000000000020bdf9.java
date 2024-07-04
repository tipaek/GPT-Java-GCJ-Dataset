
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Solution {
	public static void main(String[] args) {
		Scanner scan = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		long t = scan.nextInt();
		for (long it = 1; it <= t; ++it) {
			int n = scan.nextInt();
			Pair[] pairs = new Pair[n];
			for (int in = 0; in < n; ++in) {
				int t1 = scan.nextInt();
				int t2 = scan.nextInt();
				Pair pair = new Pair(t1, t2);
				pair.i = in;
				pairs[in] = pair;
			}
			String res = cal(pairs);
			System.out.println("Case #" + it + ": " + res);
		}
		scan.close();
	}

	private static class Pair {
		int t1, t2;
		int i;

		public Pair(int t1, int t2) {
			super();
			this.t1 = t1;
			this.t2 = t2;
		}

		@Override
		public String toString() {
			return "[t1=" + t1 + ", t2=" + t2 + "]";
		}

	}

	private static String cal(Pair[] times) {
		int len = times.length;
		Arrays.sort(times, new Comparator<Pair>() {
			@Override
			public int compare(Pair o1, Pair o2) {
				int c = Integer.compare(o1.t1, o2.t1);
				if (c != 0)
					return c;
				return Integer.compare(o1.t2, o2.t2);
			}
		});
		String kon[] = new String[len];
		int lastA = 0, lastB = 0;
		for (int i = 0; i < len; ++i) {
			if (times[i].t1 >= lastA) {
				// a do it
				lastA = times[i].t2;
				kon[times[i].i] = "C";
			} else if (times[i].t1 >= lastB) {
				// a do it
				lastB = times[i].t2;
				kon[times[i].i] = "J";
			} else {
				return "IMPOSSIBLE";
			}
		}

		return Stream.of(kon).collect(Collectors.joining());
	}

}