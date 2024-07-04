import java.util.*;

public class Solution {
    
    public static String getResult(Interval[] intervals) {
        Arrays.sort(intervals, (Interval interval1, Interval interval2) -> interval1.start - interval2.start);
        int cEnd = -1;
        int jEnd = -1;
        char[] result = new char[intervals.length];
        for (Interval interval : intervals) {
            // check c first
            if (cEnd <= interval.start) {
            	result[interval.original] = 'C';
                cEnd = interval.end;
                continue;
            }
            if (jEnd <= interval.start) {
            	result[interval.original] = 'J';
                jEnd = interval.end;
                continue;
            }
            return "IMPOSSIBLE";
        }
        return String.valueOf(result);
    }
    
    public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int testCases = scanner.nextInt();
		for (int i = 0; i < testCases; i++) {
			Interval[] intervals = new Interval[scanner.nextInt()];
			for (int j = 0; j < intervals.length; j++) {
			    intervals[j] = new Interval(scanner.nextInt(), scanner.nextInt(), j);
			}
			System.out.println("Case #" + (i + 1) + ": " + getResult(intervals));
		}
	}
    
    public static class Interval {
    	private int start;
    	private int end;
    	private int original;
    	
    	public Interval(int start, int end, int original) {
    		this.start = start;
    		this.end = end;
    		this.original = original;
    	}
    }
}