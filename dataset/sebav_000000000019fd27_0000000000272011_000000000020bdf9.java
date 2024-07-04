import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

import static java.util.stream.Collectors.joining;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; i++) {
            solveIt(in, i);
        }
    }

    private static void solveIt(Scanner in, int caseIndex) {
        int n = in.nextInt();
        final List<Activity> activities = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            int start = in.nextInt();
            int end = in.nextInt();
            activities.add(new Activity(i, start, end));
        }
        activities.sort(new ByTime());
        Optional<Activity> cameronBusy = Optional.empty();
        Optional<Activity> jamieBusy = Optional.empty();
        for (Activity activity : activities) {
            cameronBusy = cameronBusy.filter(a -> a.overlaps(activity));
            jamieBusy = jamieBusy.filter(a -> a.overlaps(activity));
            if (cameronBusy.isPresent()) {
                if (jamieBusy.isPresent()) {
                    output(caseIndex, "IMPOSSIBLE");
                    return;
                } else {
                    jamieBusy = Optional.of(activity.withAssignee(Assignee.JAMIE));
                }
            } else {
                cameronBusy = Optional.of(activity.withAssignee(Assignee.CAMERON));
            }
        }
        activities.sort(new ByIndex());
        final String result = activities.stream().map(a -> a.assignee).map(Assignee::toString).collect(joining());
        output(caseIndex, result);
    }

    private static void output(int caseIdx, String scheduling) {
        System.out.println(String.format("Case #%d: %s", caseIdx, scheduling));
    }

    private static class Activity {
        final int originalIndex;
        final int start;
        final int end;
        Assignee assignee = Assignee.NOBODY;

        private Activity(int originalIndex, int start, int end) {
            this.originalIndex = originalIndex;
            this.start = start;
            this.end = end;
        }

        boolean overlaps(Activity a) {
            return this.end > a.start;
        }

        Activity withAssignee(Assignee assignee) {
            this.assignee = assignee;
            return this;
        }

        @Override
        public String toString() {
            return String.format("Activity(idx=%d, start=%d, end=%d, assignee=%s)", originalIndex, start, end, assignee);
        }
    }

    private static class ByTime implements Comparator<Activity> {
        @Override
        public int compare(Activity act, Activity that) {
            if (act.start != that.start) return act.start - that.start;
            return act.end - that.end;
        }
    }

    private static class ByIndex implements Comparator<Activity> {
        @Override
        public int compare(Activity act, Activity that) {
            return act.originalIndex - that.originalIndex;
        }
    }

    private enum Assignee {
        CAMERON('C'), JAMIE('J'), NOBODY('N');

        private char c;
        Assignee(char c) {
            this.c = c;
        }

        @Override
        public String toString() {
            return String.valueOf(c);
        }
    }
}
