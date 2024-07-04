import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for (int i = 0; i < t; i++) {
            int N = sc.nextInt();
            int[][] intervals = new int[N][2];
            int[] startTimes = new int[N];

            for (int j = 0; j < N; j++) {
                intervals[j][0] = sc.nextInt();
                intervals[j][1] = sc.nextInt();
                startTimes[j] = intervals[j][0];
            }

            Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

            if (hasOverlap(intervals)) {
                System.out.println("Case #" + (i + 1) + ": IMPOSSIBLE");
            } else {
                String schedule = createSchedule(intervals);
                StringBuilder result = new StringBuilder();
                for (int startTime : startTimes) {
                    int index = Arrays.binarySearch(startTimes, startTime);
                    result.append(schedule.charAt(index));
                }
                System.out.println("Case #" + (i + 1) + ": " + result);
            }
        }
    }

    private static boolean hasOverlap(int[][] intervals) {
        for (int i = 0; i < intervals.length - 1; i++) {
            if (intervals[i][1] > intervals[i + 1][0]) {
                return true;
            }
        }
        return false;
    }

    private static String createSchedule(int[][] intervals) {
        StringBuilder schedule = new StringBuilder("C");
        char current = 'C';

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i - 1][1] > intervals[i][0]) {
                current = (current == 'C') ? 'J' : 'C';
            }
            schedule.append(current);
        }

        return schedule.toString();
    }
}