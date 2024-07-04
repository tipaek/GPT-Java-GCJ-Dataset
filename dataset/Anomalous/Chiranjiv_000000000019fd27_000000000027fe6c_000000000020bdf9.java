import java.util.*;

class ParentingPartnering {
    private static final String CAMERON = "C";
    private static final String JAMIE = "J";

    private static final Comparator<Interval> INTERVAL_COMPARATOR = new Comparator<Interval>() {
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
        int currentPerson = 0;
        for (int i = 0; i < intervals.size(); i++) {
            if (i > 0 && intervals.get(i).start > intervals.get(i - 1).end) {
                currentPerson = 1 - currentPerson;
            }
            schedule.append(currentPerson == 0 ? CAMERON : JAMIE);
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

        int ongoingTasks = 0;
        for (int i = 0; i < overlap.length; i++) {
            ongoingTasks += overlap[i];
            if (ongoingTasks > 2) {
                return "IMPOSSIBLE";
            }
        }

        return createSchedule(intervals);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int testcase = 1; testcase <= t; testcase++) {
            int n = sc.nextInt();
            List<Interval> intervals = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                int start = sc.nextInt();
                int end = sc.nextInt();
                intervals.add(new Interval(start, end));
            }
            String result = findSchedule(intervals);
            System.out.println("Case #" + testcase + ": " + result);
        }
        sc.close();
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