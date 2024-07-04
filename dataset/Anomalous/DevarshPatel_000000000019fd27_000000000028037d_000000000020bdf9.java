import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        ArrayList<String> results = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int numActivities = scanner.nextInt();
            int[][] activities = new int[numActivities][2];

            for (int j = 0; j < numActivities; j++) {
                activities[j][0] = scanner.nextInt();
                activities[j][1] = scanner.nextInt();
            }

            results.add(Solver.solve(activities, numActivities));
        }

        for (int i = 0; i < results.size(); i++) {
            System.out.println("Case #" + (i + 1) + ": " + results.get(i));
        }
    }
}

class Solver {
    public static String solve(int[][] activities, int n) {
        StringBuilder output = new StringBuilder();
        int endC = 0, endJ = 0;
        ArrayList<String> assignments = new ArrayList<>();

        for (int[] activity : activities) {
            if (endC <= activity[0]) {
                assignments.add("C");
                endC = activity[1];
            } else if (endJ <= activity[0]) {
                assignments.add("J");
                endJ = activity[1];
            } else {
                return "IMPOSSIBLE";
            }
        }

        // Ensure the first activity is assigned to 'C'
        if (!assignments.get(0).equals("C")) {
            for (int i = 0; i < assignments.size(); i++) {
                assignments.set(i, assignments.get(i).equals("C") ? "J" : "C");
            }
        }

        for (String assignment : assignments) {
            output.append(assignment);
        }

        return output.toString();
    }
}