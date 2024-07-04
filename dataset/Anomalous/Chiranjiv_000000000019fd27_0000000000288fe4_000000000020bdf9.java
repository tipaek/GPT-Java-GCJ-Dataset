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

    public static void createSchedule(List<Interval> intervals, String[] schedule) {
        int currentParent = 0;
        for (int i = 0; i < intervals.size(); i++) {
            if (i > 0 && intervals.get(i).start < intervals.get(i - 1).end) {
                currentParent = 1 - currentParent;
            }
            schedule[intervals.get(i).order] = currentParent == 0 ? CAMERON : JAMIE;
        }
    }

    public static String findSchedule(List<Interval> intervals) {
        int[] overlap = new int[1445];
        Arrays.fill(overlap, 0);
        Collections.sort(intervals, INTERVAL_COMPARATOR);

        for (Interval interval : intervals) {
            overlap[interval.start]++;
            overlap[interval.end + 1]--;
        }

        for (int i = 1; i < overlap.length; i++) {
            overlap[i] += overlap[i - 1];
        }

        for (int i = 0; i < overlap.length; i++) {
            if (i < overlap.length - 1 && overlap[i] > 2 && overlap[i + 1] >= overlap[i]) {
                return "IMPOSSIBLE";
            }
        }

        String[] schedule = new String[intervals.size()];
        createSchedule(intervals, schedule);
        StringBuilder sb = new StringBuilder();
        for (String s : schedule) {
            sb.append(s);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int testcase = 1; testcase <= t; testcase++) {
            int n = sc.nextInt();
            List<Interval> intervals = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                int s = sc.nextInt();
                int e = sc.nextInt();
                intervals.add(new Interval(s, e, i));
            }
            String ans = findSchedule(intervals);
            System.out.println("Case #" + testcase + ": " + ans);
        }
        sc.close();
    }
}

class Interval {
    int start;
    int end;
    int order;

    public Interval(int start, int end, int order) {
        this.start = start;
        this.end = end;
        this.order = order;
    }
}