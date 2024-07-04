import java.util.Scanner;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfTests = scanner.nextInt();
        
        for (int testIndex = 0; testIndex < numberOfTests; testIndex++) {
            int numberOfIntervals = scanner.nextInt();
            List<Interval> intervals = new ArrayList<>(numberOfIntervals);
            
            for (int i = 0; i < numberOfIntervals; i++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                intervals.add(new Interval(start, end, i));
            }
            
            Scheduler scheduler = new Scheduler(intervals);
            String result = scheduler.schedule();
            
            System.out.printf("Case #%d: %s\n", testIndex + 1, result);
        }
    }
}

class Interval implements Comparable<Interval> {
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
        return Integer.compare(this.start, other.start);
    }
}

class Scheduler {
    private static final String IMPOSSIBLE = "IMPOSSIBLE";
    private List<Interval> intervals;
    
    public Scheduler(List<Interval> intervals) {
        Collections.sort(intervals);
        this.intervals = intervals;
    }
    
    public String schedule() {
        int[] endTimes = new int[2];
        char[] assignedPersons = new char[]{'J', 'C'};
        char[] results = new char[intervals.size()];
        
        for (Interval interval : intervals) {
            int personIndex = (endTimes[0] <= endTimes[1]) ? 0 : 1;
            if (interval.start < endTimes[personIndex]) {
                return IMPOSSIBLE;
            }
            
            results[interval.index] = assignedPersons[personIndex];
            endTimes[personIndex] = interval.end;
        }
        
        return new String(results);
    }
}