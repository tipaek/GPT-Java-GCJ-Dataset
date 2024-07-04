import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int i = 1; i <= t; ++i) {
            int count = in.nextInt();

            List<Activity> activities = new ArrayList<>();
            for (int j = 0; j < count; j++) {
                activities.add(new Activity(in.nextInt(), in.nextInt()));
            }
            Collections.sort(activities);
            solve(i, activities);
        }
    }

    private static void solve(int caseNumber, List<Activity> activities) {
        String result = dfs(activities, "", 0, null, null);
        System.out.println("Case #" + caseNumber + ": " + Optional.ofNullable(result).orElse("IMPOSSIBLE"));
    }

    private static String dfs(List<Activity> activities, String prefix, int i, Activity C, Activity J) {
        if (i == activities.size()) return prefix;
        Activity current = activities.get(i);
        if (current.isOverlap(C) && current.isOverlap(J)) {
            return null;
        }

        if (!current.isOverlap(C) && !current.isOverlap(J)) {
            String jResult = dfs(activities, prefix + "J", i + 1, C, current);
            if (jResult == null) return dfs(activities, prefix + "C", i + 1, current, J);
            return jResult;
        } else if (current.isOverlap(C)) {
            return dfs(activities, prefix + "J", i + 1, C, current);
        } else {
            return dfs(activities, prefix + "C", i + 1, current, J);
        }
    }

    private static class Activity implements Comparable<Activity> {
        int start;
        int end;

        public Activity(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public boolean isOverlap(Activity activity) {
            if (activity == null) return false;
            return !(end <= activity.start || start >= activity.end);
        }

        @Override
        public int compareTo(Activity activity) {
            int startDiff = this.start - activity.start;
            if (startDiff == 0) return this.end - activity.end;
            return startDiff;
        }
    }
}
