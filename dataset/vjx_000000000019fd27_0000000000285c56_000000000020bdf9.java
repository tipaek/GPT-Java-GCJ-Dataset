import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt();

            int[][] intervals = new int[n][2];
            for (int j = 0; j < n; j++) {
                intervals[j] = new int[]{in.nextInt(), in.nextInt(), j};
            }

            String out = schedule(intervals);
            System.out.println("Case #" + i + ": " + out);
        }
    }

    static String schedule(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(interval -> interval[0]));

        char[] schedule = new char[intervals.length];

        int firstAvailable = intervals[0][1];
        schedule[intervals[0][2]] = 'C';

        int secondAvailable = 0;

        for (int i = 1; i < intervals.length; i++) {
            int[] interval = intervals[i];

            if (interval[0] >= firstAvailable) {
                firstAvailable = interval[1];
                schedule[interval[2]] = 'C';
            } else if (interval[0] >= secondAvailable) {
                secondAvailable = interval[1];
                schedule[interval[2]] = 'J';
            } else {
                return "IMPOSSIBLE";
            }
        }

        return String.valueOf(schedule);
    }
}