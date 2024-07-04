import java.util.ArrayList;
import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCaseCount = scanner.nextInt();
        ArrayList<String> results = new ArrayList<>();

        for (int i = 0; i < testCaseCount; i++) {
            int activityCount = scanner.nextInt();
            int[][] activities = new int[activityCount][2];

            for (int j = 0; j < activityCount; j++) {
                activities[j][0] = scanner.nextInt();
                activities[j][1] = scanner.nextInt();
            }

            results.add(Solver.solve(activities, activityCount));
        }

        for (int i = 0; i < results.size(); i++) {
            System.out.println("Case #" + (i + 1) + ": " + results.get(i));
        }

        scanner.close();
    }
}

class Solver {
    public static String solve(int[][] activities, int activityCount) {
        StringBuilder output = new StringBuilder();
        int cameronEnd = 0, jamieEnd = 0;
        ArrayList<String> assignments = new ArrayList<>();

        for (int i = 0; i < activityCount; i++) {
            int start = activities[i][0];
            int end = activities[i][1];

            if (cameronEnd <= start) {
                assignments.add("C");
                cameronEnd = end;
            } else if (jamieEnd <= start) {
                assignments.add("J");
                jamieEnd = end;
            } else {
                return "IMPOSSIBLE";
            }
        }

        int earliestStart = Integer.MAX_VALUE;
        int earliestIndex = -1;

        for (int i = 0; i < activityCount; i++) {
            if (activities[i][0] < earliestStart) {
                earliestStart = activities[i][0];
                earliestIndex = i;
            }
        }

        if (!assignments.get(earliestIndex).equals("C")) {
            for (int i = 0; i < assignments.size(); i++) {
                if (assignments.get(i).equals("J")) {
                    assignments.set(i, "C");
                } else {
                    assignments.set(i, "J");
                }
            }
        }

        for (String assignment : assignments) {
            output.append(assignment);
        }

        return output.toString();
    }
}