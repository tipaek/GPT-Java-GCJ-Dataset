import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
    static int[][] intervals;
    static int[][][] memo;

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(reader.readLine());
        StringBuilder result = new StringBuilder();

        for (int t = 1; t <= testCases; t++) {
            result.append("Case #").append(t).append(": ");
            int n = Integer.parseInt(reader.readLine());
            intervals = new int[n][3];

            for (int i = 0; i < n; i++) {
                StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
                intervals[i][0] = Integer.parseInt(tokenizer.nextToken());
                intervals[i][1] = Integer.parseInt(tokenizer.nextToken());
                intervals[i][2] = i;
            }

            Arrays.sort(intervals, (a, b) -> a[0] != b[0] ? Integer.compare(a[0], b[0]) : Integer.compare(a[1], b[1]));
            memo = new int[n][n + 1][];
            boolean canSchedule = canScheduleIntervals(1, -1);
            char[] schedule = new char[n];
            schedule[intervals[0][2]] = 'C';

            if (canSchedule) {
                int currentPerson = 0;
                int previousInterval = -1;

                for (int i = 1; i < n; i++) {
                    if (memo[i][previousInterval + 1][1] == 1) {
                        currentPerson = (currentPerson + 1) % 2;
                        previousInterval = i - 1;
                    }
                    schedule[intervals[i][2]] = currentPerson == 0 ? 'C' : 'J';
                }
                result.append(new String(schedule));
            } else {
                result.append("IMPOSSIBLE");
            }
            result.append("\n");
        }
        System.out.print(result);
    }

    static boolean canScheduleIntervals(int currentIndex, int lastScheduledIndex) {
        if (currentIndex == intervals.length) {
            return true;
        }
        if (memo[currentIndex][lastScheduledIndex + 1] != null) {
            return memo[currentIndex][lastScheduledIndex + 1][0] == 1;
        }
        if (intervals[currentIndex - 1][1] <= intervals[currentIndex][0] && canScheduleIntervals(currentIndex + 1, lastScheduledIndex)) {
            memo[currentIndex][lastScheduledIndex + 1] = new int[]{1, 0};
            return true;
        }
        if ((lastScheduledIndex < 0 || intervals[lastScheduledIndex][1] <= intervals[currentIndex][0]) && canScheduleIntervals(currentIndex + 1, currentIndex - 1)) {
            memo[currentIndex][lastScheduledIndex + 1] = new int[]{1, 1};
            return true;
        }
        memo[currentIndex][lastScheduledIndex + 1] = new int[]{0};
        return false;
    }
}