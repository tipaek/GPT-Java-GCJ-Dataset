import java.util.*;
import java.io.*;
import java.util.stream.Collectors;

//javac Solution2.java
//python interactive_runner.py python.exe testing_tool.py 0 -- java Solution2
//change name before submit

public class Solution {

	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);
		int T = input.nextInt();
		for (int i = 1; i <= T; i++) {
			List<Time> times = new LinkedList<>();
			int b = input.nextInt();
			for (int ii = 0; ii < b; ii++) {
				int start = input.nextInt();
				int end = input.nextInt();
				times.add(new Time(ii, start, end));
			}
			Collections.sort(times);
			boolean j = false;
			boolean c = false;
			int jEnd = -1;
			int cEnd = -1;
			boolean ok = true;
			for (int ii = 0; ii < b; ii++) {
				if (c && cEnd <= times.get(ii).start) {
					c = false;
				}
				if (j && jEnd <= times.get(ii).start) {
					j = false;
				}
				if (!j) {
					jEnd = times.get(ii).end;
					times.get(ii).c = 'J';
					j = true;
				} else if (!c) {
					cEnd = times.get(ii).end;
					c = true;
					times.get(ii).c = 'C';
				} else {
					ok = false;
					break;
				}
			}
			if (ok) {
				times.sort(Comparator.comparingInt(o -> o.pos));
				StringBuilder res = new StringBuilder("");
				for (int ii = 0; ii < b; ii++) {
					res.append(times.get(ii).c);
				}
				System.out.println("Case #" + i + ": " + res.toString());
			} else {
				System.out.println("Case #" + i + ": IMPOSSIBLE");
			}
		}
	}

	private static class Time implements Comparable<Time> {
		private int pos;
		private int start;
		private int end;
		private Character c;

		public Time(int pos, int start, int end) {
			this.pos = pos;
			this.start = start;
			this.end = end;
		}

		@Override
		public int compareTo(Time o) {
			if (this.start == o.start) {
				return this.end - o.end;
			}
			return this.start - o.start;
		}
	}
}