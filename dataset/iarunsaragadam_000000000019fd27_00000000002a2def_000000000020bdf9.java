import java.util.*;
import java.util.Map.Entry;
import java.io.*;

public class Solution {
	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int T = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.

		
		for (int t = 1; t <= T; ++t) {
			Map<Interval, String> ansMap = new LinkedHashMap<>();
			PriorityQueue<Interval> cHeap = new PriorityQueue<Solution.Interval>(Interval.endComparator());
			PriorityQueue<Interval> jHeap = new PriorityQueue<Solution.Interval>(Interval.endComparator());
			List<Interval> intervals = new ArrayList<>();
			
			int N = in.nextInt();
			for (int n = 0; n < N; n++) {
				int s = in.nextInt();
				int e = in.nextInt();
				Interval intv = new Interval(s, e);
				intervals.add(intv);
				Collections.sort(intervals);
			}

			String answer = "IMPOSSIBLE";
			try {
				for (Interval intv : intervals) {
					processInterval(intv, ansMap, cHeap, jHeap);
				}
				answer = buildAnswer(ansMap);
			} catch (Exception e1) {
			}

			
			System.out.println("Case #" + t + ": " + answer);

		}

	}

	private static String buildAnswer(Map<Interval, String> ansMap) {
		StringBuilder sb = new StringBuilder();
		for (Entry<Interval, String> entry : ansMap.entrySet())
			sb.append(entry.getValue());

		return sb.toString();
	}

	private static void processInterval(Interval intv, Map<Interval, String> ansMap, PriorityQueue<Interval> cHeap,
			PriorityQueue<Interval> jHeap) throws Exception {
		if (cHeap.isEmpty()) {
			cHeap.add(intv);
			ansMap.put(intv, "C");
			return;
		}

		if (jHeap.isEmpty()) {
			jHeap.add(intv);
			ansMap.put(intv, "J");
			return;
		}

		if (cHeap.peek().overlaps(intv) && jHeap.peek().overlaps(intv)) {
			throw new Exception("Impossible");
		}

		if (!cHeap.peek().overlaps(intv)) {
			cHeap.add(intv);
			ansMap.put(intv, "C");
			return;
		}

		jHeap.add(intv);
		ansMap.put(intv, "J");
		return;

	}

	static class Interval implements Comparable<Interval> {
		private int start;
		private int end;

		public Interval(int start, int end) {
			this.start = start;
			this.end = end;
		}

		@Override
		public int compareTo(Interval that) {
			if (this.start != that.start)
				return this.start - that.start;

			return this.end - that.end;
		}

		public boolean overlaps(Interval that) {
			if (this.end <= that.start)
				return false;

			if (that.end <= this.start)
				return false;

			return true;
		}

		private static Comparator<Interval> END_COMPARATOR = new Comparator<Solution.Interval>() {

			@Override
			public int compare(Interval i1, Interval i2) {
				if (i1.end != i2.end)
					return i1.end - i2.end;

				return i1.start - i2.start;
			}
		};

		public static Comparator<Interval> endComparator() {
			return END_COMPARATOR;
		}
	}
}