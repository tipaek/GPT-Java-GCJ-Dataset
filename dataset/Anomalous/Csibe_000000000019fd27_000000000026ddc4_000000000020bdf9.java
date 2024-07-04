import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class Solution {

    static class Interval implements Comparable<Interval> {
        private int begin;
        private int end;
        private int index;

        Interval(int begin, int end, int index) {
            this.begin = begin;
            this.end = end;
            this.index = index;
        }

        @Override
        public int compareTo(Interval other) {
            return Integer.compare(this.begin, other.begin);
        }

        public boolean overlaps(Interval other) {
            return this.end > other.begin;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        scanner.nextLine();

        for (int t = 1; t <= testCases; ++t) {
            int n = scanner.nextInt();
            Interval[] intervals = new Interval[n];

            for (int i = 0; i < n; i++) {
                int begin = scanner.nextInt();
                int end = scanner.nextInt();
                intervals[i] = new Interval(begin, end, i);
            }

            Arrays.sort(intervals);

            LinkedList<Interval> jamie = new LinkedList<>();
            LinkedList<Interval> cameron = new LinkedList<>();
            boolean isImpossible = false;

            for (Interval interval : intervals) {
                if (jamie.isEmpty() || !jamie.getLast().overlaps(interval)) {
                    jamie.add(interval);
                } else if (cameron.isEmpty() || !cameron.getLast().overlaps(interval)) {
                    cameron.add(interval);
                } else {
                    isImpossible = true;
                    break;
                }
            }

            if (isImpossible) {
                System.out.println("Case #" + t + ": IMPOSSIBLE");
            } else {
                String[] result = new String[n];
                for (Interval interval : jamie) {
                    result[interval.index] = "J";
                }
                for (Interval interval : cameron) {
                    result[interval.index] = "C";
                }

                StringBuilder output = new StringBuilder();
                for (String s : result) {
                    output.append(s);
                }
                System.out.println("Case #" + t + ": " + output.toString());
            }
        }
    }
}