import java.util.*;

public class ParentingPartnering {
    private static final String CAMERON = "C";
    private static final String JAMIE = "J";

    public String createSchedule(List<Interval> intervals) {
        StringBuilder sb = new StringBuilder();
        int curr = 0;
        for (int i = 0; i < intervals.size(); i++) {
            if (i > 0 && intervals.get(i).start > intervals.get(i - 1).end) {
                curr = 1 - curr;
            }
            sb.append(curr == 0 ? CAMERON : JAMIE);
        }
        return sb.toString();
    }

    public String findSchedule(List<Interval> intervals) {
        int[] overlap = new int[1441]; // 1440 minutes in a day + 1 for boundary

        Collections.sort(intervals, new SortInterval());

        for (Interval interval : intervals) {
            overlap[interval.start]++;
            overlap[interval.end + 1]--;
        }

        int ongoing = 0;
        for (int i = 0; i < overlap.length; i++) {
            ongoing += overlap[i];
            if (ongoing > 2) {
                return "IMPOSSIBLE";
            }
        }

        return createSchedule(intervals);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();

        for (int testcase = 1; testcase <= t; testcase++) {
            int n = sc.nextInt();
            sc.nextLine();
            List<Interval> intervals = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                int s = sc.nextInt();
                int e = sc.nextInt();
                intervals.add(new Interval(s, e));
                if (sc.hasNextLine()) sc.nextLine();
            }

            ParentingPartnering pp = new ParentingPartnering();
            String ans = pp.findSchedule(intervals);
            System.out.println("Case #" + testcase + ": " + ans);
        }
        sc.close();
    }

    public static class Interval {
        int start;
        int end;

        public Interval(int s, int e) {
            this.start = s;
            this.end = e;
        }
    }

    public static class SortInterval implements Comparator<Interval> {
        public int compare(Interval a, Interval b) {
            if (a.start != b.start) {
                return Integer.compare(a.start, b.start);
            }
            return Integer.compare(a.end, b.end);
        }
    }
}