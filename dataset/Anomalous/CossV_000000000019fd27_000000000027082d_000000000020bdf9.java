import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        
        for (int k = 1; k <= t; k++) {
            int n = Integer.parseInt(sc.nextLine());
            StringBuilder sb = new StringBuilder(" ".repeat(n));
            List<Interval> allIntervals = new ArrayList<>();
            List<Interval> cIntervals = new ArrayList<>();
            List<Interval> jIntervals = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                String[] line = sc.nextLine().split(" ");
                int s = Integer.parseInt(line[0]);
                int e = Integer.parseInt(line[1]);
                allIntervals.add(new Interval(s, e, i));
            }

            List<Interval> sortedIntervals = new ArrayList<>(allIntervals);
            sortedIntervals.sort(Comparator.comparingInt(i -> i.start));

            for (Interval interval : sortedIntervals) {
                if (!hasOverlappingIntervals(cIntervals, interval)) {
                    cIntervals.add(interval);
                    sb.setCharAt(interval.id, 'C');
                } else if (!hasOverlappingIntervals(jIntervals, interval)) {
                    jIntervals.add(interval);
                    sb.setCharAt(interval.id, 'J');
                } else {
                    sb.setLength(0);
                    sb.append("IMPOSSIBLE");
                    break;
                }
            }

            System.out.println("Case #" + k + ": " + sb);
        }
    }

    private static boolean hasOverlappingIntervals(List<Interval> intervals, Interval interval) {
        return intervals.stream().anyMatch(currInterval -> !activitiesNotOverlap(currInterval.start, currInterval.end, interval.start, interval.end));
    }

    private static boolean activitiesNotOverlap(int s1, int e1, int s2, int e2) {
        return e1 <= s2 || e2 <= s1;
    }

    static class Interval {
        int start;
        int end;
        int id;

        Interval(int start, int end, int id) {
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