import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int i = 1; i <= testCases; i++) {
            int activities = scanner.nextInt();
            int[][] intervals = new int[activities][2];

            for (int j = 0; j < activities; j++) {
                intervals[j][0] = scanner.nextInt();
                intervals[j][1] = scanner.nextInt();
            }

            System.out.println("Case #" + i + ": " + assignActivities(intervals));
        }
    }

    private static String assignActivities(int[][] intervals) {
        int n = intervals.length;
        Activity[] activities = new Activity[n];

        for (int i = 0; i < n; i++) {
            activities[i] = new Activity(intervals[i][0], intervals[i][1], i);
        }

        Arrays.sort(activities, Comparator.comparingInt(a -> a.start));

        int cEnd = 0, jEnd = 0;
        char[] result = new char[n];

        for (Activity activity : activities) {
            if (activity.start >= cEnd) {
                result[activity.index] = 'C';
                cEnd = activity.end;
            } else if (activity.start >= jEnd) {
                result[activity.index] = 'J';
                jEnd = activity.end;
            } else {
                return "IMPOSSIBLE";
            }
        }

        return new String(result);
    }

    private static class Activity {
        int start, end, index;

        Activity(int start, int end, int index) {
            this.start = start;
            this.end = end;
            this.index = index;
        }
    }
}