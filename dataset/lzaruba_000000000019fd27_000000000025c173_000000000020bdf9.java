import java.util.*;
import java.io.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Solution {

    private static class Case {

        private static class Activity {

            private final int id;
            private final int from;
            private final int to;

            public Activity(int id, int from, int to) {
                this.id = id;
                this.from = from;
                this.to = to;
            }

            public int getFrom() {
                return from;
            }

            public int getTo() {
                return to;
            }

            public int getId() {
                return id;
            }

            @Override
            public String toString() {
                return "[" + from + "-" + to + "]";
            }

        }

        private final int id;
        private final List<Activity> activities = new ArrayList<>();

        public Case(int id) {
            this.id = id;
        }

        public void pushActivity(int from, int to) {
            activities.add(new Activity(activities.size(), from, to));
        }

        @Override
        public String toString() {
            return "\nCase " + id + ": activities=" + activities;
        }

        public void output() {
            int cAvailability = 0;
            int jAvailability = 0;
            boolean possible = true;
            String[] output = new String[activities.size()];
            activities.sort(Comparator.comparingInt(Activity::getFrom));
            for (Activity a : activities) {
                if (cAvailability <= a.getFrom()) {
                    output[a.getId()] = "C";
                    cAvailability = a.getTo();
                } else if (jAvailability <= a.getFrom()) {
                    output[a.getId()] = "J";
                    jAvailability = a.getTo();
                } else {
                    possible = false;
                    break;
                }
            }

            //System.out.println(toString());
            if (possible) {
                System.out.println(String.format("Case #%d: %s", id, Stream.of(output).collect(Collectors.joining())));
            } else {
                System.out.println(String.format("Case #%d: %s", id, "IMPOSSIBLE"));
            }
        }

    }

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int casesCount = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        List<Case> cases = new ArrayList<>();
        for (int caseId = 1; caseId <= casesCount; caseId++) {
            int size = in.nextInt();
            Case c = new Case(caseId);
            for (int i = 0; i < size; i++) {
                c.pushActivity(in.nextInt(), in.nextInt());
            }
            cases.add(c);
        }

        cases.forEach(Case::output);
    }

}
