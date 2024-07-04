import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Solution {
    private static final Scanner scanner = new Scanner(System.in);
    private static final String IMPOSSIBLE = "IMPOSSIBLE";

    public static void main(String[] args) {
        int testCases = scanner.nextInt();
        for (int i = 1; i <= testCases; i++) {
            System.out.println("Case #" + i + ": " + solve());
        }
    }

    private static class Activity implements Comparable<Activity> {
        int start;
        int end;
        int index;

        Activity(int start, int end, int index) {
            this.start = start;
            this.end = end;
            this.index = index;
        }

        @Override
        public int compareTo(Activity other) {
            if (this.start != other.start) {
                return Integer.compare(this.start, other.start);
            }
            return Integer.compare(this.end, other.end);
        }
    }

    private static String solve() {
        int n = scanner.nextInt();
        List<Activity> activities = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int start = scanner.nextInt();
            int end = scanner.nextInt();
            activities.add(new Activity(start, end, i));
        }

        Collections.sort(activities);

        int cameronEnd = 0;
        int jamieEnd = 0;
        char[] assigned = new char[n];

        for (Activity activity : activities) {
            if (activity.start >= cameronEnd) {
                assigned[activity.index] = 'C';
                cameronEnd = activity.end;
            } else if (activity.start >= jamieEnd) {
                assigned[activity.index] = 'J';
                jamieEnd = activity.end;
            } else {
                return IMPOSSIBLE;
            }
        }

        return new String(assigned);
    }
}