import java.util.*;

class Interval implements Comparable<Interval> {
    int start;
    int end;
    char symbol;
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

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int caseNum = 1; caseNum <= testCases; caseNum++) {
            int n = scanner.nextInt();
            List<Interval> intervals = new ArrayList<>();
            
            for (int i = 0; i < n; i++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                intervals.add(new Interval(start, end, i));
            }
            
            Collections.sort(intervals);
            String result = assignSymbols(intervals);
            System.out.println("Case #" + caseNum + ": " + result);
        }
        
        scanner.close();
    }
    
    private static String assignSymbols(List<Interval> intervals) {
        int maxC = 0, maxJ = 0;
        char[] result = new char[intervals.size()];
        
        for (Interval interval : intervals) {
            if (interval.start >= maxC) {
                interval.symbol = 'C';
                maxC = interval.end;
            } else if (interval.start >= maxJ) {
                interval.symbol = 'J';
                maxJ = interval.end;
            } else {
                return "IMPOSSIBLE";
            }
            result[interval.index] = interval.symbol;
        }
        
        return new String(result);
    }
}