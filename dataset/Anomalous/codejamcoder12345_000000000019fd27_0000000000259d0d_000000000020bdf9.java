import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int caseNum = 1; caseNum <= testCases; caseNum++) {
            int n = scanner.nextInt();
            Interval[] intervals = new Interval[n];
            
            for (int i = 0; i < n; i++) {
                intervals[i] = new Interval(scanner.nextInt(), scanner.nextInt(), i);
            }
            
            Arrays.sort(intervals, Comparator.comparingInt(a -> a.start));
            
            int cEnd = 0, jEnd = 0;
            char[] assignments = new char[n];
            boolean possible = true;
            
            for (Interval interval : intervals) {
                if (interval.start >= cEnd) {
                    assignments[interval.index] = 'C';
                    cEnd = interval.end;
                } else if (interval.start >= jEnd) {
                    assignments[interval.index] = 'J';
                    jEnd = interval.end;
                } else {
                    possible = false;
                    break;
                }
            }
            
            if (possible) {
                System.out.println("Case #" + caseNum + ": " + new String(assignments));
            } else {
                System.out.println("Case #" + caseNum + ": IMPOSSIBLE");
            }
        }
        
        scanner.close();
    }
}

class Interval {
    int start, end, index;

    Interval(int start, int end, int index) {
        this.start = start;
        this.end = end;
        this.index = index;
    }
}