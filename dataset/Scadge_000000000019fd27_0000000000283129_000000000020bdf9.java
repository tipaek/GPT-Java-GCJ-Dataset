import java.util.*;

public class Solution {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final int numCases = scanner.nextInt();

        newCase:
        for (int caseNumber = 1; caseNumber <= numCases; ++caseNumber) {
            final int numActivities = scanner.nextInt();
            final Interval[] intervals = new Interval[numActivities];
            for (int activityNumber = 0; activityNumber < numActivities; ++activityNumber) {
                final int from = scanner.nextInt();
                final int to = scanner.nextInt();
                final Interval nextInterval = new Interval(activityNumber, from, to);
                intervals[activityNumber] = nextInterval;
            }

            Arrays.sort(intervals, Comparator.comparingInt(interval -> interval.from));

            Interval lastInterval = intervals[0];
            intervals[0].actor = 'C';
            for (int i = 1; i < intervals.length; ++i) {
                if (intervals[i].from >= lastInterval.to) {
                    intervals[i].actor = 'C';
                    lastInterval = intervals[i];
                }
            }
            for (int i = 0; i < intervals.length; ++i) {
                if (intervals[i].actor == '\u0000') {
                    lastInterval = intervals[i];
                    intervals[i].actor = 'J';
                    break;
                }
            }
            for (int i = 0; i < intervals.length; ++i) {
                if (intervals[i].actor == '\u0000' && intervals[i].from >= lastInterval.to) {
                    intervals[i].actor = 'J';
                    lastInterval = intervals[i];
                }
            }

            for (Interval interval : intervals) {
                if (interval.actor == '\u0000') {
                    System.out.println("Case #" + caseNumber + ": IMPOSSIBLE");
                    continue newCase;
                }
            }

            Arrays.sort(intervals, Comparator.comparingInt(interval -> interval.index));
            final StringBuilder schedule = new StringBuilder();
            for (Interval interval : intervals) {
                schedule.append(interval.actor);
            }
            System.out.println("Case #" + caseNumber + ": " + new String(schedule));
        }
    }
}

class Interval {
    public final int from;
    public final int to;
    public final int index;
    public char actor;

    public Interval(int index, int from, int to) {
        this.index = index;
        this.from = from;
        this.to = to;
    }

    public boolean overlaps(Interval interval) {
        return Math.max(this.from, interval.from) < Math.min(this.to, interval.to);
    }

    @Override
    public String toString() {
        return "[" + this.from + ", " + this.to + "]";
    }
}
