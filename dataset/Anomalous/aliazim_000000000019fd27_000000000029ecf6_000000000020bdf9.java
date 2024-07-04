package joohoyo.y2020.codejam;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class ParentingPartneringReturns {
    public static void main(String[] args) {
        ParentingPartneringReturns instance = new ParentingPartneringReturns();
        instance.execute();
    }

    private void execute() {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = Integer.parseInt(scanner.nextLine());
        for (int i = 1; i <= testCases; ++i) {
            int activitiesCount = Integer.parseInt(scanner.nextLine());
            int[][] activities = new int[activitiesCount][2];
            for (int j = 0; j < activitiesCount; j++) {
                String[] input = scanner.nextLine().split(" ");
                activities[j][0] = Integer.parseInt(input[0]);
                activities[j][1] = Integer.parseInt(input[1]);
            }
            String result = assignActivities(activitiesCount, activities);
            System.out.println("Case #" + i + ": " + result);
        }
    }

    private String assignActivities(int n, int[][] activities) {
        int[][] originalActivities = new int[n][2];
        for (int i = 0; i < n; i++) {
            originalActivities[i][0] = activities[i][0];
            originalActivities[i][1] = activities[i][1];
        }

        Arrays.sort(activities, Comparator.comparingInt(a -> a[0]));

        String[] assignments = new String[n];
        assignments[0] = "J";
        int[] endTimes = {activities[0][1], 0}; // endTimes[0] for J, endTimes[1] for C

        for (int i = 1; i < n; i++) {
            if (endTimes[0] <= activities[i][0]) {
                endTimes[0] = activities[i][1];
                assignments[i] = "J";
            } else if (endTimes[1] <= activities[i][0]) {
                endTimes[1] = activities[i][1];
                assignments[i] = "C";
            } else {
                return "IMPOSSIBLE";
            }
        }

        String[] finalAssignments = new String[n];
        boolean[] used = new boolean[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!used[j] && activities[i][0] == originalActivities[j][0] && activities[i][1] == originalActivities[j][1]) {
                    finalAssignments[j] = assignments[i];
                    used[j] = true;
                    break;
                }
            }
        }

        StringBuilder result = new StringBuilder();
        for (String assignment : finalAssignments) {
            result.append(assignment);
        }
        return result.toString();
    }
}