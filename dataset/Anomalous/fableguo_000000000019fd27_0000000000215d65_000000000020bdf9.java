import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCaseCount = scanner.nextInt();

        for (int testCase = 1; testCase <= testCaseCount; ++testCase) {
            int activityCount = scanner.nextInt();
            int[][] activities = new int[activityCount][3];

            for (int i = 0; i < activityCount; i++) {
                activities[i][0] = scanner.nextInt();
                activities[i][1] = scanner.nextInt();
                activities[i][2] = i;
            }

            Arrays.sort(activities, (a, b) -> a[1] == b[1] ? a[0] - b[0] : a[1] - b[1]);

            String result = "";
            char[] schedule = new char[activityCount];
            int cEnd = 0;
            int jEnd = 0;

            for (int i = 0; i < activityCount; i++) {
                if (activities[i][0] >= cEnd) {
                    cEnd = activities[i][1];
                    schedule[activities[i][2]] = 'C';
                } else if (activities[i][0] >= jEnd) {
                    jEnd = activities[i][1];
                    schedule[activities[i][2]] = 'J';
                } else {
                    result = "IMPOSSIBLE";
                    break;
                }
            }

            if (result.isEmpty()) {
                result = new String(schedule);
            }

            System.out.println("Case #" + testCase + ": " + result);
        }
    }
}