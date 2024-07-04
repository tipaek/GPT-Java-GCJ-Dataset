import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Solution {
    private Scanner input;
    private PrintStream output;

    public static void main(String[] args) {
        try (Scanner input = new Scanner(System.in); PrintStream output = System.out) {
            int numCases = input.nextInt();

            for (int t = 0; t < numCases; t++) {
                output.printf("Case #%d: ", t + 1);
                output.println(new Solution(input, output).solve());
            }
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

        for (int i = 0; i < n; i++) {
            activities.add(new Activity(input.nextInt(), input.nextInt()));
        }

        Collections.sort(activities);
        Activity lastCameronActivity = null;
        Activity lastJamieActivity = null;

        for (Activity activity : activities) {
            if (lastCameronActivity == null || !activity.overlaps(lastCameronActivity)) {
                sb.append("C");
                lastCameronActivity = activity;
            } else if (lastJamieActivity == null || !activity.overlaps(lastJamieActivity)) {
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
            if (this.start != other.start) {
                return Integer.compare(this.start, other.start);
            }
            return Integer.compare(this.end, other.end);
        }

        public boolean overlaps(Activity other) {
            return this.start < other.end && this.end > other.start;
        }
    }
}