import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Solution {
    private final Scanner input;
    private final PrintStream output;

    public static void main(String[] args) {
        try (Scanner input = new Scanner(System.in)) {
            PrintStream output = System.out;
            int numCases = input.nextInt();

            for (int t = 0; t < numCases; t++) {
                output.printf("Case #%d: ", t + 1);
                output.println(new Solution(input, output).solve());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Solution(Scanner input, PrintStream output) {
        this.input = input;
        this.output = output;
    }

    public String solve() {
        int n = input.nextInt();
        StringBuilder sb = new StringBuilder();
        List<Activity> activities = new ArrayList<>();
        List<Activity> sortedActivities = new ArrayList<>();
        Activity lastCameronActivity = null;
        Activity lastJamieActivity = null;

        for (int i = 0; i < n; i++) {
            activities.add(new Activity(input.nextInt(), input.nextInt()));
        }

        sortedActivities.addAll(activities);
        Collections.sort(sortedActivities);

        for (Activity activity : sortedActivities) {
            if (lastCameronActivity == null || !activity.overlap(lastCameronActivity)) {
                sb.append("C");
                lastCameronActivity = activity;
            } else if (lastJamieActivity == null || !activity.overlap(lastJamieActivity)) {
                sb.append("J");
                lastJamieActivity = activity;
            } else {
                return "IMPOSSIBLE";
            }
        }

        return sb.toString();
    }

    private static class Activity implements Comparable<Activity> {
        private final int start;
        private final int end;

        public Activity(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Activity other) {
            if (this.start == other.start) {
                return Integer.compare(this.end, other.end);
            }
            return Integer.compare(this.start, other.start);
        }

        public boolean overlap(Activity other) {
            return this.start < other.end && this.end > other.start;
        }
    }
}