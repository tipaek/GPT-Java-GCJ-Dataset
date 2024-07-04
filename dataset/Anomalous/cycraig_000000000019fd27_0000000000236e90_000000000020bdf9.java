import java.util.*;
import java.io.*;

public class Solution {

    private static String assignActivities(int[][] activities) {
        // Greedily assign activities from earliest to latest to whichever parent is available
        int n = activities.length;
        Arrays.sort(activities, (a, b) -> {
            if (a[0] != b[0]) {
                return Integer.compare(a[0], b[0]);
            }
            return Integer.compare(a[1], b[1]);
        });

        int cEndTime = 0;
        int jEndTime = 0;
        StringBuilder result = new StringBuilder();

        for (int[] activity : activities) {
            if (activity[0] >= cEndTime) {
                result.append('C');
                cEndTime = activity[1];
            } else if (activity[0] >= jEndTime) {
                result.append('J');
                jEndTime = activity[1];
            } else {
                return "IMPOSSIBLE";
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int i = 1; i <= testCases; i++) {
            int n = scanner.nextInt();
            int[][] activities = new int[n][2];

            for (int j = 0; j < n; j++) {
                activities[j][0] = scanner.nextInt();
                activities[j][1] = scanner.nextInt();
            }

            String result = assignActivities(activities);
            System.out.println("Case #" + i + ": " + result);
        }
    }
}