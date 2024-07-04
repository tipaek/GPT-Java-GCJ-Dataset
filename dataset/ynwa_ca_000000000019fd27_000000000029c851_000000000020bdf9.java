
import java.util.*;
import java.io.*;

public class Solution {
	private static boolean debug = false;

	static Solution _instance = new Solution();

	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int testCases = in.nextInt();
		if (debug) System.out.println("testCases: " + testCases);
		for (int testCase = 1; testCase <= testCases; testCase++) {
			if (debug) System.out.println("starting case: " + testCase);
			StringBuilder result = new StringBuilder();
			int numberOfActivities = in.nextInt();
			if (debug) System.out.println("number of activities: " + numberOfActivities);
			Partner cameron = _instance.new Partner();
			Partner jamie = _instance.new Partner();
			boolean impossible = false;
			for (int i = 1; i <= numberOfActivities; i++) {
				Assignment assignment = _instance.new Assignment(in.nextInt(), in.nextInt());
				if (debug) System.out.println("read assignment " + i + " - [" + assignment + "]");
				if (!impossible) {
					if (cameron.isAvailable(assignment)) {
						if (debug) System.out.println("assign to cam");
						result.append("C");
						cameron.addAssignment(assignment);
					} else if (jamie.isAvailable(assignment)) {
						if (debug) System.out.println("assign to jamie");
						result.append("J");
						jamie.addAssignment(assignment);
					} else {
						if (debug) System.out.println("impossible!");
						result = new StringBuilder("IMPOSSIBLE");
						cameron.assignments.clear();
						jamie.assignments.clear();
						impossible = true;
					}
				} else {
					if (debug) System.out.println("skipped assignment");
				}
				if (debug) System.out.println("cameron " + cameron);
				if (debug) System.out.println("jamie " + jamie);
			}
			if (debug) System.out.println("activities: " + numberOfActivities + " results: " + result.length());
			System.out.println("Case #" + testCase + ": " + result.toString());
		}
		System.out.flush();
	}

	public class Assignment {
		private int start;
		private int end;

		Assignment(int start, int end) {
			this.start = start;
			this.end = end;
		}

		boolean isOverlap(Assignment other) {
			return Math.max(this.start, other.start) < Math.min(this.end, other.end);
			//return this.start < other.end && other.start < this.end;
		}
		
		boolean isValid() {
			return start >= 0 && start < end && end <= (24 * 60); 
		}
		
		public String toString() {
			return "start " + start + " end " + end;
		}
	}

	public class Partner {
		private List<Assignment> assignments = new ArrayList<>();

		void addAssignment(Assignment assignment) {
			this.assignments.add(assignment);
		}

		boolean isAvailable(Assignment assignment) {
			for (Assignment currAssignment : assignments) {
				if (assignment.isOverlap(currAssignment)) {
					return false;
				}
			}
			return true;
		}
		
		public String toString() {
			StringBuilder output = new StringBuilder();
			assignments.stream().forEach(assignment->output.append("\n\tassignment-[" + assignment + "]"));
			return output.toString(); 
		}
	}
}
