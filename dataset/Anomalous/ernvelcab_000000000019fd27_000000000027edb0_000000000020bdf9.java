import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Solution {

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int numberOfCases = Integer.parseInt(reader.readLine());

            for (int caseNumber = 1; caseNumber <= numberOfCases; caseNumber++) {
                int numberOfActivities = Integer.parseInt(reader.readLine());
                int[][] activities = new int[numberOfActivities][2];

                for (int i = 0; i < numberOfActivities; i++) {
                    String[] parts = reader.readLine().split(" ");
                    activities[i][0] = Integer.parseInt(parts[0]);
                    activities[i][1] = Integer.parseInt(parts[1]);
                }

                Set<Integer> scheduledActivities = new HashSet<>();
                int[] sortedActivities = new int[numberOfActivities];

                for (int i = 0; i < numberOfActivities; i++) {
                    int earliestActivity = -1;
                    int earliestStartTime = Integer.MAX_VALUE;

                    for (int j = 0; j < numberOfActivities; j++) {
                        if (!scheduledActivities.contains(j) && activities[j][0] < earliestStartTime) {
                            earliestActivity = j;
                            earliestStartTime = activities[j][0];
                        }
                    }

                    scheduledActivities.add(earliestActivity);
                    sortedActivities[i] = earliestActivity;
                }

                boolean[] assignedToJ = new boolean[numberOfActivities];
                int endTimeJ = 0;
                int endTimeC = 0;
                boolean isPossible = true;

                for (int i = 0; i < numberOfActivities; i++) {
                    int[] currentActivity = activities[sortedActivities[i]];

                    if (endTimeJ <= currentActivity[0]) {
                        endTimeJ = currentActivity[1];
                        assignedToJ[sortedActivities[i]] = true;
                    } else if (endTimeC <= currentActivity[0]) {
                        endTimeC = currentActivity[1];
                        assignedToJ[sortedActivities[i]] = false;
                    } else {
                        System.out.println("Case #" + caseNumber + ": IMPOSSIBLE");
                        isPossible = false;
                        break;
                    }
                }

                if (isPossible) {
                    StringBuilder result = new StringBuilder();
                    for (int i = 0; i < numberOfActivities; i++) {
                        result.append(assignedToJ[i] ? "J" : "C");
                    }
                    System.out.println("Case #" + caseNumber + ": " + result.toString());
                }
            }
        }
    }
}