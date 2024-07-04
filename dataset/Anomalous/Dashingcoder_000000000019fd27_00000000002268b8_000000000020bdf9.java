import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

class Interval implements Comparable<Interval> {
	private int start;
	private int end;

	public Interval(int start, int end) {
		this.start = start;
		this.end = end;
	}

	public int getEnd() {
		return end;
	}

	public void setEnd(int end) {
		this.end = end;
	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	@Override
	public int compareTo(Interval other) {
		return Integer.compare(this.start, other.start);
	}
}

public class Solution {

	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static PrintWriter pw = new PrintWriter(System.out, false);

	public static void main(String[] args) throws Exception {
		int testCases = Integer.parseInt(br.readLine());
		for (int t = 1; t <= testCases; t++) {
			int numIntervals = Integer.parseInt(br.readLine());
			List<Interval> intervals = new ArrayList<>(numIntervals);
			for (int i = 0; i < numIntervals; i++) {
				StringTokenizer tokenizer = new StringTokenizer(br.readLine(), " ");
				int start = Integer.parseInt(tokenizer.nextToken());
				int end = Integer.parseInt(tokenizer.nextToken());
				intervals.add(new Interval(start, end));
			}
			Collections.sort(intervals);
			StringBuilder schedule = new StringBuilder();
			Interval cJob = null;
			Interval jJob = null;
			boolean impossible = false;
			for (Interval interval : intervals) {
				if (cJob == null || cJob.getEnd() <= interval.getStart()) {
					cJob = interval;
					schedule.append("C");
				} else if (jJob == null || jJob.getEnd() <= interval.getStart()) {
					jJob = interval;
					schedule.append("J");
				} else {
					impossible = true;
					break;
				}
			}
			if (impossible) {
				pw.println("Case #" + t + ": IMPOSSIBLE");
			} else {
				pw.println("Case #" + t + ": " + schedule.toString());
			}
		}
		pw.flush();
	}
}