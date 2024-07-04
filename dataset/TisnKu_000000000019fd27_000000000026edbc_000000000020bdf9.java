import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int i = 1; i <= t; ++i) {
            int count = in.nextInt();

            List<Activity> activities = new ArrayList<>();
            for (int j = 0; j < count; j++) {
                activities.add(new Activity(j, in.nextInt(), in.nextInt()));
            }
            Collections.sort(activities);
            solve(i, activities);
        }
    }

    private static void solve(int caseNumber, List<Activity> activities) {
        boolean isPossible = dfs(activities, 0, null, null);
        String result;
        if (isPossible) {
            char[] chars = new char[activities.size()];
            for (Activity activity : activities) {
                chars[activity.i] = activity.owner;
            }
            result = new String(chars);
        } else {
            result = "IMPOSSIBLE";
        }
        System.out.println("Case #" + caseNumber + ": " + result);
    }

    private static boolean dfs(List<Activity> activities, int i, Activity C, Activity J) {
        if (i == activities.size()) {
            return true;
        }
        Activity current = activities.get(i);
        if (current.isOverlap(C) && current.isOverlap(J)) {
            return false;
        }

        if (!current.isOverlap(J)) {
            current.owner = 'J';
            return dfs(activities, i + 1, C, current);
        } else {
            current.owner = 'C';
            return dfs(activities, i + 1, current, J);
        }
    }

    private static class Activity implements Comparable<Activity> {
        int i;
        int start;
        int end;
        char owner;

        public Activity(int i, int start, int end) {
            this.i = i;
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
            if (startDiff == 0) {
                return this.end - activity.end;
            }
            return startDiff;
        }
    }
}
