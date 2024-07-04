import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = in.nextInt();
        for (int i = 1; i <= testCases; ++i) {
            solve(i, in);
        }
    }

    private static void solve(int caseNr, Scanner in) {
        int activities = in.nextInt();
        List<Activity> activityList = new ArrayList<>();
        for (int i = 0; i < activities; i++) {
            int start = in.nextInt();
            int end = in.nextInt();
            activityList.add(new Activity(start, end));
        }
        activityList = activityList.stream()
                .sorted(Comparator.comparingInt(Activity::getStart))
                .collect(Collectors.toList());

        StringBuilder result = new StringBuilder();
        Activity activityC = null;
        Activity activityJ = null;
        for (Activity activity : activityList) {
            if (activityC == null || !activity.overlap(activityC)) {
                result.append("C");
                activityC = activity;
            } else if (activityJ == null || !activity.overlap(activityJ)) {
                result.append("J");
                activityJ = activity;
            } else {
                result = new StringBuilder("IMPOSSIBLE");
                break;
            }
        }

        System.out.println(String.format("Case #%d: %s", caseNr, result.toString()));
    }

    static class Activity {

        int start;
        int end;

        public Activity(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public boolean overlap(Activity other) {
            return other.start < this.end && other.start > this.start ||
                    this.start < other.end && this.start > other.start;
        }

        public int getStart() {
            return start;
        }

        public int getEnd() {
            return end;
        }
    }
}
