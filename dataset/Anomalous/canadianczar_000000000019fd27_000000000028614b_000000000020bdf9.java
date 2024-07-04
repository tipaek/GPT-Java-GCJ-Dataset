import java.util.*;
import java.io.*;

class Solution {

    public static class Interval {
        int start, end, index;
        char assignedTo;

        public Interval(int index, int start, int end) {
            this.index = index;
            this.start = start;
            this.end = end;
            this.assignedTo = ' ';
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numberOfTests = Integer.parseInt(scanner.nextLine());

        for (int currentTest = 1; currentTest <= numberOfTests; currentTest++) {
            int numberOfIntervals = scanner.nextInt();
            Interval[] intervals = new Interval[numberOfIntervals];

            for (int i = 0; i < numberOfIntervals; i++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                intervals[i] = new Interval(i, start, end);
            }

            processTestCase(currentTest, intervals);
        }

        scanner.close();
    }

    public static boolean assignJob(List<Interval> schedule, Interval interval) {
        if (schedule.isEmpty() || interval.start >= schedule.get(schedule.size() - 1).end) {
            schedule.add(interval);
            return false;
        }
        return true;
    }

    public static void processTestCase(int testNumber, Interval[] intervals) {
        StringBuilder result = new StringBuilder();
        List<Interval> cameronSchedule = new ArrayList<>();
        List<Interval> jamieSchedule = new ArrayList<>();
        boolean isCameronTurn = true;

        Arrays.sort(intervals, Comparator.comparingInt((Interval i) -> i.start)
                                          .thenComparingInt(i -> i.end)
                                          .thenComparingInt(i -> i.index));

        for (Interval interval : intervals) {
            boolean cameronOverlap = assignJob(isCameronTurn ? cameronSchedule : jamieSchedule, interval);

            if (cameronOverlap) {
                isCameronTurn = !isCameronTurn;
                boolean jamieOverlap = assignJob(isCameronTurn ? cameronSchedule : jamieSchedule, interval);

                if (cameronOverlap && jamieOverlap) {
                    result.append("IMPOSSIBLE");
                    break;
                } else {
                    interval.assignedTo = isCameronTurn ? 'C' : 'J';
                }
            } else {
                interval.assignedTo = isCameronTurn ? 'C' : 'J';
            }
        }

        if (result.length() == 0) {
            Arrays.sort(intervals, Comparator.comparingInt(i -> i.index));
            for (Interval interval : intervals) {
                result.append(interval.assignedTo);
            }
        }

        System.out.printf("Case #%d: %s\n", testNumber, result.toString());
    }
}