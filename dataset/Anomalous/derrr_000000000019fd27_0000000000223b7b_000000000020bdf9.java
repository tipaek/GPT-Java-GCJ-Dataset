import java.util.*;
import java.io.*;

public class Solution {

    private static final String IMPOSSIBLE = "IMPOSSIBLE";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int i = 1; i <= testCases; ++i) {
            int activityCount = scanner.nextInt();
            PriorityQueue<int[]> activities = new PriorityQueue<>(activityCount, Comparator.comparingInt((int[] a) -> a[0]).thenComparingInt(a -> a[1]));

            for (int j = 0; j < activityCount; j++) {
                activities.add(new int[]{scanner.nextInt(), scanner.nextInt(), j});
            }

            System.out.printf("Case #%d: %s%n", i, assignActivities(activities));
        }
    }

    private static String assignActivities(PriorityQueue<int[]> activities) {
        int cameronEndTime = 0, jamieEndTime = 0;
        char[] schedule = new char[activities.size()];

        while (!activities.isEmpty()) {
            int[] currentActivity = activities.poll();
            int start = currentActivity[0];
            int end = currentActivity[1];
            int index = currentActivity[2];

            if (start >= cameronEndTime) {
                cameronEndTime = end;
                schedule[index] = 'C';
            } else if (start >= jamieEndTime) {
                jamieEndTime = end;
                schedule[index] = 'J';
            } else {
                return IMPOSSIBLE;
            }
        }

        return new String(schedule);
    }
}