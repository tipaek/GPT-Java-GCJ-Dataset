import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
	private static boolean switched = false;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int numberOfCases = scanner.nextInt();
		for (int caseIndex = 0; caseIndex < numberOfCases; caseIndex++) {
			int caseNumber = caseIndex + 1;
			int numberOfActivities = scanner.nextInt();
			int[][] activitySchedule = new int[numberOfActivities][2];
			for (int activityIndex = 0; activityIndex < numberOfActivities; activityIndex++) {
				activitySchedule[activityIndex][0] = scanner.nextInt();
				activitySchedule[activityIndex][1] = scanner.nextInt();
			}

			String result = scheduleActivities(activitySchedule);
			System.out.println("Case #" + caseNumber + ": " + result);
		}
	}

	private static String scheduleActivities(int[][] activitySchedule) {
		StringBuilder solution = new StringBuilder();
		String currentPerson = "C";
		solution.append(currentPerson);

		List<Integer> activitiesC = new ArrayList<>();
		List<Integer> activitiesJ = new ArrayList<>();
		activitiesC.add(0);

		for (int activityIndex = 1; activityIndex < activitySchedule.length; activityIndex++) {
			switched = false;
			if (activitiesJ.isEmpty()) {
				if (!hasOverlap(activitySchedule[activityIndex - 1], activitySchedule[activityIndex])) {
					solution.append(currentPerson);
					activitiesC.add(activityIndex);
				} else {
					currentPerson = "J";
					solution.append(currentPerson);
					activitiesJ.add(activityIndex);
				}
			} else {
				if (!hasConflicts(activitiesC, activitySchedule, activityIndex)) {
					currentPerson = "C";
					solution.append(currentPerson);
					activitiesC.add(activityIndex);
				} else if (!hasConflicts(activitiesJ, activitySchedule, activityIndex)) {
					currentPerson = "J";
					solution.append(currentPerson);
					activitiesJ.add(activityIndex);
				} else {
					return "IMPOSSIBLE";
				}
			}
		}
		return solution.toString();
	}

	private static boolean hasConflicts(List<Integer> activities, int[][] activitySchedule, int currentIndex) {
		for (Integer index : activities) {
			switched = false;
			if (hasOverlap(activitySchedule[index], activitySchedule[currentIndex])) {
				return true;
			}
		}
		return false;
	}

	private static boolean hasOverlap(int[] activityA, int[] activityB) {
		int startA = activityA[0];
		int endA = activityA[1];
		int startB = activityB[0];
		int endB = activityB[1];
		if (startB >= endA || endB <= startA) {
			return false;
		} else if (!switched) {
			switched = true;
			return hasOverlap(activityB, activityA);
		}
		return true;
	}
}