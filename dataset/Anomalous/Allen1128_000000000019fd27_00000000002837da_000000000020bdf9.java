import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Solution {
    static class Schedule {
        int start;
        int end;
        int index;

        public Schedule(int start, int end, int index) {
            this.start = start;
            this.end = end;
            this.index = index;
        }

        public int getStart() {
            return start;
        }
    }

    public static String solve(int[][] intervals) {
        int n = intervals.length;
        Schedule[] schedules = new Schedule[n];
        
        for (int i = 0; i < n; i++) {
            schedules[i] = new Schedule(intervals[i][0], intervals[i][1], i);
        }

        if (!isFeasible(intervals)) {
            return "IMPOSSIBLE";
        }

        Arrays.sort(schedules, Comparator.comparingInt(Schedule::getStart));

        char[] assignments = new char[n];
        int cEnd = 0, jEnd = 0;

        for (Schedule schedule : schedules) {
            if (schedule.start >= cEnd) {
                assignments[schedule.index] = 'C';
                cEnd = schedule.end;
            } else if (schedule.start >= jEnd) {
                assignments[schedule.index] = 'J';
                jEnd = schedule.end;
            } else {
                return "IMPOSSIBLE";
            }
        }

        return new String(assignments);
    }

    private static boolean isFeasible(int[][] intervals) {
        int n = intervals.length;
        int[] starts = new int[n];
        int[] ends = new int[n];

        for (int i = 0; i < n; i++) {
            starts[i] = intervals[i][0];
            ends[i] = intervals[i][1];
        }

        Arrays.sort(starts);
        Arrays.sort(ends);

        int rooms = 0, endIdx = 0;

        for (int start : starts) {
            if (start < ends[endIdx]) {
                rooms++;
                if (rooms > 2) {
                    return false;
                }
            } else {
                endIdx++;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();

        for (int t = 1; t <= T; t++) {
            int N = scanner.nextInt();
            int[][] intervals = new int[N][2];

            for (int i = 0; i < N; i++) {
                intervals[i][0] = scanner.nextInt();
                intervals[i][1] = scanner.nextInt();
            }

            System.out.println("Case #" + t + ": " + solve(intervals));
        }

        scanner.close();
    }
}