import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Interval implements Comparable<Interval>{
	int start, end, index;
	char symbol;
	public Interval(int start, int end, int index) {
		this.start = start;
		this.end = end;
		this.index = index;
	}

	@Override
	public int compareTo(Interval inter) {
		if(this.start == inter.start) return this.end- inter.end;
		return this.start-inter.start;
	}
	
	public boolean intersect(Interval inter) {
		if(inter == null) return false;
		if((this.start >= inter.start && this.start < inter.end) || (inter.start >= this.start && inter.start < this.end)) return true;
		
		return false;
	}
}
public class Solution {
	public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        StringBuilder sb = new StringBuilder();
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt();
            Interval[] intervals = new Interval[n];
            
            for(int j=0; j<n; j++) intervals[j] = new Interval(in.nextInt(), in.nextInt(), j);
            
            String sol = getSol(intervals);
            sb.append("Case #" + i + ": " + sol +"\r\n");
            
        }
        System.out.println(sb);
    }

	public static String getSol(Interval[] intervals) {
		char[] ca = new char[intervals.length];
		Arrays.sort(intervals);
        intervals[0].symbol = 'C';
        
        Interval lastC = intervals[0];
        Interval lastJ = null;
        
        for(int j=1; j<intervals.length; j++) {
        		Interval cur = intervals[j];
        		
        		if(!cur.intersect(lastJ)) {
        			lastJ = cur;
        			lastJ.symbol = 'J';
        		}
        		else if(!cur.intersect(lastC)) {
        			lastC = cur;
        			lastC.symbol = 'C';
        		}
        		else {
        			return "IMPOSSIBLE";
        		}
        }
        
        for(int i=0; i<intervals.length; i++) {
        		ca[intervals[i].index] = intervals[i].symbol;
        }
        return new String(ca);
	}

}

