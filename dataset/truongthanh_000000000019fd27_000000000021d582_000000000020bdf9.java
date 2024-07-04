import java.util.*;
import java.io.*;
public class Solution {
	static boolean debug = false;

	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
		for (int i = 1; i <= t; ++i) {
			int n = in.nextInt();
			TreeSet<Interval> pq = new TreeSet<>((a, b) -> a.start - b.start);
			for (int j = 0; j < n; j++) {
				pq.add(new Interval(in.nextInt(), in.nextInt(), j));
			}
			System.out.println("Case #" + i + ": " + compute(n, pq));
		}
	}

	public static String compute(int n, TreeSet<Interval> pq) {
		char[] res = new char[n];
		int prevEnd = 0;
		while (!pq.isEmpty()) {
			Interval cur = pq.ceiling(new Interval(prevEnd, -1, -1));
			if (cur == null) break;
			pq.remove(cur);
			res[cur.idx] = 'C';
			prevEnd = cur.end;
		}
		prevEnd = 0;
		while (!pq.isEmpty()) {
			Interval cur = pq.ceiling(new Interval(prevEnd, -1, -1));
			if (cur == null) break;
			pq.remove(cur);
			res[cur.idx] = 'J';
			prevEnd = cur.end;
		}
		if (pq.isEmpty()) {
			return new String(res);
		} else {
			// if (debug) {
			// 	System.out.println(Arrays.toString(res));
			// }
			return "IMPOSSIBLE";
		}
	}
}

class Interval {
	int start, end, idx;
	Interval (int s, int e, int i) {
		start = s;
		end = e;
		idx = i;
	}
}