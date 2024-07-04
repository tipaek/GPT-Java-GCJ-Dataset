import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Solution {

    private static class Activity {
        int start;
        int end;
        int index;
        char assigned;

        public Activity(int start, int end, int index) {
            this.start = start;
            this.end = end;
            this.index = index;
        }

        @Override
        public String toString() {
            return "Activity{" +
                    "start=" + start +
                    ", end=" + end +
                    ", index=" + index +
                    ", assigned=" + assigned +
                    '}';
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        for (int t = 1; t <= testCases; t++) {
            int n = scanner.nextInt();
            Activity[] activities = new Activity[n];

            for (int i = 0; i < n; i++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                activities[i] = new Activity(start, end, i);
            }

            Arrays.sort(activities, Comparator.comparingInt(a -> a.start));

            boolean impossible = false;
            int[] endTimes = new int[2];  // endTimes[0] for 'J', endTimes[1] for 'C'
            char[] assigned = new char[n];

            for (Activity activity : activities) {
                if (activity.start >= endTimes[0]) {
                    endTimes[0] = activity.end;
                    assigned[activity.index] = 'J';
                } else if (activity.start >= endTimes[1]) {
                    endTimes[1] = activity.end;
                    assigned[activity.index] = 'C';
                } else {
                    impossible = true;
                    break;
                }
            }

            StringBuilder result = new StringBuilder();
            if (impossible) {
                result.append("IMPOSSIBLE");
            } else {
                for (char c : assigned) {
                    result.append(c);
                }
            }

            System.out.printf("Case #%d: %s%n", t, result.toString());
        }
    }
}