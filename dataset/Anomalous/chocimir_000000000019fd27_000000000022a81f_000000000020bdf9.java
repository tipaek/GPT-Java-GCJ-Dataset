package qualification.parenting;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    private static class Interval implements Comparable<Interval> {
        int start, end;
        
        Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Interval other) {
            if (this.start != other.start) {
                return this.start - other.start;
            }
            return this.end - other.end;
        }
    }

    public String solve(Scanner scanner) {
        int n = scanner.nextInt();
        List<Interval> intervals = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            intervals.add(new Interval(scanner.nextInt(), scanner.nextInt()));
        }
        Collections.sort(intervals);
        
        Interval cameron = null;
        Interval jamie = null;
        StringBuilder result = new StringBuilder();
        
        for (Interval interval : intervals) {
            if (cameron == null || cameron.end <= interval.start) {
                cameron = interval;
                result.append('C');
            } else if (jamie == null || jamie.end <= interval.start) {
                jamie = interval;
                result.append('J');
            } else {
                return "IMPOSSIBLE";
            }
        }
        
        return result.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        Solution solution = new Solution();
        
        for (int i = 1; i <= testCases; i++) {
            System.out.println("Case #" + i + ": " + solution.solve(scanner));
        }
    }
}