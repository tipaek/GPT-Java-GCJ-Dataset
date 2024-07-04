import java.util.*;
import java.io.*;

public class Solution {
	
	static boolean first;
	
	public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
    	
    	int t = Integer.parseInt(br.readLine());
    	
    	for (int i = 0; i < t; i++) {
    		int n = Integer.parseInt(br.readLine());
    		StringTokenizer st;
    		Interval[] intervals = new Interval[n];
    		
    		for (int j = 0; j < n; j++) {
    			st = new StringTokenizer(br.readLine());
    			int a = Integer.parseInt(st.nextToken());
    			int b = Integer.parseInt(st.nextToken());
    			intervals[j] = new Interval(a, b, false, j);
    		}
    		
    		first = true;
    		Arrays.sort(intervals);
    	
    		boolean prevIsJ = false;
    		int firstEnd = 0;
    		int secondEnd = 1;
    		
    		intervals[0].isJ = true;
    		intervals[1].isJ = false;
    		
    		boolean imposs = false;
    		
    		for (int j = 2; j < n; j++) {
    			
    			if (intervals[j].a < intervals[firstEnd].b && intervals[j].a < intervals[secondEnd].b) {
    				imposs = true;
    				break;
    			}
    			if (intervals[j].a < intervals[secondEnd].b) {
    				if (prevIsJ) {
    					intervals[j].isJ = false;
    					
        				prevIsJ = false;
        			} else {
        				intervals[j].isJ = true;
        				prevIsJ = true;
        			}
    				firstEnd = j - 1;
    				secondEnd++;
    			} else if (intervals[j].a < intervals[firstEnd].b) {
    				if (prevIsJ) {
    					intervals[j].isJ = true;
        				prevIsJ = true;
        			} else {
        				intervals[j].isJ = false;
        				prevIsJ = false;
        			}
    				secondEnd++;
    			} else {
    				intervals[j].isJ = true;
    				prevIsJ = true;
    				firstEnd = j - 1;
    				secondEnd = j;
    			}
    			
    		}
    		
    		System.out.print("Case #" + (i+1) + ": ");
    		
    		if (imposs) {
    			System.out.println("IMPOSSIBLE");
    		} else {
        		first = false;
        		Arrays.sort(intervals);
        		for (int j = 0; j < n; j++) {
        			if (intervals[j].isJ)
        				System.out.print("J");
        			else
        				System.out.print("C");
        		}
        		System.out.println();
    		}
    	}
    }
	
	public static class Interval implements Comparable<Interval> {
		int a;
		int b;
		boolean isJ;
		int orig;
		
		public Interval(int a, int b, boolean isJ, int orig) {
			this.a = a;
			this.b = b;
			this.isJ = isJ;
			this.orig = orig;
		}
		
		public int compareTo(Interval i) {
			if (first)
				return this.a - i.a;
			return this.orig - i.orig;
		}
	}
}