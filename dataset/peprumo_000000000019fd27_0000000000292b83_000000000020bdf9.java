import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    static class Range implements Comparable<Range> {
        private int position;
        private int start;
        private int end;

        public Range(int position, int start, int end) {
            this.position = position;
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Range o) {
            return this.start - o.start;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Tests number
        List<Range> activities = new LinkedList<>();
        Range range;
        for (int i = 0; i < t; i++) {
            activities.clear();
            int act = in.nextInt();
            int numActivities = 0;
            for (int j = 0; j < act; j++) {
                int start = in.nextInt();
                int end = in.nextInt();
                range = new Range(j, start, end);
                activities.add(range);
                numActivities++;
            }
            Collections.sort(activities);

            boolean possible = true;
            int claire = 0;
            int jamie = 0;

            int j = 0;
            char[] output = new char[numActivities];
            while (possible && j < activities.size()) {
                Range activity = activities.get(j);
                if (activity.start >= claire) {
                    output[activity.position] = 'C';
                    claire = activity.end;
                } else if (activity.start >= jamie) {
                    output[activity.position] = 'J';
                    jamie = activity.end;
                } else {
                    possible = false;
                }
                j++;
            }
            if (!possible) {
                System.out.println("Case #" + (i + 1) + ": IMPOSSIBLE");
            } else {
                System.out.println("Case #" + (i + 1) + ": " + new String(output));
            }
        }
    }
}
