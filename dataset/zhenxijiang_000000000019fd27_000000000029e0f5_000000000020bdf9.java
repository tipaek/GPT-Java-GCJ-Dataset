import java.util.*;
import java.io.*;

public class Solution {
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
    			intervals[j] = new Interval(a, b, "");
    		}
    		
    		Arrays.sort(intervals);
    		
    		boolean prevIsJ = false;
    		int firstEnd = 0;
    		int secondEnd = 1;
    		
    		StringBuilder ret = new StringBuilder("JC");
    		
    		for (int j = 2; j < n; j++) {
    			if (intervals[j].a < intervals[firstEnd].b && intervals[j].a < intervals[secondEnd].b) {
    				ret = new StringBuilder("IMPOSSIBLE");
    				break;
    			}
    			if (intervals[j].a < intervals[secondEnd].b) {
    				if (prevIsJ) {
        				ret.append("C");
        				prevIsJ = false;
        			} else {
        				ret.append("J");
        				prevIsJ = true;
        			}
    			} else if (intervals[j].a < intervals[firstEnd].b) {
    				if (prevIsJ) {
        				ret.append("J");
        				prevIsJ = true;
        			} else {
        				ret.append("C");
        				prevIsJ = false;
        			}
    			} else {
    				ret.append("J");
    				prevIsJ = true;
    			}
    			
    		}
    		
    		System.out.println(ret.toString());
    	}
    }
	
	public static class Interval implements Comparable<Interval> {
		int a;
		int b;
		String s;
		
		public Interval(int a, int b, String s) {
			this.a = a;
			this.b = b;
			this.s = s;
		}
		
		public int compareTo(Interval i) {
			return this.a - i.a;
		}
	}
}