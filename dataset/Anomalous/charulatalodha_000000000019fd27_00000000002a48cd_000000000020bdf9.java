import java.util.Arrays;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();
        StringBuilder result = new StringBuilder();

        for (int t = 0; t < testCases; t++) {
            int n = sc.nextInt();
            int[][] intervals = new int[n][3];

            for (int i = 0; i < n; i++) {
                intervals[i][0] = sc.nextInt();
                intervals[i][1] = sc.nextInt();
                intervals[i][2] = i;
            }

            result.append("Case #").append(t + 1).append(": ").append(assignTasks(intervals)).append("\n");
        }

        System.out.print(result);
    }

    private static String assignTasks(int[][] intervals) {
        int n = intervals.length;
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        int cEnd = intervals[0][1];
        int jEnd = 0;
        char[] schedule = new char[n];
        schedule[intervals[0][2]] = 'C';

        for (int i = 1; i < n; i++) {
            if (intervals[i][0] >= cEnd) {
                cEnd = intervals[i][1];
                schedule[intervals[i][2]] = 'C';
            } else if (intervals[i][0] >= jEnd) {
                jEnd = intervals[i][1];
                schedule[intervals[i][2]] = 'J';
            } else {
                return "IMPOSSIBLE";
            }
        }

        return new String(schedule);
    }
}