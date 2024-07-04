import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        List<String> results = new ArrayList<>();

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
    public static String solve(int[][] activities, int n) {
        StringBuilder output = new StringBuilder();
        int endC = 0, endJ = 0;
        List<String> assignments = new ArrayList<>();

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

        int earliestStart = Integer.MAX_VALUE;
        int earliestIndex = -1;
        for (int i = 0; i < n; i++) {
            if (activities[i][0] < earliestStart) {
                earliestStart = activities[i][0];
                earliestIndex = i;
            }
        }

        if (assignments.get(earliestIndex).equals("J")) {
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