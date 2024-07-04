import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<String> results = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int numActivities = sc.nextInt();
            int[][] activities = new int[numActivities][2];

            for (int j = 0; j < numActivities; j++) {
                activities[j][0] = sc.nextInt();
                activities[j][1] = sc.nextInt();
            }

            results.add(Solver.solve(activities));
        }

        for (int i = 0; i < results.size(); i++) {
            System.out.println("Case #" + (i + 1) + ": " + results.get(i));
        }
    }
}

class Solver {
    public static String solve(int[][] activities) {
        int n = activities.length;
        StringBuilder output = new StringBuilder();
        int endC = 0, endJ = 0;

        List<String> assignments = new ArrayList<>();
        for (int[] activity : activities) {
            if (activity[0] > 1440 || activity[1] > 1440) {
                return "IMPOSSIBLE";
            } else if (endC <= activity[0]) {
                assignments.add("C");
                endC = activity[1];
            } else if (endJ <= activity[0]) {
                assignments.add("J");
                endJ = activity[1];
            } else {
                return "IMPOSSIBLE";
            }
        }

        for (String assignment : assignments) {
            output.append(assignment);
        }

        return output.toString();
    }
}