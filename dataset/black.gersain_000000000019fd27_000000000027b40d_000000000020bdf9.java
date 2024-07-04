import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int T = scanner.nextInt();
		scanner.nextLine();
		for (int i = 0; i < T; i++) {
			int N = scanner.nextInt();
			scanner.nextLine();
			
			Interval[] intervals = new Interval[N];
			for (int j = 0; j < N; j++) {
				intervals[j] = new Interval(j, scanner.nextInt(), scanner.nextInt());
				scanner.nextLine();
			}
			
			System.out.println("Case #" + (i + 1) + ": " + schedule(intervals));
		}
		scanner.close();
	}
	
	public static String schedule(Interval[] intervals) {
		Arrays.sort(intervals, new Comparator<Interval>() {
			@Override
			public int compare(Interval o1, Interval o2) {
				return o1.getStart() - o2.getStart();
			}
		});
		
		Interval cameronActivity = new Interval();
		Interval jamieActivity = new Interval();
		
		cameronActivity = intervals[0];
		cameronActivity.setExecutor("C");
		for (int i = 1; i < intervals.length; i++) {
			if (!overlaps(cameronActivity, intervals[i])) {
				cameronActivity = intervals[i];
				cameronActivity.setExecutor("C");
			}
			else if (!overlaps(jamieActivity, intervals[i])) {
				jamieActivity = intervals[i];
				jamieActivity.setExecutor("J");
			}
			else {
				return "IMPOSSIBLE";
			}
		}
		
		Arrays.sort(intervals, new Comparator<Interval>() {
			@Override
			public int compare(Interval o1, Interval o2) {
				return o1.getSequence() - o2.getSequence();
			}
		});
		
		String schedule = "";
		for (int i = 0; i < intervals.length; i++) {
			schedule += intervals[i].getExecutor();
		}
		return schedule;
	}
	
	public static boolean overlaps(Interval i1, Interval i2) {
		Interval overlap = new Interval();
		overlap.setStart(Math.max(i1.getStart(), i2.getStart()));
		overlap.setEnd(Math.min(i1.getEnd(), i2.getEnd()));
		
		if (overlap.getStart() < overlap.getEnd()) return true;
		else return false;
	}
	
}

class Interval {
	
	private int start;
	private int end;
	private String executor;
	private int sequence;
	
	public Interval() {
		start = 0;
		end = 0;
	}
	
	public Interval(int start, int end) {
		this.start = start;
		this.end = end;
	}
	
	public Interval(int sequence, int start, int end) {
		this.sequence = sequence;
		this.start = start;
		this.end = end;
	}
	
	public int getStart() {
		return start;
	}
	
	public void setStart(int start) {
		this.start = start;
	}
	
	public int getEnd() {
		return end;
	}
	
	public void setEnd(int end) {
		this.end = end;
	}
	
	public String getExecutor() {
		return executor;
	}

	public void setExecutor(String executor) {
		this.executor = executor;
	}

	public int getSequence() {
		return sequence;
	}

	public void setSequence(int sequence) {
		this.sequence = sequence;
	}
}
