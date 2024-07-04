import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        scanner.nextLine();

        for (int testCase = 1; testCase <= testCases; testCase++) {
            Set<Interval> cameronIntervals = new HashSet<>();
            Set<Interval> jamieIntervals = new HashSet<>();
            StringBuilder result = new StringBuilder();
            int numIntervals = Integer.parseInt(scanner.nextLine().trim());

            for (int i = 0; i < numIntervals; i++) {
                String[] intervalInput = scanner.nextLine().split(" ");
                int start = Integer.parseInt(intervalInput[0]);
                int end = Integer.parseInt(intervalInput[1]);
                Interval interval = new Interval(start, end);

                if (!addInterval(jamieIntervals, interval)) {
                    if (!addInterval(cameronIntervals, interval)) {
                        result.setLength(0);
                        result.append("IMPOSSIBLE");
                    } else {
                        if (!"IMPOSSIBLE".equals(result.toString())) {
                            result.append("C");
                        }
                    }
                } else {
                    if (!"IMPOSSIBLE".equals(result.toString())) {
                        result.append("J");
                    }
                }
            }

            System.out.println("Case #" + testCase + ": " + result);
        }
    }

    private static boolean addInterval(Set<Interval> intervals, Interval interval) {
        int initialSize = intervals.size();
        intervals.add(interval);
        return intervals.size() > initialSize;
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
            Interval interval = (Interval) obj;
            return overlaps(this, interval);
        }

        @Override
        public int hashCode() {
            return 1;
        }

        private boolean overlaps(Interval other) {
            return (this.end > other.start && this.start < other.end) || 
                   (this.start == this.end && this.end == other.start && other.start == other.end);
        }
    }
}