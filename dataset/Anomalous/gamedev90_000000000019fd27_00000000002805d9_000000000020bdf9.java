import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(reader.readLine());
        int caseNumber = 1;

        while (testCases-- > 0) {
            int n = Integer.parseInt(reader.readLine());
            String[][] activities = new String[n][2];

            for (int i = 0; i < n; i++) {
                activities[i] = reader.readLine().split(" ");
            }

            String schedule = findSchedule(activities, new char[] {'J', 'C'});
            String result = (schedule == null) ? "IMPOSSIBLE" : schedule;
            System.out.println("Case #" + caseNumber + ": " + result);
            caseNumber++;
        }
    }

    private static String findSchedule(String[][] activities, char[] persons) {
        StringBuilder schedule = new StringBuilder();
        Arrays.sort(activities, (a, b) -> Integer.parseInt(a[0]) - Integer.parseInt(b[0]));

        int[] endTimes = {-1, -1};  // End times for J and C
        for (String[] activity : activities) {
            int start = Integer.parseInt(activity[0]);
            int end = Integer.parseInt(activity[1]);

            if (start >= endTimes[0]) {
                schedule.append(persons[0]);
                endTimes[0] = end;
            } else if (start >= endTimes[1]) {
                schedule.append(persons[1]);
                endTimes[1] = end;
            } else {
                return null;
            }
        }

        return schedule.toString();
    }
}