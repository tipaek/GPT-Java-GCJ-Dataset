import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.

        for (int i = 1; i <= t; ++i) {
            int activityCount = in.nextInt();

            StringBuilder sb = new StringBuilder();
            int lastC = 0;
            int lastJ = 0;
            boolean impossible = false;

            PriorityQueue<Interval> intervals = new PriorityQueue<>(Comparator.comparingInt(interval -> interval.end));

            for (int j = 0; j < activityCount; j++) {
                int begin = in.nextInt();
                int end = in.nextInt();

                intervals.add(new Interval(begin, end));
            }

            while (!intervals.isEmpty()) {
                Interval interval = intervals.poll();
                if (lastC <= interval.begin) {
                    lastC = interval.end;
                    sb.append("C");
                } else if (lastJ <= interval.begin) {
                    lastJ = interval.end;
                    sb.append("J");
                } else {
                    impossible = true;
                }
            }

            System.out.println("Case #" + i + ": " + (impossible ? "IMPOSSIBLE" : sb.toString()));
        }
    }

    public static class Interval {
        int begin, end;

        public Interval(int begin, int end) {
            this.begin = begin;
            this.end = end;
        }
    }
}