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
            results.add(Solver.solve(activities, activityCount));
        }

        for (int i = 0; i < results.size(); i++) {
            System.out.println("Case #" + (i + 1) + ": " + results.get(i));
        }
    }
}

class Solver {
    public static String solve(int[][] activities, int activityCount) {
        StringBuilder result = new StringBuilder();
        int endC = 0, endJ = 0;

        for (int[] activity : activities) {
            if (activity[0] >= endC) {
                result.append("C");
                endC = activity[1];
            } else if (activity[0] >= endJ) {
                result.append("J");
                endJ = activity[1];
            } else {
                return "IMPOSSIBLE";
            }
        }

        return result.toString();
    }
}