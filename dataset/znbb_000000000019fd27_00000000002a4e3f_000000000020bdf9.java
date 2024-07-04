
import java.util.*;
import java.io.*;
public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int k = 1; k <= t; ++k) {
            int n = in.nextInt();

            List<Interval> problem = new ArrayList<>();
            for (int i = 1; i <= n; ++i) {
                int start = in.nextInt();
                int end = in.nextInt();

                Interval interval = new Interval(start, end);
                problem.add(interval);
            }

            Collections.sort(problem);

            Queue<Interval> cameronFinish = new PriorityQueue<>();
            Queue<Interval> jamieFinish = new PriorityQueue<>();

            for (Interval interval : problem) {
//                System.out.println(interval);

                if (!compatibleAdd(cameronFinish, jamieFinish, interval)) {
                    System.out.println("Case #" + k + ": IMPOSSIBLE");
                }
            }
//            System.out.println("cameronFinish: " + cameronFinish);
//            System.out.println("jamieFinish: " + jamieFinish);
        }
    }

    private static boolean compatibleAdd(Queue<Interval> cameronFinish, Queue<Interval> jamieFinish, Interval interval) {
        if (cameronFinish.isEmpty()) {
            cameronFinish.add(interval);
            return true;
        } else if (jamieFinish.isEmpty()) {
            jamieFinish.add(interval);
            return true;
        }

        if (interval.startTime > cameronFinish.peek().finishTime) {
            cameronFinish.add(interval);
        } else if (interval.startTime > jamieFinish.peek().finishTime) {
            jamieFinish.add(interval);
        } else {
            return false;
        }

        return true;
    }

    public static class Interval implements Comparable {
        public int startTime;
        public int finishTime;

        public Interval(int startTime, int finishTime) {
            this.startTime = startTime;
            this.finishTime = finishTime;
        }

        @Override
        public String toString() {
            return "Interval{" +
                    "startTime=" + startTime +
                    ", finishTime=" + finishTime +
                    '}';
        }

        @Override
        public int compareTo(Object o) {
            Interval other = (Interval) o;
            return startTime - other.startTime;
        }

        public boolean overlap(Interval o) {
            boolean before = o.finishTime > startTime && o.startTime < startTime;
            boolean after = finishTime > o.startTime && startTime < o.startTime;

            boolean inside = startTime >= o.startTime && finishTime <= o.finishTime;
            boolean contains = startTime < o.startTime && finishTime > o.finishTime;

            return before || after || inside || contains;
        }
    }
}
