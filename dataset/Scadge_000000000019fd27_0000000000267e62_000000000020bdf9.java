import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final int numCases = scanner.nextInt();

        for (int caseNumber = 1; caseNumber <= numCases; ++caseNumber) {
            final int numActivities = scanner.nextInt();
            final Interval[] intervals = new Interval[numActivities];
            for (int activityNumber = 0; activityNumber < numActivities; ++activityNumber) {
                final int from = scanner.nextInt();
                final int to = scanner.nextInt();
                final Interval nextInterval = new Interval(activityNumber, from, to);
                intervals[activityNumber] = nextInterval;
            }
            Arrays.sort(intervals, Comparator.comparingInt(o -> o.from));

            boolean impossible = false;

            final char[] schedule = new char[numActivities];
            final CurrentActor currentActor = new CurrentActor('C');
            for (int i = 0; i < intervals.length; ++i) {
                if (i > 0 && intervals[i].overlaps(intervals[i - 1])) {
                    currentActor.switchActor();
                    schedule[intervals[i].index] = currentActor.get();
                    if ((i - 2) >= 0 && intervals[i - 2].overlaps(intervals[i])) {
                        impossible = true;
                    }
                } else {
                    schedule[intervals[i].index] = currentActor.get();
                }
            }

            if (impossible) {
                System.out.println("Case #" + caseNumber + ": IMPOSSIBLE");
            } else {
                System.out.println("Case #" + caseNumber + ": " + new String(schedule));
            }
        }
    }
}

class Interval {
    public final int from;
    public final int to;
    public final int index;

    public Interval(int index, int from, int to) {
        this.index = index;
        this.from = from;
        this.to = to;
    }

    public boolean overlaps(Interval interval) {
        return interval.from > this.from && interval.from < this.to || interval.to > this.from && interval.to < this.to;
    }
}

class CurrentActor {
    private char actor;

    public CurrentActor(char actor) {
        this.actor = actor;
    }

    public char get() {
        return actor;
    }

    public void switchActor() {
        if (actor == 'C') {
            actor = 'J';
        } else {
            actor = 'C';
        }
    }
}