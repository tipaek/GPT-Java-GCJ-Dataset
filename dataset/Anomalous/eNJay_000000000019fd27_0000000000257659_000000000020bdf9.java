import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        
        for (int i = 1; i <= testCases; ++i) {
            int n = scanner.nextInt();
            List<Interval> intervals = new ArrayList<>();
            
            for (int j = 0; j < n; j++) {
                intervals.add(new Interval(scanner.nextInt(), scanner.nextInt()));
            }
            
            schedule(intervals, i);
        }
    }

    private static void schedule(List<Interval> intervals, int caseNumber) {
        String impossible = "IMPOSSIBLE";
        StringBuilder result = new StringBuilder();
        
        Collections.sort(intervals);
        
        char currentChar = 'C';
        result.append(currentChar);
        
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
                
                currentChar = (currentChar == 'C') ? 'J' : 'C';
            }
            
            result.append(currentChar);
        }
        
        System.out.println("Case #" + caseNumber + ": " + result.toString());
    }

    private static class Interval implements Comparable<Interval> {
        int start;
        int end;

        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Interval other) {
            if (this.start != other.start) {
                return Integer.compare(this.start, other.start);
            }
            return Integer.compare(this.end, other.end);
        }

        @Override
        public String toString() {
            return "[" + start + ", " + end + "] ";
        }
    }
}