import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		int numberOfCases = Integer.parseInt(in.readLine().trim());

		for (int i = 0; i < numberOfCases; i++) {
			int N = Integer.parseInt(in.readLine().trim());

			PriorityQueue<Interval> intervals = new PriorityQueue<C.Interval>();

			for (int j = 0; j < N; j++) {
				StringTokenizer skt = new StringTokenizer(in.readLine());
				intervals.add(new Interval(Integer.parseInt(skt.nextToken()), Integer.parseInt(skt.nextToken()), j));
			}
			char[] result = new char[N];
			boolean imposible = false;
			Interval J = null;
			Interval C = null;

			while (!intervals.isEmpty() && !imposible) {
				if (J == null) {
					J = intervals.poll();
					result[J.original] = 'J';
				} else if (C == null) {
					C = intervals.poll();
					result[C.original] = 'C';
				} else {
					Interval actual = intervals.poll();
					if (J.end < C.end) {
						if (J.end <= actual.start) {
							J = actual;
							result[J.original] = 'J';
						} else {
							imposible = true;
						}
					} else {
						if (C.end <= actual.start) {
							C = actual;
							result[C.original] = 'C';
						} else {
							imposible = true;
						}
					}
				}
			}

			String resultString = new String(result);

			if (!imposible)
				out.write("Case #" + (i + 1) + ": " + resultString + "\n");
			else
				out.write("Case #" + (i + 1) + ": IMPOSSIBLE\n");
		}
		out.close();

	}

	static class Interval implements Comparable<Interval> {
		int start;
		int end;
		int original;

		public Interval(int s, int e, int o) {
			// TODO Auto-generated constructor stub
			start = s;
			end = e;
			original = o;
		}

		@Override
		public int compareTo(Interval o) {
			if (start == o.start) {
				return end - o.end;
			}
			return start - o.start;
		}

	}

}
