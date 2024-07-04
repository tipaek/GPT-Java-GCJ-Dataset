import java.util.*;

public class Solution {
    static int n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for (int i = 1; i <= t; i++) {
            n = sc.nextInt();
            int[][] intervals = new int[2][n];
            int[][] originalIntervals = new int[2][n];
            StringBuilder schedule = new StringBuilder();
            String finalSchedule = "";
            boolean isPossible = true;

            for (int j = 0; j < n; j++) {
                intervals[0][j] = originalIntervals[0][j] = sc.nextInt();
                intervals[1][j] = originalIntervals[1][j] = sc.nextInt();
            }

            sortIntervals(intervals);

            List<int[]> cameron = new ArrayList<>();
            List<int[]> jamie = new ArrayList<>();

            for (int j = 0; j < n; j++) {
                int start = intervals[0][j];
                int end = intervals[1][j];

                if (canSchedule(start, end, cameron)) {
                    cameron.add(new int[]{start, end});
                    schedule.append('C');
                } else if (canSchedule(start, end, jamie)) {
                    jamie.add(new int[]{start, end});
                    schedule.append('J');
                } else {
                    isPossible = false;
                    System.out.println("Case #" + i + ": IMPOSSIBLE");
                    break;
                }
            }

            if (isPossible) {
                for (int j = 0; j < n; j++) {
                    for (int k = 0; k < n; k++) {
                        if (originalIntervals[0][j] == intervals[0][k] && originalIntervals[1][j] == intervals[1][k]) {
                            finalSchedule += schedule.charAt(k);
                            break;
                        }
                    }
                }
                System.out.println("Case #" + i + ": " + finalSchedule);
            }
        }
    }

    static void sortIntervals(int[][] intervals) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (intervals[0][j] > intervals[0][j + 1]) {
                    int tempStart = intervals[0][j];
                    int tempEnd = intervals[1][j];
                    intervals[0][j] = intervals[0][j + 1];
                    intervals[1][j] = intervals[1][j + 1];
                    intervals[0][j + 1] = tempStart;
                    intervals[1][j + 1] = tempEnd;
                }
            }
        }
    }

    static boolean canSchedule(int start, int end, List<int[]> schedule) {
        for (int[] interval : schedule) {
            if ((start >= interval[0] && start < interval[1]) || (end > interval[0] && end <= interval[1])) {
                return false;
            }
        }
        return true;
    }
}