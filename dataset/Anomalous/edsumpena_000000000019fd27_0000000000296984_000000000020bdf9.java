import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int testCase = 1; testCase <= testCases; ++testCase) {
            int activitiesCount = scanner.nextInt();
            List<int[]> activities = new ArrayList<>();

            for (int i = 0; i < activitiesCount; i++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                activities.add(new int[]{start, end, i});
            }

            String result = assignActivities(activities);
            System.out.println("Case #" + testCase + ": " + result);
        }
    }

    private static String assignActivities(List<int[]> activities) {
        activities.sort(Comparator.comparingInt(a -> a[0]));
        int[] endTimes = new int[]{0, 0};  // endTimes[0] for C, endTimes[1] for J
        char[] assignments = new char[activities.size()];

        for (int[] activity : activities) {
            int start = activity[0];
            int end = activity[1];
            int index = activity[2];

            if (start >= endTimes[0]) {
                endTimes[0] = end;
                assignments[index] = 'C';
            } else if (start >= endTimes[1]) {
                endTimes[1] = end;
                assignments[index] = 'J';
            } else {
                return "IMPOSSIBLE";
            }
        }

        return new String(assignments);
    }
}