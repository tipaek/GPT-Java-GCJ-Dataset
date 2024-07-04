import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        scanner.nextLine();

        for (int caseNum = 1; caseNum <= testCases; caseNum++) {
            int numIntervals = Integer.parseInt(scanner.nextLine().trim());
            Set<Interval> cameronSchedule = new HashSet<>();
            Set<Interval> jamieSchedule = new HashSet<>();
            StringBuilder result = new StringBuilder();

            boolean isPossible = true;

            for (int i = 0; i < numIntervals; i++) {
                String[] intervalData = scanner.nextLine().split(" ");
                int start = Integer.parseInt(intervalData[0]);
                int end = Integer.parseInt(intervalData[1]);
                Interval interval = new Interval(start, end);

                if (!addInterval(cameronSchedule, interval)) {
                    if (!addInterval(jamieSchedule, interval)) {
                        isPossible = false;
                    } else {
                        result.append("J");
                    }
                } else {
                    result.append("C");
                }
            }

            if (!isPossible) {
                result.setLength(0);
                result.append("IMPOSSIBLE");
            }

            System.out.println("Case #" + caseNum + ": " + result);
        }

        scanner.close();
    }

    private static boolean addInterval(Set<Interval> schedule, Interval interval) {
        for (Interval i : schedule) {
            if (i.overlaps(interval)) {
                return false;
            }
        }
        schedule.add(interval);
        return true;
    }

    static class Interval {
        int start;
        int end;

        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public boolean overlaps(Interval other) {
            return this.start < other.end && this.end > other.start;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            Interval interval = (Interval) obj;
            return overlaps(interval);
        }

        @Override
        public int hashCode() {
            return 1;
        }
    }
}