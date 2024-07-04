import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        scanner.nextLine();

        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            Set<Interval> cameronIntervals = new HashSet<>();
            Set<Interval> jamieIntervals = new HashSet<>();
            StringBuilder schedule = new StringBuilder();
            int activities = Integer.parseInt(scanner.nextLine());

            for (int i = 0; i < activities; i++) {
                String[] timeRange = scanner.nextLine().split(" ");
                int start = Integer.parseInt(timeRange[0]);
                int end = Integer.parseInt(timeRange[1]);
                Interval currentInterval = new Interval(start, end);

                int cameronSizeBefore = cameronIntervals.size();
                int jamieSizeBefore = jamieIntervals.size();

                cameronIntervals.add(currentInterval);

                if (cameronIntervals.size() == cameronSizeBefore) {
                    jamieIntervals.add(currentInterval);
                    if (jamieIntervals.size() == jamieSizeBefore) {
                        schedule.setLength(0);
                        schedule.append("IMPOSSIBLE");
                        break;
                    } else {
                        schedule.append("J");
                    }
                } else {
                    schedule.append("C");
                }
            }

            System.out.println("Case #" + caseNumber + ": " + schedule);
        }
    }

    public static boolean overlaps(Interval interval1, Interval interval2) {
        return interval1.end > interval2.start && interval1.start < interval2.end;
    }

    static class Interval {
        int start;
        int end;

        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            Interval otherInterval = (Interval) obj;
            return overlaps(this, otherInterval);
        }

        @Override
        public int hashCode() {
            return Objects.hash(start, end);
        }
    }
}