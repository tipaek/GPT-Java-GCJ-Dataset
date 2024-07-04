import java.util.ArrayList;
import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        ArrayList<String> results = new ArrayList<>();

        for (int i = 0; i < testCases; i++) {
            int activitiesCount = scanner.nextInt();
            int[][] activities = new int[activitiesCount][2];

            for (int j = 0; j < activitiesCount; j++) {
                activities[j][0] = scanner.nextInt();
                activities[j][1] = scanner.nextInt();
            }

            results.add(Solver.solve(activities, activitiesCount));
        }

        for (int i = 0; i < results.size(); i++) {
            System.out.println("Case #" + (i + 1) + ": " + results.get(i));
        }
    }
}

class Solver {
    public static String solve(int[][] activities, int count) {
        StringBuilder result = new StringBuilder();
        int endC = 0, endJ = 0;
        int startC = 0, startJ = 0;
        ArrayList<String> assignments = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            int[] activity = activities[i];
            if (endC <= activity[0] || startC >= activity[1]) {
                assignments.add("C");
                startC = activity[0];
                endC = activity[1];
            } else if (endJ <= activity[0] || startJ >= activity[1]) {
                assignments.add("J");
                startJ = activity[0];
                endJ = activity[1];
            } else {
                return "IMPOSSIBLE";
            }
        }

        int earliestStart = Integer.MAX_VALUE;
        int earliestIndex = -1;
        for (int i = 0; i < count; i++) {
            if (activities[i][0] < earliestStart) {
                earliestStart = activities[i][0];
                earliestIndex = i;
            }
        }

        if (assignments.get(earliestIndex).equals("J")) {
            for (int i = 0; i < assignments.size(); i++) {
                if (assignments.get(i).equals("J")) {
                    assignments.set(i, "C");
                } else {
                    assignments.set(i, "J");
                }
            }
        }

        for (String assignment : assignments) {
            result.append(assignment);
        }

        return result.toString();
    }
}