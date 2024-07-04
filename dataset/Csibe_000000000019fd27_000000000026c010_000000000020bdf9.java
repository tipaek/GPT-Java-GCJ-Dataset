import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class Solution {
	
	static class Interval implements Comparable<Interval> {
		private int begin;
		private int end;
		private int index;
		
		Interval(int begin, int end, int index) {
			this.begin = begin;
			this.end = end;
			this.index = index;
		}
		
		@Override
		public int compareTo(Interval other) {
			if (other.begin == this.begin) {
				return 0;
			}
			else if (this.begin < other.begin) {
				return -1; 
			} 
			else {
				return 1;
			}
		}
		
		public boolean overlap(Interval other) {
			if (this.begin < other.begin && this.end > other.begin) {
				return true;
			}
			if (other.begin < this.begin && other.end > this.begin) {
				return true;
			}
			return false;
		}
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
		in.nextLine();
		for (int i = 1; i <= t; ++i) {
			int n = in.nextInt();
			LinkedList<Interval> jamie = new LinkedList<>();
			LinkedList<Interval> cameron = new LinkedList<>();

			Interval[] intervals = new Interval[n];
			for (int j = 0; j < n; j++) {
				int begin = in.nextInt();
				int end = in.nextInt();
				Interval interval = new Interval(begin, end, j);
				intervals[j] = interval;
			}
			
			Arrays.parallelSort(intervals);
			
			boolean impossible = false;
			
			for (Interval interval : intervals) {
				if (jamie.isEmpty()) {
					jamie.add(interval);
					continue;
				}
				
				Interval jamieLast = jamie.getLast();
				if (!jamieLast.overlap(interval)) {
					// Jamie can take it, so take it
					jamie.add(interval);
					continue;
				}
				// Jamie cannot take it. Try cameron
				if (cameron.isEmpty()) {
					// Cameron has no tasks
					cameron.add(interval);
					continue;
				}

				// Cameron can take it
				if (!cameron.getLast().overlap(interval)) {
					cameron.add(interval);
					continue;
				}

				// Cameron cannot take it either.
				impossible = true;
				break;
			}
			
			if (impossible) {
				System.out.println("Case #" + i + ": IMPOSSIBLE");
			}
			else {
				String[] output = new String[n];
				for (Interval interval : jamie) {
					output[interval.index] = "J";
				}
				for (Interval interval : cameron) {
					output[interval.index] = "C";
				}
				
				StringBuffer sb = new StringBuffer();
				for (String string : output) {
					sb.append(string);
				}
				System.out.println("Case #" + i + ": " + sb.toString());
			}
		}
	}	
}