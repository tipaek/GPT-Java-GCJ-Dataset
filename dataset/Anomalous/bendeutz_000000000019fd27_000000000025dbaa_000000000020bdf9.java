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
            int caseNumber = i + 1;
            int activities = in.nextInt();
            int[][] activitySchedule = new int[activities][2];
            for (int j = 0; j < activities; j++) {
                activitySchedule[j][0] = in.nextInt();
                activitySchedule[j][1] = in.nextInt();
            }
            String solution = assignActivities(activitySchedule);
            System.out.println("Case #" + caseNumber + ": " + solution);
        }
    }

    private static String assignActivities(int[][] activitySchedule) {
        StringBuilder solution = new StringBuilder("C");
        LinkedList<Integer> activitiesC = new LinkedList<>();
        LinkedList<Integer> activitiesJ = new LinkedList<>();
        activitiesC.add(0);
        String actualPerson = "C";

        for (int j = 1; j < activitySchedule.length; j++) {
            switched = false;
            if (activitiesJ.isEmpty()) {
                if (!checkOverlap(activitySchedule[j - 1], activitySchedule[j])) {
                    solution.append(actualPerson);
                    activitiesC.add(j);
                } else {
                    actualPerson = "J";
                    solution.append(actualPerson);
                    activitiesJ.add(j);
                }
            } else {
                if (!checkOverlaps(activitiesC, activitySchedule, j)) {
                    actualPerson = "C";
                    solution.append(actualPerson);
                    activitiesC.add(j);
                } else if (!checkOverlaps(activitiesJ, activitySchedule, j)) {
                    actualPerson = "J";
                    solution.append(actualPerson);
                    activitiesJ.add(j);
                } else {
                    return "IMPOSSIBLE";
                }
            }
        }
        return solution.toString();
    }

    private static boolean checkOverlaps(LinkedList<Integer> activities, int[][] activitySchedule, int j) {
        for (Integer activity : activities) {
            switched = false;
            if (checkOverlap(activitySchedule[activity], activitySchedule[j])) {
                return true;
            }
        }
        return false;
    }

    private static boolean checkOverlap(int[] activityA, int[] activityB) {
        if (activityA[0] < activityB[0] && activityA[1] > activityB[0]) {
            return true;
        } else if (activityB[0] < activityA[0] && activityB[1] > activityA[0]) {
            return true;
        } else if (!switched) {
            switched = true;
            return checkOverlap(activityB, activityA);
        }
        return false;
    }
}