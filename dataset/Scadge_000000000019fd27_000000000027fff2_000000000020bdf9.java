import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;

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

            final Schedule cameronSchedule = new Schedule('C');
            final Schedule jamieSchedule = new Schedule('J');

            for (Interval interval : intervals) {
                if (!cameronSchedule.add(interval) && !jamieSchedule.add(interval)) {
                    System.out.println("Case #" + caseNumber + ": IMPOSSIBLE");
                    continue newCase;
                }
            }

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

class Schedule {
    private final char owner;
    private final Collection<Interval> intervals = new ArrayList<>();

    Schedule(char owner) {
        this.owner = owner;
    }

    public boolean add(Interval interval) {
        boolean fits = intervals.stream().noneMatch(interval::overlaps);
        if (fits) {
            intervals.add(interval);
            interval.actor = owner;
        }

        return fits;
    }
}