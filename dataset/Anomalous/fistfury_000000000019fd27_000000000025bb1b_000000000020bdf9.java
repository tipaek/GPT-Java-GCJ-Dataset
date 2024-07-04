import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int numActivities = scanner.nextInt();
            int[][] activities = new int[numActivities][3];
            int[][] schedule = new int[1440][2];
            boolean isImpossible = false;

            for (int i = 0; i < numActivities; i++) {
                activities[i][0] = scanner.nextInt();
                activities[i][1] = scanner.nextInt();
                activities[i][2] = i;
            }

            Arrays.sort(activities, Comparator.comparingInt(a -> a[0]));

            int[][] assignedActivities = new int[numActivities][2];

            for (int i = 0; i < numActivities; i++) {
                int startTime = activities[i][0];
                int endTime = activities[i][1];
                int originalIndex = activities[i][2];

                boolean cameronAvailable = true;
                boolean jamieAvailable = true;

                for (int t = startTime; t < endTime; t++) {
                    if (schedule[t][0] == 1) {
                        cameronAvailable = false;
                    }
                    if (schedule[t][1] == 1) {
                        jamieAvailable = false;
                    }
                }

                if (cameronAvailable) {
                    for (int t = startTime; t < endTime; t++) {
                        schedule[t][0] = 1;
                    }
                    assignedActivities[i] = new int[]{originalIndex, 1};
                } else if (jamieAvailable) {
                    for (int t = startTime; t < endTime; t++) {
                        schedule[t][1] = 1;
                    }
                    assignedActivities[i] = new int[]{originalIndex, 2};
                } else {
                    isImpossible = true;
                    break;
                }
            }

            StringBuilder result = new StringBuilder();
            if (isImpossible) {
                result.append("IMPOSSIBLE");
            } else {
                Arrays.sort(assignedActivities, Comparator.comparingInt(a -> a[0]));
                for (int[] activity : assignedActivities) {
                    result.append(activity[1] == 1 ? "C" : "J");
                }
            }

            System.out.println("Case #" + caseNumber + ": " + result);
        }
    }
}