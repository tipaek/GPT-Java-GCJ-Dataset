import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Solution {
    private final Scanner input;
    private final PrintStream output;

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
        StringBuilder result = new StringBuilder();
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
            if (lastCameronActivity == null || !activity.overlaps(lastCameronActivity)) {
                activity.assigned = "C";
                lastCameronActivity = activity;
            } else if (lastJamieActivity == null || !activity.overlaps(lastJamieActivity)) {
                activity.assigned = "J";
                lastJamieActivity = activity;
            } else {
                return "IMPOSSIBLE";
            }
        }
        
        for (Activity activity : activities) {
            result.append(activity.assigned);
        }
        
        return result.toString();
    }

    private static class Activity implements Comparable<Activity> {
        private final int start;
        private final int end;
        private String assigned;

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