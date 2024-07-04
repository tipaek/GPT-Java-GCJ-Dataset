import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCaseCount = scanner.nextInt();
        List<String> results = new ArrayList<>();

        for (int i = 0; i < testCaseCount; i++) {
            int activityCount = scanner.nextInt();
            int[][] activities = new int[activityCount][2];

            for (int j = 0; j < activityCount; j++) {
                activities[j][0] = scanner.nextInt();
                activities[j][1] = scanner.nextInt();
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
        StringBuilder result = new StringBuilder();
        int cEnd = 0;
        int jEnd = 0;

        for (int[] activity : activities) {
            if (activity[0] >= cEnd) {
                result.append("C");
                cEnd = activity[1];
            } else if (activity[0] >= jEnd) {
                result.append("J");
                jEnd = activity[1];
            } else {
                return "IMPOSSIBLE";
            }
        }

        return result.toString();
    }
}