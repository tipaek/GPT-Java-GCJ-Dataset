
import java.util.*;
import java.io.*;

public class Solution {

	static Solution _instance = new Solution();

	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int testCases = in.nextInt();
		for (int testCase = 1; testCase <= testCases; testCase++) {
			StringBuilder result = new StringBuilder();
			int numberOfActivities = in.nextInt();
			Parent cameron = _instance.new Parent();
			Parent jamie = _instance.new Parent();
			boolean impossible = false;
			for (int i = 1; i <= numberOfActivities; i++) {
				Assignment assignment = _instance.new Assignment(in.nextInt(), in.nextInt());
				if (!impossible) {
					if (cameron.isAvailable(assignment)) {
						result.append("C");
						cameron.addAssignment(assignment);
					} else if (jamie.isAvailable(assignment)) {
						result.append("J");
						jamie.addAssignment(assignment);
					} else {
						result = new StringBuilder("IMPOSSIBLE");
						impossible = true;
					}
				}
			}
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
		}
		
	}

	public class Parent {
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
		
	}
}
