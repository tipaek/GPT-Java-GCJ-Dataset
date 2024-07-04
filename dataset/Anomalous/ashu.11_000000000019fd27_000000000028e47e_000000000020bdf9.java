import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Solution {

    public static class Interval {
        int start;
        int end;

        Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public String toString() {
            return "Interval [start=" + start + ", end=" + end + "]";
        }
    }

    public static boolean isOverlapping(Interval a, Interval b) {
        return Math.min(a.end, b.end) > Math.max(a.start, b.start);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        int caseNumber = 1;

        while (testCases-- > 0) {
            int intervalsCount = scanner.nextInt();
            StringBuilder result = new StringBuilder();
            HashMap<Character, ArrayList<Interval>> schedule = new HashMap<>();
            schedule.put('C', new ArrayList<>());
            schedule.put('J', new ArrayList<>());

            for (int i = 0; i < intervalsCount; i++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                Interval currentInterval = new Interval(start, end);

                if (canAssign(schedule.get('C'), currentInterval)) {
                    schedule.get('C').add(currentInterval);
                    result.append('C');
                } else if (canAssign(schedule.get('J'), currentInterval)) {
                    schedule.get('J').add(currentInterval);
                    result.append('J');
                } else {
                    result = new StringBuilder("IMPOSSIBLE");
                    break;
                }
            }

            System.out.println("Case #" + caseNumber + ": " + result.toString());
            caseNumber++;
        }
        scanner.close();
    }

    private static boolean canAssign(ArrayList<Interval> intervals, Interval newInterval) {
        for (Interval interval : intervals) {
            if (isOverlapping(interval, newInterval)) {
                return false;
            }
        }
        return true;
    }
}