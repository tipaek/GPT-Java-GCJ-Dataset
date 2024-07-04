import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        scanner.nextLine();
        
        for (int testCase = 1; testCase <= testCases; testCase++) {
            int intervalsCount = scanner.nextInt();
            List<Interval> intervals = new ArrayList<>();
            
            for (int i = 0; i < intervalsCount; i++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                intervals.add(new Interval(i, start, end));
            }
            
            intervals.sort(Comparator.comparingInt(interval -> interval.start));
            
            Interval cameron = null;
            Interval jamie = null;
            boolean isPossible = true;
            char[] schedule = new char[intervalsCount];
            
            for (Interval interval : intervals) {
                if (cameron == null || cameron.end <= interval.start) {
                    cameron = interval;
                    schedule[interval.index] = 'C';
                } else if (jamie == null || jamie.end <= interval.start) {
                    jamie = interval;
                    schedule[interval.index] = 'J';
                } else {
                    isPossible = false;
                    break;
                }
            }
            
            String result = isPossible ? new String(schedule) : "IMPOSSIBLE";
            System.out.printf("Case #%d: %s\n", testCase, result);
        }
    }

    static class Interval {
        int start;
        int end;
        int index;

        public Interval(int index, int start, int end) {
            this.index = index;
            this.start = start;
            this.end = end;
        }

        @Override
        public String toString() {
            return String.format("[%d, %d)", start, end);
        }
    }
}