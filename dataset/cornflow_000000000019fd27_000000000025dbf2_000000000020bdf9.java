import java.util.Scanner;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int testCount = s.nextInt();
        for (int t = 0; t < testCount; t++) {
            int intervalCount = s.nextInt();
            List<Interval> intervals = new ArrayList<>(intervalCount);
            for (int i = 0; i < intervalCount; i++) {
                int start = s.nextInt();
                int end = s.nextInt();
                intervals.add(new Interval(start, end, i));
            }
            
            Solver solver = new Solver(intervals);
            String result = solver.solve();
            
            System.out.printf("Case #%d: %s\n", t + 1, result);
        }
    }
}

class Interval implements Comparable<Interval> {
    int start;
    int end;
    int numberInInputSequence;
    
    public Interval(int start, int end, int number) {
        this.start = start;
        this.end = end;
        this.numberInInputSequence = number;
    }
    
    public int compareTo(Interval other) {
        return start - other.start;
    }
}

class Solver {
    private final static String NO_SOLUTION_RESPONSE = "IMPOSSIBLE";
    List<Interval> intervals;
    
    /**
     * Mutates intervals input list.
     */
    public Solver(List<Interval> intervals) {
        Collections.sort(intervals);
        this.intervals = intervals;
    }
    
    public String solve() {
        int[] ends = new int[2];
        char[] persons = new char[]{'J', 'C'};
        
        char[] result = new char[intervals.size()];
        for (Interval interval : intervals) {
            int nextPersonNumber = ends[0] < ends[1] ? 0 : 1;
            int nextEnd = ends[nextPersonNumber];
            char nextPerson = persons[nextPersonNumber];
            
            if (interval.start < nextEnd) {
                return NO_SOLUTION_RESPONSE;
            }
            
            result[interval.numberInInputSequence] = nextPerson;
            ends[nextPersonNumber] = interval.end;
        }
        
        return new String(result);
    }
}