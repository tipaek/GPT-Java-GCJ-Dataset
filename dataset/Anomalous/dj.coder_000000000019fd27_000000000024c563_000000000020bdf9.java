import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
    
    // Interval data class
    class Interval {
        int start, end, index;
        char assignedChar;
        
        Interval(int start, int end, int index) {
            this.start = start;
            this.end = end;
            this.index = index;
        }
    }
    
    private List<Interval> intervals;
    
    public Solution(int N) {
        intervals = new ArrayList<>(N);
    }
    
    // Method to add intervals
    void addInterval(int start, int end) {
        intervals.add(new Interval(start, end, intervals.size()));
    }
    
    // Method to solve the problem
    String solve() {
        // Sort intervals based on start time, then by index if start times are equal
        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval i1, Interval i2) {
                int startComparison = Integer.compare(i1.start, i2.start);
                return startComparison != 0 ? startComparison : Integer.compare(i1.index, i2.index);
            }
        });
        
        int cEnd = 0, jEnd = 0;
        boolean possible = true;
        
        // Assign intervals to C or J
        for (Interval interval : intervals) {
            if (interval.start >= cEnd) {
                interval.assignedChar = 'C';
                cEnd = interval.end;
            } else if (interval.start >= jEnd) {
                interval.assignedChar = 'J';
                jEnd = interval.end;
            } else {
                possible = false;
                break;
            }
        }
        
        if (possible) {
            // Build the result string based on the original order
            char[] result = new char[intervals.size()];
            for (Interval interval : intervals) {
                result[interval.index] = interval.assignedChar;
            }
            return new String(result);
        } else {
            return "IMPOSSIBLE";
        }
    }
    
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(reader.readLine());
        StringBuilder output = new StringBuilder();
        
        for (int tc = 1; tc <= T; tc++) {
            int N = Integer.parseInt(reader.readLine());
            Solution solution = new Solution(N);
            
            for (int i = 0; i < N; i++) {
                StringTokenizer tokens = new StringTokenizer(reader.readLine());
                int start = Integer.parseInt(tokens.nextToken());
                int end = Integer.parseInt(tokens.nextToken());
                solution.addInterval(start, end);
            }
            
            // Solve and append the result for the current test case
            String result = solution.solve();
            output.append("Case #").append(tc).append(": ").append(result).append(System.lineSeparator());
        }
        
        System.out.print(output);
        reader.close();
    }
}