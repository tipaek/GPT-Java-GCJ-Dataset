import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int testCases = scanner.nextInt();
        for (int t = 1; t <= testCases; t++) {
            int activityCount = scanner.nextInt();

            int[][] activities = new int[activityCount][3];
            for (int i = 0; i < activityCount; i++) {
                activities[i][0] = scanner.nextInt();
                activities[i][1] = scanner.nextInt();
                activities[i][2] = i;
            }

            Arrays.sort(activities, Comparator.comparingInt(a -> a[0]));

            char[] schedule = new char[activityCount];
            int jEndTime = -1;
            int cEndTime = -1;
            boolean possible = true;

            for (int i = 0; i < activityCount; i++) {
                int startTime = activities[i][0];
                if (startTime >= jEndTime) {
                    schedule[activities[i][2]] = 'J';
                    jEndTime = activities[i][1];
                } else if (startTime >= cEndTime) {
                    schedule[activities[i][2]] = 'C';
                    cEndTime = activities[i][1];
                } else {
                    possible = false;
                    break;
                }
            }

            String output = possible ? new String(schedule) : "IMPOSSIBLE";
            System.out.println("Case #" + t + ": " + output);
        }
    }
}