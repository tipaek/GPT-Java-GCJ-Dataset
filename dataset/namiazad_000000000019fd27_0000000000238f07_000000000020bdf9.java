import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static class Duration {
        int start;
        int end;

        public Duration(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public String toString() {
            return "Duration{" +
                    "start=" + start +
                    ", end=" + end +
                    '}';
        }
    }

    private static int size(int[] activities) {
        int i = 0;
        while (activities[i] != 0) {
            i++;
        }
        return i;
    }

    private static int indexOf(int[] activities, int i) {
        for (int c = 0; c < activities.length; c++) {
            if (activities[c] == i) {
                return c;
            }
        }
        return -1;
    }

    private static String schedule(List<Duration> activities) {
        char[] result = new char[activities.size()];

        int[][] minutes = new int[60 * 24][activities.size()];

        for (int a = 1; a <= activities.size(); a++) {
            Duration activity = activities.get(a - 1);
            for (int d = activity.start; d < activity.end; d++) {
                int size = size(minutes[d]);
                minutes[d][size] = a;
                if (size + 1 == 3) return "IMPOSSIBLE";
            }
        }

        for (int a = 1; a <= activities.size(); a++) {
            Duration activity = activities.get(a - 1);
            int rightest = 0;
            int index = 0;
            for (int d = activity.start; d < activity.end; d++) {
                int position = indexOf(minutes[d], a);
                rightest = Math.max(rightest, position);
                if (rightest == position) {
                    index = d;
                }
            }

            if (rightest == 0) result[a - 1] = 'C';
            else {
                result[a - 1] = result[minutes[index][0] - 1] == 'C' ? 'J' : 'C';
            }
        }

        return new String(result);
    }


    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int testCase = 1; testCase <= t; ++testCase) {
            int activitiesCount = in.nextInt();

            List<Duration> activitiesDuration = new ArrayList<>();
            for (int i = 1; i <= activitiesCount; i++) {
                activitiesDuration.add(new Duration(in.nextInt(), in.nextInt()));
            }

            System.out.println(String.format("Case #%d: %s", testCase, schedule(activitiesDuration)));
        }
    }
}
