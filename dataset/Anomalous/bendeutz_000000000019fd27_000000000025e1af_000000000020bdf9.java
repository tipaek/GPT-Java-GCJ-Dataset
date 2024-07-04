import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Scanner;

public class Solution {
	private static boolean switched = false;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int numberOfCases = scanner.nextInt();

		for (int caseIndex = 0; caseIndex < numberOfCases; caseIndex++) {
			int activitiesCount = scanner.nextInt();
			int[][] activitySchedule = new int[activitiesCount][2];

			for (int activityIndex = 0; activityIndex < activitiesCount; activityIndex++) {
				activitySchedule[activityIndex][0] = scanner.nextInt();
				activitySchedule[activityIndex][1] = scanner.nextInt();
			}

			String solution = assignActivities(activitySchedule);
			System.out.println("Case #" + (caseIndex + 1) + ": " + solution);
		}
		scanner.close();
	}

	private static String assignActivities(int[][] activitySchedule) {
		StringBuilder solution = new StringBuilder();
		LinkedList<Integer> activitiesC = new LinkedList<>();
		LinkedList<Integer> activitiesJ = new LinkedList<>();

		String currentPerson = "C";
		solution.append(currentPerson);
		activitiesC.add(0);

		for (int activityIndex = 1; activityIndex < activitySchedule.length; activityIndex++) {
			switched = false;

			if (activitiesJ.isEmpty()) {
				if (!checkOverlap(activitySchedule[activityIndex - 1], activitySchedule[activityIndex])) {
					solution.append(currentPerson);
					activitiesC.add(activityIndex);
				} else {
					currentPerson = "J";
					solution.append(currentPerson);
					activitiesJ.add(activityIndex);
				}
			} else {
				if (!checkOverlaps(activitiesC, activitySchedule, activityIndex)) {
					currentPerson = "C";
					solution.append(currentPerson);
					activitiesC.add(activityIndex);
				} else if (!checkOverlaps(activitiesJ, activitySchedule, activityIndex)) {
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

	private static boolean checkOverlaps(LinkedList<Integer> activities, int[][] activitySchedule, int currentIndex) {
		for (Integer activity : activities) {
			switched = false;
			if (checkOverlap(activitySchedule[activity], activitySchedule[currentIndex])) {
				return true;
			}
		}
		return false;
	}

	private static boolean checkOverlap(int[] activityA, int[] activityB) {
		if (activityA[0] <= activityB[0] && activityA[1] > activityB[0]) {
			return true;
		} else if (activityB[0] <= activityA[0] && activityB[1] > activityA[0]) {
			return true;
		} else if (!switched) {
			switched = true;
			return checkOverlap(activityB, activityA);
		}
		return false;
	}
}