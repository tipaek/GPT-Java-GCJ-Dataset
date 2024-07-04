import java.util.*;
import java.io.*;
    
class Solution {
    private static class IntervalComparator implements Comparator<int[]> {
    	@Override
    	public int compare(int[] a, int[] b) {
    		return a[0] < b[0] ? -1 : a[0] == b[0] ? 0 : 1;
    	}
	}
	
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner in = new Scanner(System.in);
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt();
            
            int[][] intervals = new int[n][2];
            for(int j=0; j<n; j++) {
            	intervals[j][0] = in.nextInt();
            	intervals[j][1] = in.nextInt();
            }
            
            StringBuilder result = new StringBuilder();
            Collections.sort(Arrays.asList(intervals), new IntervalComparator());
            
            int j = 0, c = 0;
            boolean notPossible = false;
            
            for(int[] interval: intervals) {
            	if((c == 0) || (c <= interval[0])) {
            		c = interval[1];
            		result.append("C");
            	} else if((j == 0) || (j <= interval[0])) {
            		j = interval[1];
            		result.append("J");
            	} else {
            		notPossible = true;	
            		break;
            	}
            }
            
            if(notPossible) {
	            System.out.println("Case #"+ i + ": IMPOSSIBLE");
            } else {
            	System.out.println("Case #"+ i + ": " + result.toString());
            }
		}
	}
}