import java.util.*;
import java.io.*;

class Interval {
    int start;
    int end;
    
    public Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }
    
    public boolean overlaps(int start, int end) {
        return (end > this.start && start < this.end);
    }
    
    public static boolean canAssign(List<Interval> intervals, int start, int end) {
        for (Interval interval : intervals) {
            if (interval.overlaps(start, end)) {
                return false;
            }
        }
        intervals.add(new Interval(start, end));
        return true;
    }
}

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        
        for (int t = 1; t <= testCases; t++) {
            int n = scanner.nextInt();
            List<Interval> cIntervals = new ArrayList<>();
            List<Interval> jIntervals = new ArrayList<>();
            StringBuilder result = new StringBuilder();
            boolean isImpossible = false;
            
            for (int i = 0; i < n; i++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                
                if (isImpossible) {
                    continue;
                }
                
                if (Interval.canAssign(cIntervals, start, end)) {
                    result.append("C");
                } else if (Interval.canAssign(jIntervals, start, end)) {
                    result.append("J");
                } else {
                    result = new StringBuilder("IMPOSSIBLE");
                    isImpossible = true;
                }
            }
            
            System.out.println("Case #" + t + ": " + result);
        }
        
        scanner.close();
    }
}