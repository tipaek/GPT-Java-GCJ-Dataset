import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt();
		for (int i = 1; i <= t; i++) {
			int activities = in.nextInt();
			List<Time> lines = new ArrayList<>();
			boolean impossible = false;
			for (int k = 0; k < activities; k++) {
				int start = in.nextInt();
				int end = in.nextInt();
				lines.add(new Time(start, end));
				if (end < start) {
					impossible = true;
				}
				
				if (activities > 1 && ((end-start) >=1440)) {
					impossible = true;
				}
			}
			
			if (impossible) {
				System.out.println("Case #" + i + ": IMPOSSIBLE");
			}else {
				System.out.println("Case #" + i + ": " + solve(activities, lines));
			}
		}
	}

	private static String solve(int activities, List<Time> lines) {
		boolean hasOverlap = false;
//		Collections.sort(lines);
		List<Integer> cList = new ArrayList<>(1440);
		List<Integer> jList = new ArrayList<>(1440);
		
		for (int i = 0; i < 1440; i++) {
			cList.add(0);
			jList.add(0);
		}
		boolean impossible = false;
		String result = "";
		for (Time line : lines) {
//			System.out.println(line);
			boolean cFail = false;
			boolean jFail = false;
			for (int i = line.getStart(); i < line.getEnd(); i++) {
				if (cList.get(i) > 0) {
					cFail = true;
					break;
				}
			}
			if (!cFail) {
				for (int i = line.getStart(); i < line.getEnd(); i++) {
					cList.set(i, 1);
				}
				result += "C";
			} else {
				for (int i = line.getStart(); i < line.getEnd(); i++) {
					if (jList.get(i) > 0) {
						jFail = true;
						break;
					}
				}
				if (!jFail) {
					for (int i = line.getStart(); i < line.getEnd(); i++) {
						jList.set(i, 1);
					}
					result += "J";
				}
			}
			
			if (cFail && jFail) {
				impossible = true;
			}
		}
		if (impossible) {
			return "IMPOSSIBLE";
		}
		
		return result;
	}

	public static class Time implements Comparable<Time>{
		Integer start;
		Integer end;
		
		@Override
		public String toString() {
			return "Time [start=" + start + ", end=" + end + "]";
		}

		public Time(Integer start, Integer end) {
			super();
			this.start = start;
			this.end = end;
		}

		public Integer getStart() {
			return start;
		}

		public void setStart(Integer start) {
			this.start = start;
		}

		public Integer getEnd() {
			return end;
		}

		public void setEnd(Integer end) {
			this.end = end;
		}

		@Override
		public int compareTo(Time o) {
			int t = this.getStart().compareTo(o.getStart());
			return t == 0 ? this.getEnd().compareTo(o.getEnd()) : t;
		}

	}
}
