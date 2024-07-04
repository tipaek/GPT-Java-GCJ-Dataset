
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
			Partner cameron = _instance.new Partner("C");
			Partner jamie = _instance.new Partner("J");
			boolean impossible = false;
			for (int i = 0; i < numberOfActivities; i++) {
				Assignment assignment = _instance.new Assignment(in.nextInt(), in.nextInt());
				if (debug) System.out.println("read assignment-[" + assignment + "]");
				if (!impossible) {
					if (cameron.isAvailable(assignment)) {
						result.append(cameron.name);
						cameron.addAssignment(assignment);
					} else if (jamie.isAvailable(assignment)) {
						result.append(jamie.name);
						jamie.addAssignment(assignment);
					} else {
						result = new StringBuilder("IMPOSSIBLE");
						impossible = true;
					}
				} else {
					if (debug) System.out.println("skiped assignment");
				}
			}
			System.out.println("Case #" + testCase + ": " + result);
		}
	}

	public class Assignment {
		private int start;
		private int end;

		Assignment(int start, int end) {
			this.start = start;
			this.end = end;
		}

		boolean isOverlap(Assignment other) {
			boolean result = false;
			if (other.start > this.end) {
				result = false;
			} else if (other.end < this.start) {
				result = false;
			} else if (other.start >= this.start && other.start < this.end) {
				result = true;
			} else if (other.end > this.start && other.end < this.end) {
				result = true;
			}
			if (debug)
				System.out.println("this [" + this + "] other [" + other + "] overlap [" + result + "]");
			return result;
		}

		public String toString() {
			return "start " + start + " end " + end;
		}
	}

	public class Partner {
		private String name;
		private List<Assignment> assignments = new ArrayList<>();

		Partner(String name) {
			this.name = name;
		}

		void addAssignment(Assignment assignment) {
			this.assignments.add(assignment);
		}

		boolean isAvailable(Assignment assignment) {
			for (Assignment currAssignment : assignments) {
				if (currAssignment.isOverlap(assignment)) {
					return false;
				}
			}
			return true;
		}
	}
}
