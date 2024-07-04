import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfCases = scanner.nextInt();
        List<String> results = new ArrayList<>();

        for (int i = 0; i < numberOfCases; i++) {
            int numberOfActivities = scanner.nextInt();
            int[][] activities = new int[numberOfActivities][2];

            for (int j = 0; j < numberOfActivities; j++) {
                activities[j][0] = scanner.nextInt();
                activities[j][1] = scanner.nextInt();
            }

            results.add(Scheduler.solve(activities, numberOfActivities));
        }

        for (int i = 0; i < results.size(); i++) {
            System.out.println("Case #" + (i + 1) + ": " + results.get(i));
        }
    }
}

class Scheduler {
    public static String solve(int[][] activities, int numberOfActivities) {
        StringBuilder result = new StringBuilder();
        int cEnd = 0, jEnd = 0;
        int cStart = 0, jStart = 0;
        List<String> assignments = new ArrayList<>();

        for (int[] activity : activities) {
            if (cEnd <= activity[0] || cStart >= activity[1]) {
                assignments.add("C");
                cStart = activity[0];
                cEnd = activity[1];
            } else if (jEnd <= activity[0] || jStart >= activity[1]) {
                assignments.add("J");
                jStart = activity[0];
                jEnd = activity[1];
            } else {
                return "IMPOSSIBLE";
            }
        }

        int earliestStart = Integer.MAX_VALUE;
        int earliestIndex = -1;
        for (int i = 0; i < numberOfActivities; i++) {
            if (activities[i][0] < earliestStart) {
                earliestStart = activities[i][0];
                earliestIndex = i;
            }
        }

        if (!assignments.get(earliestIndex).equals("C")) {
            for (int i = 0; i < assignments.size(); i++) {
                assignments.set(i, assignments.get(i).equals("J") ? "C" : "J");
            }
        }

        for (String assignment : assignments) {
            result.append(assignment);
        }

        return result.toString();
    }
}