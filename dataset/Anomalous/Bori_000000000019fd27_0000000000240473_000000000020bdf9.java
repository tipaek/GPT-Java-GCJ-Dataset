import java.util.Arrays;
import java.util.Scanner;

public class Solution {

    private static class Interval implements Comparable<Interval> {
        int start, end, id;

        public Interval(int start, int end, int id) {
            this.start = start;
            this.end = end;
            this.id = id;
        }

        public static Interval readInterval(Scanner scanner, int id) {
            int start = scanner.nextInt();
            int end = scanner.nextInt();
            return new Interval(start, end, id);
        }

        @Override
        public int compareTo(Interval other) {
            if (this.start != other.start) {
                return Integer.compare(this.start, other.start);
            }
            return Integer.compare(this.end, other.end);
        }
    }

    public static void main(String[] args) {
        final int MAX_INTERVALS = 1000;
        Scanner scanner = new Scanner(System.in);
        int noTests = Integer.parseInt(scanner.nextLine());

        Interval[] intervals = new Interval[MAX_INTERVALS + 1];
        char[] assignedTo = new char[MAX_INTERVALS + 1];

        for (int t = 1; t <= noTests; t++) {
            int noIntervals = scanner.nextInt();

            for (int i = 1; i <= noIntervals; i++) {
                intervals[i] = Interval.readInterval(scanner, i);
            }

            Arrays.sort(intervals, 1, noIntervals + 1);

            int jOccupUntil = 0, cOccupUntil = 0;
            boolean possible = true;

            for (int i = 1; i <= noIntervals && possible; i++) {
                if (jOccupUntil <= intervals[i].start) {
                    jOccupUntil = intervals[i].end;
                    assignedTo[intervals[i].id] = 'J';
                } else if (cOccupUntil <= intervals[i].start) {
                    cOccupUntil = intervals[i].end;
                    assignedTo[intervals[i].id] = 'C';
                } else {
                    possible = false;
                }
            }

            if (possible) {
                System.out.println("Case #" + t + ": " + new String(assignedTo, 1, noIntervals));
            } else {
                System.out.println("Case #" + t + ": IMPOSSIBLE");
            }
        }
    }
}