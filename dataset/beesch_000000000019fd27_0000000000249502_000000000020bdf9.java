import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Solution {
	
	public static void main(String[] args) {
		try( Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in))) ) {
	        int t = in.nextInt();
	        
	        Set<Activity> c, j;
	        for (int i = 1; i <= t; ++i) {
	        	c = new TreeSet<>();
	        	j = new TreeSet<>();
	        	
	        	int n = in.nextInt();
	        	boolean isImpossible = false;
	        	String result = "";
	        	
	        	for( int a = 1; a <= n; ++a ) {
	        		Activity newActivity = new Activity(in.nextInt(), in.nextInt());
	        		if( c.add(newActivity) )
	        			result += "C";
	        		else if( j.add(newActivity) )
	        			result += "J";
	        		else
	        			isImpossible = true;
	        	}
	        	
	        	if( isImpossible )
	        		System.out.println("Case #" + i + ": " + "IMPOSSIBLE");
	        	else
	        		System.out.println("Case #" + i + ": " + result);
	        }
		} catch( Exception e ) {
			e.printStackTrace();
		}
	}
	
	static class Activity implements Comparable<Activity> {
		private int start;
		private int end;
		
		public Activity(int start, int end) {
			this.start = start;
			this.end = end;
		}
		
		public int getStart() {
			return start;
		}
		
		public int getEnd() {
			return end;
		}

		@Override
		public int compareTo(Activity o) {
			if( (start >= o.getStart() && start < o.getEnd()) || (end > o.getStart() && end <= o.getEnd()) )
				return 0;
			return start - o.start;
		}
	}

}
