import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Solution {
    private static ArrayList<Activity> activities;
    private static int[][] dpTable;
    private static int numActivities;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numCases = Integer.parseInt(scanner.nextLine());

        for (int caseNum = 1; caseNum <= numCases; caseNum++) {
            numActivities = Integer.parseInt(scanner.nextLine());
            activities = new ArrayList<>();

            for (int i = 0; i < numActivities; i++) {
                activities.add(new Activity(scanner.nextLine().split(" ")));
            }

            Collections.sort(activities);
            dpTable = new int[numActivities + 1][numActivities + 1];

            boolean possible = scheduleActivities(0, 0, -1, -1);

            StringBuilder result = new StringBuilder();
            int cCount = 0, jCount = 0;

            while (cCount + jCount < numActivities) {
                if (dpTable[jCount][cCount] == 1) {
                    result.append("C");
                    jCount++;
                } else if (dpTable[jCount][cCount] == 2) {
                    result.append("J");
                    cCount++;
                } else {
                    result = new StringBuilder("IMPOSSIBLE");
                    break;
                }
            }

            System.out.println("Case #" + caseNum + ": " + result);
        }
    }

    private static boolean scheduleActivities(int c, int j, int endTimeC, int endTimeJ) {
        int nextActivityIndex = c + j;
        if (nextActivityIndex == numActivities) {
            return true;
        }

        Activity nextActivity = activities.get(nextActivityIndex);
        boolean canAssignToC = false, canAssignToJ = false;

        if (endTimeC <= nextActivity.startTime) {
            canAssignToC = scheduleActivities(c + 1, j, nextActivity.endTime, endTimeJ);
            if (canAssignToC) {
                dpTable[c][j] = 1;
                return true;
            }
        }

        if (endTimeJ <= nextActivity.startTime) {
            canAssignToJ = scheduleActivities(c, j + 1, endTimeC, nextActivity.endTime);
            if (canAssignToJ) {
                dpTable[c][j] = 2;
                return true;
            }
        }

        return false;
    }

    private static class Activity implements Comparable<Activity> {
        private final int startTime;
        private final int endTime;

        public Activity(String[] times) {
            this.startTime = Integer.parseInt(times[0]);
            this.endTime = Integer.parseInt(times[1]);
        }

        @Override
        public int compareTo(Activity other) {
            return Integer.compare(this.startTime, other.startTime);
        }
    }
}