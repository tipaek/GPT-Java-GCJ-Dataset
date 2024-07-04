import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < testCases; i++) {
            int num = Integer.parseInt(sc.nextLine());
            List<Interval> intervals = new ArrayList<>();
            for (int j = 0; j < num; j++) {
                String[] input = sc.nextLine().split(" ");
                intervals.add(new Interval(Integer.parseInt(input[0]), Integer.parseInt(input[1])));
            }
            String result = assignIntervals(intervals);
            System.out.println("Case #" + (i + 1) + ": " + result);
        }
        sc.close();
    }

    private static String assignIntervals(List<Interval> intervals) {
        List<Interval> sortedIntervals = new ArrayList<>(intervals);
        sortedIntervals.sort(Comparator.comparingInt(interval -> interval.start));
        
        Map<Interval, Character> assignment = new HashMap<>();
        Interval cameron = null, jamie = null;

        for (Interval interval : sortedIntervals) {
            if (cameron == null || interval.start >= cameron.end) {
                cameron = interval;
                assignment.put(interval, 'C');
            } else if (jamie == null || interval.start >= jamie.end) {
                jamie = interval;
                assignment.put(interval, 'J');
            } else {
                return "IMPOSSIBLE";
            }
        }

        StringBuilder result = new StringBuilder();
        for (Interval interval : intervals) {
            result.append(assignment.get(interval));
        }
        return result.toString();
    }

    private static class Interval {
        int start;
        int end;

        Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int hashCode() {
            return Objects.hash(start, end);
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            Interval interval = (Interval) obj;
            return start == interval.start && end == interval.end;
        }

        @Override
        public String toString() {
            return start + " " + end;
        }
    }
}