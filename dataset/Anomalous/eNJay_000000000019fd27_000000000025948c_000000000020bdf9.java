import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        
        for (int caseNumber = 1; caseNumber <= testCases; ++caseNumber) {
            int n = scanner.nextInt();
            List<Interval> intervals = new ArrayList<>();
            
            for (int i = 0; i < n; i++) {
                intervals.add(new Interval(scanner.nextInt(), scanner.nextInt(), i));
            }
            
            scheduleIntervals(intervals, caseNumber);
        }
    }

    private static void scheduleIntervals(List<Interval> intervals, int caseNumber) {
        String impossible = "IMPOSSIBLE";
        StringBuilder result = new StringBuilder();
        Collections.sort(intervals);
        
        char currentAssignment = 'C';
        result.append(currentAssignment);
        
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
            
            if (next.index >= result.length()) {
                result.append(currentAssignment);
            } else {
                result.insert(next.index, currentAssignment);
            }
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