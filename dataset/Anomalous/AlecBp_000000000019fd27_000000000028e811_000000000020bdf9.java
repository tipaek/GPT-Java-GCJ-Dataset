import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int t = 0; t < testCases; t++) {
            int numActivities = scanner.nextInt();
            int[][] activities = new int[numActivities][2];

            for (int i = 0; i < numActivities; i++) {
                activities[i][0] = scanner.nextInt();
                activities[i][1] = scanner.nextInt();
            }

            Arrays.sort(activities, Comparator.comparingInt(a -> a[0]));

            int jEndTime = 0, cEndTime = 0;
            StringBuilder schedule = new StringBuilder();

            for (int[] activity : activities) {
                if (activity[0] >= jEndTime) {
                    jEndTime = activity[1];
                    schedule.append('J');
                } else if (activity[0] >= cEndTime) {
                    cEndTime = activity[1];
                    schedule.append('C');
                } else {
                    schedule = new StringBuilder("IMPOSSIBLE");
                    break;
                }
            }

            System.out.println("Case #" + (t + 1) + ": " + schedule.toString());
        }
    }
}