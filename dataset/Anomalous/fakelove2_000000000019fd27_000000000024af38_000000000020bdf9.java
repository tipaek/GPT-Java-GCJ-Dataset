package qual.competitive;

import java.io.*;
import java.util.*;

public class Solution {
    static class Pair {
        int start, end, index;
        char assignedPerson = 0;

        Pair(int start, int end, int index) {
            this.start = start;
            this.end = end;
            this.index = index;
        }
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
            int testCases = scanner.nextInt();
            for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
                System.out.print("Case #" + caseNumber + ": ");
                solve(scanner);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void solve(Scanner scanner) {
        int n = scanner.nextInt();
        Pair[] intervals = new Pair[n];
        for (int i = 0; i < n; i++) {
            intervals[i] = new Pair(scanner.nextInt(), scanner.nextInt(), i);
        }
        Arrays.sort(intervals, Comparator.comparingInt(pair -> pair.start));

        List<Pair> jamieSchedule = new ArrayList<>();
        List<Pair> cameronSchedule = new ArrayList<>();

        for (Pair interval : intervals) {
            if (!hasConflict(jamieSchedule, interval)) {
                interval.assignedPerson = 'C';
                jamieSchedule.add(interval);
            } else if (!hasConflict(cameronSchedule, interval)) {
                interval.assignedPerson = 'J';
                cameronSchedule.add(interval);
            } else {
                System.out.println("IMPOSSIBLE");
                return;
            }
        }

        Arrays.sort(intervals, Comparator.comparingInt(pair -> pair.index));
        for (Pair interval : intervals) {
            System.out.print(interval.assignedPerson);
        }
        System.out.println();
    }

    private static boolean hasConflict(List<Pair> schedule, Pair newInterval) {
        for (Pair interval : schedule) {
            if ((interval.end > newInterval.start && interval.start < newInterval.start)
                    || (interval.start < newInterval.end && interval.end > newInterval.start)
                    || (newInterval.start < interval.start && newInterval.end > interval.end)
                    || (interval.start < newInterval.start && interval.end > newInterval.end)) {
                return true;
            }
        }
        return false;
    }
}