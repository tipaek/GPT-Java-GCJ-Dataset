import java.io.*;
import java.util.*;

public class Solution {
    static class Pair {
        int start, end;
        char assignedTo;

        Pair(int start, int end) {
            this.start = start;
            this.end = end;
            this.assignedTo = 0;
        }
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int t = scanner.nextInt();
            for (int i = 1; i <= t; ++i) {
                System.out.print("Case #");
                System.out.print(i);
                System.out.print(": ");
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
            intervals[i] = new Pair(scanner.nextInt(), scanner.nextInt());
        }

        Arrays.sort(intervals, Comparator.comparingInt(p -> p.start));

        List<Pair> cameronSchedule = new ArrayList<>();
        List<Pair> jamieSchedule = new ArrayList<>();

        for (Pair interval : intervals) {
            if (canSchedule(cameronSchedule, interval)) {
                interval.assignedTo = 'C';
                cameronSchedule.add(interval);
            } else if (canSchedule(jamieSchedule, interval)) {
                interval.assignedTo = 'J';
                jamieSchedule.add(interval);
            } else {
                System.out.println("IMPOSSIBLE");
                return;
            }
        }

        for (Pair interval : intervals) {
            System.out.print(interval.assignedTo);
        }
        System.out.println();
    }

    private static boolean canSchedule(List<Pair> schedule, Pair newInterval) {
        for (Pair scheduledInterval : schedule) {
            if (overlaps(scheduledInterval, newInterval)) {
                return false;
            }
        }
        return true;
    }

    private static boolean overlaps(Pair interval1, Pair interval2) {
        return interval1.start < interval2.end && interval2.start < interval1.end;
    }
}