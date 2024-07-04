import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Solution {
    private enum Parent {
        J, C, N
    }
    private static class Activity {
        private final int start;
        private final int end;
        private final int index;
        private Parent parent;
        public Activity(int start, int end, int index) {
            this.start = start;
            this.end = end;
            this.index = index;
            this.parent = Parent.N;
        }
        @Override
        public String toString() {
            return String.format("(%s, %s, %s, %s)", start, end, index, parent);
        }
    }
    private static final String CASE_TEMPLATE = "Case #%s: %s";
    private static final String IMPOSSIBLE = "IMPOSSIBLE";

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt();
            List<Activity> activities = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                int start = in.nextInt();
                int end = in.nextInt();
                activities.add(new Activity(start, end, j));
            }
            activities.sort(Comparator.comparing(a->a.start));
            int lastEnd = 0;
            for (Activity activity : activities) {
                if (activity.start >= lastEnd) {
                    activity.parent = Parent.C;
                    lastEnd = activity.end;
                }
            }
            lastEnd = 0;
            for (Activity activity : activities) {
                if (activity.parent == Parent.C) {
                    continue;
                }
                if (activity.start >= lastEnd) {
                    activity.parent = Parent.J;
                    lastEnd = activity.end;
                }
            }
            boolean impossible = false;
            for (Activity activity : activities) {
                if (activity.parent == Parent.N) {
                    impossible = true;
                    break;
                }
            }
            String solution;
            if (impossible) {
                solution = IMPOSSIBLE;
            }
            else {
                StringBuilder stringBuilder = new StringBuilder();
                activities.sort(Comparator.comparing(a->a.index));
                for (Activity activity : activities) {
                    stringBuilder.append(activity.parent);
                }
                solution = stringBuilder.toString();
            }
            System.out.println(String.format(CASE_TEMPLATE, i, solution));
        }
    }
}
