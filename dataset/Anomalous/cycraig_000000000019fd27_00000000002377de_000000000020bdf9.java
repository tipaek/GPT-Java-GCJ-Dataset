import java.util.*;
import java.io.*;

public class Solution {

    private static String solve(int[][] activities) {
        int n = activities.length;
        // Sort activities by start time, and by end time if start times are equal
        Arrays.sort(activities, (a, b) -> {
            if (a[0] == b[0]) {
                return a[1] - b[1];
            }
            return a[0] - b[0];
        });

        int cEndTime = 0;
        int jEndTime = 0;
        char[] result = new char[n];

        for (int[] activity : activities) {
            if (activity[0] >= cEndTime) {
                result[activity[2]] = 'C';
                cEndTime = activity[1];
            } else if (activity[0] >= jEndTime) {
                result[activity[2]] = 'J';
                jEndTime = activity[1];
            } else {
                return "IMPOSSIBLE";
            }
        }

        return new String(result);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = scanner.nextInt();
        for (int i = 1; i <= t; ++i) {
            int n = scanner.nextInt();
            int[][] activities = new int[n][3];
            for (int j = 0; j < n; j++) {
                activities[j][0] = scanner.nextInt();
                activities[j][1] = scanner.nextInt();
                activities[j][2] = j;
            }
            String solution = solve(activities);
            System.out.println("Case #" + i + ": " + solution);
        }
        scanner.close();
    }
}