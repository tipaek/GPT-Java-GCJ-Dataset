import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Scanner;

public class Solution {
	private static boolean switched = false;

	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int numberOfCases = in.nextInt();
		for (int i = 0; i < numberOfCases; i++) {
			String solution = "";
			int caseNumber = i + 1;
			int activities = in.nextInt();
			int[][] activitySchedule = new int[activities][2];
			for (int j = 0; j < activities; j++) {
				activitySchedule[j][0] = in.nextInt();
				activitySchedule[j][1] = in.nextInt();
			}
			String actualPerson = "C";
			solution += actualPerson;
			LinkedList<Integer> activitiesC = new LinkedList<>();
			LinkedList<Integer> activitiesJ = new LinkedList<>();
			activitiesC.add(0);
			for (int j = 1; j < activitySchedule.length; j++) {
				switched = false;
				if (activitiesJ.size() == 0) { // aka J did'nt do anything yet
					if (!checkOverlap(activitySchedule[j - 1], activitySchedule[j])) { // C is working alone
						solution += actualPerson;
						activitiesC.add(j);
					} else { // first job of J
						actualPerson = "J";
						solution += actualPerson;
						activitiesJ.add(j);
					}
				} else { // both did something
					if (!checkOverlaps(activitiesC, activitySchedule, j)) {
						actualPerson = "C";
						solution += actualPerson;
						activitiesC.add(j);
					} else if (!checkOverlaps(activitiesJ, activitySchedule, j)) {
						actualPerson = "J";
						solution += actualPerson;
						activitiesJ.add(j);
					} else {
						solution = "IMPOSSIBLE";
						break;
					}
				}
			}
			System.out.println("Case #" + caseNumber + ": " + solution);
		}
	}

	private static boolean checkOverlaps(LinkedList<Integer> activities, int[][] activitySchedule, int j) {
		boolean result = false;
		for (Integer activity : activities) {
			switched = false;
			result = result || checkOverlap(activitySchedule[activity], activitySchedule[j]);
		}
		return result;
	}

	private static boolean checkOverlap(int[] activityA, int[] activityB) {
		int AS = activityA[0];
		int AE = activityA[1];
		int BS = activityB[0];
		int BE = activityB[1];
		if(BS >= AE) {
			return false;
		} else if(BE<=AS) {
			return false;
		} else if (!switched) {
			switched = true;
			return checkOverlap(activityB, activityA);
		}
		return true;
	}
	
	

//	private static boolean checkOverlap(int[] activityA, int[] activityB) {
//		int startA = activityA[0];
//		int endA = activityA[1];
//		int startB = activityB[0];
//		int endB = activityB[1];
//		if (startB >= startA && startB < endA) {
//			return true;
//		} else if (startB <= startA && endB > startA) {
//			return true;
//		} else if (!switched) {
//			switched = true;
//			return checkOverlap(activityB, activityA);
//		}
//		return false;
//	}
}
