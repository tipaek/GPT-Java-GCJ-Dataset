

import java.util.*;

/**
 * Made and solved successfully by the Prodigy Programmer
 * @author Julian Paniagua
 */
public class Solution {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int testCases = scanner.nextInt();
		for (int t = 1; t <= testCases; t++) {
			int numberOfActivities = scanner.nextInt();
			Activity[] activities = new Activity[numberOfActivities];
			int activitiesLeft = numberOfActivities;
			int start = 0;
			int end = 0;
			char[] charset = new char[numberOfActivities];
			for (int i = 0; i < numberOfActivities; i++) {
				int nextStart = scanner.nextInt();
				int nextEnd = scanner.nextInt();
				activities[i] = new Activity(nextStart, nextEnd);
				if (i == 0 || nextStart >= end || nextEnd <= start) {
					activities[i].assignedTo = 'C';
					charset[i] = 'C';
					start = nextStart;
					end = nextEnd;
					activitiesLeft--;
				}
			}
			start = 0;
			end = 0;
			for (int i = 1; i < numberOfActivities; i++) {
				Activity next = activities[i];
				if (((start == 0 && end == 0) || next.startMinute >= end || next.endMinute <= start) && next.assignedTo != 'C') {
					start = next.startMinute;
					end = next.endMinute;
					//activities[i].assignedTo = 'J';
					charset[i] = 'J';
					activitiesLeft--;
				}
			}
			System.out.print("Case #" + t + ": ");
			if (activitiesLeft > 0) {
				System.out.println("IMPOSSIBLE");
			} else {
				System.out.println(charset);
			}
		}
	}

	public static class Activity {
		public final int startMinute;
		public final int endMinute;
		public char assignedTo;

		public Activity(int start, int end) {
			startMinute = start;
			endMinute = end;
		}
	}

}