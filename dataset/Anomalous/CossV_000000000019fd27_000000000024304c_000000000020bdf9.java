import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        scanner.nextLine();

        for (int testCase = 1; testCase <= testCases; testCase++) {
            Set<Interval> cameronIntervals = new HashSet<>();
            Set<Interval> jamieIntervals = new HashSet<>();
            StringBuilder result = new StringBuilder();
            int numberOfIntervals = Integer.parseInt(scanner.nextLine().trim());

            for (int i = 0; i < numberOfIntervals; i++) {
                String[] intervalParts = scanner.nextLine().split(" ");
                int start = Integer.parseInt(intervalParts[0]);
                int end = Integer.parseInt(intervalParts[1]);
                Interval interval = new Interval(start, end);

                int cameronSizeBefore = cameronIntervals.size();
                int jamieSizeBefore = jamieIntervals.size();

                jamieIntervals.add(interval);
                if (jamieIntervals.size() == jamieSizeBefore) {
                    cameronIntervals.add(interval);
                    if (cameronSizeBefore == cameronIntervals.size()) {
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

    public static boolean overlaps(Interval i1, Interval i2) {
        return (i1.end > i2.start) && (i1.start < i2.end);
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
            Interval other = (Interval) obj;
            return overlaps(this, other);
        }

        @Override
        public int hashCode() {
            return 1;
        }
    }
}