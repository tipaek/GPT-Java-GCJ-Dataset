import java.util.ArrayList;
import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        ArrayList<String> results = new ArrayList<>();

        for (int i = 0; i < testCases; i++) {
            int numActivities = scanner.nextInt();
            int[][] activities = new int[numActivities][2];
            for (int j = 0; j < numActivities; j++) {
                activities[j][0] = scanner.nextInt();
                activities[j][1] = scanner.nextInt();
            }
            results.add(Solver.solve(activities, numActivities));
        }

        int caseNumber = 1;
        for (String result : results) {
            System.out.println("Case #" + caseNumber + ": " + result);
            caseNumber++;
        }
    }
}

class Solver {
    public static String solve(int[][] activities, int numActivities) {
        StringBuilder output = new StringBuilder();
        int endCameron = 0;
        int endJamie = 0;
        int startCameron = 0;
        int startJamie = 0;
        ArrayList<String> assignments = new ArrayList<>();

        for (int i = 0; i < numActivities; i++) {
            int[] activity = activities[i];
            if (endCameron <= activity[0] || startCameron > activity[1]) {
                assignments.add("C");
                startCameron = activity[0];
                endCameron = Math.max(endCameron, activity[1]);
            } else if (endJamie <= activity[0] || startJamie > activity[1]) {
                assignments.add("J");
                startJamie = activity[0];
                endJamie = Math.max(endJamie, activity[1]);
            } else {
                return "IMPOSSIBLE";
            }
        }

        int earliestStart = Integer.MAX_VALUE;
        int earliestIndex = -1;
        for (int i = 0; i < numActivities; i++) {
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
            output.append(assignment);
        }

        return output.toString();
    }
}