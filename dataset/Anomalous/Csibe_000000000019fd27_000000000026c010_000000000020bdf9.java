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

        public boolean overlap(Interval other) {
            return (this.begin < other.begin && this.end > other.begin) || 
                   (other.begin < this.begin && other.end > this.begin);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = scanner.nextInt();
        scanner.nextLine();

        for (int i = 1; i <= t; ++i) {
            int n = scanner.nextInt();
            Interval[] intervals = new Interval[n];
            for (int j = 0; j < n; j++) {
                int begin = scanner.nextInt();
                int end = scanner.nextInt();
                intervals[j] = new Interval(begin, end, j);
            }

            Arrays.sort(intervals);

            LinkedList<Interval> jamie = new LinkedList<>();
            LinkedList<Interval> cameron = new LinkedList<>();
            boolean impossible = false;

            for (Interval interval : intervals) {
                if (jamie.isEmpty() || !jamie.getLast().overlap(interval)) {
                    jamie.add(interval);
                } else if (cameron.isEmpty() || !cameron.getLast().overlap(interval)) {
                    cameron.add(interval);
                } else {
                    impossible = true;
                    break;
                }
            }

            if (impossible) {
                System.out.println("Case #" + i + ": IMPOSSIBLE");
            } else {
                String[] output = new String[n];
                for (Interval interval : jamie) {
                    output[interval.index] = "J";
                }
                for (Interval interval : cameron) {
                    output[interval.index] = "C";
                }
                System.out.println("Case #" + i + ": " + String.join("", output));
            }
        }
    }
}