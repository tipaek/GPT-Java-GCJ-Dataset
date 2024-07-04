import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt();
            List<Interval> intervals = new ArrayList<>(n);
            for (int j = 0; j < n; j++) {
                intervals.add(new Interval(j, in.nextInt(), in.nextInt()));
            }
            System.out.println("Case #" + i + ": " + solve(intervals));
        }
    }

    private static String solve(List<Interval> intervals) {
//        Collections.sort(intervals); //nlogn
        Owner cameron = new Owner("C");
        Owner jamie = new Owner("J");
        for (Interval i : intervals) {
            if (cameron.canTake(i)) {
                cameron.assign(i);
                i.assign("C");
            } else if (jamie.canTake(i)) {
                jamie.assign(i);
                i.assign("J");
            } else {
                return "IMPOSSIBLE";
            }
        }
//        Collections.sort(intervals, Comparator.comparingInt(o -> o.order));
        return intervals.stream().map(i -> i.owner).collect(Collectors.joining(""));
    }

    static class Owner {
        private String name;
        private List<Interval> intervals = new ArrayList<>();

        Owner(final String name) {
            this.name = name;
        }

        public boolean canTake(Interval interval) {
            return intervals.stream().noneMatch(i -> i.overlapsWith(interval));
        }

        public void assign(Interval interval) {
            intervals.add(interval);
        }
    }

    static class Interval implements Comparable<Interval>{
        private int start;
        private int end;
        private int order;
        private String owner;

        Interval(final int order, final int start, final int end) {
            this.order = order;
            this.start = start;
            this.end = end;
        }

        public boolean overlapsWith(Interval that) {
            return  (this.start<= that.start && that.start < this.end) ||
                    (that.start<= this.start && this.start < that.end);
        }

        @Override
        public int compareTo(Interval that) {
            return Integer.compare(this.start, that.start);
        }

        public void assign(String owner) {
            this.owner = owner;
        }
    }
}
