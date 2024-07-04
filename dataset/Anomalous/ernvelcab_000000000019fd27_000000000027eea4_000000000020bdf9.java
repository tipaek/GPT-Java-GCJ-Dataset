import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Solution {

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int testCases = Integer.parseInt(reader.readLine());

            for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
                int activityCount = Integer.parseInt(reader.readLine());
                int[][] activities = new int[activityCount][2];

                for (int i = 0; i < activityCount; i++) {
                    String[] times = reader.readLine().split(" ");
                    activities[i][0] = Integer.parseInt(times[0]);
                    activities[i][1] = Integer.parseInt(times[1]);
                }

                Set<Integer> scheduledActivities = new HashSet<>();
                int[] sortedActivities = new int[activityCount];

                for (int i = 0; i < activityCount; i++) {
                    int earliestActivity = -1;
                    int earliestStart = -1;
                    for (int j = 0; j < activityCount; j++) {
                        if (!scheduledActivities.contains(j)) {
                            if (earliestActivity == -1 || activities[j][0] < earliestStart) {
                                earliestActivity = j;
                                earliestStart = activities[j][0];
                            }
                        }
                    }
                    scheduledActivities.add(earliestActivity);
                    sortedActivities[i] = earliestActivity;
                }

                boolean[] assignedToJ = new boolean[activityCount];
                int jEnd = 0, cEnd = 0;
                boolean feasible = true;

                for (int i = 0; i < activityCount; i++) {
                    int[] currentActivity = activities[sortedActivities[i]];
                    if (jEnd <= currentActivity[0]) {
                        jEnd = currentActivity[1];
                        assignedToJ[sortedActivities[i]] = true;
                    } else if (cEnd <= currentActivity[0]) {
                        cEnd = currentActivity[1];
                        assignedToJ[sortedActivities[i]] = false;
                    } else {
                        System.out.println("Case #" + caseNumber + ": IMPOSSIBLE");
                        feasible = false;
                        break;
                    }
                }

                if (feasible) {
                    StringBuilder result = new StringBuilder();
                    for (int i = 0; i < activityCount; i++) {
                        result.append(assignedToJ[i] ? "J" : "C");
                    }
                    System.out.println("Case #" + caseNumber + ": " + result);
                }
            }
        }
    }
}