import java.util.Arrays;
import java.util.Scanner;

public class Solution {

    private static class Period {
        int index;
        int start;
        int end;

        Period(int index, int start, int end) {
            this.index = index;
            this.start = start;
            this.end = end;
        }
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int numberOfTests = scanner.nextInt();

            for (int testCase = 1; testCase <= numberOfTests; testCase++) {
                Period[] periods = readPeriods(scanner);
                System.out.println("Case #" + testCase + ": " + determineSchedule(periods));
            }
        }
    }

    private static Period[] readPeriods(Scanner scanner) {
        int periodCount = scanner.nextInt();
        Period[] periods = new Period[periodCount];

        for (int i = 0; i < periodCount; i++) {
            int start = scanner.nextInt();
            int end = scanner.nextInt();
            periods[i] = new Period(i, start, end);
        }

        return periods;
    }

    private static String determineSchedule(Period[] periods) {
        if (periods.length == 1) {
            return "C";
        }

        Arrays.sort(periods, (p1, p2) -> Integer.compare(p1.start, p2.start));
        char[] schedule = new char[periods.length];
        Period c = periods[0];
        Period j = periods[1];
        schedule[c.index] = 'C';
        schedule[j.index] = 'J';

        for (int i = 2; i < periods.length; i++) {
            if (c.end <= periods[i].start) {
                c = periods[i];
                schedule[periods[i].index] = 'C';
            } else if (j.end <= periods[i].start) {
                j = periods[i];
                schedule[periods[i].index] = 'J';
            } else {
                return "IMPOSSIBLE";
            }
        }

        return new String(schedule);
    }
}