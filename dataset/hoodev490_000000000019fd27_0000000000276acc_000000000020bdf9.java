import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;


public class Solution {

	public static class Interval {
		int start; 
		int end;
		int index;
		
		public Interval(int start, int end, int index) {
			this.start = start;
			this.end = end;
			this.index = index;
		}

		@Override
		public String toString() {
			return "Interval [start=" + start + ", end=" + end + "]";
		}
	}
	
	public static void main(String[] args) {
		try (Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
			int t = in.nextInt();

			for (int i = 0; i < t; i++) {
				int tasks = in.nextInt();
				List<Interval> intervals = new ArrayList<>();
				for (int j = 0; j < tasks; j++) {
					int start = in.nextInt();
					int end = in.nextInt();
					intervals.add(new Interval(start, end, j));
				}
				solve(intervals, i + 1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.exit(0);
	}

	private static void solve(List<Interval> intervals, int testcase) {
		StringBuffer result = new StringBuffer();
		result.setLength(intervals.size());
		
		Collections.sort(intervals, (x, y) -> {
			if (x.start == y.start) {
				return x.end - y.end;
			}
			return x.start - y.start;
		});
		
		int c = 0;
		int j = 0;
		for (int i = 0; i < intervals.size(); i++) {
			Interval interval = intervals.get(i);
			if (interval.start >= c) {
				result.setCharAt(interval.index, 'C');
				c = interval.end;
			} else if (interval.start >= j) {
				result.setCharAt(interval.index, 'J');
				j = interval.end;
			} else {
				result = new StringBuffer("IMPOSSIBLE");
				break;
			}
		}
		
		System.out.println(String.format("Case #%d: %s", testcase, result.toString()));
	}

}