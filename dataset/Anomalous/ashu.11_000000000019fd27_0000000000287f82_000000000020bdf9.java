import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Solution {

    public static class Interval {
        int start;
        int end;

        Interval(int s, int e) {
            start = s;
            end = e;
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
        int t = scanner.nextInt();
        int caseNumber = 1;

        while (t-- > 0) {
            int n = scanner.nextInt();
            StringBuilder result = new StringBuilder();
            HashMap<Character, ArrayList<Interval>> scheduleMap = new HashMap<>();
            scheduleMap.put('C', new ArrayList<>());
            scheduleMap.put('J', new ArrayList<>());

            for (int i = 0; i < n; i++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                Interval currentInterval = new Interval(start, end);

                if (canBeScheduled(scheduleMap.get('C'), currentInterval)) {
                    scheduleMap.get('C').add(currentInterval);
                    result.append('C');
                } else if (canBeScheduled(scheduleMap.get('J'), currentInterval)) {
                    scheduleMap.get('J').add(currentInterval);
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

    private static boolean canBeScheduled(ArrayList<Interval> intervals, Interval newInterval) {
        for (Interval interval : intervals) {
            if (isOverlapping(interval, newInterval)) {
                return false;
            }
        }
        return true;
    }
}