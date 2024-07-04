import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numberOfCases = scanner.nextInt();

        for (int caseIndex = 1; caseIndex <= numberOfCases; caseIndex++) {
            int numActivities = scanner.nextInt();
            int[][] activities = new int[numActivities][2];

            for (int i = 0; i < numActivities; i++) {
                activities[i][0] = scanner.nextInt();
                activities[i][1] = scanner.nextInt();
            }

            String result = assignActivities(activities);
            System.out.println("Case #" + caseIndex + ": " + result);
        }
    }

    private static String assignActivities(int[][] activities) {
        StringBuilder assignment = new StringBuilder();
        LinkedList<Integer> cActivities = new LinkedList<>();
        LinkedList<Integer> jActivities = new LinkedList<>();
        
        cActivities.add(0);
        assignment.append('C');

        for (int i = 1; i < activities.length; i++) {
            if (canAssignActivity(cActivities, activities, i)) {
                assignment.append('C');
                cActivities.add(i);
            } else if (canAssignActivity(jActivities, activities, i)) {
                assignment.append('J');
                jActivities.add(i);
            } else {
                return "IMPOSSIBLE";
            }
        }

        return assignment.toString();
    }

    private static boolean canAssignActivity(LinkedList<Integer> assignedActivities, int[][] activities, int currentIndex) {
        for (Integer index : assignedActivities) {
            if (activitiesOverlap(activities[index], activities[currentIndex])) {
                return false;
            }
        }
        return true;
    }

    private static boolean activitiesOverlap(int[] activityA, int[] activityB) {
        return (activityA[0] < activityB[1] && activityA[1] > activityB[0]) || 
               (activityB[0] < activityA[1] && activityB[1] > activityA[0]);
    }
}