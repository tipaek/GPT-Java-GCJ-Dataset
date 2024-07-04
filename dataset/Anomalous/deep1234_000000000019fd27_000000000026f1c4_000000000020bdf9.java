import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

class Solution {
    static class Interval {
        int start, end;

        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        ArrayList<String> results = new ArrayList<>();

        for (int t = 1; t <= testCases; t++) {
            int n = scanner.nextInt();
            List<Interval> intervals = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                intervals.add(new Interval(start, end));
            }

            String result = assignTasks(intervals, n);
            results.add("Case #" + t + ": " + result);
        }

        for (String result : results) {
            System.out.println(result);
        }

        scanner.close();
    }

    private static String assignTasks(List<Interval> intervals, int n) {
        Collections.sort(intervals, Comparator.comparingInt(i -> i.start));
        StringBuilder result = new StringBuilder();
        int cEnd = 0, jEnd = 0;

        for (Interval interval : intervals) {
            if (cEnd <= interval.start) {
                cEnd = interval.end;
                result.append('C');
            } else if (jEnd <= interval.start) {
                jEnd = interval.end;
                result.append('J');
            } else {
                return "IMPOSSIBLE";
            }
        }

        return result.toString();
    }
}