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

        for (int i = 0; i < numberOfCases; i++) {
            int caseNumber = i + 1;
            int activities = scanner.nextInt();
            int[][] activitySchedule = new int[activities][2];

            for (int j = 0; j < activities; j++) {
                activitySchedule[j][0] = scanner.nextInt();
                activitySchedule[j][1] = scanner.nextInt();
            }

            String solution = assignActivities(activitySchedule);
            System.out.println("Case #" + caseNumber + ": " + solution);
        }
    }

    private static String assignActivities(int[][] activitySchedule) {
        StringBuilder solution = new StringBuilder();
        List<Integer> activitiesC = new ArrayList<>();
        List<Integer> activitiesJ = new ArrayList<>();
        String currentPerson = "C";

        solution.append(currentPerson);
        activitiesC.add(0);

        for (int j = 1; j < activitySchedule.length; j++) {
            if (activitiesJ.isEmpty()) {
                if (!checkOverlap(activitySchedule[j - 1], activitySchedule[j])) {
                    solution.append(currentPerson);
                    activitiesC.add(j);
                } else {
                    currentPerson = "J";
                    solution.append(currentPerson);
                    activitiesJ.add(j);
                }
            } else {
                if (!checkOverlaps(activitiesC, activitySchedule, j)) {
                    currentPerson = "C";
                    solution.append(currentPerson);
                    activitiesC.add(j);
                } else if (!checkOverlaps(activitiesJ, activitySchedule, j)) {
                    currentPerson = "J";
                    solution.append(currentPerson);
                    activitiesJ.add(j);
                } else {
                    return "IMPOSSIBLE";
                }
            }
        }

        return solution.toString();
    }

    private static boolean checkOverlaps(List<Integer> activities, int[][] activitySchedule, int j) {
        for (Integer activity : activities) {
            if (checkOverlap(activitySchedule[activity], activitySchedule[j])) {
                return true;
            }
        }
        return false;
    }

    private static boolean checkOverlap(int[] activityA, int[] activityB) {
        int startA = activityA[0];
        int endA = activityA[1];
        int startB = activityB[0];
        int endB = activityB[1];

        if ((startB >= startA && startB < endA) || (startB <= startA && endB > startA)) {
            return true;
        } else if (!switched) {
            switched = true;
            return checkOverlap(activityB, activityA);
        }
        return false;
    }
}