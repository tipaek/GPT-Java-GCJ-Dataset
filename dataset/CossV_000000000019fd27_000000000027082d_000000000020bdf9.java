import java.util.*;

public class Solution {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        for (int k = 1; k <= t; k++) {
            int n = Integer.parseInt(sc.nextLine());
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < n; i++) {
                sb.append(" ");
            }
            List<Interval> allIntervals = new ArrayList<>();
            List<Interval> cIntervals = new ArrayList<>();
            List<Interval> jIntervals = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                String[] line = sc.nextLine().split(" ");
                int s = Integer.parseInt(line[0]);
                int e = Integer.parseInt(line[1]);
                allIntervals.add(new Interval(s, e, i));
            }

            ArrayList<Interval> sortedIntervals = new ArrayList<>(allIntervals);
            sortedIntervals.sort(new Comparator<Interval>() {
                @Override
                public int compare(Interval i1, Interval i2) {
                    return Integer.compare(i1.start, i2.start);
                }
            });
            for (int i = 0; i < sortedIntervals.size(); i++) {
                Interval interval = sortedIntervals.get(i);
                if (!hasOverlappingIntervals(cIntervals, interval)) {
                    cIntervals.add(interval);
                    sb.setCharAt(allIntervals.indexOf(interval), 'C');
                } else {
                    if (!hasOverlappingIntervals(jIntervals, interval)) {
                        jIntervals.add(interval);
                        sb.setCharAt(allIntervals.indexOf(interval), 'J');
                    } else {
                        sb.setLength(0);
                        sb.append("IMPOSSIBLE");
                        break;
                    }
                }
            }

            System.out.println("Case #" + k + ": " + sb);
        }
    }

    public static boolean activitiesNotOverlap(int s1, int e1, int s2, int e2) {
        return e1 <= s2 || e2 <= s1;
    }

    public static boolean hasOverlappingIntervals(List<Interval> intervals, Interval interval) {
        boolean hasOverlapping = false;
        for (int i = 0; i < intervals.size(); i++) {
            Interval currInterval = intervals.get(i);
            if (!activitiesNotOverlap(currInterval.start, currInterval.end, interval.start, interval.end)) {
                hasOverlapping = true;
                break;
            }
        }

        return hasOverlapping;
    }

    static class Interval {
        int start;
        int end;
        int id;

        public Interval(int start, int end, int id) {
            this.start = start;
            this.end = end;
            this.id = id;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Interval interval = (Interval) o;
            return id == interval.id;
        }

        @Override
        public int hashCode() {
            return Objects.hash(id);
        }
    }
}
