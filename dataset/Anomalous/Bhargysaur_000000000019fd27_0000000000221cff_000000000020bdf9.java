import java.util.*;

public class Solution {
    private static class Interval {
        final int start;
        final int end;
        public String person = "";
        
        Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    private static class IntervalComparator implements Comparator<Interval> {
        @Override
        public int compare(Interval o1, Interval o2) {
            return Integer.compare(o1.start, o2.start);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        
        for (int i = 0; i < t; i++) {
            int n = scanner.nextInt();
            List<Interval> intervals = new ArrayList<>();
            
            for (int j = 0; j < n; j++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                intervals.add(new Interval(start, end));
            }
            
            List<Interval> sortedIntervals = new ArrayList<>(intervals);
            sortedIntervals.sort(new IntervalComparator());
            
            Interval c = null;
            Interval j = null;
            StringBuilder result = new StringBuilder();
            Map<Interval, Integer> intervalIndices = new HashMap<>();
            
            for (int k = 0; k < n; k++) {
                intervalIndices.put(intervals.get(k), k);
            }
            
            boolean isPossible = true;
            
            for (Interval interval : sortedIntervals) {
                if (c == null || c.end <= interval.start) {
                    int index = intervalIndices.get(interval);
                    intervals.get(index).person = "C";
                    c = intervals.get(index);
                } else if (j == null || j.end <= interval.start) {
                    int index = intervalIndices.get(interval);
                    intervals.get(index).person = "J";
                    j = intervals.get(index);
                } else {
                    isPossible = false;
                    break;
                }
            }
            
            if (!isPossible) {
                System.out.println("Case #" + (i + 1) + ": IMPOSSIBLE");
            } else {
                for (Interval interval : intervals) {
                    result.append(interval.person);
                }
                System.out.println("Case #" + (i + 1) + ": " + result.toString());
            }
        }
        
        scanner.close();
    }
}