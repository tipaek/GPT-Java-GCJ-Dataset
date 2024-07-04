import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

    private static final Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

    public static String compute(int[][] activities) {
        List<int[]> jSchedules = new ArrayList<>();
        List<int[]> cSchedules = new ArrayList<>();
        StringBuilder scheduleResult = new StringBuilder();

        for (int[] activity : activities) {
            if (!isBusy(jSchedules, activity)) {
                scheduleResult.append("J");
                jSchedules.add(activity);
            } else if (!isBusy(cSchedules, activity)) {
                scheduleResult.append("C");
                cSchedules.add(activity);
            } else {
                return "IMPOSSIBLE";
            }
        }
        return scheduleResult.toString();
    }

    private static boolean isBusy(List<int[]> schedules, int[] activity) {
        for (int[] schedule : schedules) {
            if ((schedule[0] <= activity[0] && activity[0] < schedule[1]) || 
                (schedule[0] < activity[1] && activity[1] <= schedule[1])) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int testCases = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        for (int testCase = 1; testCase <= testCases; testCase++) {
            int n = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            int[][] activities = new int[n][2];
            for (int i = 0; i < n; i++) {
                String[] times = scanner.nextLine().split(" ");
                activities[i][0] = Integer.parseInt(times[0]);
                activities[i][1] = Integer.parseInt(times[1]);
            }

            String result = compute(activities);
            System.out.printf("Case #%d: %s%n", testCase, result);
        }

        scanner.close();
    }
}