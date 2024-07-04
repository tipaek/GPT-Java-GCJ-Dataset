import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final int numCases = scanner.nextInt();

        for (int caseNumber = 1; caseNumber < numCases; ++caseNumber) {
            final int numActivities = scanner.nextInt();
            final Interval[] intervals = new Interval[numActivities];
            for (int activityNumber = 0; activityNumber < numActivities; ++activityNumber) {
                final int from = scanner.nextInt();
                final int to = scanner.nextInt();
                final Interval nextInterval = new Interval(from, to);
                intervals[activityNumber] = nextInterval;
            }

            boolean impossible = false;

            final StringBuilder schedule = new StringBuilder();
            final CurrentActor currentActor = new CurrentActor('C');
            schedule.append(currentActor.get());
            for (int i = 1; i < intervals.length; ++i) {
                if (intervals[i].overlaps(intervals[i - 1])) {
                    currentActor.switchActor();
                    schedule.append(currentActor.get());
                    if ((i - 2) >= 0 && intervals[i - 2].overlaps(intervals[i])) {
                        impossible = true;
                        break;
                    }
                } else {
                    schedule.append(currentActor.get());
                }
            }

            if (impossible) {
                System.out.println("Case #" + caseNumber + ": IMPOSSIBLE");
            } else {
                System.out.println("Case #" + caseNumber + ": " + schedule);
            }
        }
    }
}

class Interval {
    public final int from;
    public final int to;

    public Interval(int from, int to) {
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