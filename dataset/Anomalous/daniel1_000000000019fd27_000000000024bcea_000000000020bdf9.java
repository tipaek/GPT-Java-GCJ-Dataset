import java.util.*;

public class Solution {

    public static class Interval {
        public int start, end, parentIndex, id;

        public Interval(int start, int end, int id) {
            this.start = start;
            this.end = end;
            this.parentIndex = -1;
            this.id = id;
        }
    }

    public static class Endpoint implements Comparable<Endpoint> {
        public int time;
        public boolean isStart;
        public Interval interval;

        public Endpoint(int time, boolean isStart, Interval interval) {
            this.time = time;
            this.isStart = isStart;
            this.interval = interval;
        }

        @Override
        public int compareTo(Endpoint other) {
            int cmp = Integer.compare(this.time, other.time);
            if (cmp != 0) {
                return cmp;
            }
            return Boolean.compare(other.isStart, this.isStart);
        }
    }

    public static String solve(List<Interval> intervals) {
        List<Endpoint> endpoints = new ArrayList<>();
        for (Interval interval : intervals) {
            endpoints.add(new Endpoint(interval.start, true, interval));
            endpoints.add(new Endpoint(interval.end, false, interval));
        }
        Collections.sort(endpoints);

        List<String> plan = new ArrayList<>(Collections.nCopies(intervals.size(), "C"));
        char[] parents = {'C', 'J'};
        int curParent = 0;
        int nConcurrent = 0;

        for (Endpoint endpoint : endpoints) {
            if (endpoint.isStart) {
                nConcurrent++;
                if (nConcurrent > 2) {
                    return "IMPOSSIBLE";
                }
                plan.set(endpoint.interval.id, String.valueOf(parents[curParent]));
                endpoint.interval.parentIndex = curParent;
                curParent = (curParent + 1) % 2;
            } else {
                nConcurrent--;
                curParent = endpoint.interval.parentIndex;
            }
        }
        return String.join("", plan);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = sc.nextInt();
        for (int t = 1; t <= T; t++) {
            int n = sc.nextInt();
            List<Interval> intervals = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                intervals.add(new Interval(sc.nextInt(), sc.nextInt(), i));
            }
            System.out.println("Case #" + t + ": " + solve(intervals));
        }
    }
}