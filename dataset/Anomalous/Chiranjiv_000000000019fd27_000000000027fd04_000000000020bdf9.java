import java.util.*;

public class ParentingPartnering {
    private static final String CAMERON = "C";
    private static final String JAMIE = "J";

    private static final Comparator<Interval> INTERVAL_COMPARATOR = new Comparator<>() {
        @Override
        public int compare(Interval a, Interval b) {
            if (a.start != b.start) {
                return Integer.compare(a.start, b.start);
            }
            return Integer.compare(a.end, b.end);
        }
    };

    public static String createSchedule(List<Interval> intervals) {
        StringBuilder schedule = new StringBuilder();
        int currentParent = 0;
        for (int i = 0; i < intervals.size(); i++) {
            if (i > 0 && intervals.get(i).start >= intervals.get(i - 1).end) {
                currentParent = 1 - currentParent;
            }
            schedule.append(currentParent == 0 ? CAMERON : JAMIE);
        }
        return schedule.toString();
    }

    public static String findSchedule(List<Interval> intervals) {
        int[] overlap = new int[1445];
        Collections.sort(intervals, INTERVAL_COMPARATOR);

        for (Interval interval : intervals) {
            overlap[interval.start]++;
            overlap[interval.end + 1]--;
        }

        int ongoingEvents = 0;
        for (int i = 0; i < overlap.length; i++) {
            ongoingEvents += overlap[i];
            if (ongoingEvents > 2) {
                return "IMPOSSIBLE";
            }
        }

        return createSchedule(intervals);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        scanner.nextLine();

        for (int testcase = 1; testcase <= t; testcase++) {
            int n = scanner.nextInt();
            scanner.nextLine();
            List<Interval> intervals = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                intervals.add(new Interval(start, end));
                scanner.nextLine();
            }

            String result = findSchedule(intervals);
            System.out.println("Case #" + testcase + ": " + result);
        }
        scanner.close();
    }

    public static class Interval {
        int start;
        int end;

        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}