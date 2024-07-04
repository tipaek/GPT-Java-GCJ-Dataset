import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = scanner.nextInt();  // Number of test cases

        for (int i = 1; i <= t; ++i) {
            int n = scanner.nextInt();  // Number of intervals
            List<Interval> intervals = new ArrayList<>();

            for (int j = 0; j < n; j++) {
                intervals.add(new Interval(scanner.nextInt(), scanner.nextInt(), j));
            }

            schedule(intervals, i);
        }
    }

    private static void schedule(List<Interval> intervals, int caseNumber) {
        String impossible = "IMPOSSIBLE";
        StringBuilder result = new StringBuilder();
        Collections.sort(intervals);

        char currentAssignment = 'C';
        result.setLength(intervals.size());
        result.setCharAt(intervals.get(0).index, currentAssignment);

        for (int i = 0; i < intervals.size() - 1; i++) {
            Interval current = intervals.get(i);
            Interval next = intervals.get(i + 1);

            if (current.end > next.start) {
                if (i > 0) {
                    Interval previous = intervals.get(i - 1);
                    if (next.start < previous.end) {
                        result = new StringBuilder(impossible);
                        break;
                    }
                }

                currentAssignment = (currentAssignment == 'C') ? 'J' : 'C';
            }

            result.setCharAt(next.index, currentAssignment);
        }

        System.out.println("Case #" + caseNumber + ": " + result.toString());
    }

    private static class Interval implements Comparable<Interval> {
        int start;
        int end;
        int index;

        public Interval(int start, int end, int index) {
            this.start = start;
            this.end = end;
            this.index = index;
        }

        @Override
        public int compareTo(Interval other) {
            if (this.start != other.start) {
                return Integer.compare(this.start, other.start);
            }
            return Integer.compare(this.end, other.end);
        }
    }
}