import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int testCaseCount = Integer.parseInt(reader.readLine());

        for (int testCase = 1; testCase <= testCaseCount; testCase++) {
            int activityCount = Integer.parseInt(reader.readLine());
            StringBuilder schedule = new StringBuilder();
            int cEnd = 0, jEnd = 0;
            int[][] activities = new int[activityCount][2];

            for (int i = 0; i < activityCount; i++) {
                String[] times = reader.readLine().split(" ");
                activities[i][0] = Integer.parseInt(times[0]);
                activities[i][1] = Integer.parseInt(times[1]);
            }

            Arrays.sort(activities, Comparator.comparingInt(activity -> activity[0]));

            for (int i = 0; i < activityCount; i++) {
                if (cEnd <= activities[i][0]) {
                    cEnd = activities[i][1];
                    schedule.append("C");
                } else if (jEnd <= activities[i][0]) {
                    jEnd = activities[i][1];
                    schedule.append("J");
                } else {
                    schedule = new StringBuilder("IMPOSSIBLE");
                    break;
                }
            }

            System.out.printf("Case #%d: %s\n", testCase, schedule);
        }
    }
}