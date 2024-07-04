import java.util.*;

public class Solution {

    public static class Interval {
        int start, end;

        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public static class Endpoint implements Comparable<Endpoint> {
        int time;
        boolean isStart;

        public Endpoint(int time, boolean isStart) {
            this.time = time;
            this.isStart = isStart;
        }

        @Override
        public int compareTo(Endpoint other) {
            int cmp = Integer.compare(this.time, other.time);
            if (cmp != 0) {
                return cmp;
            }
            if ((!this.isStart && other.isStart) || (this.isStart == other.isStart)) {
                return -1;
            } else {
                return 1;
            }
        }
    }

    public static String solve(List<Interval> intervals) {
        List<Endpoint> endpoints = new ArrayList<>();
        for (Interval interval : intervals) {
            endpoints.add(new Endpoint(interval.start, true));
            endpoints.add(new Endpoint(interval.end, false));
        }
        Collections.sort(endpoints);
        StringBuilder schedule = new StringBuilder();
        char[] parents = {'C', 'J'};
        int currentParent = 0;
        int concurrentCount = 0;

        for (Endpoint endpoint : endpoints) {
            if (endpoint.isStart) {
                concurrentCount++;
                if (concurrentCount > 2) {
                    return "IMPOSSIBLE";
                }
                schedule.append(parents[currentParent]);
                currentParent = (currentParent + 1) % 2;
            } else {
                concurrentCount--;
            }
        }
        return schedule.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = sc.nextInt();
        for (int t = 1; t <= T; t++) {
            int n = sc.nextInt();
            List<Interval> intervals = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                intervals.add(new Interval(sc.nextInt(), sc.nextInt()));
            }
            System.out.println("Case #" + t + ": " + solve(intervals));
        }
    }
}