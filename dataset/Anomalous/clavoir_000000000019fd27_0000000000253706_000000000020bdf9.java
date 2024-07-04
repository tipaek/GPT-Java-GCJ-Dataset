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
        StringBuilder sb = new StringBuilder();

        for (int[] activity : activities) {
            if (!isBusySchedule(jSchedules, activity)) {
                sb.append("J");
                jSchedules.add(activity);
            } else if (!isBusySchedule(cSchedules, activity)) {
                sb.append("C");
                cSchedules.add(activity);
            } else {
                return "IMPOSSIBLE";
            }
        }

        return sb.toString();
    }

    private static boolean isBusySchedule(List<int[]> schedules, int[] activity) {
        for (int[] schedule : schedules) {
            if ((schedule[0] < activity[0] && activity[0] < schedule[1]) || 
                (schedule[0] < activity[1] && activity[1] < schedule[1])) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int t = scanner.nextInt();
        scanner.nextLine(); // Consume the remaining newline character

        for (int testCase = 0; testCase < t; testCase++) {
            int n = scanner.nextInt();
            scanner.nextLine(); // Consume the remaining newline character
            int[][] schedules = new int[n][2];

            for (int i = 0; i < n; i++) {
                String[] schedule = scanner.nextLine().split(" ");
                schedules[i][0] = Integer.parseInt(schedule[0]);
                schedules[i][1] = Integer.parseInt(schedule[1]);
            }

            String result = compute(schedules);
            System.out.printf("Case #%d: %s%n", testCase + 1, result);
        }

        scanner.close();
    }
}