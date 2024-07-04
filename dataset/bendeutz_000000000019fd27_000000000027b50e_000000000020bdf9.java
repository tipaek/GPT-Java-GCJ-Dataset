import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.TreeMap;

public class Solution {
	private static boolean switched = false;

	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int numberOfCases = in.nextInt();
		for (int i = 0; i < numberOfCases; i++) {
			boolean brokenCase = false;
			int caseNumber = i + 1;
			int activities = in.nextInt();
			char[] solution = new char[activities];
			HashMap<TimeSlot, Integer> activitiesMap = new HashMap<>();
			for (int j = 0; j < activities; j++) {
				activitiesMap.put(new TimeSlot(in.nextInt(), in.nextInt()), j);
			}
			TreeMap<TimeSlot, Integer> sortedActivities = new TreeMap<>(activitiesMap);

			List<TimeSlot> timeSlotList = new LinkedList<TimeSlot>();
			timeSlotList.addAll(sortedActivities.keySet());

			List<Integer> indexList = new LinkedList<Integer>();
			indexList.addAll(sortedActivities.values());

			int lastActivityC = 0;
			int lastActivityJ = 0;
			char actualPerson = 'C';
			solution[indexList.get(0)] = actualPerson;
			for (int j = 1; j < activities; j++) {
				if (lastActivityJ == 0) { // C is working alone
					if (!timeSlotList.get(j).overlap(timeSlotList.get(j - 1), false)) {
						solution[indexList.get(j)] = actualPerson;
						lastActivityC = j;
					} else {
						actualPerson = 'J';
						solution[indexList.get(j)] = actualPerson;
						lastActivityJ = j;
					}
				} else {
					if (!timeSlotList.get(j).overlap(timeSlotList.get(lastActivityC), false)) {
						actualPerson = 'C';
						solution[indexList.get(j)] = actualPerson;
						lastActivityC = j;
					} else if (!timeSlotList.get(j).overlap(timeSlotList.get(lastActivityJ), false)) {
						actualPerson = 'J';
						solution[indexList.get(j)] = actualPerson;
						lastActivityJ = j;
					} else {
						brokenCase = true;
						break;
					}
				}
			}
			if (brokenCase) {
				System.out.println("Case #" + caseNumber + ": " + "IMPOSSIBLE");
			} else {
				System.out.println("Case #" + caseNumber + ": " + new String(solution));
			}
		}
	}

	static class TimeSlot implements Comparable<TimeSlot> {
		private int startTime;
		private int endTime;

		public TimeSlot(int start, int end) {
			this.startTime = start;
			this.endTime = end;
		}

		public int getStartTime() {
			return startTime;
		}

		public int getEndTime() {
			return endTime;
		}

		public boolean overlap(TimeSlot other, boolean switched) {
			if (other.getStartTime() >= this.endTime) {
				return false;
			} else if (other.getEndTime() <= this.startTime) {
				return false;
			} else if (!switched) {
				return other.overlap(this, true);
			}
			return true;
		}

		public String toString() {
			return startTime + " " + endTime;
		}

		@Override
		public int compareTo(TimeSlot other) {
			return Integer.compare(this.startTime, other.getStartTime());
		}
	}
}
