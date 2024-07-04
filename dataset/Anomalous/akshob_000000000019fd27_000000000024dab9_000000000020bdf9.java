import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class Interval implements Comparable<Interval> {
    private final int start;
    private final int end;

    Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }

    int getStart() {
        return start;
    }

    int getEnd() {
        return end;
    }

    @Override
    public int compareTo(Interval other) {
        return Integer.compare(this.start, other.start);
    }
}

class Person {
    private final String name;
    private Interval interval;

    Person(String name) {
        this.name = name;
        this.interval = new Interval(0, 0);
    }

    String getName() {
        return name;
    }

    Interval getInterval() {
        return interval;
    }

    void setInterval(Interval interval) {
        this.interval = interval;
    }
}

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int i = 0; i < testCases; i++) {
            int intervalsCount = scanner.nextInt();
            scanner.nextLine();
            ArrayList<Interval> intervals = new ArrayList<>();

            for (int j = 0; j < intervalsCount; j++) {
                String[] times = scanner.nextLine().split(" ");
                int start = Integer.parseInt(times[0]);
                int end = Integer.parseInt(times[1]);
                intervals.add(new Interval(start, end));
            }

            handleTestCase(intervals, i + 1);
        }

        scanner.close();
    }

    private static void handleTestCase(ArrayList<Interval> intervals, int caseNumber) {
        Collections.sort(intervals);

        Person c = new Person("C");
        Person j = new Person("J");

        StringBuilder result = new StringBuilder();
        boolean isPossible = true;

        for (Interval interval : intervals) {
            if (interval.getStart() >= c.getInterval().getEnd()) {
                c.setInterval(interval);
                result.append(c.getName());
            } else if (interval.getStart() >= j.getInterval().getEnd()) {
                j.setInterval(interval);
                result.append(j.getName());
            } else {
                isPossible = false;
                break;
            }
        }

        if (isPossible) {
            System.out.println("Case #" + caseNumber + ": " + result);
        } else {
            System.out.println("Case #" + caseNumber + ": IMPOSSIBLE");
        }
    }
}